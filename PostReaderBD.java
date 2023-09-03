
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PostReaderBD implements PostReaderInterface {
    public PostReaderBD(){}
    
    public List<PostInterface> readPostsFromFile(String filename) 
        throws FileNotFoundException{
      
    //loads basic examples of posts
     PostInterface post = new PostBD("Sample one","sampleurl1","Hello testing");
     PostInterface post2 = new PostBD("Sample two","sampleurl2","Hello, Ah!");
     ArrayList<PostInterface> list = new ArrayList<PostInterface>();
     list.add(post);
     list.add(post2);
     
   
      return list;
    }
}