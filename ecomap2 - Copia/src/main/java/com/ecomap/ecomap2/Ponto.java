package com.ecomap.ecomap2;

import java.util.List;

public class Ponto {
    private String nome;
    private List<String> aliases;
    private List<Double> coordenadas;
    private String popup;

    public Ponto() {}

    public Ponto(String nome, List<String> aliases, List<Double> coordenadas, String popup) {
        this.nome = nome;
        this.aliases = aliases;
        this.coordenadas = coordenadas;
        this.popup = popup;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<String> getAliases() { return aliases; }
    public void setAliases(List<String> aliases) { this.aliases = aliases; }

    public List<Double> getCoordenadas() { return coordenadas; }
    public void setCoordenadas(List<Double> coordenadas) { this.coordenadas = coordenadas; }

    public String getPopup() { return popup; }
    public void setPopup(String popup) { this.popup = popup; }
}
