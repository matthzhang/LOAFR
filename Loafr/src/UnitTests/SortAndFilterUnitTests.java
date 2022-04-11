public class SortAndFilterUnitTests {
    public static void main(String[] args) {

// TESTS FOR FilterQuery() class and SortQuery() class **********************************************************************************************

        // testing FilterQuery()...testing basic filter functionality
        // Test1: FilterQuery("time-stamp")
        // INPUT: FilterQuery f = new FilterQuery() (sampleTestForUnitT1.csv file)
        // FilterQuery("2.0")
        // EXPECTED OUTPUT:
        // The DataEntry list (within Database) should only have 3 entries in it (== size of 3)
        // NOTE THIS TEST SHOULD FAIL!!

        // testing SortQuery()...testing basic sort functionality
        // Test1: SortQuery("time-stamp")
        // INPUT: SortQuery s = new SortQuery() (sampleTestForUnitT1.csv file)
        // sortAscending("time-stamp")
        // EXPECTED OUTPUT:
        // The first 3 dataEntries in the DataEntry list (within Database) should all have a time stamp of 0.0
        // NOTE THIS TEST SHOULD FAIL!!

        // testing SortQuery()...testing basic sort functionality
        // Test2: SortQuery("time-stamp")
        // INPUT: SortQuery s = new SortQuery() (sampleTestForUnitT1.csv file)
        // sortDescending("time-stamp")
        // EXPECTED OUTPUT:
        // The first 3 dataEntries in the DataEntry list (within Database) should all have a time stamp of 2.0
        // NOTE THIS TEST SHOULD FAIL!!






    }

}
