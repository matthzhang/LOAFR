import java.io.FileNotFoundException;
import java.util.Scanner;
public class MeanTests {
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
        MeanQuery mean=new MeanQuery("heat-degree");
        if(mean.findFieldMean(data)==80.0){
            System.out.println("Test1 passed");
        }
        MeanQuery fakemean=new MeanQuery("notreal");
        if(fakemean.findFieldMean(data)==0.0){
            System.out.println("Test2 passed");
        }
        MeanQuery fmean=new MeanQuery("blockage");
        if(fmean.findFieldMean(data)==-1.0){
            System.out.println("Test3 passed");
        }
}
}
