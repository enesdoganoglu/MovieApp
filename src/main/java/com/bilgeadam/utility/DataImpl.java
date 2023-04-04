package com.bilgeadam.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public void getAllMovies(){
        try {
            URL url = new URL("https://api.tvmaze.com/shows");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            //Gson --> Json formatın dönüştürülmüş hali

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
