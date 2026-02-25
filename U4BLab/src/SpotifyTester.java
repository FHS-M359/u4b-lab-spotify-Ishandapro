public class SpotifyTester {
  public static void main(String[] args)
  {
    Playlist p = new Playlist();
    p.readFile("spotify_unique_years_artists.txt");
    System.out.println(p);
  }
}
