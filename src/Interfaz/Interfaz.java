package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;

import TP.Codigo;
import TP.Grafo;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;


public class Interfaz {

	private JFrame frmTrabajoPractico;
	private JTextField CantTotalVertices;
	private JTextField ingresoDePeso;
	private JTextField vertice;
	private JTextField regiones;
	private static Codigo codigo;
	private static String [] provincias;
	private static int posicion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		codigo = new Codigo ();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmTrabajoPractico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrabajoPractico = new JFrame();
		frmTrabajoPractico.setTitle("Trabajo practico 2");
		frmTrabajoPractico.setBounds(100, 100, 682, 472);
		frmTrabajoPractico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrabajoPractico.getContentPane().setLayout(null);
		
		CantTotalVertices = new JTextField();
		CantTotalVertices.setHorizontalAlignment(SwingConstants.CENTER);
		CantTotalVertices.setFont(new Font("Tahoma", Font.PLAIN, 26));
		CantTotalVertices.setBounds(95, 40, 108, 25);
		frmTrabajoPractico.getContentPane().add(CantTotalVertices);
		CantTotalVertices.setColumns(10);
		
		JButton crearGrafo = new JButton("Crear");
		crearGrafo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		crearGrafo.setBounds(105, 74, 93, 21);
		frmTrabajoPractico.getContentPane().add(crearGrafo);
		
		JLabel pedirCantidad = new JLabel("Ingrese la cantidad de provincias para hacer el grafo:");
		pedirCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pedirCantidad.setBounds(10, 0, 378, 46);
		frmTrabajoPractico.getContentPane().add(pedirCantidad);
		
		JInternalFrame internalFrame1 = new JInternalFrame("Trabajo practico 2");
		internalFrame1.setBounds(70, 146, 421, 261);
		frmTrabajoPractico.getContentPane().add(internalFrame1);
		internalFrame1.getContentPane().setLayout(null);
		internalFrame1.setVisible(false);
		
		JLabel pedirArista = new JLabel("Ingrese peso entre provincias limitrofes:");
		pedirArista.setBounds(53, 10, 409, 21);
		internalFrame1.getContentPane().add(pedirArista);
		pedirArista.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		ingresoDePeso = new JTextField();
		ingresoDePeso.setBounds(136, 41, 108, 25);
		internalFrame1.getContentPane().add(ingresoDePeso);
		ingresoDePeso.setHorizontalAlignment(SwingConstants.CENTER);
		ingresoDePeso.setColumns(10);
		
		JButton añadirArista = new JButton("A\u00F1adir");
		añadirArista.setBounds(136, 146, 124, 35);
		internalFrame1.getContentPane().add(añadirArista);
		añadirArista.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		JButton cerrar = new JButton("cerrar");
		cerrar.setBounds(291, 201, 108, 21);
		internalFrame1.getContentPane().add(cerrar);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(38, 87, 124, 21);
		internalFrame1.getContentPane().add(comboBox);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(215, 87, 124, 21);
		internalFrame1.getContentPane().add(comboBox2);
		
		JButton Crear_AGM = new JButton("Crear AGM");
		Crear_AGM.setEnabled(false);
		Crear_AGM.setBounds(292, 49, 106, 21);
		frmTrabajoPractico.getContentPane().add(Crear_AGM);
		
		JInternalFrame internalFrame = new JInternalFrame("Trabajo practico 2");
		internalFrame.setBounds(390, 212, 268, 156);
		frmTrabajoPractico.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(false);
		
		JLabel verticeI = new JLabel("Ingrese nombre de las provincias del pais:");
		verticeI.setBounds(0, 0, 256, 30);
		internalFrame.getContentPane().add(verticeI);
		verticeI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		vertice = new JTextField();
		vertice.setBounds(49, 40, 159, 22);
		internalFrame.getContentPane().add(vertice);
		vertice.setHorizontalAlignment(SwingConstants.CENTER);
		vertice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		vertice.setColumns(10);
		
		JButton siguiente = new JButton("siguiente");
		siguiente.setBounds(138, 96, 108, 21);
		internalFrame.getContentPane().add(siguiente);
		
		JButton añadir = new JButton("a\u00F1adir");
		añadir.setBounds(73, 72, 108, 21);
		internalFrame.getContentPane().add(añadir);
		
		JLabel pedirCantRegiones = new JLabel("Cantidad de regiones");
		pedirCantRegiones.setEnabled(false);
		pedirCantRegiones.setBounds(441, 13, 151, 20);
		frmTrabajoPractico.getContentPane().add(pedirCantRegiones);
		pedirCantRegiones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		regiones = new JTextField();
		regiones.setEnabled(false);
		regiones.setBounds(458, 42, 108, 25);
		frmTrabajoPractico.getContentPane().add(regiones);
		regiones.setHorizontalAlignment(SwingConstants.CENTER);
		regiones.setColumns(10);
		
