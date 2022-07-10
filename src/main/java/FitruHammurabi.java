import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FitruHammurabi {

    static int totalDeaths = 0, percentDied = 0, year = 0, population = 95, stores = 2800, immigrants = 5, deaths, farmingLand = 0,
            harvest = 3000, yeild = 3, acres = harvest / yeild, eaten = harvest - stores, landPrice, fullPeople, temp, bushelsUsedAsSeed;
    static boolean plague = false;
    final static String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";
    Scanner input = new Scanner(System.in);


    Random rand = new Random();  // this is an instance variable

    public static void main(String[] args) { // required in every Java program
        new FitruHammurabi().playGame();

        FitruHammurabi x = new FitruHammurabi();

        int i = 0;
        while(i<5) {
            x.askHowManyAcresToPlant(x.acres, x.population, x.harvest);
            x.harvest(x.acres, x.bushelsUsedAsSeed);
            x.immigrants(x.population, x.acres, x.stores);
            i++;
        }




    }



    void playGame() {

        FitruHammurabi x = new FitruHammurabi();




    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        this.stores = grainInStorage;
        this.acres = acresOwned;
        this.population = population;
        if (grainInStorage == 0) {
            String messageFail = "We have no grain's in storage, no on arrived to the city.";
            System.out.println(messageFail);
        } else {
            this.immigrants = ((20 * acresOwned) + grainInStorage) / ((100 * population) + 1);
            this.population+=immigrants;
            return this.immigrants;
        }
        return this.immigrants = 0;
    }

    public int harvest(int acres, int bushelsUsedAsSeed) {
        int randomNumber = rand.nextInt(6);
        randomNumber = yeild;
        this.acres = acres;
        this.bushelsUsedAsSeed=bushelsUsedAsSeed;

        harvest = acres * randomNumber;
        this.stores-=bushelsUsedAsSeed;

        return this.harvest;
    }


    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        this.acres = acresOwned;
        this.population = population;
        this.stores = bushels;

        System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
        temp = input.nextInt();

        fullPeople = temp / 20;
        this.bushelsUsedAsSeed = temp;
        do {
//            System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
//            temp = input.nextInt();
            if (temp < 0)
                epicFail(0);
            if (temp > acres)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
            if (temp / 2 > stores)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        stores + " BUSHELS OF GRAIN. NOW THEN,");
            if (temp > population * 10)
                System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");
        } while (temp > acres || temp / 2 > stores || temp > population * 10);


        return temp;
    }




    private static void epicFail(int x) {
        String reason = "";
        switch (x) {
            case 0: reason = "HAMURABI:  I CANNOT DO WHAT YOU WISH.\n" +
                    "GET YOURSELF ANOTHER STEWARD!!!!!"; break;
            case 1: reason = "YOU STARVED " + deaths + " PEOPLE IN ONE YEAR!!!\n" +
                    FINK; break;
        }
        System.out.println(reason);
        System.exit(0);
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


