public class SortQuery extends DataQuery{

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String sortTarget;


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

    // METHODS ---------------------------------------------------------------------------------------------------------
    public void sortAscending(String field){

    }

    public void sortDescending(String field){

    }


} // end of class
