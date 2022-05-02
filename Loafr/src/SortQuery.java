public class SortQuery extends DataQuery{

    
    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String sortTarget;
    private String sortDirection;
    private int resultEntries;
    private DataEntry[] results;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public SortQuery (String target, String direction){
        sortTarget = target;
        sortDirection = direction;
        resultEntries = 0;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String getSortTarget(){
        return sortTarget;
    }

    public void setSortTarget(String target){
        sortTarget = target;
    }
    public DataEntry getResultAtIndex(int i){
        return results[i];
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    public void populateResults(Database data){
        int pos = 0; // current position in results array to add DataEntry
        for(int i = 0; i < data.getNumEntries(); i++){ // get entries that match sortTarget
            if (data.getEntry(i).hasField(sortTarget)){
                results[pos++] = data.getEntry(i);
                resultEntries++;
            }
        }
    }

    // transfer sorted results to Database displayData[] in ascending order
    public void transferToDisplayAscending(Database data){
        data.clearDisplayData(); // clear dataDisplay array in Database
        for (int i = 0; i < resultEntries; i++){
            data.addToDisplayed(results[i]);
        }
    }

    // transfer sorted results to Database displayData[] in descending order
    public void transferToDisplayDescending(Database data){
        data.clearDisplayData(); // clear dataDisplay array in Database
        for (int i = resultEntries - 1; i >= 0; i--){
            data.addToDisplayed(results[i]);
        }
    }

    // merge algorithm for mergesort
    public void merge(int l, int m, int r){
        int size1 = m - l + 1;
        int size2 = r - m;

        DataEntry[] left = new DataEntry[size1];
        DataEntry[] right = new DataEntry[size2];

        for (int i = 0; i < size1; i++){
            left[i] = results[l + i];
        }
        for (int i = 0; i < size2; i++){
            right[i] = results[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < size1 && j < size2) {
            double val1;
            double val2;
            try {
                val1 = Double.parseDouble(left[i].getFieldValue(sortTarget));
                val2 = Double.parseDouble(right[j].getFieldValue(sortTarget));
            } catch (NumberFormatException e) {
                val1 = 1;
                val2 = 0;
            }


            if (val1 >= val2) {
                results[k] = left[i];
                i++;
            }
            else {
                results[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            results[k] = left[i];
            i++;
            k++;
        }

        while (j < size2) {
            results[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int l, int r){
        if (l < r){
            int m = (l + r) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l,m,r);
        }
    }

    public int sort(Database data){
        results = new DataEntry[data.getNumEntries()];
        populateResults(data); // populate results[] with field category
        mergeSort(0, resultEntries - 1); // sort the DataEntry
        if (sortDirection.equals("ascending")){
            transferToDisplayAscending(data); // add to display in Ascending order
        }
        else{
            transferToDisplayDescending(data); // add to display in Descending order
        }
        return resultEntries;
    }


} // end of class
