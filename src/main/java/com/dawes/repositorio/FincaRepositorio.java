package com.dawes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dawes.modelo.FincaVO;

@Repository
public interface FincaRepository extends JpaRepository<FincaVO, Long> {

}
