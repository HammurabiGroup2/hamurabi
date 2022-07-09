import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FitruHammurabi {

    private int population;
    private int acresOwned;
    private int grainInStorage;
    private int bushels;
    private int bushelsUsedAsSeed;
    private int immigrants;
    private int farmingLand;

    // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new FitruHammurabi().playGame();

        FitruHammurabi x = new FitruHammurabi();
//        x.harvest(100, 0);
        x.askHowManyAcresToPlant(x.acresOwned, x.population, x.bushels);

//       int z = ((20 * x.acresOwned) + x.grainInStorage) / ((100 * x.population) + 1);
//       System.out.println(z);


    }


    void playGame() {

         int population = 100;
         int acresOwned = 1000;
         int bushels = 0;
         int bushelsUsedAsSeed = 0;
         int immigrants = 0;
         int farmingLand = 0;


        FitruHammurabi x = new FitruHammurabi();

//        x.harvest(acresOwned, bushelsUsedAsSeed);
//        x.immigrants(population, acresOwned, grainInStorage);
        x.askHowManyAcresToPlant(acresOwned, population, bushels);




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
        this.bushelsUsedAsSeed = bushelsUsedAsSeed;
        return this.bushelsUsedAsSeed;
    }


    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        this.acresOwned = acresOwned;
        this.population = population;
        this.bushels = bushels;
        Scanner input = new Scanner(System.in);
        System.out.print("How many acres do you want to plant with your grain's?");
        int inputMessage = input.nextInt();
        System.out.println(inputMessage + " acres planted");
        if(this.bushels !=0 && this.population !=0 && this.acresOwned > inputMessage ) {
            this.acresOwned = acresOwned - inputMessage;
            this.bushels-=inputMessage;
            this.farmingLand += inputMessage ;
            return farmingLand;
        } else if (this.bushels == 0) {
            System.out.println("Sire, the amount of bushels we have is not enough for farming.");
        } else if (this.population == 0) {
            System.out.println("Uhhh, no, we don't have anyone to farm the land.");
        } else if (this.acresOwned<inputMessage)
        {System.out.println("Wow, I think we need to fire your math tutor. We don't have enough land to farm");}

        if(this.farmingLand<this.population * 10) {
            System.out.println("Sire, we don't have the man power to farming that much land. Please look over your report.");
        } else {
            this.farmingLand += inputMessage ;
        }

//        int neededAmount = 20 * population;
//        int currentBushels = bushels - neededAmount;
//        int currentPerPerson = currentBushels/this.population;
//
//        if(this.acresOwned != 0) {
//            int amountOfBushels;
//            amountOfBushels = 2 * acresOwned;
//        }
//        } else if (this.bushelsUsedAsSeed < this.bushels * this.population) {
//            System.out.println("Sire, we dont have enough food to feed the people");
//        } else if (this.population != 0){
//            this.farmingLand = this.population * 10;
//        } else if(this.bushels == 0) {
//            boolean bushelsCheckTrue = true;
//            while(bushelsCheckTrue) {
//                System.out.println("Are you mad sire, you have " + this.bushels + "." + " Now Then,");
//
//                bushelsCheckTrue = false;
//            }
//        } else if (currentPerPerson<neededAmount) {
//            System.out.println("Sire, as your advisor I think that is a follish idea \n " +
//                    "You do not have enough grain to plant, we only have: \n" + this.grainInStorage);
//        } else if(this.acresOwned < this.farmingLand) {
//            System.out.println("Uhhh, no, we do not have enough land to farm \n" +
//                    "We only have:" + this.acresOwned);
//        }



        return inputMessage;




    }

    /*

        20 bushels per person = neededAmount
        storage bushels - needed bushels = currentBushels
        current/population = currentPerPerson
        if(bushels == 0){
        System.out.print("Are you mad sire, you have + storageBushels + now then)
        } else if (currentPerPerson < neededAmount) {
        System.out.print("Sire, as your advisor I think that is a follish idea. \n
        You do not have enough grain to plant, we only have : + storageBushels )
        }


        if(population is not equal to 0) {
        population * per person = farming acres
        } else if(current land < farm land) {
        System.out.println(Sire, please, we do not have enough land to farm, we only have: + current land)
        }

        if(current land != 0) {
        bushelsFarm * current land = amount of bushels
        } else if (amount of bushels < bushels * population) {
        System.out.println(Sire, we dont have enough food to feed the people)
        }

        if(population == 0) {
        System.out.println(Oh great incompetent ruler, your kingdom has no more people.)
        Final Summary game over
        }




         */

}





//other methods go here


