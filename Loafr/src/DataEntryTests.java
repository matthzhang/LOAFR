import java.io.FileNotFoundException;
public class DataEntryTests {
    public static void main(String[] args) {
        
        Database data=null;
        boolean getFile = true;
        try {
            data = new Database("tests/sampleTestForUnitT1.csv"); // initialize database with file content
            getFile = false;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Please Try Again.");
        }
       
        if(data.getEntry(3).hasField("heat-degree")){
            System.out.println("true, Test passed");
        }
        else{
            System.out.println("false");
        }
        if(data.getEntry(7).hasField("alert-status")){
            System.out.println("true");
        }
        else{
            System.out.println("false, Test passed");
    }
    if(data.getEntry(12).hasField("sugar-kg")){
        System.out.println("true, Test passed");
    }
    else{
        System.out.println("false");
}
    if(data.getEntry(3).getFieldValue("heat-degree").equals("50.0")){
        System.out.println("true,Test passed");
    }
    else{
        System.out.println("false");
    }
    if(data.getEntry(7).getFieldValue("alert-status").equals(" ")){
            System.out.println("true");
        }
        else{
            System.out.println("false, Test passed");
    }
    if(data.getEntry(12).getFieldValue("sugar-kg").equals("70.0")){
    System.out.println("true,Test passed");
    }
    else{
    System.out.println("false");
    }
    }
}
