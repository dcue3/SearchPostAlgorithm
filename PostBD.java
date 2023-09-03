

public class PostBD implements PostInterface{
  String title; String url; String body;
  
     public PostBD(String title, String url, String body) {
       this.title=title;
       this.body=body;
       this.url=url;
     }
    public String getTitle() {return title;}
    public String getUrl() {return url;}
    public String getBody() {return body;}
}


