package com.bilgeadam.controller;

import com.bilgeadam.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constant.EndPointList.GENRE;

@RestController
@RequiredArgsConstructor
@RequestMapping(GENRE)
public class GenreController {

    private final GenreService genreService;
}
