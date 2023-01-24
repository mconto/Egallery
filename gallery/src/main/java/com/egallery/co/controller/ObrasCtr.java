package com.egallery.co.controller;


import com.egallery.co.domain.Obras;
import com.egallery.co.domain.Usuarios;
import com.egallery.co.domain.dtos.Precios;
import com.egallery.co.response.ResponseHTTP;
import com.egallery.co.service.ObrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/egallery/obras")
public class ObrasCtr {

    @Autowired
    ObrasService obrasService;

    @GetMapping("/obtener-obras")
    public ResponseEntity<ResponseHTTP> retornaObras() {
        List<Obras> obras = obrasService.findAll();
        return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), obras),
                HttpStatus.CREATED);
    }

    @GetMapping("/obtener-obras-id")
    public ResponseEntity<ResponseHTTP> retornaObraPorId(@RequestParam Long id) {
        Optional<Obras> obras = obrasService.findById(id);
        if (obras.isPresent()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), obras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), obras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/almacenar-obra")
    public ResponseEntity<ResponseHTTP> almacenarObra(@RequestBody Obras obra) {
        try {
            boolean result = obrasService.save(obra);
            return result ?
                    new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                            HttpStatus.CREATED) : new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actualizar-obra")
    public ResponseEntity<ResponseHTTP> actualizarObra(@RequestBody Obras obras) {
        try {
            obrasService.update(obras);
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), true),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/obtener-obras-autor")
    public ResponseEntity<ResponseHTTP> retornaObraPorAutor(@RequestParam String autor) {
        List<Obras> obras = obrasService.findByUsuarioAutor(autor);
        if (!obras.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), obras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), obras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/obtener-obras-tecnica")
    public ResponseEntity<ResponseHTTP> retornaObraPorTecnica(@RequestParam String tecnica) {
        List<Obras> obras = obrasService.findByTecnica(tecnica);
        if (!obras.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), obras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), obras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/obtener-obras-autor-tecnica")
    public ResponseEntity<ResponseHTTP> retornaObraPorTecnica(@RequestParam String usuario, @RequestParam String tecnica) {
        List<Obras> obras = obrasService.findByUsuarioAutorAndTecnica(usuario, tecnica);
        if (!obras.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), obras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), obras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/actualizar-precio")
    public ResponseEntity<ResponseHTTP> actualizarPrecio(@RequestParam double precio, @RequestParam long id) {
        boolean flag  = obrasService.updatePrecios(precio, id);
        if (flag) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), flag),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), flag),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/actualizar-estado")
    public ResponseEntity<ResponseHTTP> actualizarEstado(@RequestParam boolean vendida,
                                                         @RequestParam String usuarioComprador,
                                                         @RequestParam double precioFinal,
                                                         @RequestParam long idObra) {
        boolean flag  = obrasService.updateStatusVendida(vendida, usuarioComprador, precioFinal, idObra);
        if (flag) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), flag),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), flag),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/obtener-precios")
    public ResponseEntity<ResponseHTTP> obtenerPrecios(@RequestParam long id) {
        Precios precios  = obrasService.obtenerPrecios(id);
        if (precios != null) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), precios),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), precios),
                    HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/delete-id")
    public ResponseEntity<ResponseHTTP> deleteById(@RequestParam Long id) {
        boolean flag = obrasService.deleteById(id);
        if (flag) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), flag),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), flag),
                    HttpStatus.NOT_FOUND);
        }

    }




}
