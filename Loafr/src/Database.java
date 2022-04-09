import java.io.*;
import java.util.Scanner;

public class Database {
    private DataEntry[] allData;
    private DataEntry[] displayedData;
    private String[] categories;
    private int numEntries;
    private int numDisplayed;

    public Database(String filename) throws FileNotFoundException {
        ReadFile(filename);
        displayedData = allData;
        numDisplayed = numEntries;
    }

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
            s += categories[i] + "\t\t";
        }
        s += "\n";
        for (int i = 0; i < displayedData.length; i++){
            s += displayedData[i].getProduct() + "\t\t\t";
            s += displayedData[i].getDate() + "\t\t";
            s += displayedData[i].getComponent() + "\t\t";
            s += displayedData[i].getTimeStamp() + "\t\t";
            for (int j = 4; j < categories.length; j++){
                if (displayedData[i].hasField(categories[j])){
                    s += displayedData[i].getFieldValue(categories[j]) + "\t\t";
                }
                else{
                    s += "\t\t";
                }
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

    public int getNumEntries(){
        return numEntries;
    }

    public DataEntry getEntry(int index){
        return allData[index];
    }

}
