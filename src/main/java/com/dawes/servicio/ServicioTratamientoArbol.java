package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.TratamientoArbolVO;

public interface ServicioTratamientoArbol {
	
	<S extends TratamientoArbolVO> S save(S entity);

	<S extends TratamientoArbolVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TratamientoArbolVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TratamientoArbolVO> findAll();

	Iterable<TratamientoArbolVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TratamientoArbolVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends TratamientoArbolVO> entities);

	void deleteAll();
}
