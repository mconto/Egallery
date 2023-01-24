package com.egallery.co.repository;

import com.egallery.co.domain.Obras;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObrasRepositoryI extends CrudRepository<Obras, Long> {

    List<Obras> findAll();

    Optional<Obras> findById(Long id);

    Obras save(Obras obras);

    Optional<List<Obras>> findByUsuarioAutor(String autor);
    Optional<List<Obras>> findByTecnica(String tecnica);

    void deleteById(Long id);

    Optional<List<Obras>> findByUsuarioAutorAndTecnica(String autor, String tecnica);

    @Transactional
    @Modifying
    @Query(value = "update dbo.obras SET precio_anterior =:precio_anterior where id=:id", nativeQuery = true)
    int updatePrecioAnterior(@Param(value = "precio_anterior") double precioAnterior, @Param(value = "id") long id);

    @Transactional
    @Modifying
    @Query(value = "update dbo.obras SET precio_actual =:precio_actual where id=:id", nativeQuery = true)
    int updatePrecioActual(@Param(value = "precio_actual") double precioActual, @Param(value = "id") long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE dbo.obras " +
            "SET vendida =:vendida " +
            "WHERE id=:id", nativeQuery = true)
    int updateStatusVendida(@Param(value = "vendida") boolean vendida,
                     @Param(value = "id") long idObra);

    @Transactional
    @Modifying
    @Query(value = "UPDATE dbo.obras " +
            "SET usuario_comprador =:usuario_comprador " +
            "WHERE id=:id", nativeQuery = true)
    int updateStatusUsuarioComprador(@Param(value = "usuario_comprador") String usuarioComprador,
                     @Param(value = "id") long idObra);

    @Transactional
    @Modifying
    @Query(value = "UPDATE dbo.obras " +
            "SET precio_final =:precio_final " +
            "WHERE id=:id", nativeQuery = true)
    int updateStatusPrecioFinal(@Param(value = "precio_final") double precioFinal,
                     @Param(value = "id") long idObra);




}
