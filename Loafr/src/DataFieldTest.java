
public class DataFieldTest {
    public static void main(String[] args) {
        DataField field=new DataField("Myfield","80.1");
        if(field.getName().equals("Myfield")){
            System.out.println("Field name Matches Test passed");
        }
        else{
            System.out.println("Field name doens't match Test failed");
        }
        if(field.getValue().equals("80.1")){
            System.out.println("Field value Matches Test passed");
        }
        else{
            System.out.println("Field value doens't match Test failed");
        }



    }
}