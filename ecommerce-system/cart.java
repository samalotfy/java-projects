
package ecommercesystem;


public class Cart {
      private int customerid;;
      private  int nproducts;
       private Product[] products;
       Cart(int customerid, int nproducts) {
    this.customerid =Math.abs(customerid) ;
    this.nproducts = Math.abs(nproducts);
    this.products = new Product[nproducts];
    
  }
        void setcustomerid(int customerid){
            this.customerid=customerid;
        }
        void setnproducts(int nproducts){
            this.nproducts=nproducts;
        }
        void setproducts(Product[] products){
            this.products=products;
        }
        public int getcustomerid(){
            return customerid;
        }
        public int getnproducts(){
            return nproducts;
        }
        public Product [] getproducts(){
            return products;
        }
      public void addproduct(Product s){
         for (int i=0;i<products.length;i++){
              if (products[i]==null){
                 products[i]=s;
                 break;
             }
          }
      }
  
      public void removeProduct(Product s){
          for (int i=0;i<products.length;i++)
          if (products[i]==s) {
              products[i]=null;
          }
      }
      public float calculatePrice(){
         float totalprice=0;
          for (int i =0; i<products.length; i++){
          totalprice+=products[i].getprice()  ;
              }
 return totalprice;  
      }
      
   public void placeorder(int orderid){     
    order o = new order(this ,orderid, this.calculatePrice());
    o.printorderinfo();
  }  
}
