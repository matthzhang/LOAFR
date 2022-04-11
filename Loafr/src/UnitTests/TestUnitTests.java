public class TestUnitTests {


    public static void main(String[] args) {


        // TESTS FOR the Test class ***********************************************************************************************************

        // testing if Test class holds all meta data of a testFile like intended
        // Test1: getTestId() / getNumEntriesInThisTest() / getTestDurationInSeconds()
        // INPUT: check the ret values of each of the 3 function calls above (sampleTestForUnitT1.csv file)
        // EXPECTED OUTPUT:
        // data.getTestAtIndex(0).getTestId() == 1
        // data.getTestAtIndex(0).getNumEntriesInThisTest() == 15
        // data.getTestAtIndex(0).getTestDurationInSeconds() == 2 // THIS SHOULD FAIL!!! bc we aren't capturing the test duration value

    }
}
