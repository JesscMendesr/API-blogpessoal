package com.generation.blogpessoal.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.blogpessoal.model.Usuario;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

public class FilmeVO extends RepresentationModel<FilmeVO> {
    private Long id;
    private String runtime;

    private String title;

    private String year;

    private String director;

    private String country;
    private String poster;
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
