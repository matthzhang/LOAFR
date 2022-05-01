import java.io.FileNotFoundException;
import java.util.Scanner;
public class SortTests {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Database data = null;
        boolean getFile = true;
        SortQuery sort=new SortQuery("heat-degree", "ascending");
        try {
            data = new Database("tests/sampleTestForUnitT1.csv"); // initialize database with file content
            getFile = false;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Please Try Again.");
        }
        int passed=0;
        int num =sort.sort(data);
        //sorttest ascending
        String[] sorteddata = {"100.0","100.0","100.0","100.0","100.0","100.0","50.0", "50.0", "50.0", "50.0"};
        
        for(int i=0;i<sorteddata.length;i++){
            if(sorteddata[i].equals(sort.getResultAtIndex(i).getFieldValue("heat-degree"))){
                passed++;
            }
        }
        if(num==passed){
            System.out.println("passed test1");
        }
        passed=0;
        //sort test descending
        for(int i=0;i<sorteddata.length;i++){
            if(sorteddata[9-i].equals(sort.getResultAtIndex(9-i).getFieldValue("heat-degree"))){
                passed++;
            }
            else{
                System.out.println(sorteddata[9-i]);
            }
        }
        if(num==passed){
            System.out.println("passed test2");
        }   
        }
        }
    




