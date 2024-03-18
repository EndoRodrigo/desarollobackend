package main.java.com.fullcell.demo.model;

@Entity
public class phone {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String image;
    private int price;
    private String peso;
    private String marcaDeProcesador;
    private String red;
    private String velocidadMaximaNucleos;
    private String tipoDeCamaraFrontal;
    private String memoriaInterna;
    private String gama;

}
