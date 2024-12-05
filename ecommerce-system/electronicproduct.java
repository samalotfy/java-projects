package ecommercesystem;


public class ElectronicProduct extends Product {
     private String brand;
   private int warrantyPeriod;
  
    void setbrand(String brand){
        this.brand=brand;
    }
    void setwarrantyperiod(int warrantyPeriod){
        this.warrantyPeriod=Math.abs(warrantyPeriod);
    }
    public String getbrand(){
        return brand;
    }
    public int getwarrantyperiod(){
        return warrantyPeriod;
    }
}
