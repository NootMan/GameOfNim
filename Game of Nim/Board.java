import java.util.Random;

public class Board 
{
    private static int numPieces;

    public static void generateBoard()
    {
        Random random = new Random();
        numPieces = random.nextInt(41) + 10; //value between 0(inclusive) and 41(exclusive), then add 10 to be a number between 10 and 50 inclusive
    }

    //accessors
    public static int getNumPieces()
    {
        return numPieces;
    }

    //mutators
    public static void removePieces(int pieces)
    {
        numPieces -= pieces;
    }
}
