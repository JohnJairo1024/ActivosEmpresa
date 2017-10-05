package com.cloudsrcsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloudsrcsoft.beans.Persona;
import com.cloudsrcsoft.dao.PersonaDao;

public class PersonaController {

	@Autowired
	PersonaDao dao;

	@RequestMapping("/personaform")
	public ModelAndView showform() {
		/*
		 * ModelAndView Representa un modelo (lógica de datos) y vista
		 * (interface de usuario, nuestros jsp) El objeto que le inyectamos es
		 * "personaform" el cual lo pasamos en la vista index.jsp como referencia
		 * "empform"
		 */
		return new ModelAndView("personaform", "command", new Persona());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView guardar(@ModelAttribute("persona") Persona persona) {
		dao.save(persona);
		return new ModelAndView("redirect:/indexprueba");
	}

	@RequestMapping("/indexprueba")
	public ModelAndView listaPersona() {
		List<Persona> list = dao.obtenerPersonas();
		return new ModelAndView("indexprueba", "list", list);
	}

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView editar(@PathVariable int id) {
		Persona persona = dao.getEmpById(id);
		return new ModelAndView("empeditform", "command", persona);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editarGuardado(@ModelAttribute("persona") Persona persona) {
		dao.update(persona);
		return new ModelAndView("redirect:/indexprueba");
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView eliminar(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/indexprueba");
	}

}
