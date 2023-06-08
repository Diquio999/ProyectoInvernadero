package com.dawes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
@Repository
public interface ArbolRepository extends JpaRepository<ArbolVO, Integer> {

}

