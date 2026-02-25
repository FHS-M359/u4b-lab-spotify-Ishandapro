import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Playlist
{
    private ArrayList<Song> songs;

    // Constructor
    public Playlist()
    {
        songs = new ArrayList<Song>();
    }

    // The read file method for the txt file
    public void readFile(String filename)
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(filename));

            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                String title = parts[0];
                String artist = parts[1];
                String album = parts[2];
                int duration = Integer.parseInt(parts[3]);
                int year = Integer.parseInt(parts[4]);
                String genre = parts[5];

                Song newSong = new Song(title, artist, album, duration, year, genre);
                songs.add(newSong);
            }

            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }

    // The .toString method for splitting
    public String toString()
    {
        String result = "";

        result += "Title | Artist | Album | Year | Genre\n";
        result += "-------------------------------------------------------------\n";

        for (int i = 0; i < songs.size(); i++)
        {
            result += songs.get(i).getTitle() + " | ";
            result += songs.get(i).getArtist() + " | ";
            result += songs.get(i).getAlbum() + " | ";
            result += songs.get(i).getReleaseYear() + " | ";
            result += songs.get(i).getGenre() + "\n";
        }

        return result;
    }
}
