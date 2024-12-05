
package ecommercesystem;


public class ClothingProduct extends Product{
  private String size;
    private String fabric;
      void setsize(String size){
        this.size=size;
    }
        void setfabric(String fabric){
        this.fabric=fabric;
    }
     public String getsize(){
        return size;
    }
      public String getfabric(){
        return fabric;   
}
}
