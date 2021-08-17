package com.snivault.gestionsalonmassage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Permet de gérer les pages.
 * 
 * @author Nous
 *
 */
@Controller
public class PagesController {

	@GetMapping("/")
	public String home(@RequestParam(defaultValue = "World") String name, ModelMap modelMap) {
		modelMap.put("name", name);
		return "pages/home";
	}
}
