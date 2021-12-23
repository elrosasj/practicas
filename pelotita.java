import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class pelotita extends JFrame{
	
	p contenedor;
	JPanel p_boton;
	JButton boton;
	
	hilo h;
	
	public pelotita(){
		setSize(500,500);
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    setBackground(Color.BLUE);
	    
	    inicializar();
	    atributos();
	    add(contenedor,BorderLayout.CENTER);
	    add(p_boton, BorderLayout.SOUTH);
	    p_boton.add(boton);
	    
	    h = new hilo();
	    h.start();
	}
	public void inicializar(){
		p_boton= new JPanel();
		boton = new JButton("Start");
	}
	public void atributos(){
		
		contenedor = new p(); // se inicializa un objeto de tipo p
		boton.setPreferredSize(new Dimension(100,40));
		p_boton.setBackground(Color.BLACK);
		
	}
	public static void main (String args[]){
		pelotita ventana = new pelotita();
	}
class hilo extends Thread {
	public hilo (){
		
	}
	public void run (){
		while(true){
			try {
				contenedor.repaint();
				Thread.sleep(500);
			}
			catch(Exception e){
				
			}
		}
	}
}
class p extends Panel {
	int x; // tiene que variar para hacer el movimiento
	int y=200; // y es contante siempre se va a mantener en y 
	int limite_max=450; // limite de donde tienque que llegar la pelota - los 50 del circulo
	int flag_der;
	int flag_izq;
	
	public p (){
		x=10;
		flag_der=1; // indica que 1 se movera a la derecha  y no a la izquierda 
		flag_izq=0;// indica que 1 se movera a la izq  y no a la derecha
		
		}
	public void paint(Graphics g){
		/*g.setColor(Color.blue); // fijar un color del circulo
		g.fillOval(x, y, 50,50);// dibujar un circulo con cordenadas x,y y largo y ancho e incrementar x porquer es lo que se ava incrementar
		*/ 
		// esta parte me hacia el movimiento incrementando
	/*	if (x<limite_max){
			g.setColor(new Color(0,250,0));	
			g.fillOval(x, y, 50,50);
			x+=10; // es para incremetar de 10 en 10 10 + 10 y asi sucesivamente
			}*/ 
		if(flag_der==1){ // indica que se tiene qu emover a la derecha solo indica es la direccion, la bandera esta levantada 
			if (x<limite_max){
				g.setColor(new Color(0,250,0));	
				g.fillOval(x, y, 50,50);
				x+=10; // es para incremetar de 10 en 10 10 + 10 y asi sucesivamente
				} 
			else {
				flag_der=0; // se baja la bandera der
				flag_izq=1; // se sube la bandera izq
			}
		} // fin de primer if de derecha
		
		if (flag_izq==1){ // si la badera esta levantada se ira a la izquierda
			if (x>10){ // si x es mayor a 10  
				g.setColor(new Color(0,250,0)); // fijar el color	
				g.fillOval(x, y, 50,50); // pinta el ovalo con las dimensiones y coordenadas
				x-=10; // decrementa
				}
			else {
					flag_izq=0; // se baja la mandera cuando ya no se cumpla la condicion
					flag_der=1;// se levanta la bandera
					}
				}
			}
		}
	}
