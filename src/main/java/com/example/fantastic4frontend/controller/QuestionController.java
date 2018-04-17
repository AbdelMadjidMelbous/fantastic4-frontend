package com.example.fantastic4frontend.controller;


import com.example.fantastic4frontend.dto.MessageDTO;
import com.example.fantastic4frontend.dto.QuestionDTO;
import com.example.fantastic4frontend.service.ModuleServiceImpl;
import com.example.fantastic4frontend.service.QuestionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/questions") //on doit gérer les différents modules
public class QuestionController {

    @Autowired
    private QuestionServiceImpl service;
    @Autowired
    private ModuleServiceImpl moduleservice;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("questions", service.findAll());
        model.addAttribute("modules", moduleservice.findAll());
        model.addAttribute("newQuestion", new QuestionDTO());
        return "Enseignant/AjouterQuiz";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam Long id, QuestionDTO question) {
        service.update(id, question);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/questions";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newQuestion") QuestionDTO question) {
        service.create(question);
        return "redirect:/questions";
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public String handleClientError(HttpClientErrorException ex, Model model) throws IOException {
        MessageDTO dto = mapper.readValue(ex.getResponseBodyAsByteArray(), MessageDTO.class);
        model.addAttribute("error", dto.getMessage());
        return findAll(model);
    }

}
