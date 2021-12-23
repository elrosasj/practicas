//HILOS UTILIZADOS CON THREAD DIRECTAMENTE ES DECIR SE TRABAJARA CON SOLO OBJETOS Y CON HILOS PURAMENTE

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class comprobacion_hilo extends JFrame {
	
	JPanel panel;
	JTextArea area;
	JButton boton;
	JScrollPane barra;
	oyente escucha;
	
	int contador=1; // se inicializa la variable
	
	public comprobacion_hilo(){
		setSize(300,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(false);
		
		escucha= new oyente();
		
		init();
		acomodar();
		add(panel);
		panel.add(barra);
		panel.add(boton);	
	
		boton.addActionListener(escucha);
	}
	public void init(){
		
		panel = new JPanel();
		boton = new JButton("Boton");
		area = new JTextArea();
		barra=new JScrollPane(area);//se debe de agregar el area al jscrollpane
	
	}
	public void acomodar(){
			panel.setLayout(null);
			barra.setBounds(10,10,280,190);
			boton.setBounds(150,220,100,30);
	}
	
public static void main(String args[]){

	comprobacion_hilo ventana = new comprobacion_hilo();

	}
///////////////////////////////////////////////////////////////////////////////	
class oyente implements ActionListener {
	public void actionPerformed(ActionEvent ev){
		hilo h = new hilo(contador); // se pasa como parametro el contador a la clase hilo
		contador++; // se incrementa en 1
		h.start(); // se inicia el hilo 
		
		//if(ev.getSource()==boton){
			
		//}
	}
}	
///////////////////////////////////////////////////////////////////////////////
class hilo extends Thread{ // clase de tipo hilo heredado de thread es decir se manipulan objetos
	int num_hilo; // se declara var del numero de hilos
	
	public hilo(int n){ // recibe como parametro 
		num_hilo=n; // se iguala la variable a el parametro n
		}
		
	public void run(){ // este metodo lo lleva con interfaz o heredado de thread
		
		while(true){
			try {
				area.append("HILO " + num_hilo + ": ESCRIBIENDO\n"); // se escribe esto en el area de texo cada 2 segundos
				sleep(2000); // se duerme el proces en 2 segundos despierta a los 2 segundos
				}
			catch(Exception e){
				}
			}
		}
	}
}