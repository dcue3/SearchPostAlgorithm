import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CHSearchBackendBD implements CHSearchBackendInterface{
  
  HashtableWithDuplicateKeysBD hashtable;  
  PostReaderBD postReader;

  public  CHSearchBackendBD(HashtableWithDuplicateKeysBD hashtable, 
      PostReaderBD postReader) { 
    this.hashtable=hashtable;
    this.postReader=postReader;
  }
  
  
  @Override
  public void loadData(String filename) throws FileNotFoundException {
   List<PostInterface> list = postReader.readPostsFromFile(filename);
   for(int i =0; i<list.size();i++) { //for every post

       
     String title = list.get(i).getTitle(); //get title words
     title = title.replaceAll("[^a-zA-Z ]", "");
     title =title.toLowerCase(); //format, take out punctuation, make lowercase
     String titleWords[]=title.split("\\s+"); //split into array

     for(int g =0; g<titleWords.length;g++) { //for each title word
         //if it is not already stored in hashtable, add it 
       if(!hashtable.get("TITLE:" + titleWords[g]).contains(list.get(i))) {
         hashtable.putOne("TITLE:" +titleWords[g], list.get(i));
       } 
     }
     
     
     
     String body = list.get(i).getBody(); //get body words
     body = body.replaceAll("[^a-zA-Z ]", "");
     body =body.toLowerCase(); //format, take out punctuation, make lowercase
     String bodyWords[]=body.split("\\s+"); //split into array
     for(int q =0; q<bodyWords.length;q++) { //for each body word
       //if it is not already stored in hashtable, add it
       if(!hashtable.get("BODY:" + bodyWords[q]).contains(list.get(i))) {
         hashtable.putOne("BODY:" +bodyWords[q], list.get(i));
       }
     }
     
   }
    
  }

  @Override
  public List<String> findPostsByTitleWords(String words) {
   //format search words to take out punctuation and be lowercase
    words =words.replaceAll("[^a-zA-Z ]", "");
    words =words.toLowerCase(); 
    String words2[]=words.split("\\s+");
    List<String> results = new ArrayList<String>();
    for(int i=0; i<words2.length; i++) {
       //for each words
      if(hashtable.containsKey("TITLE:" + words2[i])) {
        //if it is contained in hashtable
        for(int g=0; g<hashtable.get("TITLE:"+words2[i]).size(); g++) {
          //for each entry with the same key in hashtable
          if(!results.contains(hashtable.get("TITLE:" +words2[i]).get(g).getUrl())) {
            //if this key/value pair is not yet there add it
            results.add(hashtable.get("TITLE:" +words2[i]).get(g).getUrl());
            
          } 
          
          }
        }
        
      }

    return results;
  }

  @Override
  public List<String> findPostsByBodyWords(String words) {
    words =words.replaceAll("[^a-zA-Z ]", "");
    words =words.toLowerCase(); 
    String words2[]=words.split("\\s+");
    List<String> results = new ArrayList<String>();
    for(int i=0; i<words2.length; i++) {
 //same process as findpostsbytitlewords but with body words using BODY: in front of them
      if(hashtable.containsKey("BODY:" + words2[i])) {
        
        for(int g=0; g<hashtable.get("BODY:"+words2[i]).size(); g++) {
          
          if(!results.contains(hashtable.get("BODY:" +words2[i]).get(g).getUrl())) {
            
            results.add(hashtable.get("BODY:" +words2[i]).get(g).getUrl());
            
          } 
          
          }
        }
        
      }

    return results;

  }

  @Override
  public List<String> findPostsByTitleOrBodyWords(String words) {
//    words =words.replaceAll("[^a-zA-Z ]", "");
//    words =words.toLowerCase(); 
//    String words2[]=words.split("\\s+");
//    List<String> results = new ArrayList<String>();
//    for(int i=0; i<words2.length; i++) {
//    
//      if(hashtable.containsKey("TITLE:" + words2[i])) {
//        System.out.println(words2[i]);
//        for(int g=0; g<hashtable.get("TITLE:" +words2[i]).size(); g++) {
//          
//          if(!results.contains(hashtable.get("TITLE:" + words2[i]).get(g).getUrl())) {
//            
//            results.add(hashtable.get("TITLE:"+words2[i]).get(g).getUrl());
//            
//          } 
//          
//          }
//        }
//      else if(hashtable.containsKey("BODY:" + words2[i])) {
//        System.out.println(words2[i]);
//        for(int g=0; g<hashtable.get("BODY:"+words2[i]).size(); g++) {
//          
//          if(!results.contains(hashtable.get("BODY:" + words2[i]).get(g).getUrl())) {
//            
//            results.add(hashtable.get("BODY" +words2[i]).get(g).getUrl());
//            
//          } 
//          
//          }
//        }
//        
//      }
    //ignore above code
    
    //call both methods findpostsbytitle/body words and add their results to a list and return it
    List<String> results = findPostsByTitleWords(words);
    results.addAll(findPostsByBodyWords(words));

    return results;

  }

  @Override
  public String getStatisticsString() {
    int size = hashtable.getSize(); //gets size,capacity, and number of vals of hashtable
    int capacity = hashtable.getCapacity();
    int vals = hashtable.getNumberOfValues();
    return "Size of hashtable: "+ size + " capacity of hashtable: " + capacity +" values in hashtable: " +
       vals ;
  }

}
