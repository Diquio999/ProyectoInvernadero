package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dawes.modelo.TratamientoVO;

@Repository
public interface TratamientoRepositorio extends CrudRepository<TratamientoVO, Integer>{

}
