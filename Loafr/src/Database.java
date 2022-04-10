import java.io.*;
import java.util.Scanner;

public class Database {

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private DataEntry[] allData;
    private DataEntry[] displayedData;
    private String[] categories;
    private int numEntries;
    private int numDisplayed;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public Database(String filename) throws FileNotFoundException {
        ReadFile(filename);
        displayedData = allData;
        numDisplayed = numEntries;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public int getNumEntries(){
        return numEntries;
    }

    public DataEntry getEntry(int index){
        return allData[index];
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    public void ReadFile(String filename) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filename)); // open file to read in content
        s.useDelimiter(","); // split file by ','
        String val = s.next();
        if (!val.equals("number-of-entries")){ // file must by in specific format and must be first entry
            System.out.println("Input File does not match expected format");
            s.close();
            System.exit(1);
        }
        val = s.next();
        numEntries = Integer.parseInt(val); // set number of data entries from file
        allData = new DataEntry[numEntries];
        val = s.next();
        if (!val.equals("number-of-categories")){ // number-of-categories must be 3rd entry in csv file
            System.out.println("Input File does not match expected format");
            s.close();
            System.exit(1);
        }
        val = s.next();
        int cat = Integer.parseInt(val);
        categories = new String[cat];
        s.nextLine();
        s.nextLine();
        for (int i = 0; i < categories.length; i++){
            categories[i] = s.next(); // set each category name from file
        }
        // loop through each line of file. Each line from here is its DataEntry class
        for (int i = 0; i < allData.length; i++) {
            String product = s.next(); // get product name
            String date = s.next(); // get date of test
            String component = s.next(); // get component system is tested from
            String time_stamp = s.next(); // get time stamp of test
            allData[i] = new DataEntry(product, date, component, time_stamp); // initialize DataEntry with collected data
            // for the remaining categories only add fields to DataEntry class for its relevent fields
            for (int j = 4; j < categories.length; j++) {
                val = s.next();
                // if val is not an empty string then current category has a field to add to DataEntry
                if (!val.equals("")) {
                    allData[i].addField(categories[j], val); // add field with category name and value
                }
            }
        }
        s.close(); // close file
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < categories.length; i++){
            String category = categories[i];
            for (int j = category.length(); j <= 19; j++){
                category += " ";
            }
            s += category;
        }
        s += "\n";
        for (int i = 0; i < numDisplayed; i++){
            for (int j = 0; j < categories.length; j++){ // loop through each entry's categories
                String val = "";
                if (j == 0){
                    val = displayedData[i].getProduct(); // get product name
                }
                else if (j == 1){
                    val = displayedData[i].getDate(); // get date
                }
                else if (j == 2){
                    val = displayedData[i].getComponent(); // get component
                }
                else if (j == 3){
                    val = displayedData[i].getTimeStamp(); // get time stamp
                }
                else if (displayedData[i].hasField(categories[j])){ // check if entry contain category as field
                    val = displayedData[i].getFieldValue(categories[j]);
                }
                else{
                    val = "";
                }
                for (int k = val.length(); k <= 20; k++){
                    val += " ";
                }
                s += val;
            }
            s += "\n";
        }
        return s;
    }

    public void clearDisplayData(){
        displayedData = new DataEntry[numEntries];
        numDisplayed = 0;
    }

    public void addToDisplayed(int index){
        displayedData[numDisplayed++] = allData[index];
    }

    public void resetView(){
        displayedData = allData;
        numDisplayed = numEntries;
    }

}
