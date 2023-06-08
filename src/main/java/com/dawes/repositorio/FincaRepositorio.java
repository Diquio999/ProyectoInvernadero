package com.dawes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dawes.modelo.FincaVO;
import com.dawes.modelo.RecoleccionVO;

@Repository
public interface FincaRepositorio extends CrudRepository<FincaVO, Integer>{
	Optional<FincaVO> findByNombre(String nombre);
}
