
package ecommercesystem;

import java.util.Scanner;

public class Ecommercesystem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ordersCount = 1;
        ElectronicProduct smartphone = new ElectronicProduct();      
        smartphone.setproductId(1);
       smartphone.setprice(599.9);
        smartphone.setbrand("Samsung");
        smartphone.setwarrantyperiod(1);
        smartphone.setname("smartphone");
        
        ClothingProduct tshirt= new ClothingProduct();       
        tshirt.setproductId(2);
        tshirt.setsize("medium");
        tshirt.setfabric("cotton");
        tshirt.setprice(19.99);
        tshirt.setname("tshirt");
        
        BookProduct oop = new BookProduct();     
        oop.setproductId(3);
        oop.setprice(39.99);
        oop.setauthor("o reilly");
        oop.setpublisher("x publication");
        oop.setname("OOP");
        
        Customer s = new Customer();
        System.out.println("welcome to the e-commerce system!");
        System.out.println("please enter your id");
        int id=in.nextInt();
        s.setcustomerid(id);
        System.out.println("please enter your name");
        String name=in.next();
        s.setname(name);
        System.out.println("please enter your address");
        String address= in.next();
        s.setaddress(address);
        
        System.out.println("how many products do you want to order");
        int nproducts=in.nextInt(); 
        Cart cart = new Cart(id,nproducts);
     
        for(int i=0 ; i<nproducts;i++){
            System.out.println("which product would you like to add? 1- Smartphone 2- T-Shirt 3- OOP");  
             int type = in.nextInt();
            
             switch(type){
                 case 1: 
                     cart.addproduct(smartphone);
                     break;
                 case 2:
                     cart.addproduct(tshirt);
                     break;
                 case 3:
                     cart.addproduct(oop);
                     break;
                 default: 
                    System.out.println("invalid product");
                    i--;               
             }
        }    
   
       
        System.out.println("total is "+ cart.calculatePrice()+" do you want to place your order? 1- yes 2- no");
       
       int n = in.nextInt();
     switch (n) {
       case 1:
       cart.placeorder(ordersCount++);
        break;
       case 2:
         System.out.println("Thank You! ");
         break;
       default:
         System.out.println("Invalid Choice! ");
         break;
     }
     
    }
    
}
