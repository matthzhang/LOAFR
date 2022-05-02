public class MeanQuery extends DataQuery{

    // FIELDS ----------------------------------------------------------------------------------------------------------
    private String fieldTarget;
    private double entries;
    private double sum;

    // CONSTRUCTORS ----------------------------------------------------------------------------------------------------
    public MeanQuery(String field){
        fieldTarget = field;
        entries = 0;
        sum = 0;
    }

    // SETTERS & GETTERS -----------------------------------------------------------------------------------------------
    public void setFieldTarget(String field){
        fieldTarget = field;
    }

    public double getEntries(){
        return entries;
    }

    public double getSum(){
        return sum;
    }

    // METHODS ---------------------------------------------------------------------------------------------------------
    public double findFieldMean(Database data){
        for(int i = 0; i < data.getNumEntries(); i++){ // get entries that match sortTarget
            if (data.getEntry(i).hasField(fieldTarget)){
                try{
                    sum += Double.parseDouble(data.getEntry(i).getFieldValue(fieldTarget)); // convert value to double
                    entries++;
                } catch (NumberFormatException e) {
                    return -1.0; // entry value is non-numerical
                }
            }
        }
        if (entries == 0){ // no entries matching found, mean is equal to 0
            return 0;
        }
        return sum/entries; // return mean of the field
    }
}
