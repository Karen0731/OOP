import java.io.File;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel; 
import javax.swing.JTextField;
import javax.swing.JLabel; 

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class ReproductorGUI extends JFrame implements ActionListener{
	
	private File fileSong;
	private AudioInputStream audioStream;
	private Clip clip;

	private JButton bPlay,bStop;
	private JPanel panel1, panel2;
	private JTextField tfSong;
    private String song;
    private JLabel play;
    
	
	public ReproductorGUI() throws Exception{
		
		super("Reproductor");
		
		bStop     = new JButton("Stop");
		bPlay     = new JButton("Play");
		panel1 	  = new JPanel();
		panel2	  = new JPanel();
		tfSong     = new JTextField(10);
		play      = new JLabel("Now Playing: ");
		
		
		//Adicionar el ActionListener a los buttons
		bStop.addActionListener(this);
		bPlay.addActionListener(this);
		
		//Definir el Layout de JFrame
		panel1.setLayout(new GridLayout(2,2));
       	panel2.setLayout(new FlowLayout());
		
		//Poner los objetos de los atributos de los Panels correspondientes
		panel1.add(new JLabel("Song to play: "));
		panel1.add(tfSong);
		panel1.add(bPlay);
		panel1.add(bStop);
		
        panel2.add(panel1);
    	panel2.add(play);
    	
		//Poner el Panel1 en el JFrame y hacerlo visible 
		add(panel2);
		setSize(500,400);
	//	setVisible(true);
	}
	
	public JPanel getPanel2(){
		
		return panel2;
		
	}
	
	private void reproducir()throws Exception{
			
			//Obtener el nombre de la cancion a reproducir
			song = tfSong.getText();
			play.setText("Now Playing: "+ song);
			
			//Relacionar el nombre de la cancion con un archivo (File) wav
			fileSong = new File(song + ".wav");
			
			//Preparar el audio stirng del archivo de la cancion
			audioStream = AudioSystem.getAudioInputStream(fileSong);
			
			//Reproducir la cancion 
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			
		
	}
	
	public void stop(){
		clip.stop();
	
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bPlay){
			try{
				reproducir();
			}
			catch(Exception ex){
			}
		}
		if(e.getSource() == bStop){
			stop();
		}
		
	}

	
	public static void main (String args[]) throws Exception{
		
		ReproductorGUI reproductor = new ReproductorGUI();
	}	
}