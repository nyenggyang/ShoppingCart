//Nyeng Gyang

import java.util.ArrayList;
public class ShoppingCart
{
   private String customerName;
   private String currentDate;
   private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
   
   public ShoppingCart()
   {
      customerName = "none";
      currentDate = "January 1, 2016";
   }
   
   public ShoppingCart(String name, String date)
   {
      customerName = name;
      currentDate = date;
   }
   
   public String getCustomerName()
   {
      return customerName;
   }
   
   public String getDate()
   {
      return currentDate;
   }
   
   public void addItem(ItemToPurchase item)
   {
      cartItems.add(item);
   }
   
   public void removeItem(String name)
   {
      boolean found = false;
      for(int i = 0; i < cartItems.size(); i++)
      {
         if(name.equals(cartItems.get(i).getName()))
         {
            found = true;
            cartItems.remove(i);            
            break;
         }
      }
      if(!found) System.out.println("Item not found in cart. Nothing removed.");
   }
   
   public void modifyItem(ItemToPurchase item)
   {
      boolean found = false;
      for(int i = 0; i < cartItems.size(); i++)
      {
         if(item.getName().equals(cartItems.get(i).getName()))
         {
            found = true;
            if(!(item.getDescription().equals("none") || item.getPrice() == 0 || item.getQuantity() == 0))
            {
               cartItems.get(i).setQuantity(item.getQuantity());
            }            
            break;
         }
      }
      if(!found) System.out.println("Item not found in cart. Nothing modified.");
   }
   
   public int getNumItemsInCart()
   {
      int totalItems = 0;
      for(int i = 0; i < cartItems.size(); i++)
      {
         totalItems = totalItems + cartItems.get(i).getQuantity();
      }
      return totalItems;
   }
   
   public int getCostOfCart()
   {
      int totalCost = 0;
      for(int i = 0; i < cartItems.size(); i++)
      {
         totalCost = totalCost + cartItems.get(i).getPrice() * cartItems.get(i).getQuantity();
      }
      return totalCost;
   }
   
   public void printTotal()
   {
      System.out.println(customerName + "'s Shopping Cart - " +  currentDate);
      System.out.println("Number of Items: " +  getNumItemsInCart() + "\n");
      if(cartItems.size() == 0)
      {
         System.out.println("SHOPPING CART IS EMPTY");
      }  
      else
      {         
         for(int i = 0; i < cartItems.size(); i++)
         {
            cartItems.get(i).printItemCost();
         }
      }
      System.out.println("\nTotal: $" + getCostOfCart());
   }
   
   public void printDescriptions()
   {
      System.out.println(customerName + "\'s Shopping Cart - " +  currentDate);
      System.out.println("\nItem Descriptions");
      for(int i = 0; i < cartItems.size(); i++)
      {
         cartItems.get(i).printItemDescription();
      }
   }
}