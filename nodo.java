   import javax.swing.*;
    class nodo
   {
      String dato;
      nodo enlace;
   }
    class ColaDinamica
   {
      nodo frente,fin;
       public ColaDinamica()
      {
         frente=null;
         fin=null;
      }
       public void mostrarCola()
      {
         JTextArea cola=new JTextArea();
         JTextArea Error=new JTextArea();
         String error="Cola vacia";
         Error.setText(error);
         String Sdato="";
         if(frente==null)
         {
            JOptionPane.showMessageDialog(null, "Error, Cola Vacía");
         }
         else
         {
            nodo aux=new nodo();
            aux=frente;
            String mostrar="";
            int i=1;
            while(aux!=null)
            {
               mostrar+=(i+"° -> " + aux.dato + "\n");
               aux=aux.enlace;
               i++;
            }//cola.setText(mostrar);
            JOptionPane.showMessageDialog(null, "Los datos de la cola son: \n" + mostrar);  
         }
      }
       public void insertar(String Sdato)
      {
         nodo aux=new nodo();
         aux.dato=Sdato;
         aux.enlace=null;
         if(frente==null)
         {
            frente=aux;
            fin=aux;
         }
         else
         {
            fin.enlace=aux;
            fin=aux;
         }
      }
       public void mostrar()
      {
         String Sdato="";
         if(frente==null)
         {
            JOptionPane.showMessageDialog(null, "Error, Cola Vacía");
         }
         else
         {
            Sdato+=("El dato del frente es: "+frente.dato+"\nEl dato final es: "+fin.dato);
            JOptionPane.showMessageDialog(null,Sdato);
         }
      }

       public void eliminar()
      {
         if(frente==null)
         {
            JOptionPane.showMessageDialog(null, "Error, Cola Vacía");
         }
         else
         {
            frente=null;
            fin=null;
         }
      }
       public void sacar()
      {
         String Idato="";
         if(frente==null)
         {
            JOptionPane.showMessageDialog(null, "Error, Cola Vacía");
         }
         else
         {
            Idato=frente.dato;
            if(frente==fin)
            {
               fin=null;
               frente=null;
            }
            else
            {
               frente=frente.enlace;
            }
            JOptionPane.showMessageDialog(null,"El dato eliminado fue: "+Idato);
         }
         
      }
   }
