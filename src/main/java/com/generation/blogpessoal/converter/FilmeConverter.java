package com.generation.blogpessoal.converter;

import com.generation.blogpessoal.dto.FilmeDTO;
import com.generation.blogpessoal.model.Filme;
import com.generation.blogpessoal.vo.FilmeVO;
import org.springframework.stereotype.Component;

@Component
public class FilmeConverter {

    public Filme converterParaFilme(FilmeDTO filmeDTO){
        Filme filme = new Filme();
        filme.setTitle(filmeDTO.getTitle());
        filme.setYear(filmeDTO.getYear());
        filme.setCountry(filmeDTO.getCountry());
        filme.setDirector(filmeDTO.getDirector());
        filme.setRuntime(filmeDTO.getRuntime());
        filme.setPoster(filmeDTO.getPoster());
        filme.setUsuario(filmeDTO.getUsuario());
        return filme;
    }

    public FilmeVO converterParaFilmeVO(Filme filme){
        FilmeVO filmeVO = new FilmeVO();
        filmeVO.setId(filme.getId());
        filmeVO.setTitle(filme.getTitle());
        filmeVO.setYear(filme.getYear());
        filmeVO.setCountry(filme.getCountry());
        filmeVO.setDirector(filme.getDirector());
        filmeVO.setRuntime(filme.getRuntime());
        filmeVO.setPoster(filme.getPoster());
        filmeVO.setUsuario(filme.getUsuario());
        return filmeVO;
    }
}
