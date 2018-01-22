package com.project.LanguagesReloaded.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.LanguagesReloaded.models.Language;
import com.project.LanguagesReloaded.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController{
	private LanguageService languageService;

	public LanguageController(LanguageService languageService){
		this.languageService=languageService;
	}
	
	@RequestMapping("")
	public String languages(@ModelAttribute("language") Language language,Model model){
		model.addAttribute("languages",languageService.all());
		return "languages";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("language") Language language,BindingResult res){
		System.out.println("CREATE A LANGUAGE");

		if(res.hasErrors()){
			return "redirect:/languages";
		}else{
			languageService.create(language);
			return "redirect:/languages";
		}
		
	}

	@RequestMapping("/delete/{id}")
	public String destroy(@PathVariable("id") long id){
		languageService.destroy(id);
		return "redirect:/languages";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable("id") long id,Model model){
		model.addAttribute("language",languageService.findById(id));
		return "show_language";
	}
}
