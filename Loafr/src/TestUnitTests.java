import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestUnitTests {


    public static void main(String[] args) {

        SearchQuery s =null;
        Database data=null;
        boolean getFile = true;
        int check = 0;
        try {
            data = new Database("tests/sampleTestForUnitT1.csv"); // initialize database with file content
            s = new SearchQuery("HeartMonitor");
            getFile = false;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Please Try Again.");
            check = 1;
        }

        if(check == 0) {
            String t1 = data.getTestAtIndex(0).getTestID();
            String t2 = data.getTestAtIndex(0).getNumEntriesInThisTest();
            String t3 = data.getTestAtIndex(0).getTestDurationInSeconds();


            if (t1.equalsIgnoreCase("1")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED - issue with Test class");
            }

            if (t2.equalsIgnoreCase("15")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED - issue with Test class");
            }

            if (t3.equalsIgnoreCase("2")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED - issue with Test class");
            }
        }

    }
}

