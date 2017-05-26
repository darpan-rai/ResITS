
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Darpan
 */
public final class Control 
{
    private static List<Category> categoryList = new ArrayList<>();
    private static int noOfTables;
    private static String tableNo;
    private static List<Order> activeOrderList = new ArrayList<>();
    private static List<Order> orderHistoryList = new ArrayList<>();
    private static String orderNo;
    private static List<Item> currentOrder; //not sure
    private static boolean isActive = false;
    private static String total = "0";
    
    private Control()
    {
    
    }
    /**
     * This method adds a category by creating a Category Object adding it to the categoryList ArrayList 
     * @param str is the name of the category that the user has entered
     */
    public static void addCategory(String str)
    {
        Category cat = new Category(str);
        
        categoryList.add(cat);
    }
    
    
    /**
     * This method returns the ArrayList containing the category objects
     * @return categoryList
     */
    public static List<Category> getCatList()
    {
        return categoryList;
    }
    
    public static void main(String[] args)
    {
        MainFrame.main(null);
    }
    /**
     * This method is required when the user is setting up the software for reqular use.
     * It allows the user to set a total number of tables in the restaurant.
     * @param str the total number of tables provided by the user.
     */
    public static void setNoOfTables(String str)
    {
        noOfTables = Integer.parseInt(str);
    }
    /**
     * This method returns the total number of tables the user has entered at the time of setup.
     * 
     * @return the number of tables the user has entered at the time of setup 
     */
    public static int getNoOfTables()
    {
        return noOfTables;
    }
    /**
     * This methods sets the order as a takeaway order rather than an eat-in order.
     */
    public static void setTakeAway()
    {
        tableNo = "TA";
    }
    /**
     * This method returns the table number the user had entered at the time of taking a new order.
     * @return the table number the user had entered at the time of taking a new order.
     */
    public static String getTableNo()
    {
        return tableNo;
    }
    
    /**
     * This method sets a table number the user enters at the time of taking a new order.
     * @param str table number the user has supplied
     */
    public static void setTableNo(String str)
    {
        tableNo = str;
        
    }
    /**
     * This method allow the users to rename their menu categories.
     * @param str1 old name of the category
     * @param str2 new name of the category
     */
    public static void editCategory(String str1, String str2)
    {
        for (Category cat: categoryList)
        {
            if(cat.getCatName().equals(str1))
            {
                cat.setCatName(str2);
                
                break;
            }
        }
    }
    /**
     * This method allow the users to remove a category from the system
     * @param str the category the user wishes to remove
     */
    public static void removeCategory(String str)
    {
        for (Category cat: categoryList)
        {
            if(cat.getCatName().equals(str))
            {
                categoryList.remove(cat);
                
                break;
            }
        }
    }
    /**
     * This method generates an Order Number for a new order
     * @param tableNo table number of the customer
     */
    public static void setOrderNo(String tableNo)
    {
        String dateTime;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String fDate = Integer.toString(day).concat(Integer.toString(month));
        
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        
        String fTime = Integer.toString(hour).concat(Integer.toString(minute));
        
        dateTime = fDate.concat(fTime);
        
        orderNo = getTableNo().concat(dateTime);
        
        //new order object created
        Order odr = new Order(orderNo, tableNo);
        odr.setOrderStatusTrue();
        activeOrderList.add(odr);
        
    }
    /**
     * This method returns the Order Number
     * @return order number
     */
    public static String getOrderNo()
    {
        return orderNo;
    }
    
    /**
     * This method returns the list of orders in the Active order list
     * @return active order list
     */
    public static List<Order> getActiveOrderList()
    {
        return activeOrderList;
    }
     
