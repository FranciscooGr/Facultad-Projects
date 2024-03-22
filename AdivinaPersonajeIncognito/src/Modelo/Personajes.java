/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guerr
 */
class Personajes extends PersonajesJuego{
    public Personajes(){
        
    }
    public Personajes(String nombre, boolean calvo, boolean gorro, boolean peloLargo, boolean bigote,
           boolean peloCorto, boolean barba, boolean rubio, boolean morocho, boolean pelirrojo, boolean narizGrande, boolean narizChica){
        super(nombre,gorro,barba, peloCorto, peloLargo, calvo, bigote, rubio, morocho, pelirrojo, narizGrande, narizChica); 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGorro() {
        return gorro;
    }

    public void setGorro(boolean gorro) {
        this.gorro = gorro;
    }

    public boolean isBarba() {
        return barba;
    }

    public void setBarba(boolean barba) {
        this.barba = barba;
    }

    public boolean isPeloCorto() {
        return peloCorto;
    }

    public void setPeloCorto(boolean peloCorto) {
        this.peloCorto = peloCorto;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public void setPeloLargo(boolean peloLargo) {
        this.peloLargo = peloLargo;
    }

    public boolean isCalvo() {
        return calvo;
    }

    public void setCalvo(boolean calvo) {
        this.calvo = calvo;
    }

    public boolean isBigote() {
        return bigote;
    }

    public void setBigote(boolean bigote) {
        this.bigote = bigote;
    }

    public boolean isMorocho() {
        return morocho;
    }

    public void setMorocho(boolean morocho) {
        this.morocho = morocho;
    }

    public boolean isPelirrojo() {
        return pelirrojo;
    }

    public void setPelirrojo(boolean pelirrojo) {
        this.pelirrojo = pelirrojo;
    }

    public boolean isRubio() {
        return rubio;
    }

    public void setRubio(boolean rubio) {
        this.rubio = rubio;
    }

    public boolean isNarizGrande() {
        return narizGrande;
    }

    public void setNarizGrande(boolean narizGrande) {
        this.narizGrande = narizGrande;
    }

    public boolean isNarizChica() {
        return narizChica;
    }

    public void setNarizChica(boolean narizChica) {
        this.narizChica = narizChica;
    }
    
}
