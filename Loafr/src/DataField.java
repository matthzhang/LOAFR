public class DataField {

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String name;
    private String value;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public DataField(String name, String value){
        this.name = name;
        this.value = value;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public void setName(String name){
        this.name = name;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getName(){
        return name;
    }
    public String getValue(){
        return value;
    }
}
