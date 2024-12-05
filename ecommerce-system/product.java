
package ecommercesystem;


public class Product {
     private int productId;
   private String name;
   private double price;
   
     void setproductId(int productId){
        this.productId=Math.abs(productId);
    }
     void setname(String name){
         this.name=name;
     }
     void setprice(double price){
         this.price=Math.abs(price);
     }
    public int getproductId(){
        return productId;
    }
     public String getname(){
        return name;
    }
     public double getprice(){
         return price;
     } 
}
