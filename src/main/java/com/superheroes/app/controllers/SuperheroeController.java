package com.superheroes.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.superheroes.app.models.dao.ISuperheroeDao;
import com.superheroes.app.models.entity.SuperHeroe;

@Controller
public class SuperheroeController {

	@Autowired
	private ISuperheroeDao superheroeDao;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de superheroes");
		model.addAttribute("superheroes", superheroeDao.findAll());
		return "listar";

	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		SuperHeroe superheroe = new SuperHeroe();
		model.put("superheroe", superheroe);
		model.put("titulo", "Formulario de Superheroe");

		return "form";

	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value ="id")Long id, Map<String, Object> model) {

		SuperHeroe superheroe =null;
		if(id > 0 ) {
			superheroe= superheroeDao.findOne(id);
		}else {
			return "redirect:/listar";
		}
       model.put("superheroe", superheroe);
       model.put("titulo", "Editar superheroe");
		return "form";

	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid SuperHeroe superheroe, Model model) {

		superheroeDao.save(superheroe);
		return "redirect:listar";

	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value ="id")Long id) {

		
		if(id > 0 ) {
			superheroeDao.delete(id);
		}
		return "redirect:/listar";

	}

}
