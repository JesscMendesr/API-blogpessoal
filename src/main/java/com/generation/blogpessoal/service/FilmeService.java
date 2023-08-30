package com.generation.blogpessoal.service;

import com.generation.blogpessoal.client.FilmeClientOMDB;
import com.generation.blogpessoal.converter.FilmeConverter;
import com.generation.blogpessoal.dto.FilmeDTO;
import com.generation.blogpessoal.model.Filme;
import com.generation.blogpessoal.repository.FilmeRepository;
import com.generation.blogpessoal.vo.FilmeOMDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Value("${omdb.apikey}")
    private String apiKey;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private FilmeConverter filmeConverter;

    @Autowired
    private FilmeClientOMDB clientOMDB;

    public FilmeOMDB getFilme(String title){
        return clientOMDB.getFilme(title, apiKey);
    }


    public Filme save(FilmeDTO filmeDTO){
        Filme filme = filmeConverter.converterParaFilme(filmeDTO);
        return filmeRepository.save(filme);
    }

    public Filme getById(Long id){
        return filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado."));
    }

}
