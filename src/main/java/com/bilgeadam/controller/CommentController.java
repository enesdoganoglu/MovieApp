package com.bilgeadam.controller;

import com.bilgeadam.entity.Comment;
import com.bilgeadam.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMMENT)
public class CommentController {
    private final CommentService commentService;

    @PostMapping(SAVE)
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.save(comment));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping(FIND_BY_ID + "/{id}")
    public ResponseEntity<List<Comment>> findByMovieId(@PathVariable Integer id) {
        return ResponseEntity.ok(commentService.findByMovieId(id));
    }

    @GetMapping(FIND_BY_MOVIE_DATE_BETWEEN + "/{movieId}")
    public ResponseEntity<List<Comment>> findByMovieIdAndDateBetween(@PathVariable Integer movieId,
                                                                     String start, String end) {
        return ResponseEntity.ok(commentService.findByMovieIdAndDateBetween(movieId, start, end));
    }

    @GetMapping(FIND_BY_ID + "/{userId}")
    public ResponseEntity<List<Comment>> findByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(commentService.findByUserId(userId));
    }

    @GetMapping(FIND_BY_USER_ID_AND_DATE)
    public ResponseEntity<List<Comment>> findAllByUserIdAndDateBetween(Integer userId, String start, String end) {
        return ResponseEntity.ok(commentService.findAllByUserIdAndDateBetween(userId, start, end));
    }
}
