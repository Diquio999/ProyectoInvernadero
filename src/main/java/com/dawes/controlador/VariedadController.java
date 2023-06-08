package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dawes.modelo.VariedadVO;
import com.dawes.servicio.ServicioVariedad;

@Controller
@RequestMapping("/variedad")
public class VariedadController {
	
	@Autowired
	ServicioVariedad sa;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("variedad", sa.findAll());
		return "Variedad/mostrar";
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("variedad", new VariedadVO());
		return "Variedad/forminsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute VariedadVO variedad,Model modelo) {
		sa.save(variedad);
		modelo.addAttribute("variedad", sa.findAll());
		return "Variedad/mostrar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idvariedad") int idvariedad, Model modelo) {
		sa.deleteById(idvariedad);
		modelo.addAttribute("variedad", sa.findAll());
		return "Variedad/mostrar";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("variedad") VariedadVO variedad, Model modelo) {
        sa.save(variedad);
        modelo.addAttribute("variedad", sa.findAll());
        return "Variedad/mostrar";
    }
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("idvariedad") int idvariedad, Model modelo) {
		modelo.addAttribute("variedad", sa.findById(idvariedad));
		return "Variedad/editar";
	}
}