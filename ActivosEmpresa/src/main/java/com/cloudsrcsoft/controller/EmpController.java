/*package com.cloudsrcsoft.springmvc;*/

package com.cloudsrcsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloudsrcsoft.beans.Emp;
import com.cloudsrcsoft.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired
	EmpDao dao;

	@RequestMapping("/empform")
	public ModelAndView showform() {
		/*
		 * ModelAndView Representa un modelo (lógica de datos) y vista
		 * (interface de usuario, nuestros jsp) El objeto que le inyectamos es
		 * "empform" el cual lo pasamos en la vista index.jsp como referencia
		 * "empform"
		 */
		return new ModelAndView("empform", "command", new Emp());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView guardar(@ModelAttribute("emp") Emp emp) {
		dao.save(emp);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping("/index")
	public ModelAndView listaEmpleado() {
		List<Emp> list = dao.getEmployees();
		return new ModelAndView("index", "list", list);
	}

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView editar(@PathVariable int id) {
		Emp emp = dao.getEmpById(id);
		return new ModelAndView("empeditform", "command", emp);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editarGuardado(@ModelAttribute("emp") Emp emp) {
		dao.update(emp);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView eliminar(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/index");
	}

}