package hammurabi;               // package declaration
import java.util.InputMismatchException;
import java.util.Random;         // imports go here
import java.util.Scanner;

public class NickHammurabi {
    // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new NickHammurabi().playGame();
    }

    void playGame() {
        //our starting value...
        int years =1;
        int population = 100;
        int bushels = 2800; //bushels in storage..
        int acres = 1000;
        int price = 19;    //price is in bushels/acre


        // declare local variables here: grain, population, etc.
        // statements go after the declations
        int acresBought;
        int acresSold;
        int grainsFed;
        int acresOwned;
        int grainsEaten;


        while(years <= 10){
//            printSummary();


//ask user how many acres to buy

            acresBought = askHowManyAcresToBuy(price,bushels);
            acres += acresBought; //keeping track of how many acres you have
            bushels -= acresBought*price; //how much bushels left...
            System.out.println("You have "+acres+ " acres and "+ bushels + " bushels left in storage.");
            System.out.println(price);

//ask user how many acres they want to sell

            if(acresBought == 0){
                acresSold = askHowManyAcresToSell(acres);
                acres -= acresSold;
                bushels += (price* acresSold);
                System.out.println("You have "+acres+ " acres and "+ bushels + " bushels left in storage.");
            }

//ask how much grain to feed people
            grainsFed = askHowMuchGrainToFeedPeople(bushels);
            bushels -=grainsFed;
            System.out.println("You have "+ bushels + " remaining");

//grains eaten by rats
            grainsEaten = grainEatenByRats(bushels);
            if(grainsEaten>0){
                System.out.println("***********************RATTATAS have appeared*************************\n" +
                        "***********************You LOST " + grainsEaten + " bushels!!*************************");

            }
            bushels -= grainsEaten;


//new cost of land
            price = newCostOfLand();

        }

    }


    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }


    public int askHowManyAcresToBuy(int price, int bushels){
        int acresBought = getNumber("How many Acres do you want to buy?");
        while(price * acresBought> bushels || price* acresBought <0) {
            acresBought = getNumber("Total Cost is " + (price * acresBought)+ " bushels, but you only have "+bushels+"!! \nHow many Acres can you AFFORD?");
        }
        return acresBought;
    }

    public int askHowManyAcresToSell(int acresOwned){
        int acresSold = getNumber("How many acres do you want to sell?");
        while (acresSold > acresOwned || acresSold <0){
            acresSold = getNumber("You don't even own "+ acresSold + " acres. \nHow many acres do you really want to sell?");
        }
        return acresSold;
    }

    int askHowMuchGrainToFeedPeople(int bushels){
        int grainsFed = getNumber("How much grain do you want to feed your people? ");
        while(grainsFed>bushels){
            grainsFed = getNumber("Not Enough!! You only have "+bushels + " grains left to feed your people!!");
        }
        return grainsFed;
    }

    public int newCostOfLand(){
        int max=23;
        int min=17;
        int random = (int) Math.floor(Math.random()*(max-min +1)+min);
        return random;
    }

    public int grainEatenByRats(int bushels) {
        int grainsEaten = 0;
        if (Math.random() * 100 < 40) {
            grainsEaten = (int) (Math.floor(Math.random() * (30 - 10 + 1) + 10) * bushels) / 100;
        }
        return grainsEaten;
    }





//    public void printSummary() {
//        System.out.println("Oh my King Hammurabi!!\n" +
//                "You are in year " + years + " of your 10 year Dynasty.\n" +
//                "The Kingdom owns " + acres + " acres of land.\n" +
//                "Land is currently worth " + price + " bushels per acre.\n" +
//                "In your previous year, " + death + " starved to death. X.X\n" +
//                "In your previous year, " + immigrants + "entered your Kingdom.\n" +
//                "The population is now " + population + ".\n" +
//                "We harvested " + harvest + " bushels of grain\n" +
//                "O, King, rats have destroyed " + grainEaten + " bushels\n" +
//                "We only have " + bushel + " bushels left in the storage");
//    }
//
//    public void finalSummary(){
//        if(starved > 45*population /100){
//            System.out.println("You FOOL!!!!!!\n Step down thy throne.\n You starved " + starved + " people in your final year.\n You are not worthy.");
//        }
//    }







    //other methods go here

}
