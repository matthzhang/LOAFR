public abstract class DataQuery{


    // FIELDS ----------------------------------------------------------------------------------------------------------
    private int testID; //
    private boolean priority;
    private String[] timeWindow;



    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public DataQuery(){
        timeWindow = new String[2];
    }

    public DataQuery(int test_id){
        testID = test_id;
        timeWindow = new String[2];
    }

    public DataQuery(int test_id, boolean testPriority){
        testID = test_id;
        priority = testPriority;
        timeWindow = new String[2];
    }




    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public boolean isPriority(){
        return priority;
    }

    public int getTestID(){
        return testID;
    }

    public void setPriority(boolean b){
        priority = b;
    }

    public void setTimeWindow(String start, String end){
        timeWindow[0] = start;
        timeWindow[1] = end;
    }

    public String[] getTimeWindow() {
        return timeWindow;
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "to do" + "\n";
    }


} // end of class 









