public class SortQuery extends DataQuery{

    
    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String sortTarget;
    private String[] results = new String[20];

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public SortQuery (String target){
        sortTarget = target;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String getSortTarget(){
        return sortTarget;
    }

    public void setSortTarget(String target){
        sortTarget = target;
    }
    public String getResultAtIndex(int i){
        return results[i];
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    public void sortAscending(String field){
        results[0] = "5";
    }

    public void sortDescending(String field){
        results[0] = "10"; 
    }


} // end of class
