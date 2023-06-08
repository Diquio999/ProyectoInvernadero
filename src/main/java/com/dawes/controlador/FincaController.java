package com.dawes.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
import com.dawes.modelo.TratamientoArbolVO;
import com.dawes.servicioImpl.ServicioArbolImpl;
import com.dawes.servicioImpl.ServicioFincaImpl;

@Controller
@RequestMapping("/finca")
public class FincaController {
	@Autowired
	ServicioFincaImpl sf;
	@Autowired
	ServicioArbolImpl sa;
	
	@RequestMapping("/mostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("finca", sf.findAll());
		return "Finca/mostrar";
	}
	
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo) {
		modelo.addAttribute("finca", new FincaVO());
		return "Finca/forminsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute FincaVO finca,Model modelo) {
		sf.save(finca);
		modelo.addAttribute("finca", sf.findAll());
		return "Finca/mostrar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idfinca") int idfinca, Model modelo) {
		List<ArbolVO> ta = (List<ArbolVO>) sa.findAll();
		for(ArbolVO tt : ta) {
			if(tt.getFinca().getIdfinca() == idfinca) {
				sa.deleteById(tt.getIdarbol());
			}
		}
		sf.deleteById(idfinca);
		modelo.addAttribute("finca", sf.findAll());
		return "Finca/mostrar";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("finca") FincaVO finca, Model modelo) {
		sf.save(finca);
        modelo.addAttribute("finca", sf.findAll());
        return "Finca/mostrar";
    }
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("idfinca") int idfinca, Model modelo) {
		modelo.addAttribute("finca", sf.findById(idfinca));
		return "Finca/editar";
	}
	
	@RequestMapping("/mapafinca/{id}")
	public String Mapa(Model model, @PathVariable(name = "id") int id) {
		int[][] matriz = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 },
					{ -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } };
		Optional<FincaVO> finca= sf.findById(id);
		List<ArbolVO> arboles = (List<ArbolVO>) sa.findAll();
		if(false) {
			String nombreFinca = finca.get().getNombre(); 
		for (ArbolVO arbolVO : arboles) {
			if (arbolVO.getFinca().getIdfinca() == id)
			matriz[arbolVO.getFila() - 1][arbolVO.getColumna() - 1] = arbolVO.getIdarbol();
		}
		model.addAttribute("matriz", matriz);
		model.addAttribute("nombreFinca", nombreFinca);
		return "mapa";
		}
		
		return "Finca/mostrar";
	}
}
