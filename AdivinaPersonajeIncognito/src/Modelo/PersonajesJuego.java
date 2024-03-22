/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guerr
 */
abstract class PersonajesJuego {
     public String nombre; 
   public boolean gorro; 
   public boolean barba; 
   public boolean peloCorto; 
   public boolean peloLargo; 
   public boolean calvo; 
   public boolean bigote; 
   public boolean morocho; 
   public boolean pelirrojo; 
   public boolean rubio; 
   public boolean narizGrande;
   public boolean narizChica; 

   public PersonajesJuego(){
       
   }
   public PersonajesJuego(String nombre, boolean gorro, boolean barba, boolean peloCorto, boolean peloLargo,
           boolean calvo, boolean bigote, boolean rubio, boolean morocho, boolean pelirrojo, boolean narizGrande, boolean narizChica){
       this.nombre=nombre; 
       this.gorro = gorro; 
       this.barba=barba; 
       this.peloCorto=peloCorto; 
       this.peloLargo=peloLargo; 
       this.calvo=calvo; 
       this.bigote=bigote; 
       this.rubio=rubio; 
       this.morocho=morocho; 
       this.pelirrojo=pelirrojo;
       this.narizChica=narizChica;
       this.narizGrande=narizGrande;
   }
}
