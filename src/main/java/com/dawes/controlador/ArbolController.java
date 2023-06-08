package com.dawes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.TratamientoArbolVO;
import com.dawes.servicioImpl.ServicioArbolImpl;
import com.dawes.servicioImpl.ServicioFincaImpl;
import com.dawes.servicioImpl.ServicioTratamientoArbolImpl;
import com.dawes.servicioImpl.ServicioVariedadImpl;

@Controller
@RequestMapping("/arbol")
public class ArbolController {
	@Autowired
	ServicioArbolImpl sa;
	@Autowired
	ServicioFincaImpl sf;;
	@Autowired
	ServicioVariedadImpl sv;
	@Autowired
	ServicioTratamientoArbolImpl sta;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("arbol", sa.findAll());
		return "Arbol/mostrar";
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("arbol", new ArbolVO());
		modelo.addAttribute("finca", sf.findAll());
		modelo.addAttribute("variedad", sv.findAll());
		return "Arbol/forminsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute ArbolVO arbol,Model modelo) {
		sa.save(arbol);
		modelo.addAttribute("arbol", sa.findAll());
		return "Arbol/mostrar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idarbol") int idarbol, Model modelo) {
		List<TratamientoArbolVO> ta = (List<TratamientoArbolVO>) sta.findAll();
		for(TratamientoArbolVO tt : ta) {
			if(tt.getArbol().getIdarbol() == idarbol) {
				sta.deleteById(tt.getIdtratamientoarbol());
			}
		}
		sa.deleteById(idarbol);
		modelo.addAttribute("arbol", sa.findAll());
		return "Arbol/mostrar";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("finca") ArbolVO arbol, Model modelo) {
		sa.save(arbol);
        modelo.addAttribute("arbol", sa.findAll());
        return "Arbol/mostrar";
    }
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("idarbol") int idarbol, Model modelo) {
		modelo.addAttribute("arbol", sa.findById(idarbol));
		return "Arbol/editar";
	}
}
