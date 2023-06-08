package com.dawes.servicioImpl;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dawes.modelo.TratamientoArbolVO;
import com.dawes.repositorio.TratamientoArbolRepositorio;
import com.dawes.modelo.ArbolVO;

@Service
@Transactional
public class ServicioTratamientoArbolImpl{
	@Autowired
	private TratamientoArbolRepositorio repo;

	public TratamientoArbolVO save(TratamientoArbolVO tratamientoarbol) {
		return repo.save(tratamientoarbol);

	}
	public TratamientoArbolVO findById(Integer id) {
		Optional<TratamientoArbolVO> tratamientoarbol = repo.findById(id);
		if (tratamientoarbol.isPresent()) {
			return tratamientoarbol.get();
		}
		return null;
	}



public List<TratamientoArbolVO> findAll() {
		List<TratamientoArbolVO> tratamientoarboles = repo.findAll();
		return tratamientoarboles;
	}

	
	//TRATAMIENTOS POR ARBOL
	public Optional<List<TratamientoArbolVO>> findAllByArbol(ArbolVO arbol) {
		return repo.findAllByArbol(arbol);
	}
	

	
	public void deleteById(Integer id) {
		tar.deleteById(id);
		
	}

	
}
