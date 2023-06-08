package com.dawes.WS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.DTO.FincaDTO;
import com.dawes.DTO.RecoleccionDTO;
import com.dawes.DTO.TratamientoDTO;
import com.dawes.DTO.VariedadDTO;
import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
import com.dawes.modelo.RecoleccionVO;
import com.dawes.modelo.TratamientoVO;
import com.dawes.modelo.VariedadVO;
import com.dawes.servicio.ServicioArbol;
import com.dawes.servicio.ServicioFinca;
import com.dawes.servicio.ServicioRecoleccion;
import com.dawes.servicio.ServicioTratamiento;
import com.dawes.servicio.ServicioVariedad;

@RestController
public class WSController {
	@Autowired
	ServicioVariedad sv;
	@Autowired
	ServicioFinca sf;
	@Autowired
	ServicioTratamiento st;
	@Autowired
	ServicioRecoleccion sr;
	@Autowired
	ServicioArbol sa;
	
	@GetMapping("/fincas")
	ResponseEntity<?> consultaFincas(){
		Iterable<FincaVO> fincas = sf.findAll();
		List<FincaDTO> fincaDTO = new ArrayList<>();
		for(FincaVO f : fincas)
		{
			fincaDTO.add(new FincaDTO(f.getIdfinca(), f.getNombre(), f.getDireccion(), f.getSuperficie(), f.getFecha()));
		}
		return new ResponseEntity<List<FincaDTO>>(fincaDTO, HttpStatus.OK);
	}
	
	@PutMapping("/arboles/{fila}/{columna}/{nombre}/{ubicacion}")
	ResponseEntity<?> actualizaUbicacion(@PathVariable int fila, @PathVariable int columna, @PathVariable String nombre, @PathVariable String ubicacion){
		try {
			FincaVO finca = sf.findByNombre(nombre).get();
			ArbolVO arbol = sa.findByColumnaAndFilaAndFinca(fila, columna, finca).get();
			sa.save(arbol);
			return new ResponseEntity<>(arbol, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/fincas/{idfinca}")
	ResponseEntity<?> consultaFincaPorId(@PathVariable int idfinca){
		try {
			FincaVO f = sf.findById(idfinca).get();
			
			FincaDTO fincaDTO = new FincaDTO(f.getIdfinca(), f.getNombre(), f.getDireccion(), f.getSuperficie(), f.getFecha());
		    
			return new ResponseEntity<FincaDTO>(fincaDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Finca no encontrada", HttpStatus.NOT_FOUND);
		}
	   
	}
	
	@DeleteMapping("/fincas/{idfinca}")
	ResponseEntity<?> borrarFinca(@PathVariable int idfinca)
	{
		try {
			 sf.deleteById(idfinca);
		        return new ResponseEntity<String>("Finca eliminada", HttpStatus.OK);

		}catch (Exception e) {
	        return new ResponseEntity<String>("Finca no encontrada", HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping("/variedades")
	ResponseEntity<?> consultaVariedades()
	{
		Iterable<VariedadVO> variedades = sv.findAll();
		List<VariedadDTO> variedadDTO = new ArrayList<>();
		for(VariedadVO v : variedades)
		{
			variedadDTO.add(new VariedadDTO(v.getIdvariedad(), v.getNombre()));
		}
		
		return new ResponseEntity<List<VariedadDTO>>(variedadDTO, HttpStatus.OK);
	}
	@GetMapping("/variedades/{idvariedad}")
	ResponseEntity<?> consultaVariedadPorId(@PathVariable int idvariedad)
	{
		
		try {
			VariedadVO v = sv.findById(idvariedad).get();
			
			VariedadDTO variedadDTO = new VariedadDTO(v.getIdvariedad(), v.getNombre());
		    
			return new ResponseEntity<VariedadDTO>(variedadDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Variedad no encontrada", HttpStatus.NOT_FOUND);
		}
	   
	}
	
	@DeleteMapping("/variedades/{idvariedad}")
	ResponseEntity<?> borrarVariedad(@PathVariable int idvariedad)
	{
		try {
			 sv.deleteById(idvariedad);
		        return new ResponseEntity<String>("Variedad eliminada", HttpStatus.OK);

		}catch (Exception e) {
	        return new ResponseEntity<String>("Variedad no encontrada", HttpStatus.NOT_FOUND);

		}
	}
	@GetMapping("/tratamientos")
	ResponseEntity<?> consultaTratamientos()
	{
		Iterable<TratamientoVO> tratamientos = st.findAll();
		List<TratamientoDTO> tratamientoDTO = new ArrayList<>();
		for(TratamientoVO t : tratamientos)
		{
			tratamientoDTO.add(new TratamientoDTO(t.getIdtratamiento(), t.getNombre(), t.getDescripcion(), t.getTipo()));
		}
		
		return new ResponseEntity<List<TratamientoDTO>>(tratamientoDTO, HttpStatus.OK);
	}
	@GetMapping("/tratamientos/{idtratamiento}")
	ResponseEntity<?> consultaTratamientoPorId(@PathVariable int idtratamiento)
	{
		
		try {
			TratamientoVO t = st.findById(idtratamiento).get();
			
			TratamientoDTO tratamientoDTO = new TratamientoDTO(t.getIdtratamiento(), t.getNombre(), t.getDescripcion(), t.getTipo());
		    
			return new ResponseEntity<TratamientoDTO>(tratamientoDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Tratamiento no encontrado", HttpStatus.NOT_FOUND);
		}
	   
	}
	
	@DeleteMapping("/tratamientos/{idtratamiento}")
	ResponseEntity<?> borrarTratamiento(@PathVariable int idtratamiento)
	{
		try {
			 st.deleteById(idtratamiento);
		        return new ResponseEntity<String>("Tratamiento eliminado", HttpStatus.OK);

		}catch (Exception e) {
	        return new ResponseEntity<String>("Tratamiento no encontrado", HttpStatus.NOT_FOUND);

		}
	}
	@GetMapping("/recolecciones")
	ResponseEntity<?> consultaRecolecciones()
	{
		Iterable<RecoleccionVO> recolecciones = sr.findAll();
		List<RecoleccionDTO> recoleccionDTO = new ArrayList<>();
		for(RecoleccionVO r : recolecciones)
		{
			recoleccionDTO.add(new RecoleccionDTO(r.getIdrecoleccion(), r.getFechaRecogida(), r.getRecolecta(), r.getFinca(), r.getVariedad()));
		}
		return new ResponseEntity<List<RecoleccionDTO>>(recoleccionDTO, HttpStatus.OK);
	}
	@GetMapping("/recolecciones/{idrecoleccion}")
	ResponseEntity<?> consultaRecoleccionPorId(@PathVariable int idrecoleccion)
	{
		
		try {
			RecoleccionVO r = sr.findById(idrecoleccion).get();
			
			RecoleccionDTO recoleccionDTO = new RecoleccionDTO(r.getIdrecoleccion(), r.getFechaRecogida(), r.getRecolecta(), r.getFinca(), r.getVariedad());
		    
			return new ResponseEntity<>(recoleccionDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Recoleccion no encontrada", HttpStatus.NOT_FOUND);
		}
	   
	}
	
	@DeleteMapping("/recolecciones/{idrecoleccion}")
	ResponseEntity<?> borrarRecoleccion(@PathVariable int idrecoleccion)
	{
		try {
			 sr.deleteById(idrecoleccion);
		        return new ResponseEntity<String>("Recoleccion eliminada", HttpStatus.OK);

		}catch (Exception e) {
	        return new ResponseEntity<String>("Recoleccion no encontrada", HttpStatus.NOT_FOUND);

		}
	}
}
