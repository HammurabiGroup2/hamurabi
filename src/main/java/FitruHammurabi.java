import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FitruHammurabi {

    static int totalDeaths = 0, percentDied = 0, year = 0, population = 150, stores = 250, immigrants = 5, deaths, farmingLand = 0,
             harvest, yeild = 3, acres = 1000, landPrice, fullPeople, temp, bushelsUsedAsSeed, negative;
    static boolean plague = false;
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();  // this is an instance variable

    public static void main(String[] args) { // required in every Java program
        new FitruHammurabi().playGame();

        FitruHammurabi x = new FitruHammurabi();

        int i = 0;
        while(i<5) {
            x.askHowManyAcresToPlant(acres, population, stores);
            x.harvest(acres, bushelsUsedAsSeed);
//            System.out.println(x.harvest(acres, bushelsUsedAsSeed));
            i++;
        }





    }



    void playGame() {



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

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        stores = grainInStorage;
        acres = acresOwned;
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
        int randomNumber = rand.nextInt(6 - 1 + 1) + 1;
        System.out.println(randomNumber);
        this.acres = acres;
        temp=bushelsUsedAsSeed;

        this.stores-=bushelsUsedAsSeed;
        harvest = bushelsUsedAsSeed * randomNumber;
        this.stores+=harvest;

        return harvest;
    }

    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        this.acres = acresOwned;
        this.population = population;

        System.out.println("You have " + this.acres + " acres of land, " + this.population + " people and " + this.stores + " bushels");
        temp = getNumber("How many acres do you want to plant?\n");

        this.negative = bushels-temp;
        System.out.println(negative);

        fullPeople = temp / 20;
        this.bushelsUsedAsSeed = temp;
        while (temp < 0) {
            temp = getNumber("Sire, I don't know what that is. Please how much bushels should we plant?");
        }
        while (temp > acres) {
            temp = getNumber("Sire, please check again. You only have " + acres + " acres. So, how much bushels should we plant.");
                    }

        while (this.negative<0) {
            temp = getNumber("Ok, wow, sire, maybe we should get you better glasses. You only have\n" +
                    stores + " bushels of grain. So, uh how much bushels should we plant?");
            negative = bushels-temp;
            System.out.println(negative);
        }

        while (temp > population * 10) {
            if (temp > population * 10) {
                temp = getNumber("Sire, please read the report. We only have " + population + " people to tend the fields. \n" +
                        "I know you get cranky in the morning, but this is a serious matter. How much bushels should we plant?");
            }
        }
        return temp;
    }








}







