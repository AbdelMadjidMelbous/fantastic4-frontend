package com.example.fantastic4frontend.controller;


import com.example.fantastic4frontend.dto.MessageDTO;
import com.example.fantastic4frontend.dto.NiveauDTO;
import com.example.fantastic4frontend.service.ModuleServiceImpl;
import com.example.fantastic4frontend.service.NiveauServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/niveaux")
public class NiveauController {

    @Autowired
    private NiveauServiceImpl service;
    @Autowired
    private ModuleServiceImpl moduleservice;

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("niveaux", service.findAll());
        model.addAttribute("modules", moduleservice.findAll());
        model.addAttribute("newNiveau", new NiveauDTO());
        return "Enseignant/AjouterQuiz";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam Long id, NiveauDTO niveau) {
        service.update(id, niveau);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/niveaux";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newNiveau") NiveauDTO niveau) {
        service.create(niveau);
        return "redirect:/niveaux";
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public String handleClientError(HttpClientErrorException ex, Model model) throws IOException {
        MessageDTO dto = mapper.readValue(ex.getResponseBodyAsByteArray(), MessageDTO.class);
        model.addAttribute("error", dto.getMessage());
        return findAll(model);
    }

}
