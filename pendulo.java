import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class pendulo extends JFrame{
	
	dibujo c;
	
	public pendulo(){
		setLayout(null);
		c=new dibujo();
		c.setBounds(0,0,600,600);
		add(c);
	}
	
	public static void main(String[] a){
		pendulo p=new pendulo();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setResizable(false);
		p.setSize(600,600);
		p.setVisible(true);
	}	
}

class dibujo extends Panel implements Runnable{
		Thread h;
		Image b;
		Graphics sb,st;
		Hilo h2;
		int x1,y1;

		Button iniciar,parar;
		JTextField angu;
		
		dibujo(){
			setLayout(null);
			iniciar=new Button("Iniciar");
			iniciar.setBackground(Color.green);
			iniciar.setForeground(Color.blue);
			iniciar.setBounds(200,500,100,25);
			iniciar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						x1=300;y1=350;
						int tetha=Integer.parseInt(angu.getText());
								if(tetha>90){
									JOptionPane.showMessageDialog(null,"Error : Angulo no valido"); 
									h2.stop();
									iniciar.setEnabled(false);
								}
						
						if(h2!=null){
							h2.stop();
						}
						h2=new Hilo(tetha);
						h2.start();
						iniciar.setEnabled(false);
					}
				});
			parar=new Button("Parar");
			parar.setBounds(100,500,100,25);
			parar.setBackground(Color.orange);
			parar.setForeground(Color.blue);

			parar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						x1=300;y1=350;
						try{
							h2.stop();
						}catch(Exception err){}
						h2=null;
						iniciar.setEnabled(true);
					}
				});
			angu=new JTextField();
			angu.setBounds(310,500,100,25);
			//angu.setFont(new Font("",Font.BOLD,30));
			//angu.setForeground(Color.blue);
			this.add(iniciar);
			this.add(parar);
			this.add(angu);
			h=new Thread(this);
			h.start();
			x1=300;
			y1=350;
		}
		
		public void update(Graphics gr){
			b=createImage(600,500);	
			sb=b.getGraphics();
			sb.setColor(Color.black);
			sb.fillRect(0,0,600,500);
			sb.setColor(Color.green);
			sb.drawString("x = " + x1, 20,20);
			sb.drawString("y = " + y1, 20,40);
			sb.drawString("GRAFICACION DE PENDULO", 250,15);
			sb.drawLine(0,100,600,100);
			sb.setColor(Color.blue);
			sb.fillOval(300-5,100-5,10,10);
			sb.drawLine(300,100,x1,y1);
			sb.fillOval(x1-20,y1-20,40,40);
			gr.drawImage(b,0,0,this);
		}
		
		public void rotacion(int angulo){
			x1=(int)(300-250*Math.sin(Math.toRadians(angulo))*-1);
         y1=(int)(100+250*Math.cos(Math.toRadians(angulo)));
		}

		public void run(){
			while(true){
				repaint();
			}
		}
		
	class Hilo extends Thread{
			int A;
			Hilo(int angulo){
				A=angulo;
			}
			public void run(){
				while(true){
					for(int i=0;i<A;i++){ //si i es igual a cero y i sea menor al angulo entonces incrementa i hasta llegar al angulo ingresado
						try{
							rotacion(i);//rotacion de cero hasta el angulo que se ingreso 
							sleep(100);
						}catch(Exception e){}
					}
					for(int i=A;i>0;i--){//si i es igual al angulo anterior y i mayor que cero entonces decrementa hasta llegar a cero
						try{
							rotacion(i);
							sleep(100);
						}catch(Exception e){}
					}
					for(int i=0;i>(-A);i--){ // si i es de nuevo igual a cero  y es mayor a - el angulo ingresado entonces decrementa hasta el -A
						try{
							rotacion(i);
							sleep(100);
						}catch(Exception e){}
					}
					for(int i=(-A);i<0;i++){ // si i es igual al -A y i es menor a 0 entonces incrementa hasta llegar a 0 y se repite de nuevo el proceso al primer ciclo
						try{
							rotacion(i);
							sleep(100);
						}catch(Exception e){}
					}
				}
			}
	}
}