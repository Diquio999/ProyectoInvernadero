package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.VariedadVO;

@Repository
public interface VariedadRepositorio extends CrudRepository<VariedadVO, Integer>{

}
