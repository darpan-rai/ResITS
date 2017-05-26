
import javax.swing.JToggleButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Darpan
 */
public class CategoryBtn extends JToggleButton 
{
    private String catName;
    
    
    public CategoryBtn(String str)
    {
        super(str);
        this.setFont(this.getFont().deriveFont(20.0f));
        
        this.catName = str;
    }
    
    public String getCatName()
    {
        return catName;
    }

     
    
}
