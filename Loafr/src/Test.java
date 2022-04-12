public class Test {

    // FIELDS -----------------------------------------------------------------------------
    private String testID = "";
    private String numEntriesInThisTest = "";
    private String testDurationInSeconds = "";


    // CONSTRUCTOR(s) --------------------------------------------------------------
    public Test(String id){
        testID = id;
    }



    // SETTERS AND GETTERS ------------------------------------------------------------------
    public void setNumEntriesInThisTest(String numEntriesInThisTest) {
        this.numEntriesInThisTest = numEntriesInThisTest;
    }

    public String getNumEntriesInThisTest() {
        return numEntriesInThisTest;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getTestDurationInSeconds() {
        return testDurationInSeconds;
    }

    public void setTestDurationInSeconds(String testDurationInSeconds) {
        this.testDurationInSeconds = testDurationInSeconds;
    }
}
