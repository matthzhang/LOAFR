public class FilterQuery extends DataQuery {

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String filterCriteria;
    private int numOccurence;
    private double lowerBound;
    private double upperBound;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public FilterQuery() {
    }
    
    public FilterQuery(String criteria, double low, double up){
        filterCriteria = criteria;
        lowerBound = low;
        upperBound = up;
        numOccurence = 0;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String getFilterCriteria() {
        return filterCriteria;
    }

    public void setFilterCriteria(String f) {
        filterCriteria = f;
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
    public int filterByTimeStamp(Database data) {
        numOccurence = 0;
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        int k = 0;
        double stamp = 0;
        // for each entry in the Database allData array, check if DataEntry timestamp falls between bounds
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            stamp = Double.parseDouble(entry.getTimeStamp()); // get timestamp of DataEntry
            if (stamp >= lowerBound && stamp <= upperBound){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component doesn't match, add DataEntry index to Database displayData array
                numOccurence++;
            }
        }
        return numOccurence;
    }

    public int filterByField(Database data) {
        numOccurence = 0;
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        String[] found = new String[entries];
        int k = 0;
        double pumpPercent = 0;
        
        // for each entry in the Database allData array, check if DataEntry timestamp falls between bounds
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            if(entry.hasField(filterCriteria)){
                try{
                    pumpPercent = Double.parseDouble(entry.getFieldValue(filterCriteria));
                }
                catch (Exception e){
                    return -1;
                }
            }
            else{
                continue;
            }
            if (pumpPercent >= lowerBound && pumpPercent <= upperBound){ // check if component matches filterCriteria
                data.addToDisplayed(i); // if component is in bound, add DataEntry index to Database displayData array
                numOccurence++;
            }
        }
        
        return numOccurence; // return array of components with variables in bould
    }
}

