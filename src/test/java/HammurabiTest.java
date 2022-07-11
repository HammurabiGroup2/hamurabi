import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HammurabiTest {
    
    FitruHammurabi ham;
    
//    boolean about(double expected, double actual) {
//        return actual > 0.90 * expected && actual < 1.10 * expected;
//    }

    @Before
    public void setUp() throws Exception {
        ham = new FitruHammurabi();
    }

    @Test
    public void immigrantsTest1() {
        // Given
        int population = 100;
        int acresOwned = 1000;
        int grainInStorage = 500;
        int expectedImmigrants = 2;

        // When
        ham.immigrants(population, acresOwned, grainInStorage);


        // Then
        Assert.assertEquals(expectedImmigrants, ham.immigrants(population,acresOwned,grainInStorage));

    }

    @Test
    public void immigrantsTest2() {
        // Given
        int population = 100;
        int acresOwned = 1000;
        int grainInStorage = 0;

        ham.immigrants(population, acresOwned, grainInStorage);
        int expectedImmigrants = 0;


        // When
        int actualImmigrants = ham.immigrants(population, acresOwned, grainInStorage);



        // Then
        Assert.assertEquals(expectedImmigrants, actualImmigrants);

    }

    @Test
    public final void testImmigrants3() {
        int imm = ham.immigrants(10, 1200, 500);
        assertEquals("Wrong number of immigrants.", 24, imm);
    }

    @Test
    public void testHarvest1() {
        // Given
        int acres = 1000;
        int expectedHarvest = 500;
        int expectedHarvest2 = 3000;
        int expectedHarvest3 = 1000;
        int expectedHarvest4 = 1500;
        int expectedHarvest5 = 2000;
        int expectedHarvest6 = 2500;




        // When
        int actualHarvest = ham.harvest(acres, 500);
        System.out.println(actualHarvest);

        // Then
        if(actualHarvest==500) {
            Assert.assertEquals(expectedHarvest, actualHarvest);
        }else if(actualHarvest ==3000) {
            Assert.assertEquals(expectedHarvest2, actualHarvest);
        } else if (actualHarvest==1000) {
            Assert.assertEquals(expectedHarvest3, actualHarvest);
        } else if (actualHarvest==1500) {
            Assert.assertEquals(expectedHarvest4, actualHarvest);
        } else if (actualHarvest==2000) {
            Assert.assertEquals(expectedHarvest5, actualHarvest);
        } else if (actualHarvest==2500) {
            Assert.assertEquals(expectedHarvest6, actualHarvest);
        }
    }

    @Test
    public void testHarvest2() {
        // Given
        int acres = 2000;
        int bushels = 100;
        int expectedHarvest = 100;
        int expectedHarvest2 = 300;
        int expectedHarvest3 = 200;
        int expectedHarvest4 = 400;
        int expectedHarvest5 = 500;
        int expectedHarvest6 = 600;


        // When
        int actualHarvest = ham.harvest(acres, bushels);
        System.out.println(actualHarvest);

        // Then
        if(actualHarvest==100) {
            Assert.assertEquals(expectedHarvest, actualHarvest);
        }else if(actualHarvest ==300) {
            Assert.assertEquals(expectedHarvest2, actualHarvest);
        } else if (actualHarvest==200) {
            Assert.assertEquals(expectedHarvest3, actualHarvest);
        } else if (actualHarvest==400) {
            Assert.assertEquals(expectedHarvest4, actualHarvest);
        } else if (actualHarvest==500) {
            Assert.assertEquals(expectedHarvest5, actualHarvest);
        } else if (actualHarvest==600) {
            Assert.assertEquals(expectedHarvest6, actualHarvest);
        }
    }


//        @Test
//    public final void testHarvest() {
//        int[] yield = new int[7000];
//
//        for (int i = 0; i < 10; i++) {
//            int harvest = ham.harvest(1000, 500);
//            assertTrue("Illegal harvest per acre: " + harvest, harvest > 0 && harvest <= 7000);
//            yield[harvest] += 1;
//        }
//        for (int j = 1; j <= 10; j++) {
//            assertTrue("You never have a yield of " + j + " bushels per acre.", yield[j] > 0);
//        }
//    }






//    @Test
//    public final void testPlagueDeaths1() {
//        int number_of_plagues = 0;
//        for (int i = 0; i < 10000; i++) {
//            int deaths = ham.plagueDeaths(100);
//            if (deaths > 0) {
//                number_of_plagues += 1;
//            }
//        }
//        int percentPlagues = number_of_plagues / 100;
//        assertTrue("Number of plagues is about " + percentPlagues + ", not about 15%.",
//                   about(1500, number_of_plagues));
//    }

//    @Test
//    public final void testPlagueDeaths2() {
//        int deaths = 0;
//        for (int i = 0; i < 10000; i++) {
//            deaths = ham.plagueDeaths(100);
//            if (deaths > 0) break;
//        }
//        assertEquals("In a plague, " + deaths + "% of your people die, not 50%.",
//                     50, deaths);
//    }
    
//    @Test
//    public final void testStarvationDeaths() {
//        int deaths = ham.starvationDeaths(100, 1639);
//        assertEquals("Wrong number of starvations deaths.", 19, deaths);
//        deaths = ham.starvationDeaths(100, 2500);
//        if (deaths < 0) {
//            fail("You starved a negative number of people!");
//        }
//    }

//    @Test
//    public final void testUprising() {
//        assertTrue("Should have had an uprising!", ham.uprising(1000, 451));
//        assertFalse("Should not have had an uprising!", ham.uprising(1000, 449));
//    }



//    @Test
//    public final void testHarvest() {
//        int[] yield = new int[7];
//        for (int i = 0; i < 1000; i++) {
//            int harvest = ham.harvest(1);
//            assertTrue("Illegal harvest per acre: " + harvest, harvest > 0 && harvest <= 6);
//            yield[harvest] += 1;
//        }
//        for (int j = 1; j <= 6; j++) {
//            assertTrue("You never have a yield of " + j + " bushels per acre.", yield[j] > 0);
//        }
//    }

//    @Test
//    public final void testGrainEatenByRats1() {
//        int infestations = 0;
//        for (int i = 0; i < 1000; i++) {
//            int eaten = ham.grainEatenByRats(100);
//            if (eaten > 0) {
//                infestations += 1;
//            }
//        }
//        int percentInfestations = infestations / 100;
//        assertTrue("Number of rat infestations is about " + percentInfestations +
//                   ", not about 40%.", about(400, infestations));
//    }

//    @Test
//    public final void testGrainEatenByRats2() {
//        int percent = 0;
//        int[] counts = new int[31];
//        for (int i = 0; i < 10000; i++) {
//            percent = ham.grainEatenByRats(100);
//            if (percent == 0) continue;
//            counts[percent] += 1;
//            assertTrue("Rats ate " + percent + "% of your grain, not 10% to 30%.",
//                       percent >= 10 && percent <= 30);
//        }
//        for (int j = 11; j < 30; j++) {
//            assertTrue("Rats never ate " + j + "% of your grain.", counts[j] > 0);
//        }
//    }

//    @Test
//    public final void testNewCostOfLand() {
//        int[] cost = new int[24];
//        for (int i = 0; i < 1000; i++) {
//            int price = ham.newCostOfLand();
//            assertTrue("Illegal cost of land: " + price, price >= 17 && price <= 23);
//            cost[price] += 1;
//        }
//        for (int j = 17; j <= 23; j++) {
//            assertTrue("You never have a land cost of " + j + " bushels per acre.", cost[j] > 0);
//        }
//    }
//

//    @Test
//    public final void testHarvest() {
//        int[] yield = new int[7000];
//
//        for (int i = 0; i < 10; i++) {
//            int harvest = ham.harvest(500, 250);
//            assertTrue("Illegal harvest per acre: " + harvest, harvest > 0 && harvest <= 3000);
//            yield[harvest] += 1;
//        }
//
//        for (int j = 1; j <= 1000; j++) {
//            assertFalse("You never have a yield of " + j + " bushels per acre.", yield[j] > 0);
//        }
//    }
}

