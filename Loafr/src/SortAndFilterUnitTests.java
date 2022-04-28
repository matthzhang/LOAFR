import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortAndFilterUnitTests {
    public static void main(String[] args) {
        
        // THE SETUP:
        Scanner s = new Scanner(System.in);
        Database data = null;
        boolean getFile = true;
        try {
            data = new Database("tests/sampleTestForUnitT1.csv"); // initialize database with file content
            getFile = false;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Please Try Again.");
        }

        /* need to update filter tests

        // FilterQuery TEST
        FilterQuery fQuery = new FilterQuery();
        fQuery.filterByField("time-stamp");
        if(fQuery.getNumMatches() == 15){
            System.out.println("TEST PASSED");
        }
        else{
            System.out.println("TEST FAILED -- issue with FilterQuery");
        }
        */

        /* need to update sort tests

        // SortQuery TEST1
        SortQuery sQuery = new SortQuery("HeartMonitor");
        sQuery.sortAscending("time-stamp");
        if(sQuery.getResultAtIndex(0).equalsIgnoreCase("0.0")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED -- issue with SortQuery");
        }

        // SortQuery TEST2
        SortQuery sQuery2 = new SortQuery("ValveMonitor");
        sQuery2.sortDescending("time-stamp");
        if(sQuery2.getResultAtIndex(0).equalsIgnoreCase("2.0")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED -- issue with SortQuery");
        }
        */

    }

}
