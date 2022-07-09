import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FitruHammurabi {

   private int population = 100;
    private int acresOwned = 1500;
    private int grainInStorage = 1000;
    private int acres;
    private int bushelsUsedAsSeed;
    private int immigrants = 0;

    // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new FitruHammurabi().playGame();

        FitruHammurabi x = new FitruHammurabi();
        x.immigrants(x.population, x.acresOwned, x.grainInStorage);

       int z = ((20 * x.acresOwned) + x.grainInStorage) / ((100 * x.population) + 1);
       System.out.println(z);


    }


    void playGame() {




        // declare local variables here: grain, population, etc.
        // statements go after the declations
    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        if (grainInStorage == 0) {
            String messageFail = "We have no grain's in storage, no on arrived to the city.";
            System.out.println(messageFail);

        } else {
            immigrants = ((20 * acresOwned) + grainInStorage) / ((100 * population) + 1);
            return this.immigrants;
        }
        return this.immigrants = 0;
    }

    public int harvest(int acres, int bushelsUsedAsSeed) {
        int randomNumber = rand.nextInt(6); if(randomNumber==0){
            randomNumber = 1;
        }
        bushelsUsedAsSeed = acres * randomNumber;
        return bushelsUsedAsSeed;
    }


    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many acres do you want to plant with grain?");
        int inputMessage = input.nextInt();
        System.out.println(inputMessage + " acres planted");
        if(bushels < 200 || population < 100) {
            System.out.print("Not enough bushels for the population");
        }
        
        return inputMessage;
    };

}





//other methods go here


