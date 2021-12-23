//solo puede haber una clase publica, ya que es la princiapal

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class colores extends JFrame implements Runnable { //clase principal y runnable para que el jframe tenga funcionalidaslidades de hilo no es un hilo como tal
	
	p contenedor; //crear objeto
	Thread hilo;
	
	public colores(){ //contructor	
		setSize(300,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(false);
		
		contenedor = new p();// objeto y la llamada a la clase del contructor	
		add(contenedor); // se agrega el objeto de tipo panel al JFrame
		
		hilo = new Thread(this); // se pone this para especificar que este hilo esta en esta clase que tienen la interfaz runnable
		hilo.start();
		}
	public void run(){ // metodo solo de la clase porque inprementa la interfaz runnable
		while(true){ // siempre es infinito
			try {
				contenedor.repaint();//llama al metod de repinmtaod del panel			
				Thread.sleep(1000); //duerme cada segundo
				 }
			catch(Exception e){
		
				}
		}

	}

public static void main(String args []){ 
			colores x = new colores(); // se hace la instancia de la clase para que jale lo principal
		}
	}
	

class p extends Panel{ // subclase de tipo panel para adecuarse al pintado de animacion
	int bandera;
	public p(){
		bandera=0; //iniciar bandera
	}
		public void paint(Graphics gr){
	/*	gr.setColor(new Color(0,0,255)); // R,G,B SON DE 0 A 255 PERTENECE DE AWT para los colores
		gr.fillRect(10,10,100,100);
		gr.setColor(new Color(0,150,0)); // R,G,B SON DE 0 A 255 PERTENECE DE AWT para los colores
		gr.fillRect(200,10,100,100);
		*/
		// parte de la animacion todo esto se hace siempre en el paint
		
		//BLOQUE A
		if(bandera==0){
			gr.setColor(new Color(0,0,255)); // R,G,B SON DE 0 A 255 PERTENECE DE AWT para los colores
			gr.fillRect(10,10,100,100);
			gr.setColor(new Color(0,150,0)); // R,G,B SON DE 0 A 255 PERTENECE DE AWT para los colores
			gr.fillRect(200,10,100,100);
			
			bandera=1; // se levanta la bandera
		} else {
		//BLOQUE B
			gr.setColor(new Color(0,0,150)); // R,G,B SON DE 0 A 255 PERTENECE DE AWT para los colores
			gr.fillRect(10,10,100,100);
			gr.setColor(new Color(0,255,0)); // R,G,B SON DE 0 A 255 PERTENECE DE AWT para los colores
			gr.fillRect(200,10,100,100);
			
			bandera=0;// se mantiene la bandera
			}
		}
	}