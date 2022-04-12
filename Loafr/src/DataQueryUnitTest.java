import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataQueryUnitTest {

    // MAIN
    public static void main(String[] args) {

        // TEST 1
        // Testing DataQuery through SearchQuery because DataQuery is an abstract class
        SearchQuery sQuery1 = new SearchQuery("heat-degrees");
        sQuery1.setTimeWindow("0.5", "1.5");
        String t1 = sQuery1.getTimeWindow()[0];
        String t2 = sQuery1.getTimeWindow()[1];
        if(t1.equalsIgnoreCase("0.5") && t2.equalsIgnoreCase("1.5")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED -issue with timeWindow()");
        }


        // TEST 2
        SearchQuery sQuery2 = new SearchQuery("heat-degrees");
        sQuery2.setTimeWindow("1.5", "0.5");
        String w1 = sQuery2.getTimeWindow()[0];
        String w2 = sQuery2.getTimeWindow()[1];
        if(w1.equalsIgnoreCase("1.5") && w2.equalsIgnoreCase("0.5")){
            System.out.println("TEST FAILED: should notify of invalid range given");
        }

    }// END OF MAIN()
} // end of class

