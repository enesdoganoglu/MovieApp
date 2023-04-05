package com.bilgeadam.utility;

import com.bilgeadam.entity.Movie;
import com.bilgeadam.service.GenreService;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.utility.data.Sample;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {

    private final MovieService movieService;
    private final GenreService genreService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        getAllMovies();
    }

    public void getAllMovies(){
        try {
            URL url = new URL("https://api.tvmaze.com/shows");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String value = "";
            value = bufferedReader.readLine();
            //Gson --> Json formatın dönüştürülmüş hali
            Sample[] array = new Gson().fromJson(value, Sample[].class);

            Arrays.asList(array).forEach(x -> {
                Movie movie = null;

                movie = Movie.builder()
                        .id(x.id)
                        .url(x.url)
                        .image(x.image.medium)
                        .language(x.language)
                        .premiered(LocalDate.parse(x.premiered))
                        .summary(x.summary)
                        .name(x.name)
                        .genreId(genreService.createGenresWithNames(x.genres))
                        .rating(x.rating.average)
                        .build();
                movieService.save(movie);
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
