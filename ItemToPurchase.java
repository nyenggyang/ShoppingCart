//Nyeng Gyang

public class ItemToPurchase
{
   private String itemName;
   private int itemPrice;
   private int itemQuantity;
   private String itemDescription;
   
   public ItemToPurchase()
   {
      itemName = "none";
      itemPrice = 0;
      itemQuantity = 0;
      itemDescription = "none";
   }
   
   public ItemToPurchase(String name, String description, int price, int quantity)
   {
      itemName = name;
      itemPrice = price;
      itemQuantity = quantity;
      itemDescription = description;
   }
   
   public void setName(String name)
   {
      itemName = name;
   }
   
   public String getName()
   {
       return itemName;
   }
   
   public void setPrice(int price)
   {
      itemPrice = price;
   }
   
   public int getPrice()
   {
      return itemPrice;
   }
   
   public void setQuantity(int quantity)
   {
      itemQuantity = quantity;
   }
   
   public int getQuantity()
   {
      return itemQuantity;
   }
   
   public void setDescription(String description)
   {
      itemDescription = description;
   }
   
   public String getDescription()
   {
      return itemDescription;
   }
   
   public void printItemCost()
   {
      System.out.println(getName() + " " + getQuantity() + " @ $" + getPrice() + " = $" + (getPrice() * getQuantity()));
   }
   
   public void printItemDescription()
   {
      System.out.println(getName() + ": " + getDescription());   
   }
   
   public boolean equals(ItemToPurchase item)
   {
      boolean equals = false;
      if(this.itemName.equals(item.itemName) &&
         this.itemPrice == item.itemPrice &&
         this.itemQuantity == item.itemQuantity &&
         this.itemDescription.equals(item.itemDescription)) equals = true;
      return equals;
   }
}