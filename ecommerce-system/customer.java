
package ecommercesystem;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    void setcustomerid(int customerId){
        this.customerId=Math.abs(customerId);
    }
    public int getcustomerid(){
        return customerId;
    }
        void setname(String name){
        this.name=name;
    }
     public String getname(){
        return name;
    }
         void setaddress(String address){
        this.address=address;
    }
     public String getaddress(){
        return address;
    }  
}