		JButton calcular = new JButton("Calcular");
		calcular.setEnabled(false);
		calcular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		calcular.setBounds(468, 74, 93, 21);
		frmTrabajoPractico.getContentPane().add(calcular);
		
		JLabel mostrarRegiones = new JLabel(" ");
		mostrarRegiones.setVerticalAlignment(SwingConstants.TOP);
		mostrarRegiones.setBounds(10, 106, 648, 301);
		frmTrabajoPractico.getContentPane().add(mostrarRegiones);
		mostrarRegiones.setVisible(false);
		
		
		posicion = 1;
		
		//Pide cuantos vertices quiere----------------------------------------------------
		crearGrafo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				int cantVertices =Integer.parseInt(CantTotalVertices.getText());			 
			 	codigo.crearGrafo(cantVertices);
			 	
			 	//inicializa el arreglo con el nombre de provincias para los comboBox
			 	provincias= new String[cantVertices + 1];
			 	provincias[0] = "Seleccione provicia";
			 	
			 	CantTotalVertices.setEnabled(false);
			 	crearGrafo.setEnabled(false);
			 	CantTotalVertices.setText("");
			 	
			 	internalFrame.setVisible(true);
			}	
		});
		
		
		//Ingresa el nombre de todas las provincias---------------------------------------
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String provincia = vertice.getText();
				codigo.agregarProvincias(provincia);
				
				//agrega el nombre de las provincias en el arreglo para añadirlo en el comboBox
				provincias[posicion] = provincia;
				posicion ++;
				
				vertice.setText("");
			}
		});
		
		//Pasar a la siguiente ventana (Pedir peso)---------------------------------------
		siguiente.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				//carga los comboBox con las provincias
				comboBox.setModel(new DefaultComboBoxModel (provincias));
				comboBox2.setModel(new DefaultComboBoxModel (provincias));
				
			 	internalFrame.setVisible(false);
			 	internalFrame1.setVisible(true);
			}
		});
		
		//Ingresa el peso entre dos provincias--------------------------------------------
		añadirArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String primeraProvincia = (String) comboBox.getSelectedItem();
				String segundaProvincia = (String) comboBox2.getSelectedItem();
				
				double peso = Double.parseDouble(ingresoDePeso.getText());
				codigo.agregarArista(primeraProvincia, segundaProvincia, peso);
				
				ingresoDePeso.setText("");

				}		
		});
		
		//Cierra la ventana del ingreso del peso y habilita poder crear un AGM con el grafo creado
		//Genera la matriz con los pesos de las airstas igresados del grafo
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame1.setVisible(false);
				Crear_AGM.setEnabled(true);
				
				Grafo grafo = codigo.getGrafo();
				crearTablaGrafo(grafo);
				}		
		});
		
		//Genera el AGM a partir del grafo ingresado y habilita poder generar las regiones-------------------
		//Genera la matriz con los pesos de las aristas del AGM
		Crear_AGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_AGM.setEnabled(false);
				pedirCantRegiones.setEnabled(true);
				regiones.setEnabled(true);
				calcular.setEnabled(true);
		
				codigo.generarAGM();
				Grafo grafoAGM = codigo.getAGM();
				crearTablaGrafo(grafoAGM);
			}		
		});
		
		//Genera las regiones a partir del AGM creado---------------------------------------------------
		calcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int cantidadRegiones = Integer.parseInt(regiones.getText());
			codigo.partirAGMEnRegiones(cantidadRegiones);
			
			String regionesFormadas = codigo.mostrarRegiones();
			mostrarRegiones.setText(regionesFormadas);
			mostrarRegiones.setVisible(true);
			
			pedirCantRegiones.setEnabled(false);
			regiones.setEnabled(false);
			calcular.setEnabled(false);		
			}		
		});
	}
		

		//---------------------------Muestra la matriz de pesos de los grafos-----------------------
		public void crearTablaGrafo(Grafo g) {
			double[][] matrizPesos = g.getMatrizPesos();
			Object[][] matrizPesos2 = new Object[matrizPesos.length][matrizPesos[0].length + 1];
			String[] provinciasSinDefault = Arrays.copyOf(provincias, provincias.length);
			provinciasSinDefault[0] = "";
			for (int i = 1; i < provincias.length; i++) {
				matrizPesos2[i - 1][0] = provincias[i];
				for (int j = 0; j < matrizPesos[i - 1].length; j++) {
					matrizPesos2[i - 1][j + 1] = matrizPesos[i - 1][j];
				}
			}
			
			JTable table = new JTable(matrizPesos2, provincias);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(241, 213, 251, 120);
			frmTrabajoPractico.getContentPane().add(scrollPane);
		}
	}



