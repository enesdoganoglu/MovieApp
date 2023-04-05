package com.bilgeadam.controller;

import com.bilgeadam.entity.Comment;
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

    @GetMapping("/find-by-user-id/{userId}")
    public  ResponseEntity <List<Comment>> findByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(commentService.findByUserId(userId));
    }
    @GetMapping("/find-by-user-id-and-date")
    public   ResponseEntity <List<Comment>> findAllByUserIdAndDateBetween(Integer userId, String start, String end){
        return ResponseEntity.ok( commentService.findAllByUserIdAndDateBetween(userId,start,end));
    }
}
