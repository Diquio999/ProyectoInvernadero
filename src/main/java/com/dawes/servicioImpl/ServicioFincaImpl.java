package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.modelo.FincaVO;
import com.dawes.repositorio.FincaRepositorio;

@Service
@Transactional
public class ServicioFincaImpl{

	@Autowired
	private FincaRepositorio repo;
	
		public FincaVO save(FincaVO finca) {
		return repo.save(finca);

	}

		public FincaVO findById(Integer id) {
		Optional<FincaVO> finca = repo.findById(id);
		if (finca.isPresent()) {
			return finca.get();
		}
		return null;
	}


	public List<FincaVO> findAll() {
		List<FincaVO> fincas = repo.findAll();
		return fincas;
	}
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

}
