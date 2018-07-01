import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.peer.PanelPeer;
import java.util.concurrent.BrokenBarrierException;
import java.util.Vector;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AudioTunesGUIVLWAV extends JFrame implements ActionListener,ListSelectionListener{

	private JPanel 	panelUser, panelArtists, panelAlbums, panelSongs, panelAudio,
					panelMain;
	private JButton bCatalog, bArtist, bAlbums, bSongs,
					bPlay, bStop;
	private JTextField tfArtist, tfAlbum, tfSong;
	private JTextArea taArtists, taAlbums, taSongs;
	//AudioOS audio = new AudioOS();
	private AudioTunesADVL audioAD = new AudioTunesADVL();
	
	private Vector vectorArtistas, vectorAlbums, vectorSongs;
	private JList listaArtistas, listaAlbums, listaSongs;
	
	private File fileSong;
	private AudioInputStream audioStream;
	private Clip clip;
	
	public AudioTunesGUIVLWAV(){
		
		// Define objects
		tfArtist = new JTextField(10);
		tfAlbum = new JTextField(10);
		tfSong = new JTextField(10);
		
		bCatalog = new JButton("Catalog");
		bArtist = new JButton("Artist");
		bAlbums = new JButton("Albums");
		bSongs = new JButton("Songs");
		bPlay = new JButton("Play");
		bStop = new JButton("Stop");
		
		taArtists = new JTextArea("Artists", 15, 10);
		taAlbums = new JTextArea("Albums");
		taSongs = new JTextArea("Songs", 15, 10);
		
		panelUser = new JPanel();
		panelArtists = new JPanel();
		panelAlbums = new JPanel();
		panelSongs = new JPanel();
		panelAudio = new JPanel();
		panelMain = new JPanel();
		
		// Define button actions
		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		bAlbums.addActionListener(this);
		bSongs.addActionListener(this);
		bArtist.addActionListener(this);
		bCatalog.addActionListener(this);
		
		// Define panel layouts
		panelUser.setLayout(new FlowLayout());
		panelArtists.setLayout(new GridLayout(1, 1));
		panelAlbums.setLayout(new GridLayout(1,1));
		panelSongs.setLayout(new GridLayout(1,1));
		panelAudio.setLayout(new FlowLayout());
		panelMain.setLayout(new BorderLayout());
		
		// Place attributes from objects in their respective panels
		panelUser.add(bCatalog);
		panelUser.add(new JLabel("Artista: "));
		panelUser.add(tfArtist);
		panelUser.add(bAlbums);
		panelUser.add(tfAlbum);
		panelUser.add(bSongs);
		
		panelArtists.add(new JScrollPane(taArtists));
		panelAlbums.add(new JScrollPane(taAlbums));
		panelSongs.add(new JScrollPane(taSongs));
		
		panelAudio.add(new JLabel("Song: "));
		panelAudio.add(tfSong);
		panelAudio.add(bPlay);
		panelAudio.add(bStop);
		
		panelMain.add(panelUser, BorderLayout.NORTH);
		panelMain.add(panelArtists, BorderLayout.WEST);
		panelMain.add(panelAlbums, BorderLayout.CENTER);
		panelMain.add(panelSongs, BorderLayout.EAST);
		panelMain.add(panelAudio, BorderLayout.SOUTH);
		
		// Add the main panel to JFrame
		add(panelMain);
		
		setSize(800, 400);
		setTitle("Audio Tunes Tec WAV");
		setVisible(true);
	
	}
	
	private void reproducir()throws Exception
	{
			String song;
			
			//Obtener el nombre de la cancion a reproducir
			song = tfSong.getText();
			
			//Relacionar el nombre de la cancion con un archivo (File) wav
			fileSong = new File(song + ".wav");
			
			//Preparar el audio stirng del archivo de la cancion
			audioStream = AudioSystem.getAudioInputStream(fileSong);
			
			//Reproducir la cancion 
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		String song,respuesta;
		String artistas="",artista,album,cancion;
		
		if(e.getSource() == bCatalog)
		{
			//Obtener artistas del archivo
			vectorArtistas = audioAD.ObtenerArtistas();
			
			//Desplegar los datos en el panel de artistas
			//taArtists.setText(artista);
			
			//Crear un JList del vectorArtistas
			listaArtistas = new JList(vectorArtistas);
			listaArtistas.addListSelectionListener(this);
			
			//Desplegar el JList en el panel Artistas
			panelArtists.setVisible(false);
			panelArtists.removeAll();
			panelArtists.add(listaArtistas);
			panelArtists.setVisible(true);
		}
		
		if(e.getSource() == bPlay)
		{
			try{
				reproducir();
			}
			catch(Exception ex){
			}			
		}
		
		if(e.getSource() == bStop)
		{
			clip.stop();
		}
		
		if(e.getSource()==bAlbums)
		{
			//Leer el artista del tfArtista
			artista = tfArtist.getText();
			
			//Obtener los albums del artista
			//album = audioAD.ObtenerAlbums(artista);
			vectorAlbums = audioAD.ObtenerAlbums(artista);
			
			//Desplegar los albums en el panel correspondiente
			//taAlbums.setText(album);
			
			//Crear un JList del vectorAlbums
			listaAlbums = new JList(vectorAlbums);
			listaAlbums.addListSelectionListener(this);
			
			//Desplegar el JList en el panel Artistas
			panelAlbums.setVisible(false);
			panelAlbums.removeAll();
			panelAlbums.add(listaAlbums);
			panelAlbums.setVisible(true);
		}
		
		if(e.getSource()==bSongs)
		{
			//Leer el artista del tfArtista
			album = tfAlbum.getText();
			
			//Obtener los albums del artista
			//album = audioAD.ObtenerAlbums(artista);
			vectorSongs = audioAD.ObtenerCancion(album);
			
			//Desplegar los albums en el panel correspondiente
			//taAlbums.setText(album);
			
			//Crear un JList del vectorAlbums
			listaSongs = new JList(vectorSongs);
			listaSongs.addListSelectionListener(this);
			
			//Desplegar el JList en el panel Artistas
			panelSongs.setVisible(false);
			panelSongs.removeAll();
			panelSongs.add(listaSongs);
			panelSongs.setVisible(true);
		}

	}
	
	public void valueChanged(ListSelectionEvent ls)
	{
		String artistaElegido,albumElegido,cancionElegida;
		
		if(ls.getValueIsAdjusting()==true)
		{
			if(ls.getSource()==listaArtistas)
			{
			artistaElegido = (String)listaArtistas.getSelectedValue();
			tfArtist.setText(artistaElegido);
			System.out.println(artistaElegido);
			
			//Leer el artista del tfArtista
			artistaElegido = tfArtist.getText();
			
			//Obtener los albums del artista
			//album = audioAD.ObtenerAlbums(artista);
			vectorAlbums = audioAD.ObtenerAlbums(artistaElegido);
			
			//Desplegar los albums en el panel correspondiente
			//taAlbums.setText(album);
			
			//Crear un JList del vectorAlbums
			listaAlbums = new JList(vectorAlbums);
			listaAlbums.addListSelectionListener(this);
			
			//Desplegar el JList en el panel Artistas
			panelAlbums.setVisible(false);
			panelAlbums.removeAll();
			panelAlbums.add(listaAlbums);
			panelAlbums.setVisible(true);//Desplegar los albums en el panel correspondiente
			//taAlbums.setText(album);
			
			//Crear un JList del vectorAlbums
			listaAlbums = new JList(vectorAlbums);
			listaAlbums.addListSelectionListener(this);
			
			//Desplegar el JList en el panel Artistas
			panelAlbums.setVisible(false);
			panelAlbums.removeAll();
			panelAlbums.add(listaAlbums);
			panelAlbums.setVisible(true);
			
			}
			
			if(ls.getSource()==listaAlbums)
			{
			albumElegido = (String)listaAlbums.getSelectedValue();
			tfAlbum.setText(albumElegido);
			System.out.println(albumElegido);
		
			//Leer el artista del tfArtista
			albumElegido = tfAlbum.getText();
			
			//Obtener los albums del artista
			//album = audioAD.ObtenerAlbums(artista);
			vectorSongs = audioAD.ObtenerCancion(albumElegido);
			
			//Desplegar los albums en el panel correspondiente
			//taAlbums.setText(album);
			
			//Crear un JList del vectorAlbums
			listaSongs = new JList(vectorSongs);
			listaSongs.addListSelectionListener(this);
			
			//Desplegar el JList en el panel Artistas
			panelSongs.setVisible(false);
			panelSongs.removeAll();
			panelSongs.add(listaSongs);
			panelSongs.setVisible(true);
			}
			
			if(ls.getSource()==listaSongs)
			{
				cancionElegida = (String)listaSongs.getSelectedValue();
				tfSong.setText(cancionElegida);
			}
		}	
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new AudioTunesGUIVLWAV();
	}

}
