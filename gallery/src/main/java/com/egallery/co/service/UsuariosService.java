package com.egallery.co.service;

import com.egallery.co.domain.Obras;
import com.egallery.co.domain.Usuarios;
import com.egallery.co.repository.ObrasRepoI;
import com.egallery.co.repository.ObrasRepositoryI;
import com.egallery.co.repository.UsuariosRepoI;
import com.egallery.co.repository.UsuariosRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements UsuariosRepoI {

    @Autowired
    UsuariosRepositoryI usuariosRepositoryI;

    @Override
    public Usuarios findById(Long id) {
        Optional<Usuarios> usuarios = usuariosRepositoryI.findById(id);
        return usuarios.orElseGet(Usuarios::new);
    }

    @Override
    public boolean save(Usuarios usuarios) {
        try {
            usuariosRepositoryI.save(usuarios);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Usuarios usuarios) {
        try {
            Optional<Usuarios> usuarioGuardado = usuariosRepositoryI.findById(usuarios.getId());
            Usuarios usuarioParaSave = new Usuarios();
            if (usuarioGuardado.isPresent()) {
                usuarioParaSave.setFoto(usuarios.getFoto());
                usuarioParaSave.setEdad(usuarios.getEdad());
                usuarioParaSave.setId(usuarios.getId());
                usuarioParaSave.setCorreo(usuarios.getCorreo());
                usuariosRepositoryI.save(usuarioParaSave);
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean deleteById(Long id) {
        try {
            usuariosRepositoryI.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
