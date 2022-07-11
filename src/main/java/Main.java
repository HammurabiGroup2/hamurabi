import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int totalDeaths = 0, percentDied = 0, year = 0, population = 100, stores = 2800, immigrants = 0, deaths,
            harvest = 0, yeild = 3, eaten = harvest - stores, landPrice, fullPeople, temp,
            bushelsUsedAsSeed, negative;
    //            acres = harvest / yeild,
    static boolean plague = false;
    static int starveDeaths = 0; // added

    final static String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";
    Scanner scanner = new Scanner(System.in);


    //our starting value...
    static int populationDecrease = 0; //num population decreases by
    int years = 1;
    //    int population = 100;
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

    public static void main(String[] args) {
        Main newGame = new Main();
        newGame.playGame();
    }

    void playGame() {
        Main play = new Main();


        while (years <= 10) {
            printSummary();


//ask user how many acres to buy
            System.out.println("Enter 0 to sell acres");
            acresBought = askHowManyAcresToBuy(price, bushels);
            acres += acresBought; //keeping track of how many acres you have
            bushels -= acresBought * price; //how much bushels left...
            System.out.println("You have " + acres + " acres and " + bushels + " bushels left in storage.");
            System.out.println("1 acre/"+price+" bushels");

//ask user how many acres they want to sell
            if (acresBought == 0) {
                acresSold = askHowManyAcresToSell(acres);
                acres -= acresSold;
                bushels += (price * acresSold);
                System.out.println("You have " + acres + " acres and " + bushels + " bushels left in storage.");
            }

//ask how much grain to feed people
            grainsFed = askHowMuchGrainToFeedPeople(bushels);
            bushels -= grainsFed;
            System.out.println("You have " + bushels + " bushels remaining");
//            asks how many acres to plant
            play.askHowManyAcresToPlant(acres, population, bushels);

            play.plagueDeaths(population);
            play.starvationDeaths(population, grainsFed);
            play.uprising(population, starveDeaths);


            play.immigrants(population, acres, bushels);
            play.harvest(temp, temp);
//grains eaten by rats
            grainsEaten = grainEatenByRats(bushels);
            if (grainsEaten > 0) {
                System.out.println("***********************RATTATAS have appeared*************************\n" +
                        "***********************You LOST " + grainsEaten + " bushels!!*************************");

            }
            bushels -= grainsEaten;
            bushels-=bushelsUsedAsSeed;
            bushels+=harvest;


//new cost of land
            price = newCostOfLand();
            years++;
        }

        finalSummary();
    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }


    public int askHowManyAcresToBuy(int price, int bushels) {
        int acresBought = getNumber("How many Acres do you want to buy?");
        while (price * acresBought > bushels || price * acresBought < 0) {
            acresBought = getNumber("Total Cost is " + (price * acresBought) + " bushels, but you only have " + bushels + "!! \nHow many Acres can you AFFORD?");
        }
        return acresBought;
    }

    public int askHowManyAcresToSell(int acresOwned) {
        int acresSold = getNumber("How many acres do you want to sell?");
        while (acresSold > acresOwned || acresSold < 0) {
            acresSold = getNumber("You don't even own " + acresSold + " acres. \nHow many acres do you really want to sell?");
        }
        return acresSold;
    }

    int askHowMuchGrainToFeedPeople(int bushels) {
        int grainsFed = getNumber("How much grain do you want to feed your people? ");
        this.bushels=bushels;
        while (grainsFed > bushels || grainsFed < 0) {
            grainsFed = getNumber("Try again.");
        }
        fullPeople = grainsFed;
        return grainsFed;
    }


    int newCostOfLand() {
        int max = 23;
        int min = 17;
        int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random;
    }


    int grainEatenByRats(int bushels) {
        int grainsEaten = 0;
        if (Math.random() * 100 < 40) {
            grainsEaten = (int) (Math.floor(Math.random() * (30 - 10 + 1) + 10) * bushels) / 100;
        }
        return grainsEaten;
    }


    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        this.acres = acresOwned;
        this.population = population;
        this.bushels=bushels;

        System.out.println("You have " + this.acres + " acres of land, " + this.population + " people and " + bushels + " bushels");
        temp = getNumber("How many acres do you want to plant?\n");
        temp = 2*temp;

        this.negative = bushels-temp;
