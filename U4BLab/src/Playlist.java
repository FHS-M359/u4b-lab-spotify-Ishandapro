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

    // The .toString method
    public String toString()
    {
        String result = "";

        result += String.format("%-30s %-20s %-30s %-6s %-15s%n",
                "Title", "Artist", "Album", "Year", "Genre");
        result += "-----------------------------------------------------------------------------------------------\n";

        for (int i = 0; i < songs.size(); i++)
        {
            Song s = songs.get(i);
            result += String.format("%-30s %-20s %-30s %-6d %-15s%n",
                    s.getTitle(), s.getArtist(), s.getAlbum(), s.getReleaseYear(), s.getGenre());
        }

        return result;
    }

    // Linear Search by genre method
    public void searchByGenre(String genre)
    {
        boolean found = false;

        for (int i = 0; i < songs.size(); i++)
        {
            if (songs.get(i).getGenre().equalsIgnoreCase(genre))
            {
                System.out.println(songs.get(i));
                found = true;
            }
        }

        if (!found)
        {
            System.out.println("No songs found in that genre.");
        }
    }

    // Selection Sort by artist (A-Z)
    public void sortByArtist()
    {
        for (int i = 0; i < songs.size() - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < songs.size(); j++)
            {
                if (songs.get(j).getArtist().compareToIgnoreCase(
                        songs.get(minIndex).getArtist()) < 0)
                {
                    minIndex = j;
                }
            }

            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }

        // DISPLAY ONLY ARTISTS
        for (int i = 0; i < songs.size(); i++)
        {
            System.out.println(songs.get(i).getArtist());
        }
    }

    // Insertion Sort by release year (old to new)
    public void sortByReleaseYear()
    {
        for (int i = 1; i < songs.size(); i++)
        {
            Song key = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() > key.getReleaseYear())
            {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, key);
        }
    }
}
