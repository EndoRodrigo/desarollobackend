package com.back.demo.model;

import jakarta.persistence.*;


@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private double price;
    private String peso;
    private String marcaDeProcesador;
    private String red;
    private String velocidadMaximaNucleos;
    private String tipoDeCamaraFrontal;
    private String memoriaInterna;
    private String gama;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getMarcaDeProcesador() {
        return marcaDeProcesador;
    }
    public void setMarcaDeProcesador(String marcaDeProcesador) {
        this.marcaDeProcesador = marcaDeProcesador;
    }
    public String getRed() {
        return red;
    }
    public void setRed(String red) {
        this.red = red;
    }
    public String getVelocidadMaximaNucleos() {
        return velocidadMaximaNucleos;
    }
    public void setVelocidadMaximaNucleos(String velocidadMaximaNucleos) {
        this.velocidadMaximaNucleos = velocidadMaximaNucleos;
    }
    public String getTipoDeCamaraFrontal() {
        return tipoDeCamaraFrontal;
    }
    public void setTipoDeCamaraFrontal(String tipoDeCamaraFrontal) {
        this.tipoDeCamaraFrontal = tipoDeCamaraFrontal;
    }
    public String getMemoriaInterna() {
        return memoriaInterna;
    }
    public void setMemoriaInterna(String memoriaInterna) {
        this.memoriaInterna = memoriaInterna;
    }
    public String getGama() {
        return gama;
    }
    public void setGama(String gama) {
        this.gama = gama;
    }

    

    

}
