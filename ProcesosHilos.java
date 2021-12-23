   import java.applet.Applet;
   import java.awt.Color;
   import java.awt.Graphics;
   import java.awt.event.ActionEvent;
   import java.awt.event.*;
   import javax.swing.*;
   import java.awt.*;

    public class ProcesosHilos extends JApplet implements  Runnable{
   //JPanel panel;
      int a, b;
      JButton interrup,continuar,detener,salir;
   
      Thread hilo;
      Thread hilo2;
      Thread hilo3 = new Thread();
      Thread hilo4 = new Thread();
      boolean despachando;
      Container contenedor = getContentPane();   
      int i, azar, npro, x,z1=0, y, z,x3=-115,z13=0, y3, z3, dx, dy, time, time2,act =0,proc=0,act3 =0,azarC1,azarC ,x1,y1,x13,y13,zz1,zz13,dat,dd=0;
      String str2,color;
   		 
       public void init (){
      
         contenedor.setLayout(new FlowLayout());
         contenedor.setBackground(Color.black);
         a=200+((int)(Math.random()*2));
         b=200+((int)(Math.random()*2));
         azar = (int)(Math.random()*26);
         azarC = (int)(Math.random()*7);
         azarC1 = (int)(Math.random()*7);
         npro = (int)(Math.random()*15);
      
         interrup = new JButton("Interrupcion");
         continuar = new JButton("Continuar");
         detener = new JButton("Detener");
         interrup.setBackground(Color.white);
         continuar.setBackground(Color.white);
         interrup.setVisible(true);
         continuar.setVisible(true);
         contenedor.add(interrup);
         contenedor.add(continuar);
         contenedor.add(detener);
      
         interrup.setVisible(true);
         hilo = new Thread(this);
         hilo2 = new Thread(this);
         hilo.start();
         hilo3.start();
         
         interrup.addActionListener(
                new ActionListener()
               {
               
                   public void actionPerformed(ActionEvent e)
                  {
                     hilo.suspend();
                     hilo2.suspend();
                     time = 5;
                     repaint();
                     System.out.println("Suspendido");
                  }
               
               });
         detener.addActionListener(
                new ActionListener()
               {
               
                   public void actionPerformed(ActionEvent e)
                  {
                  
                     hilo.stop();
                     hilo2.stop();
                     hilo4.stop();
                     hilo3.stop();
                     stop();
                     time =2;
                     repaint();
                  
                  }
               
               });
      
         continuar.addActionListener(
                new ActionListener()
               {
               
                   public void actionPerformed(ActionEvent e)
                  {
                     hilo.resume();
                     hilo2.resume();
                     System.out.println("Continuar");
                  
                  }
               
               });
         
      
      }
   
   
   
   
   
       public void paint(Graphics g){
         if(time==0){
            grafo(g);
            proces(g);
            proces1(g);
         }
         if(time==1){
            proces3(g);
            grafo(g);
            proces(g);
            proces1(g);
            time =0;
         }
         if(time ==2){
            grafo1(g);
            proces4(g);
         }
         if(time==5){
            proces2(g);
         }
         
      }
   
       public void grafo(Graphics g){
         g.setColor(Color.red);
         g.drawString(" Proceso 1",255,45);
         g.setColor(Color.green);
         g.drawString(" Proceso 2",315,45);
         g.setColor(Color.yellow);
         g.fillOval(70, 185, 50, 50);//listo
         g.setColor(Color.red);
         g.fillOval(255, 185, 50, 50);//bloqueado
         g.setColor(Color.green);
         g.fillOval(150, 100, 50, 50);//ejec
         g.drawString("Listo", 70, 180);
         g.drawString("Bloqueado", 260, 180);
         g.drawString("Ejecución", 150, 90);
         g.setColor(Color.blue);
         g.fillRect(260,50,50,30);
         g.fillRect(320,50,50,30);
         g.setColor(Color.black);
         g.fillRect(210,360,170,30);
         g.setColor(Color.GREEN);
         g.fillRect(50,360,150,30);
         g.setColor(Color.black);
         g.drawString(" PROCESANDO...",60,380);
      }
       public void grafo1(Graphics g){
         g.setColor(Color.black);
         g.fillRect(0,0,600,600);
         g.setColor(Color.red);
         g.drawString(" Proceso 1",255,45);
         g.setColor(Color.green);
         g.drawString(" Proceso 2",315,45);
         g.setColor(Color.yellow);
         g.fillOval(70, 185, 50, 50);//listo
         g.setColor(Color.red);
         g.fillOval(255, 185, 50, 50);//bloqueado
         g.setColor(Color.green);
         g.fillOval(150, 100, 50, 50);//ejec
         g.drawString("Listo", 70, 180);
         g.drawString("Bloqueado", 260, 180);
         g.drawString("Ejecución", 150, 90);
         g.setColor(Color.blue);
         g.fillRect(260,50,50,30);
         g.fillRect(320,50,50,30);
         continuar.setVisible(false);
         detener.setVisible(false);
         interrup.setVisible(false);
      }
       public void proces2(Graphics g){
         g.setColor(Color.black);
         g.fillRect(50,360,150,30);
         g.setColor(Color.gray);
         g.fillRect(210,360,170,30);
         g.setColor(Color.RED);
         g.drawString(" PROCESO INTERRUMPIDO",220,380);
         time =1;
      }
       public void proces4(Graphics g){
         g.setColor(Color.black);
         g.fillRect(50,360,150,30);
         g.fillRect(210,360,170,30);
         g.setColor(Color.green);
         g.fillRect(110,250,170,30);
         g.setColor(Color.BLACK);
         g.drawString(" PROCESO TERMINADO",120,270);
         time =1;
      }
       public void proces3(Graphics g){
         g.setColor(Color.black);
         g.fillRect(210,360,170,30);
         g.setColor(Color.GREEN);
         g.fillRect(50,360,150,30);
         g.setColor(Color.black);
         g.drawString(" PROCESANDO...",60,380);
         time =1;
      }
   
       public void proces(Graphics g){
         dat =0;
         x++;
         g.setColor(Color.white);
         g.drawString("Ready",270,70);
      
         if(azarC==1){
            g.setColor(Color.white);
         }
         if(azarC==2){
            g.setColor(Color.pink);
         }
         if(azarC==3){
            g.setColor(Color.cyan);
         }
         if(azarC==4){
            g.setColor(Color.orange);
         }
         if(azarC==5){
            g.setColor(Color.magenta);
         }
         if(azarC==6){
            g.setColor(Color.gray);
         }
         if(azarC==7){
            g.setColor(Color.blue);
         }
         g.fillOval(50+x, 200+z, 20, 20);//listo
         if(x>=120&&z<=1){
            act=1;
         }
         if(x >=40&&act==0&&x<120){
            z--;
            g.setColor(Color.white);
            g.drawString("Ready",270,70);
         }
         if(act==1&&z<1){
            z++;
            g.setColor(Color.blue);
            g.fillRect(260,50,50,30);
            g.setColor(Color.white);
            g.drawString("Block",267,70);
         }
      
         if(z==-80){
            g.setColor(Color.blue);
            g.fillRect(320,50,50,30);
            g.setColor(Color.white);
            g.drawString("Ready",325,70);
            try{
               proc=1;
               
               for(int t =1;t<7;t++ ){
                  g.setColor(Color.red);
                  g.drawString(" Proceso 1",255,45);
                  g.setColor(Color.red);
                  g.fillRect(260,50,50,30);
                  g.setColor(Color.black);
                  g.drawString(String.valueOf(t),280,70);
                  hilo.sleep(1000); 
               }
               g.setColor(Color.black);
               g.fillRect(260,50,50,30);
               if(hilo3.isAlive()==false){
                  //proces1(g);
                  System.out.println("Durmiendo");
               }
            
            }
                catch(InterruptedException e){}
            proc=0;
         }
         if(x>199&&x<232){
            act=2;
            g.setColor(Color.blue);
            g.fillRect(260,50,50,30);
            g.setColor(Color.white);
            g.drawString("Blocked",263,70);
            if(x>=230){
               z1++;
               azarC = (int)(Math.random()*7);
               System.out.println("Stop");
               if(z1%2!=0){
                  y1=zz1=x=y=z=act=0;
                  x1=-115;
                  azar = (int)(Math.random()*26);
                  npro = (int)(Math.random()*15);
               
                  if(hilo2.isAlive()==false){
                     hilo2.start();
                     hilo.suspend();
                  
                  }
               }
               else{
                  y1=zz1=x=y=z=act=0;
                  x1=-115;
                  azar = (int)(Math.random()*26);
                  npro = (int)(Math.random()*15);
               
                  if(hilo.isAlive()==false){
                     hilo.resume();
                     hilo2.suspend();
                  }
               }
            
            }
         }
         
      
      }
       public void proces1(Graphics g){
         g.setColor(Color.blue);
         g.fillRect(320,50,50,30);
         g.setColor(Color.white);
         g.drawString("Ready",325,70);
         x3++;
         if(azarC1==1){
            g.setColor(Color.white);
         }
         if(azarC1==2){
            g.setColor(Color.pink);
         }
         if(azarC1==3){
            g.setColor(Color.cyan);
         }
         if(azarC1==4){
            g.setColor(Color.orange);
         }
         if(azarC1==5){
            g.setColor(Color.magenta);
         }
         if(azarC1==6){
            g.setColor(Color.gray);
         }
         if(azarC1==7){
            g.setColor(Color.blue);
         }
         g.fillOval(50+x3, 200+z3, 20, 20);//listo
         if(x3>=120&&z3<=1){
            act3=1;
            g.setColor(Color.blue);
            g.fillRect(320,50,50,30);
            g.setColor(Color.white);
            g.drawString("Ready",325,70);
         }
         if(x3 >=40&&act3==0&&x3<=120){
            g.setColor(Color.blue);
            g.fillRect(320,50,50,30);
            g.setColor(Color.white);
            g.drawString("Ready",325,70);
            z3--;
            System.out.println(z3);
         }
         if(act3==1&&z3<1){
            g.setColor(Color.blue);
            g.fillRect(320,50,50,30);
            g.setColor(Color.white);
            g.drawString("Block",323,70);
            z3++;
         }
      
         if(z3==-80){
            
            try{
               for(int t =1;t<9;t++ ){
                  g.setColor(Color.green);
                  g.drawString(" Proceso 2",315,45);
                  g.setColor(Color.green);
                  g.fillRect(320,50,50,30);
                  g.setColor(Color.black);
                  g.drawString(String.valueOf(t),340,70);
                  hilo.sleep(1000); 
               }
               g.setColor(Color.black);                  
               g.fillRect(320,50,50,30);
            
            }
                catch(InterruptedException e){}
            
         }
         if(x3>199&&x3<232){
            act3=2;
            System.out.println(x3);
            g.setColor(Color.blue);
            g.fillRect(320,50,50,30);
            g.setColor(Color.white);
            g.drawString("Blocked",323,70);
            if(x3>=230){
               z13++;
               azarC1 = (int)(Math.random()*7);
               System.out.println("Stop");
               if(z13%2!=0){
                  y13=zz13=x13=x3=y3=z3=act3=0;
                  azar = (int)(Math.random()*26);
                  npro = (int)(Math.random()*15);
               
                  if(hilo4.isAlive()==false){
                  
                  }
               }
               else{
                  y13=zz13=x13=x3=y3=z3=act3=0;
                  azar = (int)(Math.random()*26);
                  npro = (int)(Math.random()*15);
               
                  if(hilo3.isAlive()==false){
                     hilo3.resume();
                     hilo4.suspend();
                  }
               }
            
            }
         }
      }
       public void mov(){
         
         //x++;
         y++;
         repaint();
         
      }
       public void mov1(){
      
         repaint();
      }
   
       public void run(){
         while (true){
         
            mov();
            mov1();
            try{
               hilo.sleep(50);
            }
                catch(InterruptedException e){}
         
         }
      
      }
   
       public void stop(){
      
         hilo = null;
         hilo2=null;
         hilo3=null;
         hilo4=null;
      }
   
   }