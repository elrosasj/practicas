import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class colagrafica extends JFrame {
	ColaDinamica objeto = new ColaDinamica ();
	JLabel etiqueta = new JLabel ("Elija una opción");
	JButton insertar = new JButton ("Insertar Dato");
	JButton eliminar = new JButton ("Eliminar Dato");
	JButton frenteyfin = new JButton ("Frente y Fin");
	JButton all = new JButton ("Mostrar Cola");
	JButton salir = new JButton ("Salir");
	public colagrafica () {
		super ("Cola en almacenamiento dinámico");
		this.setSize (350, 275);
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit ().getScreenSize ();
		cuadro = this.getSize();
		this.setLocation (((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);
		setLayout (null);
		etiqueta.reshape (125, 0, 350, 20);
		add (etiqueta);
		insertar.reshape (110, 35, 120, 25);
		add (insertar);
		eliminar.reshape (110, 75, 120, 25);
		add (eliminar);
		frenteyfin.reshape (110, 115, 120, 25);
		add (frenteyfin);
		all.reshape (110, 155, 120, 25);
		add (all);
		salir.reshape (110, 195, 120, 25);
		add (salir);
		salir.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				System.exit (0);
			}
		});
		insertar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				String info;
				info = JOptionPane.showInputDialog ("Ingrese un dato");
				objeto.insertar (info);
				JOptionPane.showMessageDialog (null, "El dato " + info + " se ha insertado en la cola");
			}
		});
		eliminar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				objeto.sacar ();
			}
		});
		frenteyfin.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				objeto.mostrar ();
			}
		});
		all.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				objeto.mostrarCola ();
			}
		});
	}
	public static void main (String [] args) {
		colagrafica obj = new colagrafica ();
		obj.show ();
		obj.addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent evt) {
				System.exit (0);
			}
		});	
	}
}