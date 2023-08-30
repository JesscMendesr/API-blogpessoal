package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.converter.FilmeConverter;
import com.generation.blogpessoal.dto.FilmeDTO;
import com.generation.blogpessoal.model.Filme;
import com.generation.blogpessoal.repository.FilmeRepository;
import com.generation.blogpessoal.service.FilmeService;
import com.generation.blogpessoal.vo.FilmeOMDB;
import com.generation.blogpessoal.vo.FilmeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private FilmeConverter filmeConverter;

    @GetMapping
    public ResponseEntity<List<Filme>> getAll(){
        return ResponseEntity.ok(filmeRepository.findAll());
    }

    @GetMapping("/omdb/{title}")
    private ResponseEntity<FilmeOMDB> getFilme(@PathVariable String title){
        try {
            FilmeOMDB filmeOMDB = filmeService.getFilme(title);
            return ResponseEntity.status(HttpStatus.OK).body(filmeOMDB);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeVO> getById(@PathVariable("id") Long id){
        try{
            FilmeVO filmeVO = filmeConverter.converterParaFilmeVO(filmeService.getById(id));
            return ResponseEntity.ok(filmeVO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<FilmeVO> saveFilme(@RequestBody FilmeDTO filmeDTO){
        try{
            FilmeVO filmeVO = filmeConverter.converterParaFilmeVO(filmeService.save(filmeDTO));
            addHateoas(filmeVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(filmeVO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void addHateoas(FilmeVO filmeVO) {
        filmeVO.add(linkTo(methodOn(FilmeController.class).getById(filmeVO.getId()))
                .withSelfRel());
    }

}
