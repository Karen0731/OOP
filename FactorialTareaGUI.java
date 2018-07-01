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

public class FactorialTareaGUI extends JFrame implements ActionListener{
	
	private JTextField tfFactorial;
	private JButton bSalir,bCalcular;
	private JPanel panel1, panel2;
	private JTextArea taDatos;
	
	private CalculoDP calculo = new CalculoDP();
	
	public FactorialTareaGUI(){
		
		super("Factorial de un numero");
		
		//Crear objetos de los atributos
		tfFactorial  = new JTextField();
		bCalcular = new JButton("Factorial");
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
		panel1.add(tfFactorial);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//Poner panel1 en JFrame y hacerlo visible 
		add(panel2);
		setSize(300,400);
	//	setVisible(true);
			
	}
	
	public JPanel getPanel2(){
		
		return panel2;	
	}
	
	
	public void actionPerformed(ActionEvent evento){
		
		if(evento.getSource() == bCalcular){
			
			//Obtener numero
			String strNumero = tfFactorial.getText();
			
			//Hacer la conversion
			int n = Integer.parseInt(strNumero);
			int f = calculo.factorial(n);
			
			//Despliega los datos 
			taDatos.setText("Factorial de "+n+"= "+f);
		}
	
		if(evento.getSource() == bSalir){
			System.exit(0);
		}
	}
	
	public static void main (String args[]){
		
		FactorialTareaGUI grados = new FactorialTareaGUI();
	}
}