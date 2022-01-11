
package shop.Services;
import java.util.List;
import java.util.Scanner;
import shop.Persistence.ManufacturerDAO;
import static shop.Services.ProductService.spaces;
import shop.entities.Manufacturer;


public class ManufacturerService {
    
    public void listManufacturer() throws Exception{
        ManufacturerDAO dao = new ManufacturerDAO();
        try {
            List<Manufacturer> manufacturers = dao.listManufacturer();
            if(manufacturers.isEmpty()){
                throw new Exception("There are no products to print");
            }else{
                System.out.println("Code:\t\t"+ spaces("Name:"));
                for (Manufacturer aux : manufacturers) {
                    System.out.println(aux.getCode()+"\t\t" + aux.getName());
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    
    public void addManufacturer() throws Exception{
        ManufacturerDAO dao = new ManufacturerDAO();
        
        Scanner sc = new Scanner(System.in);
        Manufacturer newManufacturer = new Manufacturer();
        System.out.println("Enter the name of the Manufacturer:");
        newManufacturer.setName(sc.nextLine());
        dao.saveManufacturer(newManufacturer);
        System.out.println("Manufacturer Added SUCCESFULLY!!!");
        
    }

}
