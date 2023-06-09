package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.FincaVO;
import com.dawes.modelo.RecoleccionVO;
import com.dawes.repositorio.RecoleccionRepositorio;
import com.dawes.servicio.ServicioRecoleccion;

@Service
public class ServicioRecoleccionImpl implements ServicioRecoleccion{

	@Autowired
	private RecoleccionRepositorio rr;
	
	@Override
	public <S extends RecoleccionVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public <S extends RecoleccionVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rr.saveAll(entities);
	}

	@Override
	public Optional<RecoleccionVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rr.existsById(id);
	}

	@Override
	public Iterable<RecoleccionVO> findAll() {
		return rr.findAll();
	}

	@Override
	public Iterable<RecoleccionVO> findAllById(Iterable<Integer> ids) {
		return rr.findAllById(ids);
	}

	@Override
	public long count() {
		return rr.count();
	}

	@Override
	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	@Override
	public void delete(RecoleccionVO entity) {
		rr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		rr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends RecoleccionVO> entities) {
		rr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rr.deleteAll();
	}

	@Override
	public Optional<List<RecoleccionVO>> findByFinca(FincaVO finca) {
		return rr.findByFinca(finca);
	}

}
