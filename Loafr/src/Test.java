import java.util.Random;

public class Test {

    // FIELDS -----------------------------------------------------------------------------
    private int testID;
    private int numEntriesInThisTest;
    private int testDurationInSeconds;


    // CONSTRUCTOR(s) --------------------------------------------------------------
    public Test(int id){
        testID = id;
    }



    // SETTERS AND GETTERS ------------------------------------------------------------------
    public void setNumEntriesInThisTest(int numEntriesInThisTest) {
        this.numEntriesInThisTest = numEntriesInThisTest;
    }

    public int getNumEntriesInThisTest() {
        return numEntriesInThisTest;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }
}
