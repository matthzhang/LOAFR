import java.io.FileNotFoundException;


    // MAIN
    
public class SearchTest {
    public static void main(String[] args) {
        SearchQuery search=null;
        Database data=null;
        boolean getFile = true;
        try {
            data = new Database("tests\\sampleTestForUnitT1.csv"); // initialize database with file content   
            search=new SearchQuery("HeartMonitor");
            getFile = false;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Please Try Again.");
        }
        if(search.searchByComponent(data)==5){
            System.out.println("SEARCH TEST 1: SUCCESS");
           
        }
        else{
        System.out.println("SEARCH TEST 1: FAILED");
        
        }

        search.setSearchTarget("heat-degree");
        System.out.println(search.getSearchTarget());
        if(search.searchByField(data)==10){
            System.out.println("SEARCH TEST 2: SUCCESS");
        }
        else{
            
        System.out.println("SEARCH TEST 2: FAILED");
        }
        search.setSearchTarget("2.00");
        if(search.searchByTime(data)==3){
            System.out.println("SEARCH TEST 3: SUCCESS");
        }
        else{
            
        System.out.println("SEARCH TEST 3: FAILED");
        }
        
    }
    
}
