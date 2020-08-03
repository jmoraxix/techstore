package com.techstore.web.service;

import com.techstore.web.dao.CategoriaRepository;
import com.techstore.web.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public List<Categoria> findAllOrdered() {
        return categoriaRepository.findAll(Sort.by("orden").and(Sort.by("nombre")));
    }
}