    /**
     * This method makes changes to the items in the menu according to the user's wishes
     * @param catName category name of the item
     * @param itmName1 old name of the item
     * @param itmName2 new name of the item
     * @param itmInfo new information about the item
     * @param Price new price of the item
     */
    public static void editItem(String catName, String itmName1, String itmName2, String itmInfo, String Price)
    {
        for(Category cat: categoryList)
        {
            if(catName.equalsIgnoreCase(cat.getCatName()))
            {
                for(Item i: cat.getCatItems())
                {
                    if(itmName1.equalsIgnoreCase(i.getItemName()))
                    {
                        i.setItemName(itmName2);
                        i.setItemInfo(itmInfo);
                        i.setItemPrice(Price);
                    }
                    System.out.println(i.getItemName()+"\n"+i.getItemInfo()+"\n"+i.getItemPrice());
                }
            }
            System.out.println("Category items in "+cat.getCatName()+": "+cat.getCatItems());
        }
        
    }
    /**
     * This method removes the item from the item list of the category selected by the user.
     * @param catName
     * @param itmName 
     */
    public static void removeItem(String catName, String itmName)
    {
        for (Category cat: categoryList)
        {
            if(cat.getCatName().equals(catName))
            {
                cat.removeItem(itmName);
                System.out.println("updated item list in: "+cat.getCatName()+"..."+cat.getCatItems());
                break;
            }
        }
    }
    
    
    public static void addItem(String cName, String iName, String iInfo, String iPrice)
    {
        for (Category cat: categoryList)
        {
            if (cName.equals(cat.getCatName()))
            {
                cat.setCatItem(iName, iInfo, iPrice);
                System.out.println("Items in "+cat.getCatName()+" category are: "+cat.getCatItems());

                break;
            }

        }
    }
    /**
     * This method sets the current status of the terminal as true.  It denotes
     * that the terminal is currently in the process of taking an order, and therefore
     * no other orders can be taken until this current task is completed.
     */
    public static void setActive()
    {
        isActive = true;
    }
    
    /**
     * This method returns the boolean value of the status of the terminal.
     * @return the boolean value of isActive.
     */
    public static boolean getIsActive()
    {
        return isActive;
    }
    /**
     * This order returns the item list of the current active order
     * @param tableNo table number of the currently active order
     * @param orderNo order number of the currently active order
     * @return orderlist of the curretnly active order.
     */
    public static List<Item> getOrderList(String tableNo, String orderNo)
    {
        for(Order o : activeOrderList)
        {
            if(o.getOrderNo().equals(orderNo) && o.getTableNo().equals(tableNo))
            {
                return o.getOrderList();
            }
        }
        return null;
    }
    /**
     * This method creates a new order.
     * @param tableNo table number of the new order
     * @param orderNo order number of the new order
     */
    public static void createOrder(String tableNo, String orderNo)
    {
        Order o = new Order(tableNo, orderNo);
        activeOrderList.add(o);
    }
    /**
     * This method adds the selected item to the item list in the order
     * @param i the item that was selected
     */
    public static void addItem(Item i)
    {
        Item itm = new Item();
        itm.setItemInfo(i.getItemInfo());
        itm.setItemName(i.getItemName());
        itm.setItemPrice(i.getItemPrice());
        
        for(Order o: activeOrderList)
        {
            if(o.getOrderNo().equalsIgnoreCase(orderNo) && o.getTableNo().equalsIgnoreCase(tableNo))
            {
                o.addItem(itm);
            }
        }
    }
    
    /**
     * This method creates a list where the items of new orders would be stored temporarily. 
     */
    public static void newOrderCurrentOrder()
    {
        currentOrder = new ArrayList<Item>();
    }
    /**
     * This method adds the selected item to the temporary list named currentOrder.
     * @param i 
     */
    public static void currentOrderAddItem(Item i)
    {
        /*Item itm = new Item();
        itm.setItemInfo(i.getItemInfo());
        itm.setItemName(i.getItemName());
        itm.setItemPrice(i.getItemPrice());*/
        Item itm = i;
        
        currentOrder.add(itm);
    }
    /**
     * This method creates an order in the activeOrder list and migrates every 
     * item in the temporary list to this new order and empties the temporary list.
     * @param tableNo
     * @param orderNo 
     */
    public static void migrateOrder(String tableNo, String orderNo)
    {
        createOrder(tableNo, orderNo);
        
        for(Item i: currentOrder)
        {
            addItem(i);
        }
        
        currentOrder.clear();
    }
    /**
     * This method returns the Items in the currentOrder(temporary list)
     */
    public static List<Item> getTemporaryList()
    {
        return currentOrder;
    }
    /**
     * This method calculates the total of the current order and returns to the 
     * console to display.
     * @param itmList
     * @return 
     */
    public static String calculateTotal(List<Item> itmList)
    {
        double t = 0.00d;
        for(Item i: itmList)
        {
             t = t + Double.parseDouble(i.getItemPrice());
            
        }    
        total = Double.toString(t);
        return total;
    }
}
