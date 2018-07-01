import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaGUI extends JFrame implements ActionListener{
	
	private JTextField tfTabla;
	private JButton bSalir,bCalcular;
	private JPanel panel1, panel2;
	private JTextArea taDatos;
	
	private CalculoDP calculo = new CalculoDP();
	
	public TablaGUI(){
		
		super("Tabla de N");
		
		//Crear objetos de los atributos
		tfTabla  = new JTextField();
		bCalcular = new JButton("Tabla de N");
		bSalir    = new JButton("Exit");
		panel1 	  = new JPanel();
		panel2    = new JPanel();
		taDatos   = new JTextArea(10,30);
		
		// Adicionar addActionListener a los JButtons
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);
		
		//Definir el Layout de los JPanels
		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new FlowLayout());
		
		//Poner objetos de los atributos en los panels correspondientes
		panel1.add(new JLabel("Numero ="));
		panel1.add(tfTabla);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//Poner panel1 en JFrame y hacerlo visible 
		add(panel2);
		setSize(400,400);
		//setVisible(true);
			
	}
	
	public JPanel getPanel2(){
		
		return panel2;
		
	}
	
	
	public void actionPerformed(ActionEvent evento){
		
		if(evento.getSource() == bCalcular){
			
			//Obtener numero
			String strNumero = tfTabla.getText();
			
			//Hacer la conversion
			int n = Integer.parseInt(strNumero);
			
			int x1 = calculo.tabla1(n);
			int x2 = calculo.tabla2(n);
			int x3 = calculo.tabla3(n);
			int x4 = calculo.tabla4(n);
			int x5 = calculo.tabla5(n);
			int x6 = calculo.tabla6(n);
			int x7 = calculo.tabla7(n);
			int x8 = calculo.tabla8(n);
			int x9 = calculo.tabla9(n);
			int x10 = calculo.tabla10(n);
			
			taDatos.setText(n + "* 1  =" + x1 + "\n" + n + "* 2  =" + x2 + "\n" + n + "* 3  =" + x3 + "\n" + n + "* 4  =" + x4 + "\n" + n + "* 5  =" + x5 + "\n" + n + "* 6  =" + x6 + "\n" + n + "* 7  =" + x7 + "\n" + n + "* 8  =" + x8 + "\n" + n + "* 9  =" + x9 + "\n" + n + "* 10  =" + x10 + "\n");
			
		}
	
		if(evento.getSource() == bSalir){
			System.exit(0);
		}
	}
	
	public static void main (String args[]){
		
		TablaGUI grados = new TablaGUI();
	}
}