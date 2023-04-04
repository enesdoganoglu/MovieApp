package com.bilgeadam.service;

import com.bilgeadam.entity.Genre;
import com.bilgeadam.repository.IGenreRepository;
import com.bilgeadam.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService implements ICrudService<Genre, Integer> {

    private final IGenreRepository genreRepository;

    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public Iterable<Genre> saveAll(Iterable<Genre> t) {
        return null;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public Genre delete(Integer integer) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Optional<Genre> findById(Integer integer) {
        return Optional.empty();
    }
}
