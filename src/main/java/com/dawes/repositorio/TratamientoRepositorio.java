package com.dawes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dawes.modelo.TratamientoVO;

@Repository
public interface TratamientoRepositorio extends JpaRepository<TratamientoVO, Integer>{

}
