package com.bilgeadam.controller;

import com.bilgeadam.entity.Comment;
import com.bilgeadam.entity.Movie;
import com.bilgeadam.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.save(comment));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Comment>> findAll(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/find-by-movie/{id}")
    public ResponseEntity<List<Comment>> findByMovieId(@PathVariable Integer id){
        return ResponseEntity.ok(commentService.findByMovieId(id));
    }

    @GetMapping("/find-by-movie-date-between/{movieId}")
    public ResponseEntity<List<Comment>> findByMovieIdAndDateBetween(@PathVariable Integer movieId,
                                                                     String start, String end){
        return ResponseEntity.ok(commentService.findByMovieIdAndDateBetween(movieId, start, end));
    }
}
