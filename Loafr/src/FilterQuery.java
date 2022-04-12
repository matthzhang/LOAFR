public class FilterQuery extends DataQuery {

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String[] filterCriteria = new String[5];
    private String[] results = new String[15];
    private int numMatches;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public FilterQuery() {
    }
    
    public FilterQuery(String criteria){
        filterCriteria[0] = criteria;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String[] getFilterCriteria() {
        return filterCriteria;
    }

    public void setFilterCriteria(String f) {
        filterCriteria[0] = f;
    }
    
    public int getNumMatches() {
        return numMatches;
    }

    public void setNumMatches(int numMatches) {
        this.numMatches = numMatches;
    }


    // METHODS ---------------------------------------------------------------------------------------------------------
    public String[] filterByComponent(Database data) {
        String[] results = {""};
        return results;
    }

    public String[] filterByField(String fName) {
        String[] results = {""};
        numMatches = results.length;
        return results;
    }

    public String[] filterByTime(Database data) {
        String[] results = {""};
        return results;
    }
}

