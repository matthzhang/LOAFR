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
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        // for each entry in the Database allData array, check if DataEntry component matches filterCriteria
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            String component = entry.getComponent(); // get component of DataEntry
            if (!filterCriteria[0].equals(component)){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component doesn't match, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with target removed
    }

    public String[] filterByField(Database data) {
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        // for each entry in the Database allData array, check DataEntry contains filterCriteria field
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            if (!entry.hasField(filterCriteria[0])){ // check if DataEntry contains filterCriteria field
                data.addToDisplayed(i); // if field does not matche, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with target removed
    }

    public String[] filterByTime(Database data) {
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        // for each entry in the Database allData array, check if DataEntry time stamp matches searchTarget
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            String time = entry.getTimeStamp(); // get time of DataEntry
            if (!filterCriteria[0].equals(time)){ // check if time matches searchTarget
                data.addToDisplayed(i); // if time does not match, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with target removed
    }
}

