package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.TratamientoArbolVO;
import com.dawes.repositorio.TratamientoArbolRepositorio;
import com.dawes.servicio.ServicioTratamientoArbol;

@Service
public class ServicioTratamientoArbolImpl implements ServicioTratamientoArbol{
	@Autowired
	private TratamientoArbolRepositorio tar;

	@Override
	public <S extends TratamientoArbolVO> S save(S entity) {
		return tar.save(entity);
	}

	@Override
	public <S extends TratamientoArbolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return tar.saveAll(entities);
	}

	@Override
	public Optional<TratamientoArbolVO> findById(Integer id) {
		return tar.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return tar.existsById(id);
	}

	@Override
	public Iterable<TratamientoArbolVO> findAll() {
		return tar.findAll();
	}

	@Override
	public Iterable<TratamientoArbolVO> findAllById(Iterable<Integer> ids) {
		return tar.findAllById(ids);
	}

	@Override
	public long count() {
		return tar.count();
	}

	@Override
	public void deleteById(Integer id) {
		tar.deleteById(id);
		
	}

	@Override
	public void delete(TratamientoArbolVO entity) {
		tar.delete(entity);
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		tar.deleteAllById(ids);
		
	}

	@Override
	public void deleteAll(Iterable<? extends TratamientoArbolVO> entities) {
		tar.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tar.deleteAll();
	}
}
