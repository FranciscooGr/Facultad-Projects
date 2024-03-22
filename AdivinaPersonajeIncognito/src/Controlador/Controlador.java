/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import java.awt.Color;
import static java.awt.Color.cyan;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class Controlador implements ActionListener, MouseListener {
    private  Vista vista; 
    private  Modelo modelo; 
    
    public Controlador(Vista vista, Modelo modelo){
        this.vista=vista; 
        this.modelo=modelo; 
        this.vista.jbPersonaje1.addMouseListener(this); 
        this.vista.jbPersonaje2.addMouseListener(this); 
        this.vista.jbPersonaje3.addMouseListener(this); 
        this.vista.jbPersonaje4.addMouseListener(this); 
        this.vista.jbPersonaje5.addMouseListener(this); 
        this.vista.jbPersonaje6.addMouseListener(this); 
        this.vista.jbPersonaje7.addMouseListener(this); 
        this.vista.jbPersonaje8.addMouseListener(this); 
        this.vista.jbPersonaje9.addMouseListener(this);
        this.vista.jBcartaAzar.addActionListener(this); 
        this.vista.jBPregunta.addActionListener(this);
        this.vista.jBturno.addActionListener(this);
        this.vista.jBterminarJuego.addActionListener(this);
        this.vista.jBEnviarRespuesta.addActionListener(this);
        this.vista.jbRespuestaFinalUsuario.addActionListener(this);
        this.vista.jbOtraRonda.addActionListener(this);
        desactivarControles(); 
        vista.setVisible(true); 
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(vista.jBcartaAzar)){
             startGame();
             desactivarjBcartaAzar(vista.jBcartaAzar);
        }
        if (e.getSource().equals(vista.jbRespuestaFinalUsuario)){
            adivinarPersonaje(vista.jbRespuestaFinalUsuario); 
        }
        if (e.getSource().equals(vista.jBEnviarRespuesta)){
            modelo.cambiarTurno();
            actualizarInterfazSegunTurno();
            mandarPregunta(vista.jBEnviarRespuesta); 
        }
        if (e.getSource().equals(vista.jBPregunta)){
            modelo.cambiarTurno();
            actualizarInterfazSegunTurno(); 
            mostrarSiguientePregunta(vista.jBturno); 
            
        }
        if (e.getSource().equals(vista.jBterminarJuego)){
            terminarJuego();
        }
        
        if (e.getSource().equals(vista.jBPregunta)){
            modelo.setPregunta(String.valueOf(vista.jTextPregunta.getText()));
            modelo.responderPregunta();
            modelo.RespuestaSioNo();
            vista.jTextRespuesta.setText(String.valueOf(modelo.getRespuestaS()));
            actualizarContador(vista.jBPregunta); 
        }
        if (e.getSource().equals(vista.jbOtraRonda)){ 
            startGame();
            desactivarjBcartaAzar(vista.jBcartaAzar);
        }
    }
    
    public void startGame(){
        modelo.escribirIntentos();
        int random = this.modelo.generarNumeroAleatorio(); 
        modelo.numeroUsuario = random; 
        modelo.inicializarJuego(); 
        setCarta(vista.jLmostrarCarta, random);
        vista.jbPersonaje1.setEnabled(true);
        vista.jbPersonaje2.setEnabled(true);
        vista.jbPersonaje3.setEnabled(true);
        vista.jbPersonaje4.setEnabled(true);
        vista.jbPersonaje5.setEnabled(true);
        vista.jbPersonaje6.setEnabled(true);
        vista.jbPersonaje7.setEnabled(true);
        vista.jbPersonaje8.setEnabled(true);
        vista.jbPersonaje9.setEnabled(true);
        vista.jBPregunta.setEnabled(true);
        vista.jBturno.setEnabled(true);
        vista.jBEnviarRespuesta.setEnabled(false);
        vista.jbRespuestaFinalUsuario.setEnabled(true);
        vista.jbOtraRonda.setEnabled(false);

        // Desactiva los campos de texto
        vista.jTextPregunta.setEnabled(true);
        vista.jTextRespuesta.setEnabled(true);
        vista.jTextPreguntaPc.setEnabled(false);
        vista.jTextUsuarioRespuesta.setEnabled(false);
        vista.jTextPersonajeFinal.setEnabled(true);
        vista.jTContador.setText("6");
        vista.jTextPregunta.setText("");
        vista.jTextRespuesta.setText("");
        vista.jTextPreguntaPc.setText("");
        vista.jTextUsuarioRespuesta.setText("");
        vista.jTextPersonajeFinal.setText("");
        
        vista.jtResultadoFinal.setText("");
        vista.jtResultadoFinal.setBackground(cyan);
    }
     
     private void setCarta(JLabel jLmostrarCarta, int numero){
        String url= " "; 
        
        switch(numero){
            case 1: 
                url = "/icons/foto1.png"; 
                break; 
            case 2: 
                 url = "/icons/foto2.png"; 
                break; 
            case 3: 
                 url = "/icons/foto4.png"; 
                break; 
            case 4: 
                 url = "/icons/foto5.png"; 
                break; 
            case 5:
                 url = "/icons/foto6.png"; 
                break; 
            case 6:
                 url = "/icons/foto7.png"; 
                break; 
            case 7: 
                 url = "/icons/foto8.png"; 
                break; 
            case 8: 
                 url = "/icons/foto9.png"; 
                break; 
            case 9: 
                 url = "/icons/foto10.png"; 
                break; 
                    
        }
        
        jLmostrarCarta.setIcon(new ImageIcon(getClass().getResource(url)));
       }
     
    
    private void desactivarjBcartaAzar(JButton jBcartaAzar){
        jBcartaAzar.setEnabled(false);
    }
    private void terminarJuego(){
         System.exit(0);
    }
    private void preguntaUsuario(JButton jBPregunta) { 
        
        modelo.setPregunta(String.valueOf(vista.jTextPregunta.getText()));
        modelo.responderPregunta();  
        vista.jTextRespuesta.setText(String.valueOf(modelo.getRespuestaS())); 
        String pregunta = String.valueOf(vista.jTextPregunta.getText());
        String respuesta = modelo.getRespuestaS();

        }
    private void actualizarContador(JButton jBPregunta){
        int contador = modelo.decrementarIntentos(); 
        vista.jTContador.setText(String.valueOf(contador));
        boolean checkContador= modelo.checkContador(); 
        if(checkContador == false){
                modelo.leerIntentos();
                vista.jtResultadoFinal.setText("SIN INTENTOS, PERDISTE");
                vista.jtResultadoFinal.setBackground(red); 
                vista.jBPregunta.setEnabled(false);//usuario
                vista.jTextPregunta.setEnabled(false);//usuario
                vista.jTextRespuesta.setEnabled(false);//usuario
                vista.jTextPreguntaPc.setEnabled(false); //maquina
                vista.jTextUsuarioRespuesta.setEnabled(false); //maquina
                vista.jBEnviarRespuesta.setEnabled(false);//maquin
                vista.jTextPersonajeFinal.setEnabled(false);
                vista.jbRespuestaFinalUsuario.setEnabled(false);
                vista.jbOtraRonda.setEnabled(true);
        }
    }
    private void mostrarSiguientePregunta(JButton jBPregunta) {
       
              String siguientePregunta = modelo.obtenerSiguientePregunta();
              if (siguientePregunta != null) {
            modelo.setPreguntaIA(siguientePregunta);
            vista.jTextPreguntaPc.setText(siguientePregunta);
            modelo.validarPersonaje();
        } else {
            modelo.validarPersonaje();
            vista.jTextPersonajeAdivinado.setText(String.valueOf(modelo.getNombreIA()));
            boolean adivinanzaIA = modelo.validarAdivinanzaIA(); 
                if(adivinanzaIA == true){
                    vista.jtResultadoFinal.setText("HAS PERDIDO, ADIVINO LA IA"); 
                    vista.jtResultadoFinal.setBackground(red); 
                    vista.jBPregunta.setEnabled(false);//usuario
                    vista.jTextPregunta.setEnabled(false);//usuario
                    vista.jTextRespuesta.setEnabled(false);//usuario
                    vista.jTextPreguntaPc.setEnabled(false); //maquina
                    vista.jTextUsuarioRespuesta.setEnabled(false); //maquina
                    vista.jBEnviarRespuesta.setEnabled(false);//maquina
                    vista.jTextPersonajeFinal.setEnabled(false);
                    vista.jbRespuestaFinalUsuario.setEnabled(false);
                    vista.jbOtraRonda.setEnabled(true);
                }

            }      
    }
    
    private void mandarPregunta(JButton jBEnviarRespuesta){
        modelo.setRespuestaUsuario(String.valueOf(vista.jTextUsuarioRespuesta.getText())); 
        modelo.respuestaUsuarioX(); 
        vista.jTextUsuarioRespuesta.setText(null); 
        //vista.jTextPreguntaPc.setText(null); 
    }
    private void actualizarInterfazSegunTurno() {
        boolean turnoMaquina = modelo.isTurnoMaquina();

        if(turnoMaquina == true){
        vista.jbRespuestaFinalUsuario.setEnabled(false);//usuario
        vista.jTextPersonajeFinal.setEnabled(false);//usuario
        vista.jBPregunta.setEnabled(false);//usuario
        vista.jTextPregunta.setEnabled(false);//usuario
        vista.jTextRespuesta.setEnabled(false);//usuario
        vista.jTextPreguntaPc.setEnabled(true); //maquina
        vista.jTextUsuarioRespuesta.setEnabled(true); //maquina
        vista.jBEnviarRespuesta.setEnabled(true);//maquina
        }
       if(turnoMaquina == false){
        
        vista.jBPregunta.setEnabled(true);//usuario
        vista.jTextPregunta.setEnabled(true);//usuario
        vista.jTextRespuesta.setEnabled(true);//usuario
        vista.jbRespuestaFinalUsuario.setEnabled(true);//usuario
        vista.jTextPersonajeFinal.setEnabled(true);
        vista.jTextPreguntaPc.setEnabled(false); //maquina
        vista.jTextUsuarioRespuesta.setEnabled(false); //maquina
        vista.jBEnviarRespuesta.setEnabled(false);//maquina
        vista.jTextPersonajeAdivinado.setEnabled(false); 
        }
    }
    
    private void adivinarPersonaje(JButton jbRespuestaFinalUsuario){
        modelo.setPersonajeFinal(String.valueOf(vista.jTextPersonajeFinal.getText()));
        boolean adivinanza = modelo.validarAdivinanzaUsuario();
            if(adivinanza == true){
                modelo.leerIntentos();
                vista.jtResultadoFinal.setText("HAS GANADO"); 
                vista.jtResultadoFinal.setBackground(green); 
                vista.jBPregunta.setEnabled(false);//usuario
                vista.jTextPregunta.setEnabled(false);//usuario
                vista.jTextRespuesta.setEnabled(false);//usuario
                vista.jTextPreguntaPc.setEnabled(false); //maquina
                vista.jTextUsuarioRespuesta.setEnabled(false); //maquina
                vista.jBEnviarRespuesta.setEnabled(false);//maquina
                vista.jTextPersonajeFinal.setEnabled(false);
                vista.jbRespuestaFinalUsuario.setEnabled(false);
                vista.jbOtraRonda.setEnabled(true);
              
            }else{
                modelo.leerIntentos();
                vista.jtResultadoFinal.setText("HAS PERDIDO"); 
                vista.jtResultadoFinal.setBackground(red); 
                vista.jBPregunta.setEnabled(false);//usuario
                vista.jTextPregunta.setEnabled(false);//usuario
                vista.jTextRespuesta.setEnabled(false);//usuario
                vista.jTextPreguntaPc.setEnabled(false); //maquina
                vista.jTextUsuarioRespuesta.setEnabled(false); //maquina
                vista.jBEnviarRespuesta.setEnabled(false);//maquina
                vista.jTextPersonajeFinal.setEnabled(false);
                vista.jbRespuestaFinalUsuario.setEnabled(false);
                vista.jbOtraRonda.setEnabled(true);
            }
          
    }
  
  
