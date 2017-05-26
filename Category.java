
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Darpan
 */
public class Category 
{
    private String catName;              //name of the category
    private List<Item> catItems = new ArrayList<>();    //list of items in this category
    
    
    public Category()
    {
        
    }
    /**
     * The constructor of the Category object.
     * @param str name of the category
     */
    public Category(String str)
    {
        this.catName = str;
    }
    
    
    /**
     * This method returns the category name.
     * @return catName
     */
    public String getCatName() 
    {
        return catName;
    }
    
       
    @Override
    public String toString()
    {
        return catName;
    }
    
    /**
     * This method sets the name of the category to the object while remaning.
     * @param str name of the category
     */
    public void setCatName(String str)
    {
        this.catName = str;
    }
    
    /**
     * This method returns the list of Items contained in the Category.
     * @return catItem
     */
    public List<Item> getCatItems() 
    {
        return catItems;
    }

    
    /**
     * This method set the details of each Items that would be added to the catItems ArrayList.
     * @param name: name of the Items
     * @param info: additional information of this Item e.g. allergy information
     * @param price: price of the Item
     */
    public void setCatItem(String name, String info, String price) 
    {
        Item itm = new Item();
        
        itm.setItemName(name);
        itm.setItemInfo(info);
        itm.setItemPrice(price);
        
        catItems.add(itm);
        
    }
    
    public void removeItem(String iName)
    {
        for( Item i : catItems)
        {
            if(i.getItemName().equals(iName))
                catItems.remove(i);
        }
    }
    
    
}
