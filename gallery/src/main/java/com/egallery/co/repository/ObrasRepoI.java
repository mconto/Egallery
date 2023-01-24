package com.egallery.co.repository;

import com.egallery.co.domain.Obras;
import com.egallery.co.domain.Usuarios;
import com.egallery.co.domain.dtos.Precios;

import java.util.List;
import java.util.Optional;

public interface ObrasRepoI {

    Optional<Obras> findById(Long id);
    List<Obras> findAll();
    boolean save(Obras obra);
    boolean update(Obras obras);

    List<Obras> findByUsuarioAutor(String autor);
    List<Obras> findByTecnica(String tecnica);
    boolean deleteById(Long id);
    List<Obras> findByUsuarioAutorAndTecnica(String autor, String tecnica);
    boolean updatePrecios(double precio, long id);
    boolean updateStatusVendida(boolean vendida, String usuarioComprador, double precioFinal, long idObra);
    Precios obtenerPrecios(long id);

}
