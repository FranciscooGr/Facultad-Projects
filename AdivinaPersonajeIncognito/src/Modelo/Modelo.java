/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.*;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author guerr
 */
public class Modelo {
    private String pregunta = null;
    private int personajePC=0; 
    private int numeroRandom;
    private int numeroPersonajeIA;
    private static int puntaje; 
    private boolean respuesta;
    private boolean checkRespuesta = true;
    private String respuestaS;
    private int intentosUsuario; 
    public static int intentos; 
    private boolean turnoMaquina;
    private boolean calvoIA, gorroIA, peloLargoIA, bigoteIA, peloCortoIA, barbaIA, rubioIA, morochoIA, pelirrojoIA, narizGrandeIA, narizChicaIA;
    public String personajeAzarMaquina; 
    private String personajeFinal; 
    public String preguntaIA; 
    public String nombreIA; 
    public int numeroUsuario;   
    public static final String PREGUNTA_FILE = "pregunta.txt";
    public static final String RESPUESTA_FILE = "respuesta.txt";
    private String respuestaUsuario = null;
    private Stack<String> preguntaPC = new Stack<>();
   Personajes[] personaje = new Personajes[9];

    // Constructor
    public Modelo(){
            
            preguntaPC.push("Tiene barba?");
            preguntaPC.push("Tiene pelo corto?");
            preguntaPC.push("Tiene bigote?");
            preguntaPC.push("Tiene pelo largo?");
            preguntaPC.push("Tiene gorro?");
            preguntaPC.push("Es calvo?");
            preguntaPC.push("Es rubio?");
            preguntaPC.push("Es morocho?");
            preguntaPC.push("Es pelirrojo?");
            preguntaPC.push("Tiene nariz grande?");
            preguntaPC.push("Tiene nariz chica?");
            
            personaje[0] = new Personajes("Alex", false, false, false, true, true, false, false, true, false, false, true);
            personaje[1] = new Personajes("Alfred", false, false, true, true, false, false, false, false, true, false, true);       
            personaje[2] = new Personajes("Anne", false, false, false, false, true, false, false, true, false, true, false);
            personaje[3] = new Personajes("Bernard", false, true, false, false, true, false, false, true, false, true, false);
            personaje[4] = new Personajes("David", false, false, false, false, true, true, true, false, false, false, true);
            personaje[5] = new Personajes("Eric", false, true, false, false, true, false, true, false, false, false, true);
            personaje[6] = new Personajes("Frans", false, false, false, false, true, false, false, false, true, false, true);
            personaje[7] = new Personajes("George", false, true, false, false, true, false, false, false, false, false, true);
            personaje[8] = new Personajes("Herman", true, false, false, false, false, false, false, false, true, true, false);
            turnoMaquina = false;

                this.intentosUsuario = 6;        
                calvoIA=false; 
                gorroIA=false; 
                peloLargoIA=false; 
                bigoteIA=false;
                peloCortoIA=false;
                barbaIA=false; 
                rubioIA = false; 
                morochoIA=false; 
                pelirrojoIA=false; 
                narizGrandeIA = false; 
                narizChicaIA=false; 
    }

    public String getPersonajeFinal() {
        return personajeFinal;
    }

    public boolean isCalvoIA() {
        return calvoIA;
    }

    public void setCalvoIA(boolean calvoIA) {
        this.calvoIA = calvoIA;
    }

    public boolean isGorroIA() {
        return gorroIA;
    }

    public void setGorroIA(boolean gorroIA) {
        this.gorroIA = gorroIA;
    }

    public boolean isPeloLargoIA() {
        return peloLargoIA;
    }

    public void setPeloLargoIA(boolean peloLargoIA) {
        this.peloLargoIA = peloLargoIA;
    }

    public boolean isBigoteIA() {
        return bigoteIA;
    }

    public String getRespuestaS() {
        return respuestaS;
    }

    public void setRespuestaS(String respuestaS) {
        this.respuestaS = respuestaS;
    }
    
    public int getNumeroPersonajeIA() {
        return numeroPersonajeIA;
    }

    public void setNumeroPersonajeIA(int numeroPersonajeIA) {
        this.numeroPersonajeIA = numeroPersonajeIA;
    }

    public boolean isRubioIA() {
        return rubioIA;
    }