//        System.out.println(negative);

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
                    bushels + " bushels of grain. So, uh how much bushels should we plant?");
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


    int plagueDeaths(int population) {
        this.population = population;
        boolean isPlagueHappening = false;
        float chanceOfPlague = 15.0f;
        float generateChance = new Random().nextFloat() * 100;
        populationDecrease = 0; //num population decreases by
//        int numOfPlagues = 0;

        if (isPlagueHappening != true) {
            if (generateChance <= chanceOfPlague) {
                isPlagueHappening = true;
                populationDecrease = population / 2;
//                numOfPlagues++;
            } else {
                populationDecrease = 0;
            }
        }
        //test case passes, but does not return (population-population decrease)
        //as parameter in plagueDeath method when looping
        this.population = population - populationDecrease;
        isPlagueHappening = false;
        return populationDecrease;
    }

    int starvationDeaths(int population, int bushelsFedToPeople) {
//        fullPeople = bushelsFedToPeople;
        grainsFed = bushelsFedToPeople;
        double peopleThatGet20Bushels = (bushelsFedToPeople / 20); //TODO fix to more appropriate name for var
        int extraBushels = 0;
        starveDeaths = (int) (population - peopleThatGet20Bushels);
        DownesHammurabi.Moodlet happyEffect = DownesHammurabi.Moodlet.POSITIVE;
        DownesHammurabi.Moodlet upsetEffect = DownesHammurabi.Moodlet.NEGATIVE;
/*
         if starvation <0, that means there was an abundance of bushels
         after each person was distributed an amount of 20
         therefore store those extra in storage
*/
        if (starveDeaths < 0) {
            extraBushels = Math.abs(starveDeaths);
            starveDeaths = starveDeaths + extraBushels; //should equal out to 0
            System.out.println("The population feels: " +happyEffect);
        } else {
            System.out.println("The population feels: " +upsetEffect);
        }

        this.population = population - starveDeaths;
        return starveDeaths;
    }

    boolean uprising(int population, int totalPeopleStarved) {
        boolean upriseHappening = false;
        this.starveDeaths = totalPeopleStarved;
        float percentOfPopStarved = (float) totalPeopleStarved / population * 100;

        if (percentOfPopStarved > 45.00) {
            upriseHappening = true;
//            System.out.println("Terrible ruler, you will be fired!");
            System.out.println("You FOOL!!!!!!\n Step down thy throne.\n You starved " + starveDeaths +
                    " people in your final " + year + " year.\n You are not worthy.");
            System.exit(2);
        } else {
            upriseHappening = false;
//            System.out.println("You're doing a great job");
        }
        return upriseHappening;
    }


    public int immigrants(int population, int acresOwned, int grainInStorage) {
//        this.stores = grainInStorage;
        this.acres = acresOwned;
        this.population = population;
        if (starveDeaths > 0) {
            String messageFail = "We have no grain's in storage, no on arrived to the city.";
            System.out.println(messageFail);
        } else {
            this.immigrants = ((20 * acresOwned) + grainInStorage) / ((100 * population) + 1);
            this.population += immigrants;
            return this.immigrants;
        }
        return this.immigrants = 0;
    }

    public int harvest(int acres, int bushelsUsedAsSeed) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(6);
        randomNumber = yeild;
//        temp = acres;
//        temp = bushelsUsedAsSeed;

        harvest = acres * randomNumber;
        this.bushels -= bushelsUsedAsSeed;
        this.bushels += harvest;
        return harvest;
    }

    public void printSummary() {
        String hc = healthCare();
        System.out.println("---------------------------------------------------\n"+
                "---------------------------------------------------\n"+
                "Oh my King Hammurabi!!\n" +
                "You are in year " + years + " of your 10 year Dynasty.\n" +
                "The Kingdom owns " + acres + " acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.\n" +
                "In your previous year, " + starveDeaths + " starved to death. X.X\n" +
                "In your previous year, " + immigrants + " entered your Kingdom.\n" +
                hc + "The population is now " + population + ".\n" +
                "We harvested " + harvest + " bushels of grain\n" +
                "O, King, rats have destroyed " + grainsEaten + " bushels\n" +
                "We only have " + this.bushels + " bushels left in the storage\n" +
                "--------------------------------------------------------------------\n" +
                "--------------------------------------------------------------------\n");
    }

    public String healthCare() {
        if (populationDecrease>0) {
//            System.out.println("*cough cough* Sire! We lost " + populationDecrease +
//                    " to the plague.\n" + "Where is our free healthcare?!\n");

            return "*cough cough* Sire! We lost " + populationDecrease +
                    " to the plague.\n" + "Where is our free healthcare?!\n";
        }
        return "";
    }


    void finalSummary() {
        if (population>=90) {
            System.out.println("Starved Deaths: " + starveDeaths +
                    "\nAcres per Person: " +(acres*population) +
                    "\nCONGRATULATIONS, please become ruler again!");
        }
        else if(population>=50 && population<=89) {
            System.out.println("Starved Deaths: " + starveDeaths +
                    "Acres per Person: " + (acres*population) +
                    "You did well, but could've done better.");
        }
        else if(population<50) {
            System.out.println("Starved Deaths: " + starveDeaths +
                    "Acres per Person: " + (acres*population) +
                    "Welp...you survived. Can't say the same for the population though.");

        }
    }


}

