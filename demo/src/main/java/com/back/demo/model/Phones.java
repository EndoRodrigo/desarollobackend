package com.back.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phones {
	
	private String id;
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

}
