public class MeanQuery extends DataQuery{
    private String fieldTarget;
    private double entries;
    private double sum;

    public MeanQuery(String field){
        fieldTarget = field;
        entries = 0;
        sum = 0;
    }

    public double findFieldMean(Database data){
        for(int i = 0; i < data.getNumEntries(); i++){ // get entries that match sortTarget
            if (data.getEntry(i).hasField(fieldTarget)){
                try{
                    sum += Double.parseDouble(data.getEntry(i).getFieldValue(fieldTarget));
                    entries++;
                } catch (NumberFormatException e) {
                    return -1.0;
                }
            }
        }
        if (entries == 0){
            return 0;
        }
        return sum/entries;
    }
}
