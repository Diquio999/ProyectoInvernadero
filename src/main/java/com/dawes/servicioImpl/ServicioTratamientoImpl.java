package com.dawes.servicioImpl;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dawes.modelo.TratamientoVO;
import com.dawes.repositorio.TratamientoRepositorio;

@Service
@Transactional
public class ServicioTratamientoImpl{

	@Autowired
	private TratamientoRepositorio repo;
	
	public TratamientoVO save(TratamientoVO tratamiento) {
		return repo.save(tratamiento);

	}

	


	public TratamientoVO findById(Integer id) {
		Optional<TratamientoVO> tratamiento = repo.findById(id);
		if (tratamiento.isPresent()) {
			return tratamiento.get();
		}
		return null;
	}
	
	


	
	public List<TratamientoVO> findAll() {
		List<TratamientoVO> tratamientos = repo.findAll();
		return tratamientos;
	}

	
	public void deleteById(Integer id) {
		tr.deleteById(id);
		
	}

}
