package no.oslomet.restcountriesnor.controller;

import no.oslomet.restcountriesnor.service.RestCountriesNorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {
    @Autowired
    private RestCountriesNorService restCountriesNorService;

    @GetMapping(value = "/api/getNorData",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getNorData() throws IOException {
        return restCountriesNorService.getNorData();
    }
}
