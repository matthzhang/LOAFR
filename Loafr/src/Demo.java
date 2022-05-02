import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Welcome to Loafr v0.1");
        boolean systemOn = true;
        while (systemOn) { // loop while system is on
            Scanner s = new Scanner(System.in);
            Database data = null;
            boolean getFile = true;
            while (getFile) { // loop until user enters valid file name
                System.out.print("Enter file name: ");
                String filename = s.nextLine(); // get csv file input from user
                try {
                    data = new Database(filename); // initialize database with file content
                    getFile = false;
                } catch (FileNotFoundException e) {
                    System.out.println("File not Found. Please Try Again.");
                }
            }
            SearchQuery searchQuery;
            SortQuery sortQuery;
            FilterQuery filterQuery;
            MeanQuery meanQuery;
            boolean fileWork = true;
            while (fileWork) { // loop while user is working with current file data
                System.out.println(data); // print current data view
                System.out.println("\n");
                System.out.print("Enter Operation (search, sort, filter, mean, reset view, change file, quit): ");
                String operation = s.nextLine(); // get operation input from user
                if (operation.equals("search")) { // if user would like to perform search operation
                    boolean searching = true;
                    while (searching){
                        System.out.println("What Would You Like To Search By?\n" +
                                "\t -component\n" +
                                "\t -field\n" +
                                "\t -time stamp");
                        String search = s.nextLine();
                        if (search.equals("component")){
                            searching = false;
                            System.out.print("Enter Component: ");
                            String component = s.nextLine();
                            // send component to search
                            searchQuery = new SearchQuery(component);
                            int entriesFound = searchQuery.searchByComponent(data);
                            if (entriesFound == 0){
                                System.out.println("No Entries Found");
                            }
                            else{
                                System.out.println(entriesFound + " Entries Found");
                            }

                        }
                        else if(search.equals("field")){
                            searching = false;
                            System.out.print("Enter Field: ");
                            String field = s.nextLine();
                            // send field to search
                            searchQuery = new SearchQuery(field);
                            int entriesFound = searchQuery.searchByField(data);
                            if (entriesFound == 0){
                                System.out.println("No Entries Found");
                            }
                            else{
                                System.out.println(entriesFound + " Entries Found");
                            }
                        }
                        else if (search.equals("time stamp")){
                            searching = false;
                            // get which time to search by
                            System.out.print("Enter Time (X.XX Fromat): ");
                            String time = s.nextLine();
                            // send field to search
                            searchQuery = new SearchQuery(time);
                            int entriesFound = searchQuery.searchByTime(data);
                            if (entriesFound == 0){
                                System.out.println("No Entries Found");
                            }
                            else{
                                System.out.println(entriesFound + " Entries Found");
                            }
                        }
                        else{
                            System.out.println("Unknown Search Criteria. Please Try Again.");
                        }
                    }
                }
                else if (operation.equals("sort")){
                    System.out.print("Enter Field You Would Like To Sort By: ");
                    String field = s.nextLine();
                    boolean sorting = true;
                    while (sorting){
                        System.out.println("How Would You Like To Sort: ascending or descending ");
                        String dir = s.nextLine();
                        if (dir.equals("ascending")){
                            sorting = false;
                            sortQuery = new SortQuery(field, dir); // set target field and direction for sort
                            int entriesFound = sortQuery.sort(data);
                            System.out.println("In the given field " + field + ", there are " + entriesFound
                                    + " entries sorted in a ascending fashion in the table below.");
                        }
                        else if (dir.equals("descending")){
                            sorting = false;
                            sortQuery = new SortQuery(field, dir); // set target field and direction for sort
                            int entriesFound = sortQuery.sort(data);
                            System.out.println("In the given field " + field + ", there are " + entriesFound
                                    + " entries sorted in a descending fashion in the table below.");
                        }
                        else{
                            System.out.println("Unknown Sort Command. Please Try Again.");
                        }
                    }
                }
                else if (operation.equals("filter")){
                    boolean filtering = true;
                    while (filtering){
                        System.out.println("What Would You Like To Search By?\n" +
                                "\t -field\n" +
                                "\t -time stamp");
                        String search = s.nextLine();
                        if (search.equals("time stamp")){
                            filtering = false;
                            System.out.print("Enter Lower Bound: ");
                            String lowString = s.nextLine();
                            double low = Double.parseDouble(lowString);
                            System.out.print("Enter Upper Bound: ");
                            String upString = s.nextLine();
                            double up = Double.parseDouble(upString);
                            filterQuery = new FilterQuery(operation, low, up);
                            int entriesFound = filterQuery.filterByTimeStamp(data);
                            if (entriesFound == 0){
                                System.out.println("no time stamp entries found withing the bounds of " + low + " and " + up + ".");
                            }
                            else{
                                System.out.println("In the bounded time stamp, there are " + entriesFound
                                        + " entries filtered within the bounds " + low + " and " + up + ".");
                            }

                        }
                        else if(search.equals("field")){
                            filtering = false;
                            System.out.print("Enter Field: ");
                            String field = s.nextLine();
                            System.out.print("Enter Lower Bound: ");
                            String lowString = s.nextLine();
                            double low = Double.parseDouble(lowString);
                            System.out.print("Enter Upper Bound: ");
                            String upString = s.nextLine();
                            double up = Double.parseDouble(upString);
                            // send field to filter
                            filterQuery = new FilterQuery(field, low, up);
                            int entriesFound = filterQuery.filterByField(data);
                            if (entriesFound == 0){
                                System.out.println("no " + field + " field entries found withing the bounds of " + low + "and" + up + ".");
                            }
                            else if (entriesFound == -1){
                                System.out.println(field + " field does not use numerical values");
                            }
                            else{
                                System.out.println("In the given field " + field + ", there are " + entriesFound
                                        + " entries filtered within the bounds " + low + " and " + up + ".");
                            }
                        }
                        else{
                            System.out.println("Unknown Search Criteria. Please Try Again.");
                        }
                    }
                }
                else if (operation.equals("mean")){
                    System.out.print("Which Field Would You Like To Find the Mean of? ");
                    String field = s.nextLine();
                    meanQuery = new MeanQuery(field);
                    double result = meanQuery.findFieldMean(data);
                    if (result == -1){
                        System.out.println("Field Contain Non Numerical Values. Cannot Compute Mean.");
                    }
                    else if (result == 0){
                        System.out.println("Field Does Not Exist In Current File.");
                    }
                    else{
                        System.out.println("The " + field + " Field Has A Mean Of " + result + ".");
                    }
                }
                else if (operation.equals("reset view")){
                    data.resetView();
                }
                else if (operation.equals("change file")){ // if user would like to change files
                    fileWork = false;
                }
                else if (operation.equals("quit")) { // if user would like to exit system
                    systemOn = false;
                    fileWork = false;
                }
                else{ // user has entered an unknown operation
                    System.out.println("Unknown Operation. Please Try Again.");
                }
            }
            if (!systemOn){
                s.close();
            }
        }

        System.out.println("Thank you for using Loafr v0.1");
    }
}
