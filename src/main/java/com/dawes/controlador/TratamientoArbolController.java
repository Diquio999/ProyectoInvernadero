package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dawes.modelo.TratamientoArbolVO;
import com.dawes.servicioImpl.ServicioArbolImpl;
import com.dawes.servicioImpl.ServicioFincaImpl;
import com.dawes.servicioImpl.ServicioTratamientoImpl;
import com.dawes.servicioImpl.ServicioTratamientoArbolImpl;
import com.dawes.servicioImpl.ServicioVariedadImpl;

@Controller
@RequestMapping("/tratamientosarbol")
public class TratamientoArbolController {

	@Autowired
	ServicioArbolImpl sa;
	@Autowired
	ServicioFincaImpl sf;
	@Autowired
	ServicioVariedadImpl sv;
	@Autowired
	ServicioTratamientoImpl st;
	@Autowired
	ServicioTratamientoArbolImpl sta;
	
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("tratamientosarbol", sta.findAll());
		return "TratamientosArbol/mostrar";
	}

	@RequestMapping("/forminsertar")
	public String forminsertar(Model model) {
		model.addAttribute("tratamientosarbol", new TratamientoArbolVO());
		model.addAttribute("arbol", sa.findAll());
		model.addAttribute("tratamiento", st.findAll());
		return "TratamientosArbol/forminsertar";
	}

	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute TratamientoArbolVO tratamientosarbol,Model modelo) {
		sta.save(tratamientosarbol);
		modelo.addAttribute("tratamientosarbol", sta.findAll());
		return "TratamientosArbol/mostrar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idtratamientoarbol") int idtratamientoarbol, Model modelo) {
		sta.deleteById(idtratamientoarbol);
		modelo.addAttribute("tratamientosarbol", sta.findAll());
		return "TratamientosArbol/mostrar";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tratamientosarbol") TratamientoArbolVO tratamientosarbol, Model modelo) {
		sta.save(tratamientosarbol);
        modelo.addAttribute("tratamientosarbol", sta.findAll());
        return "TratamientosArbol/mostrar";
    }
}
