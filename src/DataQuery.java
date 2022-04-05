public class DataQuery{


    // FIELDS ------------------------------------------------------------------------------------------------------------------------
    private int testID; //
    private boolean priority;













    // CONSTRUCTORS ------------------------------------------------------------------------------------------------------------------------
    public DataQuery(){
    }


    public DataQuery(int test_id){
        testID = test_id;
    }

    public DataQuery(int test_id, boolean testPriority){
        testID = test_id;
        priority = testPriority;
    }









    // SETTERS & GETTERS ---------------------------------------------------------------------------------------------------------------
    public boolean isPriority(){
        return priority;
    }

    public int getTestID(){
        return testID;
    }

    public void setPriority(boolean b){
        priority = b;
    }

    @Override
    public String toString() {
        return "to do" + "\n";
    }

} // end of class  (other ideas below)









