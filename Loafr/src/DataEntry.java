import java.util.Objects;

public class DataEntry {
    private String product;
    private String date;
    private String component;
    private String timeStamp;
    private DataField[] fields;
    private int numFields;

    public DataEntry(String product, String date, String component, String timeStamp){
        this.product = product;
        this.date = date;
        this.component = component;
        this.timeStamp = timeStamp;
        fields = new DataField[10];
        numFields = 0;
    }

    public void addField(String name, String value){
        fields[numFields++] = new DataField(name, value);

    }

    public String getProduct(){
        return product;
    }

    public String getDate(){
        return date;
    }

    public String getComponent(){
        return component;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public boolean hasField(String field){
        for (int i = 0; i < fields.length && fields[i] != null; i++){
            if (field.equals(fields[i].getName())){
                return true;
            }
        }
        return false;
    }

    public String getFieldValue(String field){
        for (int i = 0; i < fields.length && fields[i] != null; i++){
            if (field.equals(fields[i].getName())){
                return fields[i].getValue();
            }
        }
        return "";
    }
}
