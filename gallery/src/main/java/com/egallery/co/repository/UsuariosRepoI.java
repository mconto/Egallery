package com.egallery.co.repository;

import com.egallery.co.domain.Obras;
import com.egallery.co.domain.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepoI {

    Usuarios findById(Long id);
    boolean save(Usuarios usuarios);
    boolean update(Usuarios usuarios);

    boolean deleteById(Long id);


}
