package com.example.fantastic4frontend.controller;

import com.example.dto.MessageDTO;
import com.example.dto.QuestionDTO;
import com.example.dto.ModuleDTO;
//
import com.example.dto.NiveauDTO;
import com.example.models.Niveau;
import com.example.models.Question;
import com.example.models.Module;

import com.example.service.QuestionServiceImpl;
//
import com.example.service.ModuleServiceImpl;
import com.example.service.NiveauServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Locale;


public class QuestionController {

}
