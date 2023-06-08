package com.dawes.servicioImpl;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dawes.modelo.VariedadVO;
import com.dawes.repositorio.VariedadRepositorio;

@Service
@Transactional
public class ServicioVariedadImpl implements ServicioVariedad{
	@Autowired
	private VariedadRepositorio repo;
	
	public VariedadVO save(VariedadVO variedad) {
		return repo.save(variedad);

	}
	public VariedadVO findById(Long id) {
		Optional<VariedadVO> variedad = repo.findById(id);
		if (variedad.isPresent()) {
			return variedad.get();
		}
		return null;
	}
	
		public List<VariedadVO> findAll() {
		List<VariedadVO> variedades = repo.findAll();
		return variedades;
	}
	

	
	public void deleteById(Integer id) {
		vr.deleteById(id);
		
	}


}
