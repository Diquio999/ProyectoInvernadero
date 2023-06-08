package com.dawes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.VariedadVO;

@Repository
public interface VariedadRepositorio extends JpaRepository<VariedadVO, Long>{

}
