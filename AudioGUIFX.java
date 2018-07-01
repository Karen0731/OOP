 import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class AudioGUIFX extends JFrame implements ActionListener
{
		private JButton bPlay,bStop;
		private JPanel panel1, panel2;
		private JTextField tfSong;
    	private String song;
    	private JLabel play;
		
		private Thread thrAudio;
	
	public AudioGUIFX() throws Exception//FileNotFoundException,JavaLayerException
	{
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
		//setVisible(true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}	
		
	public JPanel getPanel2(){
		
		return panel2;	
	}

	public void actionPerformed(ActionEvent evento) 
	{
		String song="";
		
		if(evento.getSource()==bPlay) 
		
		{
			try
			{
				try
				{
					song=tfSong.getText();
					thrAudio = new Thread(new AudioOSFX(song));
					thrAudio.start();	
				}			
				catch(Exception JavaLayerException)
				{
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
			catch (Exception FileNotFoundException)
			{
				JOptionPane.showMessageDialog(null,"Cancion inexistente");
			}
		}
		
		if(evento.getSource()==bStop)
		{
			thrAudio.stop();
		}
		
	}
	
	public static void main(String[] args) throws Exception//FileNotFoundException,JavaLayerException 
	{
		AudioGUIFX audio = new AudioGUIFX();		
	}
}