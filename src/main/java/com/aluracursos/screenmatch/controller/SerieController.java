package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SerieController {
   @Autowired
   private SerieService service;
   // private SerieRepository repository;  // se paso a SerieService
   // y desde el controller se llama el servicio que se necesite
   // instanciando SerieService

   @GetMapping("")
   public List<SerieDTO> obtenerTodasSeries() {
      return service.obtenerTodasSeries();
   }

   @GetMapping("/top5")
   public List<SerieDTO> obtenerTop5() {
      return service.obtenerTop5();
   }

   @GetMapping("/lanzamientos")
   public List<SerieDTO> obtenerLamzamientosMasRecientes() {
      return service.obtenerLanzamientosMasRecientes();
   }

   // mapear el id, con variables dinamicas
   @GetMapping("/{id}")
   public SerieDTO obtenerPorID(@PathVariable Long id) {
      return service.obtenerPorId(id);
   }

   // endpoint de id+temporadas+todas
   @GetMapping("/{id}/temporadas/todas")
   public List<EpisodioDTO> obtenerTodasLasTempradas(@PathVariable Long id) {
      return service.obtenerTodasLasTemporadas(id);
   }

   // emdpoint para numero de serie y numero de episodio de esa serie
   @GetMapping("/{id}/temporadas/{numeroTemporada}")
   public List<EpisodioDTO> ontenerTemporadasPorNumero(@PathVariable Long id,
                                                       @PathVariable Long numeroTemporada){
      return service.obtenerTemporadasPorNumero(id,numeroTemporada);
   }

   @GetMapping("/categoria/{nombreGenero}")
   public List<SerieDTO> obtenerSeriesPorCategoria(@PathVariable String nombreGenero){
      return service.obtenerSeriesPorCategoria(nombreGenero);
   }

//   @GetMapping("/{id}/temporadas/top")
//   public List<SerieDTO> obtenerTop5Episodios(@PathVariable Long id){
//      return service.obtenerTop5();
//   }

}
