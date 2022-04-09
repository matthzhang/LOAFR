import java.util.ArrayList;

public class searchQuery extends DataQuery{


    // FIELDS --------------------------------------------------------------------------------------------
    private int targetValue;
    private ArrayList<logEntry> searchResults;







    // CONSTRUCTORS --------------------------------------------------------------------------------------------
    public searchQuery(){
    }

    // constructor that sets value for fields (only 1 field in this case, non-inherited)
    public searchQuery(int searchValue){
        searchResults = new ArrayList<logEntry>();
        targetValue = searchValue;
    }

    // constructor with use of super
    // (sets values for local fields and the inherited fields
    // (local field being 'amount' and inherited being 'date' and 'customer'
    public searchQuery(int test_id, boolean tPriority, int searchTarget){
        super(test_id, tPriority); // sets the inherited field values using the parents 2-arg constructor
        targetValue = searchTarget;
        searchResults = new ArrayList<logEntry>();
    }






    // METHODS: --------------------------------------------------------------------------------------------

    // search all test data by 'int'
    public void searchAllTestData(String componentName, int targetVal){
        // increment each search match to our 'searchResult' private list
    }

    // search all test data by 'string'
    public void searchAllTestData(String componentName, String targetVal){
        // increment each search match to our 'searchResult' private list
    }


    // search component data by 'int'
    public void searchWithinComponentData(String componentName, int targetVal){
        // increment each search match to our 'searchResult' private list
    }

    // search component data by 'string'
    public void searchWithinComponentData(String componentName, String targetVal){
        // increment each search match to our 'searchResult' private list
    }















    // SETTERS & GETTERS --------------------------------------------------------------------------------------------

    public void setTargetValue(int target){
        targetValue = target;
    }

    public void printSearchResults(){
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println("MATCH #"+(i+1)+": "+(searchResults.get(i))+" \n");
        } // end of loop
    }

    public int getTargetValue(){
        return targetValue;
    }





    @Override
    public String toString() {
        return "DataQuery type: SEARCH " + "\n" +
                "Test ID: ........." + getTestID() + "\n" +
                "High Priority? " + isPriority() +"\n"+
                "Target Search Value: " + targetValue +"\n";
    }

} // end of class  (other ideas below)









