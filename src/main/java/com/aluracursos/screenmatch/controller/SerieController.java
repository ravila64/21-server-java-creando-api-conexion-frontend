package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService service;
    // private SerieRepository repository;  // se paso a SerieService
    // y desde el controller se llama el servicio que se necesite
    // instanciando SerieService

    @GetMapping("")
    public List<SerieDTO> obtenerTodasSeries(){
        return service.obtenerTodasSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obtenerTop5(){
        return service.obtenerTop5();
    }

    @GetMapping("/lanzamientos")
    public List<SerieDTO> obtenerLamzamientosMasRecientes(){
        return service.obtenerLanzamientosMasRecientes();
    }

    // este mapeo de ejemplo se puede borrar
    @GetMapping("/inicio")
    public String Bienvenida(){
        return "Probando Live reloading ...";
    }

}
