import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashtableWithDuplicateKeysBD implements HashtableWithDuplicateKeysInterface<String, PostInterface>{
 
  public HashtableWithDuplicateKeysBD(int capacity) {
    
  }
  public HashtableWithDuplicateKeysBD() {}
  @Override
  public void put(String key, List<PostInterface> value) throws IllegalArgumentException {
    // doesnt need to work for my tests
    
  }
  @Override
  public boolean containsKey(String key) {
    // just need to return true for my tests
    return true;
  }
  @Override
  public List<PostInterface> get(String key) throws NoSuchElementException {
    
    
    //includes hardcoded examples of search terms and returns a list of various corresponding matches
    
    if(key.equals("TITLE:sample")) {
      
      
      PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
      PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
      PostInterface post3 = new PostBD("Sample three","sampleurl3","  sam!ple hello ");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post);
      list.add(post2);
      list.add(post3);

      
      return list;
    }
    if(key.equals("TITLE:one")) {
      PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post);

      return list;
    }
    if(key.equals("TITLE:two")) {
      PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post2);

      return list;
    }
    if(key.equals("TITLE:three")) {
      PostInterface post3 = new PostBD("Sample three","sampleurl3","  sam!ple hello ");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post3);

      return list;
    }
    if(key.equals("BODY:hello")) {
      PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
      PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
//      PostInterface post3 = new PostBD("Sample three","sampleurl3","  sam!ple hello ");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post);
      list.add(post2);
//      list.add(post3);
      
      return list;
    }
    
    if(key.equals("BODY:testing")) {
      PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post);

      return list;
    }
    
    if(key.equals("BODY:ah")) {

      PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post2);

      return list;
    }
    if(key.equals("BODY:sample")) {
      PostInterface post3 = new PostBD("Sample three","sampleurl3","  sam!ple hello ");
      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
      list.add(post3);

      return list;
    }
    
    
//    if(key.equals("one")) {
//      PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
//      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
//      list.add(post);
//
//      return list;
//    }
    
//    if(key.equals("ah")) {
//      PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
//      ArrayList<PostInterface> list = new ArrayList<PostInterface>();
//      list.add(post2);
//
//      return list;
//    }
    
    PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
    PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
//    PostInterface post3 = new PostBD("Sample three","sampleurl3","  sam!ple hello ");
    ArrayList<PostInterface> list = new ArrayList<PostInterface>();
    list.add(post);
    list.add(post2);
//    list.add(post3);
    
    
    return new ArrayList();
  }
  @Override
  public List<PostInterface> remove(String key) throws NoSuchElementException {
    // doesnt need to work for my tests
    return null;
  }
  @Override
  public void clear() {
    // doesnt need to work for my tests
    
  }
  @Override
  public int getSize() {
    // can return constant numbers
    return 2;
  }
  @Override
  public int getCapacity() {
    // can return constant numbers
    return 4;
  }
  @Override
  public void putOne(String key, PostInterface value) {
    // doesnt need to work
    
  }
  @Override
  public void removeOne(String key, PostInterface value) {
    // doesnt need to work
    
  }
  @Override
  public int getNumberOfValues() {
    // can return constant numbers
    return 2;
  }
  
  
}
