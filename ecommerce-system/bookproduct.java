package ecommercesystem;


public class BookProduct extends Product {
    
  private String author;
    private String publisher;
      void setauthor(String author){
        this.author=author;
    }
        void setpublisher(String publisher){
        this.publisher=publisher;
    }
     public String getauthor(){
        return author;
    }
      public String getpublisher(){
        return publisher;
    }   
}
