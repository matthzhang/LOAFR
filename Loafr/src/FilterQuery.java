public class FilterQuery extends DataQuery{

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String[] filterCriteria;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public FilterQuery (){
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String[] getFilterCriteria(){
        return filterCriteria;
    }

    public void setSearchTarget(String f){
        filterCriteria[0] = f;
    }




    // METHODS ---------------------------------------------------------------------------------------------------------
    public String[] filterByComponent(Database data){
        String[] results = {""};
        return results;
    }

    public String[] filterByField(Database data){
        String[] results = {""};
        return results;
    }

    public String[] filterByTime(Database data){
        String[] results = {""};
        return results;
    }

