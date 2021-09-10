


public class TestSort
{
	public static void main(String[] args) 
    {
        Sort sortTest = new Sort(50);// how many elements will the array contain
        
        /** Read in test data t into array **/

        sortTest.readIn("studentFiles/test1.txt");
        sortTest.display(15,"Values in test1.txt");
        sortTest.insertion();
        sortTest.readIn("studentFiles/test1.txt");
        sortTest.quicksort(0,49);//leftmost and rightmost index of the array
        sortTest.readIn("studentFiles/test1.txt");
        sortTest.newsort();
        /** Display array **/
        
        /** Display two comparison counters **/
        System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
        System.out.println("Quicksort comparison counter: " + sortTest.compQS);
        System.out.println("NewSort comparison counter: " + sortTest.compNS);
        sortTest.display(15,"Values in test1.txt");

        
       
    }
    
} 
