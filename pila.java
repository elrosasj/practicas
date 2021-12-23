import javax.swing.JOptionPane;
class pila {
	public static void main(String [] args) {
		int o, p = 0;
		String pil[] = new String[6];
		do {
			o = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija una opcion\n1.- Ingresar dato\n2.- Eliminar Dato\n3.- Mostrar Frente\n4.- Mostrar Ultimo\n5.- Salir\n")); 
			switch (o) {
				case 1: {
					if (p == 5) {
						JOptionPane.showMessageDialog(null, "Pila llena, elimine un dato para ingresar otro");
						break;
					}
					else {
						pil[p] = JOptionPane.showInputDialog(null, "Ingresa un elemento ");
						JOptionPane.showMessageDialog(null, "Elemento "+pil[p]+" insertado");
						p++;
					}
				}
				break;
				case 2: {
					if (pil[0] == null) {
						JOptionPane.showMessageDialog(null, "Pila vacia, inserte algun elemento para poder eliminar");
						break;						
					}
					else {
						JOptionPane.showMessageDialog(null, "Elemento "+pil[p-1]+" eliminado");
						pil[p-1] = null;
						p--;
					}
				}
				break;			
				case 3: {
					if (pil[0] == null) {
						JOptionPane.showMessageDialog(null, "Pila vacia, inserte algun elemento para poder mostrarlo");
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Frente de la pila: "+pil[0]);
					}						
				}
				break;
				case 4: {
					if (pil[0] == null) {
							JOptionPane.showMessageDialog(null, "Pila vacia, inserte algun elemento para poder eliminar");
							break;						
					}
					else {
						JOptionPane.showMessageDialog(null, "Elemento Final de la Pila: "+pil[p-1]);
					}
				}
				break;
				case 5: JOptionPane.showMessageDialog(null, "Fin del programa");
				break;
				default: JOptionPane.showMessageDialog(null, "Opcion Invalida");
			}	
		}
		while (o != 5);
	}
}