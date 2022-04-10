import java.io.FileNotFoundException;
import java.util.Scanner;

public class DemoForUnitTests {

    // MAIN
    public static void main(String[] args) {


        // TESTS FOR THE DATABASE CLASS...
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


        if(data.getNumEntries()==15){
            System.out.println("DATABASE TEST 1: SUCCESS");
        } else{
            System.out.println("DATABASE TEST 1: FAILED - getNumEntries()");
        }


        String entryStr = data.getEntry(0).getWholeEntry();
        String rowStr = "iMedPump, 1/25/20, system, 0.00, 100.0, 80.0, low";
        if(entryStr.equals(rowStr)){
            System.out.println("DATABASE TEST 2: SUCCESS");
        }
        else{
            System.out.println("DATABASE TEST 2: FAILED - getEntry()");
        }













        // TESTS FOR THE SearchQuery CLASS...


        // searchByComponent() TEST1
        // INPUT: searchTarget  == HeartMonitor, (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT: 5 dataEntry matches -- use getComponent() should ret "HeartMonitor" for all 5 dataEntries


        // searchByField() TEST1
        // INPUT: searchTarget  == time-stamp, (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT: 15 dataEntry matches(all) --

        // searchByField() TEST2
        // INPUT: searchTarget  == sugar-kg, (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT: 10 dataEntry matches -- use getComponent() should ret 5 "HeartMonitor" and 5 "ValveReader"

        // searchByTime() TEST1
        // INPUT: searchTarget == 2.0, (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT: 3 dataEntry matches (one from each of the 3 components) -- use getComponent() should ret "HeartMonitor" for all 5 dataEntries
                // for getComponent() == system: check that heat-degree == 100.0
                // for getComponent() == HeartMonitor: check that glucose-mg == 10.0
                // for getComponent() == ValveReader: check that sugar-kg == 50.0








        // TESTS FOR THE DataQuery CLASS...

        // setTimeWindow() TEST1
        // INPUT: start == 0.5, end == 1.5 (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT: getTimeWindow() == [0.5, 1.5]

        // setTimeWindow() TEST2 (case where the end > start arg, should result in no change)
        // setup --> setTimeWindow(0.0, 2.0)
        // INPUT: start == 2.0, end == 1.0 (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT: getTimeWindow() == [0.0, 2.0]








    }// END OF MAIN()
} // end of class
