package com.example.fantastic4frontend.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ModuleDTO {
    private Long id;
    @NotNull(message = "NotNull.moduleDTO.libellé")
    private String libelle;
    private List<NiveauDTO> niveaux;


    public ModuleDTO() {
    }

    public ModuleDTO(Long id, @NotNull(message = "NotNull.moduleDTO.libellé") String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public ModuleDTO(Long id, @NotNull(message = "NotNull.moduleDTO.libellé") String libelle, List<NiveauDTO> niveaux) {
        this.id = id;
        this.libelle = libelle;
        this.niveaux = niveaux;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<NiveauDTO> getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(List<NiveauDTO> niveaux) {
        this.niveaux = niveaux;
    }
}
