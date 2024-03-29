package com.generation.blogpessoal.client;

import com.generation.blogpessoal.vo.FilmeOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="omdbFilmes", url = "http://www.omdbapi.com/")
public interface FilmeClientOMDB {
    @RequestMapping(method = RequestMethod.GET)
     FilmeOMDB getFilme(@RequestParam("t") String tema, @RequestParam("apikey") String key);

}
