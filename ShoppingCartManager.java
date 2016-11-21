//Nyeng Gyang

import java.util.Scanner;
public class ShoppingCartManager
{
   static Scanner kbdInput = new Scanner(System.in);
   public static void main(String[] cmdLineArgs)
   {
      System.out.println("Enter Customer's Name: ");
      String custName = kbdInput.nextLine();
      System.out.println("Enter Today's Date: ");
      String date = kbdInput.nextLine();
      System.out.println("Customer Name: " + custName);
      System.out.println("Today's Date: " + date);      
      System.out.println();
      ShoppingCart shoppingCart = new ShoppingCart(custName, date);
      printMenu(shoppingCart);
   }
   
   public static void printMenu(ShoppingCart cart)
   {
      String userChoice;
      do
      {
         System.out.println("MENU");
         System.out.println("a - Add item to cart");
         System.out.println("d - Remove item from cart");
         System.out.println("c - Change item quantity");
         System.out.println("i - Output items' descriptions");
         System.out.println("o - Output shopping cart");
         System.out.println("q - Quit\n");         
         System.out.println("Choose an option: "); 
                    
         do
         {  
            userChoice = kbdInput.nextLine();
            if(!(userChoice.equals("a") || userChoice.equals("d") || userChoice.equals("c") || userChoice.equals("i") || userChoice.equals("o") || userChoice.equals("q")))
            { 
               System.out.println("Choose an option: ");
            }
         }while(!(userChoice.equals("a") || userChoice.equals("d") || userChoice.equals("c") || userChoice.equals("i") || userChoice.equals("o") || userChoice.equals("q")));
         
         if(userChoice.equals("o"))
         {
            System.out.println("OUTPUT SHOPPING CART");
            cart.printTotal();      
            System.out.println();
         }
         else if(userChoice.equals("i"))
         {
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            cart.printDescriptions();
            System.out.println();
         }
         else if(userChoice.equals("a"))
         {
            System.out.println("ADD ITEM TO CART");         
            System.out.println("Enter the item name: ");
            String name = kbdInput.nextLine();
            System.out.println("Enter the item description: ");
            String description = kbdInput.nextLine();
            System.out.println("Enter the item price: ");
            int price = kbdInput.nextInt();
            System.out.println("Enter the item quantity: ");
            int quantity = kbdInput.nextInt();         
            ItemToPurchase item = new ItemToPurchase(name, description, price, quantity);
            cart.addItem(item);
            kbdInput.nextLine();
            System.out.println();            
         }
         else if(userChoice.equals("d"))
         {
            System.out.println("REMOVE ITEM FROM CART");
            System.out.println("Enter name of item to remove: ");
            cart.removeItem(kbdInput.nextLine());
            System.out.println();      
         }
         else if(userChoice.equals("c"))
         {
            System.out.println("CHANGE ITEM QUANTITY");
            System.out.println("Enter the item name: ");
            String name = kbdInput.nextLine();        
            System.out.println("Enter the new quantity: ");
            int quantity = kbdInput.nextInt();
            ItemToPurchase item = new ItemToPurchase(name, "", -1, quantity);
            cart.modifyItem(item);
            kbdInput.nextLine();
            System.out.println();
         }               
      }while(!userChoice.equals("q"));
   }   
}