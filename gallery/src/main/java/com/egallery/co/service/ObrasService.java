package com.egallery.co.service;

import com.egallery.co.domain.Obras;
import com.egallery.co.domain.Usuarios;
import com.egallery.co.domain.dtos.Precios;
import com.egallery.co.repository.ObrasRepoI;
import com.egallery.co.repository.ObrasRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObrasService implements ObrasRepoI {

    @Autowired
    ObrasRepositoryI obrasRepositoryI;

    @Override
    public Optional<Obras> findById(Long id) {
        return obrasRepositoryI.findById(id);
    }

    @Override
    public List<Obras> findAll() {
        return obrasRepositoryI.findAll();
    }

    @Override
    public boolean save(Obras obra) {
        try {
            obrasRepositoryI.save(obra);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Obras obras) {
        try {
            Optional<Obras> obra = obrasRepositoryI.findById(obras.getId());
            Obras obraParaSave = new Obras();
            if (obra.isPresent()) {
                obraParaSave.setNombre(obras.getNombre());
                obraParaSave.setDescripcion(obras.getDescripcion());
                obraParaSave.setFoto(obras.getFoto());
                obraParaSave.setId(obras.getId());
                obraParaSave.setTecnica(obras.getTecnica());
                obrasRepositoryI.save(obraParaSave);
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Obras> findByUsuarioAutor(String autor) {
        Optional<List<Obras>> obras = obrasRepositoryI.findByUsuarioAutor(autor);
        if (obras.isEmpty()){
            return new ArrayList<Obras>();
        }else{
            return obras.get();
        }
    }

    @Override
    public List<Obras> findByTecnica(String tecnica) {
        Optional<List<Obras>> obras = obrasRepositoryI.findByTecnica(tecnica);
        if (obras.isEmpty()){
            return new ArrayList<Obras>();
        }else{
            return obras.get();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            obrasRepositoryI.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Obras> findByUsuarioAutorAndTecnica(String usuarios, String tecnica) {
        Optional<List<Obras>> obrasPorUsuarioTecnica = obrasRepositoryI.findByUsuarioAutorAndTecnica(usuarios, tecnica);
        if (obrasPorUsuarioTecnica.isEmpty()){
            return new ArrayList<>();
        }else{
            return obrasPorUsuarioTecnica.get();
        }
    }

    @Override
    public boolean updatePrecios(double precio, long id){
        Optional<Obras> obra = obrasRepositoryI.findById(id);
        double precioActual = obra.get().getPrecioActual();
        try {
            int i = obrasRepositoryI.updatePrecioAnterior(precioActual, id);
            int y = obrasRepositoryI.updatePrecioActual(precio, id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateStatusVendida(boolean vendida, String usuarioComprador, double precioFinal, long idObra) {
        try {
            obrasRepositoryI.updateStatusVendida(true, idObra);
            obrasRepositoryI.updateStatusUsuarioComprador(usuarioComprador, idObra);
            obrasRepositoryI.updateStatusPrecioFinal(precioFinal, idObra);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Precios obtenerPrecios(long id) {
        Optional<Obras> obra = obrasRepositoryI.findById(id);
            return new Precios(obra.get().getPrecioAnterior(), obra.get().getPrecioActual());
    }


}
