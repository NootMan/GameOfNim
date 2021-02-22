import java.util.Scanner;

public class Player 
{
    //attributes
    private String name = "";
    private int losses = 0;
    
    //constructors
    public Player()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        losses = 0;
    }
    public Player(String inputName)
    {
        name = inputName;
        losses = 0;
    }

    //accessors
    public int getLosses()
    {
        return losses;
    }
    public String getName()
    {
        return name;
    }

    //mutators
    public void addLoss()
    {
        losses += 1;
    }
}