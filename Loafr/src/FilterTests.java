import java.io.FileNotFoundException;
import java.util.Scanner;
public class FilterTests {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Database data = null;
        boolean getFile = true;
        try {
            data = new Database("tests/sampleTestForUnitT1.csv"); // initialize database with file content
            getFile = false;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Please Try Again.");
        }
        FilterQuery filter=new FilterQuery("heat-degree",0.00,99.0);
        if(filter.filterByField(data)==4){
            System.out.println("Test 1 passed");
        }
        filter.setFilterCriteria("blockage");
        if(filter.filterByField(data)==-1){
            System.out.println("Test 2 passed");
        }
        filter.setFilterCriteria("heat-degree");
        filter.setLowerBound(150.0);
        filter.setUpperBound(200.0);
        filter.getLowerBound();
        if(filter.filterByField(data)==0){
            System.out.println("Test 3 passed");
        }
        else{
            System.out.println(filter.getLowerBound());
            System.out.println(filter.filterByField(data));

        }
    

    }
}
