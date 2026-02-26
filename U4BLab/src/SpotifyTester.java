import java.util.Scanner;

public class SpotifyTester
{
    public static final int SORT_ARTIST = 1;
    public static final int SORT_YEAR = 2;
    public static final int SEARCH_GENRE = 3;
    public static final int DISPLAY = 4;
    public static final int QUIT = 5;

    public static void main(String[] args)
    {
        Playlist p = new Playlist();
        p.readFile("spotify_unique_years_artists.txt");

        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != QUIT)
        {
            printMenu();

            try
            {
                choice = Integer.parseInt(input.nextLine());

                if (choice == SORT_ARTIST)
                {
                    p.sortByArtist();
                    System.out.println(p);
                }
                else if (choice == SORT_YEAR)
                {
                    p.sortByReleaseYear();
                    System.out.println(p);
                }
                else if (choice == SEARCH_GENRE)
                {
                    System.out.print("Enter genre: ");
                    String genre = input.nextLine();
                    p.searchByGenre(genre);
                }
                else if (choice == DISPLAY)
                {
                    System.out.println(p);
                }
                else if (choice == QUIT)
                {
                    System.out.println("Goodbye!");
                }
                else
                {
                    System.out.println("Invalid option. Please enter 1-5.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid input. Please enter a number 1-5.");
            }

            System.out.println();
        }

        input.close();
    }

    public static void printMenu()
    {
        System.out.println("----- Spotify Menu -----");
        System.out.println("1. Sort by Artist (A-Z)");
        System.out.println("2. Sort by Release Year (Old-New)");
        System.out.println("3. Search by Genre");
        System.out.println("4. Display Playlist");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
    }
}
