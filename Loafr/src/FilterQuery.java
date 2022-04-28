public class FilterQuery extends DataQuery {

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String[] filterCriteria = new String[5];
    private String[] results = new String[15];
    private double lowerBound;
    private double upperBound;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public FilterQuery() {
    }
    
    public FilterQuery(String criteria, double low, double up){
        filterCriteria[0] = criteria;
        lowerBound = low;
        upperBound = up;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String[] getFilterCriteria() {
        return filterCriteria;
    }

    public void setFilterCriteria(String f) {
        filterCriteria[0] = f;
    }
    
    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setLowerBound(double low) {
        lowerBound = low;
    }

    public void setUpperBound(double high) {
        upperBound = high;
    }


    // METHODS ---------------------------------------------------------------------------------------------------------
    public String[] filterByTimeStamp(Database data) {
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        double stamp = 0;
        // for each entry in the Database allData array, check if DataEntry timestamp falls between bounds
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            stamp = Double.parseDouble(entry.getTimeStamp()); // get timestamp of DataEntry
            if (stamp >= lowerBound && stamp <= upperBound){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component doesn't match, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with variables in bould
    }

    public String[] filterByHeat(Database data) {
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        double pumpPercent = 0;
        
        // for each entry in the Database allData array, check if DataEntry timestamp falls between bounds
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            if(entry.hasField("insulin_%")){
                pumpPercent = Double.parseDouble(entry.getFieldValue("insulin_%"));
            }
            else{
                continue;
            }
            if (pumpPercent >= lowerBound && pumpPercent <= upperBound){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component is in bound, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with variables in bould
    }

    public String[] filterBySugar(Database data) {
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        double sugar = 0;
        
        // for each entry in the Database allData array, check if DataEntry timestamp falls between bounds
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            if(entry.hasField("sugar-kg")){
                sugar = Double.parseDouble(entry.getFieldValue("sugar-kg"));
            }
            else{
                continue;
            }
            if (sugar >= lowerBound && sugar <= upperBound){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component is in bound, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with variables in bould
    }

    public String[] filterByGlucose(Database data) {
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        double glucose = 0;
        
        // for each entry in the Database allData array, check if DataEntry timestamp falls between bounds
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            if(entry.hasField("glucose-mg")){
                glucose = Double.parseDouble(entry.getFieldValue("glucose-mg"));
            }
            else{
                continue;
            }
            if (glucose >= lowerBound && glucose <= upperBound){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component is in bound, add DataEntry index to Database displayData array
                found[k] = entry.getWholeEntry();
                k++;
            }
        }
        return found; // return array of components with variables in bould
    }
}

