
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Darpan
 */
public class Order 
{
    private String orderNo;
    private String tableNo;
    private List<Item> orderList;
    private boolean isActive = false;
    private String total;
    
    /**
     * Constructor of the order
     * @param orderNo order number of the current active order
     * @param tableNo table number of the current active order
     */
    public Order(String orderNo, String tableNo)
    {
        this.orderNo = orderNo;
        this.tableNo = tableNo;
        this.orderList = new ArrayList<>();
    }
    /**
     * This method sets the generated order number to the new order object that was created. 
     * @param str order number
     */
    public void setOrderNo(String str)
    {
        this.orderNo = str;
    }
    /**
     * This method returns the order number of the order.
     * @return order number
     */
    public String getOrderNo()
    {
        return orderNo;
    }
    
    /**
     * This method sets the table number to the new order object that was created.
     * @param str table number
     */
    public void setTableNo(String str)
    {
        this.tableNo = str;
    }
    /**
     * This method returns the table number of the order
     * @return table number
     */
    public String getTableNo()
    {
        return tableNo;
    }
    /**
     * This method adds the item object created in the Control class to the order list
     * @param i item object
     */
    public void addItem(Item i)
    {
        //Item odrItm = new Item();
        /*for(Category cat: Control.getCatList())
        {
            for(Item i: cat.getCatItems())
            {
                if(itm.getItemName().equals(i.getItemName()))
                {
                    odrItm.setItemName(itm.getItemName());
                    odrItm.setItemInfo(itm.getItemInfo());
                    odrItm.setItemPrice(itm.getItemPrice());
                    
                    orderList.add(odrItm);
                }
            }
        }*/
        //odrItm.setItemName(name);
        //odrItm.setItemInfo(info);
        //odrItm.setItemPrice(price);

        orderList.add(i);
        
    }
    /**
     * This method returns the order list of the order object
     * @return order list
     */        
    public List<Item> getOrderList()
    {
        return orderList;
    }
    /**
     * This method calculates the total amount of the order.
     */
    public void setTotal()
    {
        float subTotal = 0.0f;
        for(Item itm: orderList)
        {
            subTotal = subTotal + Float.valueOf(itm.getItemPrice());
        }
        this.total = Float.toString(subTotal);
    }
    /**
     * This method returns the total amount owed by the customer to the restaurant
     * @param tableNo 
     * @return the total amount
     */
    public String getTotal(String tableNo)
    {
        return total;
    }
    /**
     * not sure
     * @return 
     */
    public Boolean getOrderStatus()
    {
        return isActive;
    }
    /**
     * not sure
     */
    public void setOrderStatusTrue()
    {
        this.isActive = true;
    }
    /**
     * not sure
     */
    public void setDefaultOrderStatus()
    {
        this.isActive = false;
    }
    
    @Override
    public String toString()
    {
        return tableNo.concat(", ").concat(orderNo);
        //return name;
    }
}
