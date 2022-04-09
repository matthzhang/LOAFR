public abstract class DataQuery{


    // FIELDS ----------------------------------------------------------------------------------------------------------
    private int testID; //
    private boolean priority;


    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public DataQuery(){
    }

    public DataQuery(int test_id){
        testID = test_id;
    }

    public DataQuery(int test_id, boolean testPriority){
        testID = test_id;
        priority = testPriority;
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


    // METHODS ---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "to do" + "\n";
    }


    // ABSTRACT METHODS ------------------------------------------------------------------------------------------------
    public abstract int searchByComponent(Database data);
    public abstract int searchByField(Database data);
    public abstract int searchByTime(Database data);


} // end of class  (other ideas below)









