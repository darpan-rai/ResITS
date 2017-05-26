

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Darpan
 */
public class Item 
{
    private String itemName;                    //name of the item
    private String itemInfo;                    //item inforamtion e.g. allergy information
    private String itemPrice;                   //item price
    
    /**
     * Item Constructor
     */
    public Item()
    {
        this.itemName = new String();
        this.itemInfo = new String();
        this.itemPrice = new String();
    }

    /**
     * This method sets the name of the item to the item object.
     * @param itemName name of the item.
     */
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }
    /**
     * This method sets the item information to the item object.
     * @param itemInfo item information
     */
    public void setItemInfo(String itemInfo)
    {
        this.itemInfo = itemInfo;
    }
    /**
     * This method sets the item price to the item object.
     * @param itemPrice item price
     */
    public void setItemPrice(String itemPrice) 
    {
        this.itemPrice = itemPrice;
    }
    /**
     * This method returns the name of the item object.
     * @return item name
     */
    public String getItemName()
    {
        return itemName;
    }
    /**
     * This method returns the information of the item object.
     * @return item information
     */
    public String getItemInfo()
    {
        return itemInfo;
    }
    /**
     * This method returns the price of the item object.
     * @return item price
     */
    public String getItemPrice()
    {
        return itemPrice;
    }
    
    @Override
    public String toString()
    {
        return itemName;
    }
}
