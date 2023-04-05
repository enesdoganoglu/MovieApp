package com.bilgeadam.controller;

import com.bilgeadam.entity.Movie;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MOVIE)
public class MovieController {
    private final MovieService movieService;

    @PostMapping(SAVE)
    public ResponseEntity<Movie> save(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.save(movie));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Movie>> findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }

    //GetMapping için kullanılan 3 anotasyon vardır
    //--> RequestParam --> property isimleri url de gözükür
    //--> PathVariable --> property isimler url' de gözükmez, yalnızca atılan sorgudaki parametre gözükür
    //-X-> RequestBody
    @GetMapping(FIND_BY_ID +"/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping(FIND_BY_RATING_GREATER_THAN + "/{rating}")
    public ResponseEntity<List<Movie>> findByRatingGreaterThan(@PathVariable double rating){
        return ResponseEntity.ok(movieService.findByRatingGreaterThan(rating));
    }

    //Tarih formatı --> Yıl-Ay-Gün şeklinde olmalıdır.
    @GetMapping(FIND_BY_PREMIERED_BEFORE + "/{date}")
    public ResponseEntity<List<Movie>> findByPremieredBefore(@PathVariable String date){
        return ResponseEntity.ok(movieService.findByPremieredBefore((LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy")))));
    }

    @GetMapping(COUNT_IDENTICAL_RATING + "/{rating}")
    public ResponseEntity<Object> countByIdenticalRating(@PathVariable double rating){
        return ResponseEntity.ok(movieService.countByIdenticalRating(rating));
    }

    @GetMapping(COUNT_IDENTICAL_RATING_GROUP_BY_RATING)
    public ResponseEntity<Object[]> countByRatingGroupByRating(){
        return ResponseEntity.ok(movieService.countByRatingGroupByRating());
    }

    @GetMapping(FIND_BY_RATING_IN)
    public ResponseEntity<List<Movie>> findByRatingIn(){
        return ResponseEntity.ok(movieService.findByRatingIn());
    }

    @GetMapping(FIND_BY_NAME_CONTAINS + "/{name}")
    public ResponseEntity<List<Movie>> findByNameContainsIgnoreCase(@PathVariable String name){
        return ResponseEntity.ok(movieService.findByNameContainsIgnoreCase(name));
    }

}