    public void setRubioIA(boolean rubioIA) {
        this.rubioIA = rubioIA;
    }

    public boolean isMorochoIA() {
        return morochoIA;
    }

    public void setMorochoIA(boolean morochoIA) {
        this.morochoIA = morochoIA;
    }

    public boolean isPelirrojoIA() {
        return pelirrojoIA;
    }

    public void setPelirrojoIA(boolean pelirrojoIA) {
        this.pelirrojoIA = pelirrojoIA;
    }

    public boolean isNarizGrandeIA() {
        return narizGrandeIA;
    }

    public void setNarizGrandeIA(boolean narizGrandeIA) {
        this.narizGrandeIA = narizGrandeIA;
    }

    public boolean isNarizChicaIA() {
        return narizChicaIA;
    }

    public void setNarizChicaIA(boolean narizChicaIA) {
        this.narizChicaIA = narizChicaIA;
    }
    
    public void setBigoteIA(boolean bigoteIA) {
        this.bigoteIA = bigoteIA;
    }

    public boolean isPeloCortoIA() {
        return peloCortoIA;
    }

    public void setPeloCortoIA(boolean peloCortoIA) {
        this.peloCortoIA = peloCortoIA;
    }

    public boolean isBarbaIA() {
        return barbaIA;
    }

    public void setBarbaIA(boolean barbaIA) {
        this.barbaIA = barbaIA;
    }

    public static int getPuntaje() {
        return puntaje;
    }

    public static void setPuntaje(int puntaje) {
        Modelo.puntaje = puntaje;
    }

    public boolean isCheckRespuesta() {
        return checkRespuesta;
    }

    public void setCheckRespuesta(boolean checkRespuesta) {
        this.checkRespuesta = checkRespuesta;
    }

    public static int getIntentos() {
        return intentos;
    }

    public static void setIntentos(int intentos) {
        Modelo.intentos = intentos;
    }

    public int getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public String getPersonajeAzarMaquina() {
        return personajeAzarMaquina;
    }

    public void setPersonajeAzarMaquina(String personajeAzarMaquina) {
        this.personajeAzarMaquina = personajeAzarMaquina;
    }

    public void setPersonajeFinal(String personajeFinal) {
        this.personajeFinal = personajeFinal;
    }
    
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getPersonajePC() {
        return personajePC;
    }

    public void setPersonajePC(int personajePC) {
        this.personajePC = personajePC;
    }

    public String getNombreIA() {
        return nombreIA;
    }

    public void setNombreIA(String nombreIA) {
        this.nombreIA = nombreIA;
    }
    
    public int getNumeroRandom() {
        return numeroRandom;
    }

    public void setNumeroRandom(int numeroRandom) {
        this.numeroRandom = numeroRandom;
    }

    public boolean isRespuesta() {
        return respuesta;
    }
   
    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public int getIntentosUsuario() {
        return intentosUsuario;
    }
    

    public void setIntentosUsuario(int intentosUsuario) {
        this.intentosUsuario = intentosUsuario;
    }

