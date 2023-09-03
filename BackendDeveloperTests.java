
import java.util.List;

public class BackendDeveloperTests { 
  public static boolean test1() { try { 
    //this test is designed to test the loadData method
    HashtableWithDuplicateKeysBD hasht = new HashtableWithDuplicateKeysBD();
    PostReaderBD postr = new PostReaderBD(); //making search interface
    CHSearchBackendBD inter = new CHSearchBackendBD(hasht, postr);
    
      inter.loadData("");
      //the test doesn't need a file name because I hardcoded the postreader to contain a set
      //number of objects.
      //additionally, I did not code the hashtable class to store anything, but assuming that it
      //would be run with a working hashtable and put method, this method should work correctly as it 
      //does not throw any errors when run. 
    } catch (Exception e) {
      return false; //if any exceptions thrown
    }
    
    //no errors encountered, works correctly so return true
    return true;
    }
  public static boolean test2() {  try {
    HashtableWithDuplicateKeysBD hasht = new HashtableWithDuplicateKeysBD();
    PostReaderBD postr = new PostReaderBD(); //making search interface
    CHSearchBackendBD inter = new CHSearchBackendBD(hasht, postr);
    
    List<String> words =inter.findPostsByTitleOrBodyWords("hello");
    String check =""; //testing findpostsbytitleorbodywords, 
    //with my hardcoded implementation of the hastable class this should return 
    //"sampleurl1sampleurl2"
    for(int i =0; i<words.size();i++) {
      check=check +(words.get(i)); //iterating through results list
    }
    if(!check.equals("sampleurl1sampleurl2")) {
      return false;} //checking for correct output
  }catch(Exception e) {return false;} //any exceptions, return false.
    return true; 
    }
  
  public static boolean test3() { try {
    
    HashtableWithDuplicateKeysBD hasht = new HashtableWithDuplicateKeysBD();
    PostReaderBD postr = new PostReaderBD(); //making search interface
    CHSearchBackendBD inter = new CHSearchBackendBD(hasht, postr);
    
    //with my hardcoded implementation of hashtable, this should return "sampleurl1"
    List<String> wordsTitle =inter.findPostsByTitleWords("one");
    String check="";
    for(int i =0; i<wordsTitle.size();i++) {
      check=check+(wordsTitle.get(i));
    } //checking for correct outputted list
    if(!check.equals("sampleurl1")) {return false;}
    
    //now test for searching multiple words by title, should return sampleurl1sampleurl2 bc
    //of hardcoded hashtable methods
    List<String> wordsTitle2 =inter.findPostsByTitleWords("one two");
    String check2="";
    for(int i =0; i<wordsTitle2.size();i++) {
      check2=check2+(wordsTitle2.get(i));
    } //checking for correct outputted list
    if(!check2.equals("sampleurl1sampleurl2")) {return false;}
    
  }catch(Exception e) {return false;} //any exceptions, return false.
    return true;}
  
  public static boolean test4() { try {
    HashtableWithDuplicateKeysBD hasht = new HashtableWithDuplicateKeysBD();
    PostReaderBD postr = new PostReaderBD();//creating search interface
    CHSearchBackendBD inter = new CHSearchBackendBD(hasht, postr);
    //this also tests for searching multiple words when one doesnt exist
    List<String> wordsTitle =inter.findPostsByBodyWords("ah test");
    String check=""; //findpostsbybodywords should return "sampleurl2" in a list with my
    //hardcoded hashtable implementation. 
    for(int i =0; i<wordsTitle.size();i++) {
      check=check+(wordsTitle.get(i));
    }
    if(!check.equals("sampleurl2")) {
      System.out.println(check);
      return false;}
  }catch(Exception e) {return false;} //any exceptions, return false.
    return true;
    }
  
  public static boolean test5() { try {
    HashtableWithDuplicateKeysBD hasht = new HashtableWithDuplicateKeysBD();
    PostReaderBD postr = new PostReaderBD();//creating search interface
    CHSearchBackendBD inter = new CHSearchBackendBD(hasht, postr);
    //check for correct stats string
    if(!inter.getStatisticsString().equals("Size of hashtable: 2 capacity of hashtable: 4 values in hashtable: 2"))
    return false;
  }catch(Exception e) {return false;} //any exceptions, return false.
    return true;}
  
  
  public static void main(String[] args) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
  }
}
