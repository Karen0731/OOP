import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioOSFX implements Runnable
{

	private     Player player;
	private String Song;
	
	public AudioOSFX(String song)
	{
		this.Song = song;	
	}
   	
   	public void run()
   	{
   		reproducir();	
   	}
   	
   	public void reproducir()
   {
	    try
	    {
	    	player = new Player(new FileInputStream(Song+".mp3"));
			player.play();
	    }
	    catch(JavaLayerException e)
	    {
   			System.out.println("Error: "+e);	    	
	    }
	    catch(FileNotFoundException e)
   		{
   			System.out.println("Error: "+e);
   		}
   }
   
   public void stop()
   {
   		player.close();
   }
}