    public String getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(String respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public String getPreguntaIA() {
        return preguntaIA;
    }

    public void setPreguntaIA(String preguntaIA) {
        this.preguntaIA = preguntaIA;
    }
    public boolean isTurnoMaquina() {
        return turnoMaquina;
    }

    public void cambiarTurno() {
        turnoMaquina = !turnoMaquina;
    }
    
     public void inicializarJuego() {
         intentosUsuario = 6; 
        this.personajePC = generarPersonaje();      
    }
    
    public int decrementarIntentos(){
        try {
        if (intentosUsuario > -1) {
            intentosUsuario--;
            return intentosUsuario;
        } else {
            return -1;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
    }
    public boolean checkContador(){
         try {
        if (intentosUsuario > -1) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public void responderPregunta(){
       
        switch(personajePC){
            
            case 1: 
                checkRespuesta = true;
                if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[0].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[0].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[0].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[0].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[0].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[0].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[0].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[0].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[0].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[0].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[0].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[0].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                    personajeAzarMaquina= "Alex"; 
                break; 
            case 2: 
                checkRespuesta = true;
               if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[0].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[1].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[1].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[1].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[1].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[1].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[1].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[1].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[1].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[1].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[1].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[1].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                    personajeAzarMaquina= "Alfred"; 
                break;
            case 3: 
                checkRespuesta = true;
                if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[2].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[2].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[2].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[2].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[2].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[2].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[2].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[2].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[2].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[2].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[2].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[2].isNarizChica();
                    }else{
                       checkRespuesta= false;
                    }
                    personajeAzarMaquina= "Anne"; 
                break; 
            case 4: 
                checkRespuesta = true;
                if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[3].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[3].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[3].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[3].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[3].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[3].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[3].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[3].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[3].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[3].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[3].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[3].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                    personajeAzarMaquina= "Bernard"; 
                break; 
            case 5: 
                checkRespuesta = true;
                    if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[4].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[4].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[4].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[4].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[4].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[4].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[4].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[4].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[4].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[4].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[4].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[4].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                    personajeAzarMaquina= "David"; 
                break; 
            case 6: 
                checkRespuesta = true;
                if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[5].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[5].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[5].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[5].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[5].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[5].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[5].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[5].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[5].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[5].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[5].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[5].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                   personajeAzarMaquina= "Eric"; 
                break; 
            case 7: 
                checkRespuesta = true;
               if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[6].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[6].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[6].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[6].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[6].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[6].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[6].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[6].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[6].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[6].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[6].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[6].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                   personajeAzarMaquina= "Frans"; 
                break; 
            case 8: 
                checkRespuesta = true;
                if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[7].isBarba(); 
                            
                        }
                
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[7].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[7].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[7].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[7].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[7].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[7].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[7].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[7].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[7].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[7].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[7].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                    personajeAzarMaquina= "George"; 
                break; 
            case 9: 
                checkRespuesta = true;
                if ("tiene barba?".equals(this.pregunta)) {
                            this.respuesta = personaje[8].isBarba();                     
                        }
                    else if ("tiene pelo corto?".equals(this.pregunta)) {
                            this.respuesta = personaje[8].isPeloCorto();
                        } else if ("tiene pelo corto?".equals(pregunta)) {
                        this.respuesta = personaje[8].isPeloCorto();
                    } else if ("tiene bigote?".equals(pregunta)) {
                        this.respuesta = personaje[8].isBigote();
                    } else if ("tiene gorro?".equals(pregunta)) {
                        this.respuesta = personaje[8].isGorro();
                    } else if ("es calvo?".equals(pregunta)) {
                        this.respuesta = personaje[8].isCalvo();
                    } else if ("tiene pelo largo?".equals(pregunta)) {
                        this.respuesta = personaje[8].isPeloLargo();
                    } else if ("es rubio?".equals(pregunta)) {
                        this.respuesta = personaje[8].isRubio();
                    } else if ("es morocho?".equals(pregunta)) {
                        this.respuesta = personaje[8].isMorocho();
                    } else if ("es pelirrojo?".equals(pregunta)) {
                        this.respuesta = personaje[8].isPelirrojo();
                    } else if ("tiene nariz grande?".equals(pregunta)) {
                        this.respuesta = personaje[8].isNarizGrande();
                    } else if ("tiene nariz chica?".equals(pregunta)) {
                        this.respuesta = personaje[8].isNarizChica();
                    }else{
                        checkRespuesta= false;
                    }
                        personajeAzarMaquina= "Herman";
                break; 
        
        }
        
        
   }
   public void RespuestaSioNo(){
    if(checkRespuesta == true){   
       if(respuesta == true){
            respuestaS= "Si";
        }
       if(respuesta == false){
            respuestaS= "No";
        }
    }
    if(checkRespuesta == false){
        respuestaS="Pregunta incorrecta";
        intentosUsuario +=1;
    }
       
   }
    
    
    public String obtenerSiguientePregunta() {
        if (!preguntaPC.isEmpty()) {
            return preguntaPC.pop();
        }
        return null; 
    }
    public void respuestaUsuarioX(){
    
        switch (this.preguntaIA) {
        case "Es calvo?":
             if("si".equals(this.respuestaUsuario)){
                 this.calvoIA = true; 
             }else{
                this.calvoIA = false; 
            }
            break;
        case "Tiene gorro?":
            if("si".equals(this.respuestaUsuario)){
                 this.gorroIA = true; 
             }else{
                this.gorroIA = false; 
            }
            break;
        case "Tiene pelo largo?":
            if("si".equals(this.respuestaUsuario)){
                 this.peloLargoIA = true; 
             }else{
                this.peloLargoIA = false; 
            }
            break;
        case "Tiene bigote?":
            if("si".equals(this.respuestaUsuario)){
                 this.bigoteIA = true; 
             }else{
                this.bigoteIA = false; 
            }
            break;
        case "Tiene pelo corto?":
            if("si".equals(this.respuestaUsuario)){
                 this.peloCortoIA = true; 
             }else{
                this.peloCortoIA = false; 
            }
            break;
        case "Tiene barba?":
            if("si".equals(this.respuestaUsuario)){
                 this.barbaIA = true; 
             }else{
                this.barbaIA = false; 
            }
            break;
        
        case "Es rubio?": 
            if("si".equals(this.respuestaUsuario)){
                this.rubioIA=true; 
            }else{
                this.rubioIA=false;
            }
            break;
        case "Es morocho?": 
            if("si".equals(this.respuestaUsuario)){
                this.morochoIA=true;
            }else{
                morochoIA=false; 
            }
            break;
        case "Es pelirrojo?": 
            if("si".equals(this.respuestaUsuario)){
                this.pelirrojoIA=true;
            }else{
                this.pelirrojoIA=false; 
            }
            break; 
        case "Tiene nariz grande?": 
            if("si".equals(this.respuestaUsuario)){
                this.narizGrandeIA=true;
            }else{
                this.narizGrandeIA=false; 
            }
            break; 
        case "Tiene nariz chica?":
            if("si".equals(this.respuestaUsuario)){
                this.narizChicaIA=true;
            }else{
                this.narizChicaIA=false; 
            }
            break; 
        }
    }
    
    public void validarPersonaje(){      
       try{
           //faltan anne y frans
            if (this.calvoIA && this.narizGrandeIA && this.pelirrojoIA) {
                this.nombreIA = "Herman";
                numeroPersonajeIA= 9; 
            } else if (this.barbaIA && this.rubioIA && this.narizChicaIA) {
                this.nombreIA = "David";
                numeroPersonajeIA = 5; 
            } else if (this.bigoteIA && this.peloLargoIA && this.pelirrojoIA && this.narizChicaIA) {
                this.nombreIA = "Alfred";
                numeroPersonajeIA= 2; 
            } else if (this.bigoteIA && this.peloCortoIA && this.morochoIA && this.narizChicaIA) {
                this.nombreIA = "Alex";
                numeroPersonajeIA = 1; 
            } else if (this.peloCortoIA && this.gorroIA && this.morochoIA && this.narizGrandeIA) {
                this.nombreIA = "Bernard";
                numeroPersonajeIA = 4; 
            } else if (this.peloCortoIA && this.gorroIA && this.rubioIA && this.narizChicaIA) {
                this.nombreIA = "Eric";
                numeroPersonajeIA = 6;
            } else if (this.peloCortoIA && this.gorroIA && this.narizChicaIA) {
                this.nombreIA = "George";
                numeroPersonajeIA = 8;
            } else if(this.peloCortoIA && this.morochoIA && this.narizGrandeIA && !this.bigoteIA){
                this.nombreIA= "Anne"; 
                numeroPersonajeIA = 4; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean validarAdivinanzaUsuario(){
    try {
        if (personajeFinal.equals(personajeAzarMaquina)) {
            puntaje= puntaje + 1; 
            intentos = getIntentosUsuario(); 
            return true;
            
        } else {
            puntaje = puntaje -1;  
            intentos = getIntentosUsuario();
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean validarAdivinanzaIA() {
    try {
        if (numeroPersonajeIA == numeroUsuario) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public int generarPersonaje(){
         personajePC = ThreadLocalRandom.current().nextInt(1,10);
        return personajePC; 
    } 
    public int generarNumeroAleatorio() {
        numeroRandom = ThreadLocalRandom.current().nextInt(1,10);
        return numeroRandom; 
    }
    
    public static void escribirIntentos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("intentos.txt", true))) {
            writer.write("Puntaje: " +puntaje+ " intentos:" + intentos);
            writer.newLine();
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }

    // Método para leer los intentos desde el archivo
    public static void leerIntentos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("intentos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Procesar cada línea del archivo (puedes imprimir o hacer lo que necesites)
                System.out.println("Registro: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


