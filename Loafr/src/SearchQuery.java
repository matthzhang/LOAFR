
public class SearchQuery extends DataQuery{

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String searchTarget;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public SearchQuery (String target){
        searchTarget = target;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String getSearchTarget(){
        return searchTarget;
    }

    public void setSearchTarget(String target){
        searchTarget = target;
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    public int searchByComponent(Database data){
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        int totalFound = 0;
        // for each entry in the Database allData array, check if DataEntry component matches searchTarget
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            String component = entry.getComponent(); // get component of DataEntry
            if (searchTarget.equals(component)){ // check if component matches searchTarget
                data.addToDisplayed(i); // if component matches, add DataEntry index to Database displayData array
                totalFound++;
            }
        }
        return totalFound; // return total number of entries found
    }

    public int searchByField(Database data){
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        int totalFound = 0;
        // for each entry in the Database allData array, check DataEntry contains searchTarget field
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            if (entry.hasField(searchTarget)){ // check if DataEntry contains searchTarget field
                data.addToDisplayed(i); // if field matches, add DataEntry index to Database displayData array
                totalFound++;
            }
        }
        return totalFound; // return total number of entries found
    }

    public int searchByTime(Database data){
        data.clearDisplayData(); // clear dataDisplay array in Database
        int entries = data.getNumEntries();
        int totalFound = 0;
        // for each entry in the Database allData array, check if DataEntry time stamp matches searchTarget
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i); // get DataEntry from Database
            String time = entry.getTimeStamp(); // get time of DataEntry
            if (searchTarget.equals(time)){ // check if time matches searchTarget
                data.addToDisplayed(i); // if time matches, add DataEntry index to Database displayData array
                totalFound++;
            }
        }
        return totalFound; // return total number of entries found
    }





} // end of class









