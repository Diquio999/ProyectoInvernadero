package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.TratamientoVO;
import com.dawes.servicioImpl.ServicioTratamientoImpl;

@Controller
@RequestMapping("/tratamiento")
public class TratamientoController {
	@Autowired
	ServicioTratamientoImpl st;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("tratamiento", st.findAll());
		return "Tratamiento/mostrar";
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("tratamiento", new TratamientoVO());
		return "Tratamiento/forminsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute TratamientoVO tratamiento,Model modelo) {
		st.save(tratamiento);
		modelo.addAttribute("tratamiento", st.findAll());
		return "Tratamiento/mostrar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idtratamiento") int idtratamiento, Model modelo) {
		st.deleteById(idtratamiento);
		modelo.addAttribute("tratamiento", st.findAll());
		return "Tratamiento/mostrar";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tratamiento") TratamientoVO tratamiento, Model modelo) {
		st.save(tratamiento);
        modelo.addAttribute("tratamiento", st.findAll());
        return "Tratamiento/mostrar";
    }
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("idtratamiento") int idtratamiento, Model modelo) {
		modelo.addAttribute("tratamiento", st.findById(idtratamiento));
		return "Tratamiento/editar";
	}
}
