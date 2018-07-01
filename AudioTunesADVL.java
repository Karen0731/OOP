import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class AudioTunesADVL {
	
	private BufferedReader archivoIn;
	private Vector vectorArtistas, vectorAlbums, vectorSongs;
		
    public Vector ObtenerArtistas(){
    	
		String artistas="",str;
		
		try
		{
		//Abrir el archivo de datos
		archivoIn = new BufferedReader(new FileReader("Artistas.txt"));
		
		//Leer todos los datos del archivo
		vectorArtistas = new Vector();
		
		while(archivoIn.ready())
		{
			str = archivoIn.readLine();
			
			//artistas = artistas + str + "\n";
			vectorArtistas.add(str);

		}
		//Cerrar el archivo 
		archivoIn.close();
	
		}catch(FileNotFoundException e)
		{
		System.out.println("Error: "+ e);
		}catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		
		return vectorArtistas;
	}
	
	public Vector ObtenerAlbums(String artista)
	{
		String str, albums="", grupo, album;
		StringTokenizer st;
		
		try
		{
			//Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Albums.txt"));
			//Leer los datos del artista 
			
			vectorAlbums = new Vector();
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				grupo = st.nextToken();
				album = st.nextToken();
				
				
				System.out.println(grupo);
				
				if(artista.equals(grupo))
				{
					//albums = albums + album + "\n";
					vectorAlbums.add(album);
				}
			}
			//Cerra el archivo
			archivoIn.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: "+ e);
		}
		catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		return vectorAlbums;
	}
	
	public Vector ObtenerCancion(String albumElegido)
	{
		String str, songs="", album, song;
		StringTokenizer st;
		
		try
		{
			//Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Songs.txt"));
			//Leer los datos del artista 
			
			vectorSongs = new Vector();
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				album = st.nextToken();
				song = st.nextToken();
				
				
				System.out.println(song);
				
				if(albumElegido.equals(album))
				{
					//albums = albums + album + "\n";
					vectorSongs.add(song);
				}
			}
			//Cerra el archivo
			archivoIn.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: "+ e);
		}
		catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		return vectorSongs;
	}
  
}