private void desactivarControles() {
    // Desactiva los botones
    vista.jbPersonaje1.setEnabled(false);
    vista.jbPersonaje2.setEnabled(false);
    vista.jbPersonaje3.setEnabled(false);
    vista.jbPersonaje4.setEnabled(false);
    vista.jbPersonaje5.setEnabled(false);
    vista.jbPersonaje6.setEnabled(false);
    vista.jbPersonaje7.setEnabled(false);
    vista.jbPersonaje8.setEnabled(false);
    vista.jbPersonaje9.setEnabled(false);
    vista.jBPregunta.setEnabled(false);
    vista.jBturno.setEnabled(false);
    vista.jBEnviarRespuesta.setEnabled(false);
    vista.jbRespuestaFinalUsuario.setEnabled(false);

    // Desactiva los campos de texto
    vista.jTextPregunta.setEnabled(false);
    vista.jTextRespuesta.setEnabled(false);
    vista.jTextPreguntaPc.setEnabled(false);
    vista.jTextUsuarioRespuesta.setEnabled(false);
    vista.jTextPersonajeFinal.setEnabled(false);
}

    @Override
    public void mouseClicked(MouseEvent me) {
        JButton botonClicado = (JButton) me.getSource();

    if (botonClicado == vista.jbPersonaje1) {
      vista.jbPersonaje1.setEnabled(false);       
    } else if (botonClicado == vista.jbPersonaje2) {
       vista.jbPersonaje2.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje3) {
        vista.jbPersonaje3.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje4) {
        vista.jbPersonaje4.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje5) {
        vista.jbPersonaje5.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje6) {
        vista.jbPersonaje6.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje7) {
       vista.jbPersonaje7.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje8) {
        vista.jbPersonaje8.setEnabled(false);
    } else if (botonClicado == vista.jbPersonaje9) {
        vista.jbPersonaje9.setEnabled(false);
    }
    
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
    

