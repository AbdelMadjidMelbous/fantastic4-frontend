package com.example.fantastic4frontend.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class NiveauDTO {

    private Long id;
    @NotNull(message = "NotNull.niveauDTO.libellé")
    private String libelle;
    @NotNull(message = "NotNull.niveauDTO.poids")
    private int poids;
    private ModuleDTO module;
    private List<QuestionDTO> questions;

    public NiveauDTO() {
    }

    public NiveauDTO(Long id, @NotNull(message = "NotNull.niveauDTO.libellé") String libelle, @NotNull(message = "NotNull.moduleDTO.poids") int poids) {
        this.id = id;
        this.libelle = libelle;
        this.poids = poids;
    }

    public NiveauDTO(Long id, @NotNull(message = "NotNull.niveauDTO.libellé") String libelle, @NotNull(message = "NotNull.moduleDTO.poids") int poids, ModuleDTO module, List<QuestionDTO> questions) {
        this.id = id;
        this.libelle = libelle;
        this.poids = poids;
        this.module = module;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public ModuleDTO getModule() {
        return module;
    }

    public void setModule(ModuleDTO module) {
        this.module = module;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
