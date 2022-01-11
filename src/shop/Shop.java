
package shop;

import java.util.InputMismatchException;
import shop.Services.MenuService;


public class Shop {

    
    public static void main(String[] args) throws Exception {
         MenuService newMenu = new MenuService();
        try {
             newMenu.Menu();
        } catch (InputMismatchException ex) {
            System.out.println("Error: "+ex.toString());
     main(args);
          
            
        }

    }
    
}
