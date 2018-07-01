import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame implements ActionListener{
	
	private JPanel 		panel; //Atributo
	
	private JMenuBar 	mbPrincipal;
	private JMenu    	menuCalculos, menuGrados, menuAudio, menuAudioT; //Atributo
	private JMenuItem	miFactorial, miGradosCF, miGradosFC, miExponencial, miEcuacion, miTabla,
		miCalculadora, miReproductor, miAudioFX, miAudioZOOM, miAudioTMP3, miAudioTWAV, miSalir, miAudioTImgWav;
	 
	private FactorialTareaGUI factor     = new FactorialTareaGUI(); 
	private Exponencial exponencial      = new Exponencial();
	private GradosGUI3 grados            = new GradosGUI3();
	private EcuacionGUI ecuacion         = new EcuacionGUI();
	private TablaGUI tabla			     = new TablaGUI();
	private Calculadora calcu;
	private ReproductorGUI reproductor;
	private AudioGUIFX audioFX;     
	private AudioGUIZOOM audioZOOM;
	private AudioTunesGUIVLMP3 audioTMP3;    
	private AudioTunesGUIVLWAV audioTWAV;  
	
	public App(){
		
		super("Java App: Audio y Calculos");
		
		try{
			reproductor = new ReproductorGUI();
		
		}catch(Exception ex){}
		
		try{
			audioFX     = new AudioGUIFX();
			audioZOOM   = new AudioGUIZOOM();
			
		}catch(Exception e){}	
			
		//1.Crear los objetos de los atributos
		panel 		  = new JPanel();
		mbPrincipal   = new JMenuBar();
		menuCalculos  = new JMenu("Calculos");
		menuAudio	  = new JMenu("Audio");
		menuAudioT    = new JMenu("Audio Tunes");
		menuGrados    = new JMenu("Coneversion de Grados");
		miFactorial   = new JMenuItem("Factorial de N");
		miExponencial = new JMenuItem("Y = B ^ X");
		miGradosCF    = new JMenuItem("G. Centigrados a G. Fahrenheit");
		miGradosFC    = new JMenuItem("G. Fahrenheit a G. Centigrados");
		miEcuacion    = new JMenuItem("Ecuacion Cuadratica");
		miCalculadora = new JMenuItem("Calculadora");
		miTabla       = new JMenuItem("Tabla de N");
		
		miReproductor = new JMenuItem("Audio WAV");
		miAudioFX     = new JMenuItem("AudioMP3 FX");
		miAudioZOOM   = new JMenuItem("AudioMP3 ZOOM");
		
		miAudioTMP3   = new JMenuItem("Audio Tunes MP3");
		miAudioTWAV   = new JMenuItem("Audio Tunes WAV");
		
		miSalir       = new JMenuItem("Exit");		
		
		//1.2 Colocar el metodo  
		miFactorial.addActionListener(this);
		miExponencial.addActionListener(this);
		miGradosCF.addActionListener(this);
		miGradosFC.addActionListener(this);
		miEcuacion.addActionListener(this);
		miCalculadora.addActionListener(this);
		miTabla.addActionListener(this);
		
		miReproductor.addActionListener(this);
		miAudioFX.addActionListener(this);
		miAudioZOOM.addActionListener(this);
		
		miAudioTMP3.addActionListener(this);
		miAudioTWAV.addActionListener(this);
		
		miSalir.addActionListener(this);
		
		//2.Colocar los JMenuItems en los JMenus correspondientes
		menuGrados.add(miGradosCF);
		menuGrados.add(miGradosFC);
		
		menuCalculos.add(miFactorial);
		menuCalculos.add(miExponencial);
		menuCalculos.add(menuGrados);
		menuCalculos.add(miEcuacion);
		menuCalculos.add(miCalculadora);
		menuCalculos.add(miTabla);
		menuCalculos.add(miSalir);
		
		menuAudio.add(miReproductor);
		menuAudio.add(miAudioFX);
		menuAudio.add(miAudioZOOM);
		menuAudio.add(miSalir);
		
		menuAudioT.add(miAudioTMP3);
		menuAudioT.add(miAudioTWAV);
				
		//3.Colocar en JMenuBar los JMenus 
		mbPrincipal.add(menuCalculos);
		mbPrincipal.add(menuAudio);
		mbPrincipal.add(menuAudioT);
		
		//4.Colocar el JMenuBar en el JFrame y hacerlo visible
		setJMenuBar(mbPrincipal);
		setSize(400,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == miFactorial){
			 
			 panel.setVisible(false);
			 panel = factor.getPanel2();
			 panel.setVisible(true);
			 add(panel);
			 setVisible(true);
		}	 
		if(e.getSource() == miExponencial){
			
			 panel.setVisible(false);
			 panel = exponencial.getPanel2();
			 panel.setVisible(true);
			 add(panel);
			 setVisible(true);	 
		}	 
		if(e.getSource() == miGradosCF){
			
			 panel.setVisible(false);
			 panel = grados.getPanel2();
			 panel.setVisible(true);
			 add(panel);
			 setVisible(true);
		}
		if(e.getSource() == miGradosFC){
			
			 panel.setVisible(false);
			 panel = grados.getPanel2();
			 panel.setVisible(true);
			 add(panel);
			 setVisible(true);
		}
		if(e.getSource() == miEcuacion){
			
			panel.setVisible(false);
			panel = ecuacion.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource() == miTabla){
			
			panel.setVisible(false);
			panel = tabla.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource() == miCalculadora){
			calcu = new Calculadora();
		}
		
		if(e.getSource() == miReproductor){
		
			panel.setVisible(false);
			panel = reproductor.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource() == miAudioFX){
		
			panel.setVisible(false);
			panel = audioFX.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource() == miAudioZOOM){
		
			panel.setVisible(false);
			panel = audioZOOM.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource() == miAudioTWAV){
		
			audioTWAV   = new AudioTunesGUIVLWAV();
		}
		
		if(e.getSource() == miAudioTMP3){
		
			audioTMP3   = new AudioTunesGUIVLMP3();
		}
		
		if(e.getSource() == miSalir) System.exit(0);
		
	}
	
	public static void main (String args[]){
		
		new App(); 
	}	
}