import java.util.Random;
import java.util.Scanner;

public class Game
{
    private Player player1;
    private Player player2;

    //constructor
    public Game()
    {
        player1 = new Player();
        player2 = new Player();
    }

    public void play()
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int currentPlayer = rand.nextInt(2) + 1;    //either 1 or 2
        boolean playAgain = true;

        //Playing
        while(playAgain)
        {
            Board.generateBoard();  //generates amount of Pieces, got moved here to make replaying easier
            while(Board.getNumPieces() != 1)
            {
                System.out.println("There are " + Board.getNumPieces() + " pieces on the board.");
                if(currentPlayer == 1)
                {
                    System.out.println("It is " + player1.getName() + "'s turn. ");
                }
                else if(currentPlayer == 2)
                {
                    System.out.println("It is " + player2.getName() + "'s turn. ");
                }

                System.out.print("How many would you like to take? ");
                int takeAmount = sc.nextInt();
                //doesn't invalidate a turn if they input incorrectly, just asks them to input it again
                while(takeAmount > Board.getNumPieces()/2)
                {
                    System.out.println("Please take up to half the available pieces.");
                    System.out.print("How many would you like to take? ");
                    takeAmount = sc.nextInt();
                }
                Board.removePieces(takeAmount);
                if(currentPlayer == 1)
                {
                    currentPlayer = 2;
                }
                else if(currentPlayer == 2)
                {
                    currentPlayer = 1;
                }
            }

            //End of Round Display
            if(currentPlayer == 1)
            {
                System.out.println(player1.getName() + " LOST! BIG L!");
                player1.addLoss();
            }
            else if(currentPlayer == 2)
            {
                System.out.println(player2.getName() + " LOST! BIG L!");
                player2.addLoss();
            }

            System.out.print("Would you like to play again? Answer in a boolean: ");
            playAgain = sc.nextBoolean();   //I wanted to use nextLine with an if statement, but nextLine just wouldn't work. nextBoolean does tho, so I'm just gonna stick with this
        }
        
        //End of Game Display
        System.out.println("\n" + player1.getName() + " lost " + player1.getLosses() + " time(s).");
        System.out.println(player2.getName() + " lost " + player2.getLosses() + " time(s).");
    }
}