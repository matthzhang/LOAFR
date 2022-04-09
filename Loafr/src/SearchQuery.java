
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
        data.clearDisplayData();
        int entries = data.getNumEntries();
        int totalFound = 0;
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i);
            String component = entry.getComponent();
            if (searchTarget.equals(component)){
                data.addToDisplayed(i);
                totalFound++;
            }
        }
        return totalFound;
    }

    public int searchByField(Database data){
        data.clearDisplayData();
        int entries = data.getNumEntries();
        int totalFound = 0;
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i);
            if (entry.hasField(searchTarget)){
                data.addToDisplayed(i);
                totalFound++;
            }
        }
        return totalFound;
    }

    public int searchByTime(Database data){
        data.clearDisplayData();
        int entries = data.getNumEntries();
        int totalFound = 0;
        for (int i = 0; i < entries; i++){
            DataEntry entry = data.getEntry(i);
            String time = entry.getTimeStamp();
            if (searchTarget.equals(time)){
                data.addToDisplayed(i);
                totalFound++;
            }
        }
        return totalFound;
    }





} // end of class  (other ideas below)









