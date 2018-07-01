import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;

public class Calculadora extends JFrame implements ActionListener
{
    private JTextField tfNumero = new JTextField(8);
    
    private JButton bSuma, bResta, bMultiplica, bDivide, bIgual, bClear, bPunto;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bFactorial, bExpo, bRaiz, bCuadrado;
    private Panel panel1, panel2;
    
    private float n1, n2, r;
    private String operacion = "";
    private String strNumero = "";
    private int base, x;
    private boolean punto = false;
    
    public Calculadora()
    {
        super("Calculadora");
        
        panel1 = new Panel();
        panel2 = new Panel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(5,4));
        
        
        panel1.add(tfNumero);
        
        bClear = new JButton("clear");
        bClear.addActionListener(this);
        panel1.add(bClear);
        
        
        b7 = new JButton("7");
        b7.addActionListener(this);
        panel2.add(b7);
        
        b8 = new JButton("8");
        b8.addActionListener(this);
        panel2.add(b8);
        
        b9 = new JButton("9");
        b9.addActionListener(this);
        panel2.add(b9);
        
        bSuma = new JButton("+");
        bSuma.addActionListener(this);
        panel2.add(bSuma);
        
        b4 = new JButton("4");
        b4.addActionListener(this);
        panel2.add(b4);
        
        b5 = new JButton("5");
        b5.addActionListener(this);
        panel2.add(b5);
        
        b6 = new JButton("6");
        b6.addActionListener(this);
        panel2.add(b6);
        
        bResta = new JButton("-");
        bResta.addActionListener(this);
        panel2.add(bResta);
        
        b1 = new JButton("1");
        b1.addActionListener(this);
        panel2.add(b1);
        
        b2 = new JButton("2");
        b2.addActionListener(this);
        panel2.add(b2);
        
        b3 = new JButton("3");
        b3.addActionListener(this);
        panel2.add(b3);
        
        bMultiplica = new JButton("x");
        bMultiplica.addActionListener(this);
        panel2.add(bMultiplica);
        
        b0 = new JButton("0");
        b0.addActionListener(this);
        panel2.add(b0);
        
        bPunto = new JButton(".");
        bPunto.addActionListener(this);
        panel2.add(bPunto);
        
        bIgual = new JButton("=");
        bIgual.addActionListener(this);
        panel2.add(bIgual);
        
        bDivide = new JButton("/");
        bDivide.addActionListener(this);
        panel2.add(bDivide);
        
        bFactorial = new JButton("x!");
        bFactorial.addActionListener(this);
        panel2.add(bFactorial);
        
        bRaiz = new JButton("sqrt(x)");
        bRaiz.addActionListener(this);
        panel2.add(bRaiz);
        
        bCuadrado = new JButton("x^2");
        bCuadrado.addActionListener(this);
        panel2.add(bCuadrado);
        
        bExpo = new JButton("y^x");
        bExpo.addActionListener(this);
        panel2.add(bExpo);
        
        
        setLayout(new FlowLayout());
        add(panel1);
        add(panel2);
        setSize(350,220);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e){
    	
    	
    	if(e.getSource() == b0)
    	{
    		strNumero= strNumero+"0";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b1)
    	{
    		x=1;
    		strNumero= strNumero+"1";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b2)
    	{
    		strNumero= strNumero+"2";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b3)
    	{
    		strNumero= strNumero+"3";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b4)
    	{
    		strNumero= strNumero+"4";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b5)
    	{
    		x=5;
    		strNumero= strNumero+"5";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b6)
    	{
   			strNumero= strNumero+"6";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b7)
    	{
    		x=7;
    		strNumero= strNumero+"7";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b8){
    		strNumero= strNumero+"8";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == b9)
    	{
    		strNumero= strNumero+"9";
    		tfNumero.setText(strNumero);
    	}
    	
    	if(e.getSource() == bPunto)
    	{
    		if(punto == false)
    		{
    		strNumero= strNumero+".";
    		tfNumero.setText(strNumero);
    		punto = true;
    		}
    	}
    	
    	
    	if(e.getSource() == bCuadrado)
    	{
   			n1 = Float.parseFloat(strNumero);
    		
    		n1 = n1*n1;
    		
    		tfNumero.setText(""+n1);
    		strNumero = "";
    		
    	}
    	
    	if(e.getSource() == bFactorial)
    	{	
    		strNumero = tfNumero.getText();
    		n1 = Float.parseFloat(strNumero);
    		
    		float f=1;
	        for(int i=1;i<=n1;i++)
	        {
	            f=f*i;
	        }
        	tfNumero.setText(""+f);
    		strNumero = "";
    	}
    	
    	if(e.getSource() == bSuma)
    	{
    		n1 = Float.parseFloat(strNumero);
    		
    		strNumero = "";
    		tfNumero.setText(strNumero);
    		operacion = "Suma";
    		punto = false;
    	}
    
       	
    	if(e.getSource() == bExpo)
    	{	
    		n1 = Float.parseFloat(strNumero);
    		
    		strNumero = "";
    		tfNumero.setText(strNumero);
    		operacion = "Expo";
    		punto = false;
    	}
    	
    	if(e.getSource() == bResta)
    	{	
    		n1 = Float.parseFloat(strNumero);
    		
    		strNumero = "";
    		tfNumero.setText(strNumero);
    		operacion = "Resta";
    		punto = false;	
    	}
    	
    	if(e.getSource() == bDivide)
    	{	
    		n1 = Float.parseFloat(strNumero);
    		
    		strNumero = "";
    		tfNumero.setText(strNumero);
    		operacion = "Divide";
    		punto = false;	
    	}
    	
    	if(e.getSource() == bMultiplica)
    	{	
    		n1 = Float.parseFloat(strNumero);
    		
    		strNumero = "";
    		tfNumero.setText(strNumero);
    		operacion = "Multiplicacion";
    		punto = false;
    	}
    	
    	if(e.getSource() == bRaiz)
    	{
    		double y = Double.parseDouble(strNumero);
    	
    		y= Math.sqrt(y);
   
    		tfNumero.setText("="+y);
    		strNumero = "";
    	}
    	
    	
    	if(e.getSource() == bIgual)
    	{
    		
			n2 = Float.parseFloat(strNumero);
			punto = false;
			
			System.out.println(operacion);
			
			if(operacion == "Suma"){
				r = n1 + n2;
			}
			
			if(operacion == "Expo"){
				r = (float)Math.pow(n1,n2);
		    }
		    
		    if(operacion == "Resta"){
		    	r = n1 - n2;
		    }
		    
		    if(operacion == "Divide"){
		    	r = n1/n2;
		    }
		    
		    if(operacion == "Multiplicacion"){
		    	r = n1*n2;
		    }
		    
			
			tfNumero.setText(""+r);
    	}
    	
    	if(e.getSource() == bClear)
    	{
    		punto = false;
    		tfNumero.setText("");
    		strNumero = "";	
    	}
    	
    	
    }
    
    public static void main(String args[])
    {
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
