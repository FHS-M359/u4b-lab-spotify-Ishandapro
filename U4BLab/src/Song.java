//Aligns the text and integers correctly
public class Song
{
    private String title;
    private String artist;
    private String album;
    private int durationSeconds;
    private int releaseYear;
    private String genre;

    // Constructor
    public Song(String t, String ar, String al, int d, int y, String g)
    {
        title = t;
        artist = ar;
        album = al;
        durationSeconds = d;
        releaseYear = y;
        genre = g;
    }

    // Getters
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public int getDurationSeconds()
    {
        return durationSeconds;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public String getGenre()
    {
        return genre;
    }

    // toString Method
    public String toString()
    {
        return String.format("%-30s %-20s %-25s %-6d %-15s",
                title, artist, album, releaseYear, genre);
    }
}
