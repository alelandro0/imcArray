package imc;


import java.util.Arrays;

import javax.swing.JOptionPane;

public class ImcArreglo {
      String [] nombres ;
      double [] tallas ;
      double [] pesos ;
	int []edades ;
	String[] telefonos ;
	double[] imc ;
	String[] diagnostico ;
	

	public ImcArreglo() {
        nombres = new String[3];
        edades = new int[3];
        pesos = new double[3];
        tallas = new double[3];
        telefonos = new String[3];
		iniciar();
	}

	public void iniciar() {
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(
					"MENU PRINCIPAL\n\n" + "1) " + "Registrar otra personas\n" + "2) " + " Imprimir lista\n" + "3) "
							+ " Consulta individual\n" + "4) " + " Eliminar persona\n" + "5) " + " Actualizar\n" + "6) "
							+ " Limpiar lista\n" + "7) " + " Salir\n\n" + "***SELECCIONE UNA OPCION***\n\n"));
			menu(op);
		} while (op != 7);
	}

	public void menu(int op) {
		switch (op) {
		case 1:
			registraOtraPersona();

			break;
		case 2:
			if (nombres.length == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				imprimrLista();
			}
			break;
		case 3:
			if (nombres.length == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				imprimirIndividual();
			}
			break;
		case 4:
			if (nombres.length == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				eliminarPersona();
			}
			break;
		case 5:
			if (nombres.length == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				actualizar();
			}
			break;
		case 6:
			if (nombres.length == 0) {
				JOptionPane.showMessageDialog(null, "Insertar Datos");
			} else {
				limpiarLista();
			}
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "SALIR");
			break;
		default:
			break;
		}
	}

	public void registraOtraPersona() {
	 

	    for (int i = 0; i < nombres.length; i++) {
	        String nombre = JOptionPane.showInputDialog("NOMBRE");
	        int edad = Integer.parseInt(JOptionPane.showInputDialog("EDAD"));
	        double peso = Double.parseDouble(JOptionPane.showInputDialog("PESO"));
	        double talla = Double.parseDouble(JOptionPane.showInputDialog("ESTATURA"));
	        String telefono = JOptionPane.showInputDialog("TELEFONO");

	        nombres[i] = nombre;
	        edades[i] = edad;
	        telefonos[i] = telefono;
	        pesos[i] = peso;
	        tallas[i] = talla;
	    }
	}


	public void imprimrLista() {
		System.out.println("*****LISTA*****");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("NOMBRE : " + nombres[i] + "\nEdad : " + edades[i] + "\nTelefono : "
					+ telefonos[i] + "\nPeso : " + pesos[i] + "\nEstatura : " + tallas[i]);
			System.out.println("-------------------\n");
		}
	}



	public void eliminarPersona() {
		String nombre = JOptionPane.showInputDialog("ingrese el usuario a eliminar");
		int conta = 0;
		int aux= -1;
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(nombre)) {
				aux=i;
				JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
				conta++;
				break;
				
			}
		}
		if (conta == 0) {
			JOptionPane.showMessageDialog(null, "VALOR NO EXISTE");
		}

	}

	public void actualizar() {
		String actaul = JOptionPane.showInputDialog("ingresa el nombre para actualizar datos");
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(actaul)) {
				JOptionPane.showMessageDialog(null, "ingrese valores a actualizar");
				int edad = Integer.parseInt(JOptionPane.showInputDialog("EDAD"));
				double peso = Double.parseDouble(JOptionPane.showInputDialog("PESO"));
				double talla = Double.parseDouble(JOptionPane.showInputDialog("ESTATURA"));
				String telefono = JOptionPane.showInputDialog("TELEFONO");
				edades[i]=edad;
				pesos[i]= peso;
				tallas[i]= talla;
				telefonos[i]= telefono;
			}

		}
	}

	public void limpiarLista() {
		Arrays.fill(nombres, 0);
		Arrays.fill(pesos, 0);
		Arrays.fill(imc,0);
		Arrays.fill(tallas, 0);
		Arrays.fill(telefonos, 0);;
		Arrays.fill(edades, 0);
	}
	public void imprimirIndividual() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario: ");
		String diagnostico = "";
		boolean encontrado = false;
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(nombre)) {
				double imc = pesos[i] / Math.pow(tallas[i], 2);

				if (imc < 18) {
					diagnostico = "ANOREXIA";
				} else if (imc >= 18 && imc <= 20) {
					diagnostico = "DELGADES";
				} else if (imc >= 20 && imc < 25) {
					diagnostico = "NORMAL";
				} else if (imc >= 25 && imc <= 30) {
					diagnostico = "OBECIDAD GRADO1";
				} else if (imc >= 30 && imc < 35) {
					diagnostico = "OBECIDAD GRADO 2";
				} else if (imc >= 35 && imc < 40) {
					diagnostico = "OBECIDAD GRADO 3";
				}else if (imc >= 40) {
					diagnostico = "OBECIDAD MORFIDA";
				}
				JOptionPane.showMessageDialog(null,
						"Nombre: " + nombres[i] + "\nEdad: " + edades[i] + "\nTeléfono: " + telefonos[i]
								+ "\nPeso: " + pesos[i]+ " kg" + "\nTalla: " + tallas[i] + " m" + "\nIMC: "
								+ imc + "\nDiagnóstico: " + diagnostico);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
		}
	}
}
