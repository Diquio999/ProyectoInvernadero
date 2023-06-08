package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
import com.dawes.repositorio.ArbolRepositorio;
import com.dawes.repositorio.FincaRepositorio;
import com.dawes.servicio.ServicioArbol;

@Service
public class ServicioArbolImpl implements ServicioArbol {

	@Autowired
	private ArbolRepositorio ar;
	
	@Override
	public <S extends ArbolVO> S save(S entity) {
		return ar.save(entity);
	}

	@Override
	public <S extends ArbolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ar.saveAll(entities);
	}

	@Override
	public Optional<ArbolVO> findById(Integer id) {
		return ar.findById(id);
	}

	@Override
	public Optional<ArbolVO> findByColumnaAndFilaAndFinca(int fila, int columna, FincaVO finca) {
		return ar.findByColumnaAndFilaAndFinca(fila, columna, finca);
	}

	@Override
	public boolean existsById(Integer id) {
		return ar.existsById(id);
	}

	@Override
	public Iterable<ArbolVO> findAll() {
		return ar.findAll();
	}

	@Override
	public Iterable<ArbolVO> findAllById(Iterable<Integer> ids) {
		return ar.findAllById(ids);
	}

	@Override
	public long count() {
		return ar.count();
	}

	@Override
	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

	@Override
	public void delete(ArbolVO entity) {
		ar.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		ar.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends ArbolVO> entities) {
		ar.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ar.deleteAll();
	}

}
