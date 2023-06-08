package com.dawes.repositorio;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RecoleccionVO;
@Repository
public interface RecoleccionRepository extends JpaRepository<RecoleccionVO, Integer>{

}
