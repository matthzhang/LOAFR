import java.util.Objects;

public class DataEntry {

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String product;
    private String date;
    private String component;
    private String timeStamp;
    private DataField[] fields; // hold the various fields that a dataEntry may have
    private int numFields;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public DataEntry(String product, String date, String component, String timeStamp){
        this.product = product;
        this.date = date;
        this.component = component;
        this.timeStamp = timeStamp;
        fields = new DataField[10];
        numFields = 0;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public String getDate(){
        return date;
    }

    public String getProduct(){
        return product;
    }

    public String getComponent(){
        return component;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public int getNumFields(){
        return numFields;
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    public void addField(String name, String value){
        fields[numFields++] = new DataField(name, value);

    }

    // check if DataEntry contains a field by passing a String name of a field
    // return true if DataEntry contains the field or false if it does not
    public boolean hasField(String field){
        for (int i = 0; i < fields.length && fields[i] != null; i++){
            if (field.equals(fields[i].getName())){
                return true;
            }
        }
        return false;
    }

    // get the value from a DataField by passing in the name of the requested field
    // return value of field or and empty string if field is not in DataEntry
    public String getFieldValue(String field){
        for (int i = 0; i < fields.length && fields[i] != null; i++){
            if (field.equals(fields[i].getName())){
                return fields[i].getValue();
            }
        }
        return "";
    }

    public String getFieldValue(int index){
        if (index >= numFields){
            return "";
        }
        return fields[index].getValue();
    }

    // create a string of a single DataEntry
    public String getWholeEntry(){
        String s = "";
        s += product;
        s += ", " + date;
        s += ", " + component;
        s += ", " + timeStamp;
        for (int i = 0; i < numFields; i++){
            s += ", " + getFieldValue(i);
        }
        return s;
    }
}
