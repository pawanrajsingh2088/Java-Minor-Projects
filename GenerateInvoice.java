public class Invoice 
{
    private int item_number;
    private String name;
    private int quantity;
    private double price;
    private double total_cost;
    
    public Invoice(int item_num, String nm, int quan, double pri)
    {
        item_number = item_num;
        name = nm;
        quantity = quan;
        price = pri;
        total_cost = 0;
    }
    
    public int getitem_number()
    {
        return item_number;
    }
    public String getname()
    {
        return name;
    }
    public int getquantity()
    {
        return quantity;
    }
    public double getprice()
    {
        return price;
    }
    public double gettotal_cost()
    {
        return total_cost;
    }  
        
    public void setitem_number( int item_n)
    {
        item_number = item_n;
    }
    public void setname(String n)
    {
        name = n;
    }
    public void setquantity(int quan)
    {
        quantity = quan;
        total();
    }
    public void setprice(double pri)
    {
        price = pri;
        total();
    }
    public void total()
    {
        total_cost = price * quantity;
    } 
    public void displayLine()
    {
        System.out.println("Item Number: "+item_number);
        System.out.println("Name: "+name);
        System.out.println("Quantity: "+quantity);
        System.out.println("Price: "+price);
        System.out.println("Total Cost: "+total_cost);
    } 
}

//-----------------------------------------------------------
import java.util.Scanner;
public class InvoiceDriver {
 
    public static void main(String[] args) {
        
      Invoice check1 = new Invoice(112, "Book", 3, 125.98);
      Invoice check2 = new Invoice(101, "Phone", 2, 456.35);
      Invoice check3 = new Invoice(187, "Laptop", 1, 2345.68);
      
      items(check1,check2, check3);
    }
    
    public static void items(Invoice chk1, Invoice chk2, Invoice chk3)
    {
        Scanner sn = new Scanner(System.in);
        //-----------------------------------------------------------
        System.out.println("Please enter Item Number: ");
        chk1.setitem_number(sn.nextInt());
        
        System.out.println("Please enter Item Name: ");
        chk1.setname(sn.next());
        
        System.out.println("Please enter quantity: ");
        chk1.setquantity(sn.nextInt());
        
        System.out.println("Please enter price: ");
        chk1.setprice(sn.nextDouble());
        //-----------------------------------------------------------
        
        //-----------------------------------------------------------
        System.out.println("Please enter Item Number: ");
        chk2.setitem_number(sn.nextInt());
        
        System.out.println("Please enter Item Name: ");
        chk2.setname(sn.next());
        
        System.out.println("Please enter quantity: ");
        chk2.setquantity(sn.nextInt());
        
        System.out.println("Please enter price: ");
        chk2.setprice(sn.nextDouble());
        //-----------------------------------------------------------
        
        //-----------------------------------------------------------
        System.out.println("Please enter Item Number: ");
        chk3.setitem_number(sn.nextInt());
        
        System.out.println("Please enter Item Name: ");
        chk3.setname(sn.next());
        
        System.out.println("Please enter quantity: ");
        chk3.setquantity(sn.nextInt());
        
        System.out.println("Please enter price: ");
        chk3.setprice(sn.nextDouble());
        //-----------------------------------------------------------
        
        chk1.displayLine();
        chk2.displayLine();
        chk3.displayLine();
    }
    
}


