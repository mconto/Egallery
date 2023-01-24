package com.egallery.co.repository;

import com.egallery.co.domain.Obras;
import com.egallery.co.domain.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepositoryI extends CrudRepository<Usuarios, Long> {

    Usuarios save(Usuarios usuarios);

    void deleteById(Long id);

}
