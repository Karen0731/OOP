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

public class GradosGUI3 extends JFrame implements ActionListener{
	
	private JTextField tfGrados;
	private JButton bSalir,bCalcular,bCalcularF;
	private JPanel panel1, panel2;     
	private JTextArea taDatos;
	
	private CalculoDP calculo = new CalculoDP();
	
	public GradosGUI3(){
		
		super("Conversion de grados");
		
		//Crear objetos de los atributos
		tfGrados  = new JTextField();
		bCalcular = new JButton("G. Fahrenheit a Centigrados");
		bCalcularF= new JButton("G. Centigrados a Fahrenheit");
		bSalir    = new JButton("Exit");
		panel1 	  = new JPanel();
		panel2    = new JPanel();
		taDatos   = new JTextArea(10,30);
		
		// Adicionar addActionListener a los JButtons
		bCalcular.addActionListener(this);
		bCalcularF.addActionListener(this);
		bSalir.addActionListener(this);
		
		//Definir el Layout de los JPanels
		panel1.setLayout(new GridLayout(3,2));
		panel2.setLayout(new FlowLayout());
		
		//Poner objetos de los atributos en los panels correspondientes
		panel1.add(new JLabel("Grados a convertir ="));
		panel1.add(tfGrados);
		panel1.add(bCalcularF);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//Poner panel1 en JFrame y hacerlo visible 
		add(panel2);
		setSize(500,400);
		//setVisible(true);
			
	}
	
	public JPanel getPanel2(){
		
		return panel2;
		
	}
	
	
	public void actionPerformed(ActionEvent evento){
		
		if(evento.getSource() == bCalcular){
			//Obtener os grados a convertir
			String strGrados = tfGrados.getText();
			
			//Hacer la conversion
			float gf = Float.parseFloat(strGrados);
			//float gc = (float)5*(gf-32)/9;
			float gc = calculo.gradosFC(gf); 
			
			//Despliega los datos 
			taDatos.setText(gf+" G. Fahrenheit = "+gc+ " G. Centigrados\n");
		}
		
		if(evento.getSource() == bCalcularF){
			//Obtener os grados a convertir
			String strGrados = tfGrados.getText();
			
			//Hacer la conversion
			float gc = Float.parseFloat(strGrados);
			//float gf = (float)9/5*gc+32;
			float gf = calculo.gradosFC(gc);
			
			//Despliega los datos 
			taDatos.setText(gc+" G.Centigrados = "+gf+ " G. Fahrenheit\n");
		}
		
		if(evento.getSource() == bSalir){
			System.exit(0);
		}
	}
	
	public static void main (String args[]){
		
		GradosGUI3 grados = new GradosGUI3();
	}
}