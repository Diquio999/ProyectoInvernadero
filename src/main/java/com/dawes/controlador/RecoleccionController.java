package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FincaVO;
import com.dawes.modelo.RecoleccionVO;
import com.dawes.servicio.ServicioFinca;
import com.dawes.servicio.ServicioRecoleccion;
import com.dawes.servicio.ServicioVariedad;


@Controller
@RequestMapping("/recoleccion")
public class RecoleccionController {
	@Autowired
	ServicioRecoleccion sr;
	@Autowired
	ServicioFinca sf;
	@Autowired
	ServicioVariedad sv;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("recoleccion", sr.findAll());
		return "Recoleccion/mostrar";
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("recoleccion", new RecoleccionVO());
		modelo.addAttribute("finca", sf.findAll());
		modelo.addAttribute("variedad", sv.findAll());
		return "Recoleccion/forminsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute RecoleccionVO recoleccion,Model modelo) {
		sr.save(recoleccion);
		modelo.addAttribute("recoleccion", sr.findAll());
		return "Recoleccion/mostrar";
	}
	

	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idrecoleccion") int idrecoleccion, Model modelo) {
		sr.deleteById(idrecoleccion);
		modelo.addAttribute("recoleccion", sr.findAll());
		return "Recoleccion/mostrar";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("recoleccion") RecoleccionVO recoleccion, Model modelo) {
		sr.save(recoleccion);
        modelo.addAttribute("recoleccion", sr.findAll());
        return "Recoleccion/mostrar";
    }
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("idrecoleccion") int idrecoleccion, Model modelo) {
		modelo.addAttribute("recoleccion", sr.findById(idrecoleccion));
		return "Recoleccion/editar";
	}
}
