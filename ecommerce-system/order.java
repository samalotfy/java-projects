
package ecommercesystem;

public class order {
     private int customerid;
   private int orderid;
   private int nproducts;
  private  Product [] products= new Product [nproducts];
    private float totalprice;
    private Cart c;
    order(Cart c, int orderid, double totalprice) {
    this.orderid = orderid;
    this.c = c;
    this.totalprice = this.c.calculatePrice();
  }
     
      void setcustomerid(int customerid){
            this.customerid=Math.abs(customerid);
        }
      void setcart(Cart c){
          this.c=c;
      }
      void setorderid(int orderid){
            this.orderid=Math.abs(orderid);
        }
       void setnproducts(int nproducts){
            this.nproducts=nproducts;
        }
        void setproducts(Product[] products){
            this.products=products;
        }
        void settotalprice(float totalprice){
            this.totalprice=Math.abs(this.c.calculatePrice());
        }
      
      public int getcustomerid(){
            return customerid;
        }
      public Cart getcart(){
          return c;
      }
       public int getorderrid(){
            return orderid;
        }
        public int getnproducts(){
            return nproducts;
        }
        public Product [] getproducts(){
            return products;
        }
        public float gettotalprice(){
            return totalprice;
        }
    
    public void printorderinfo(){
        System.out.println("here is your order summary : ");
        System.out.println("order id : "+ orderid);
        System.out.println("customer id : "+c.getcustomerid());
        System.out.println("products:");
 
        for (int i=0 ;i<c.getnproducts();i++){
            System.out.println(c.getproducts()[i].getname()+" - $"+c.getproducts()[i].getprice());  
        }  
        System.out.println("total price: "+c.calculatePrice());
    }
    
  
}
