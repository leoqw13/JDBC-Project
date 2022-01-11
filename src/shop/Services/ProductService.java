
package shop.Services;



import java.util.List;
import java.util.Scanner;
import shop.Persistence.ProductDAO;
import shop.entities.Product;


public class ProductService {

    public ProductService() {
    }
    
        
    public void listNameProducts() throws Exception{
        ProductDAO dao = new ProductDAO();
        try {
            List<Product> products = dao.listProducts();
            if(products.isEmpty()){
                throw new Exception("There are not products to print");
            }else{
                System.out.println("Product Name: ");
                for (Product aux : products) {
                    System.out.println(aux.getName());
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
     public void listCodeNameProducts() throws Exception{
        ProductDAO dao = new ProductDAO();
        try {
            List<Product> products = dao.listProducts();
            if(products.isEmpty()){
                throw new Exception("There are not products to print");
            }else{
                System.out.println("Code:\t\t"+spaces("Name:"));
                for (Product aux : products) {
                    System.out.println(aux.getCode()+"\t\t" + aux.getName());
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    public void listNamePriceProducts() throws Exception{
        ProductDAO dao = new ProductDAO();
        try {
            List<Product> products = dao.listProducts();
            if(products.isEmpty()){
                throw new Exception("There are not products to print");
            }else{
                System.out.println(spaces("Product name:")+spaces("Price:"));
                for (Product aux : products) {
                    System.out.println(spaces(aux.getName()) +"$ "+ aux.getPrice());
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    
    public void listPricesRange() throws Exception{
        ProductDAO dao = new ProductDAO();
        try {
            List<Product> products = dao.listPriceRange();
            if(products.isEmpty()){
                throw new Exception("There are not products to print");
            }else{
                System.out.println("Code:\t\t"+ spaces("Product name:")+spaces("Price:")+spaces("Manufacturer Code:"));
                for (Product aux : products) {
                    System.out.println(aux.getCode()+"\t\t"+ spaces(aux.getName()) +"$ "+ spaces(String.valueOf(aux.getPrice()))+spaces(String.valueOf(aux.getCodeManufacturer())));
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    
    public void listPortable() throws Exception{
        ProductDAO dao = new ProductDAO();
        try {
            List<Product> products = dao.listPortable();
            if(products.isEmpty()){
                throw new Exception("There are not products to print");
            }else{
                System.out.println("Code:\t\t"+ spaces("Product Name:")+spaces("Price:")+spaces("Manufacturer Code:"));
                for (Product aux : products) {
                    System.out.println(aux.getCode()+"\t\t"+ spaces(aux.getName()) +"$ "+ spaces(String.valueOf(aux.getPrice()))+spaces(String.valueOf(aux.getCodeManufacturer())));
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    public void listCheapestProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        try {
            List<Product> products = dao.listCheapestProduct();
            if(products.isEmpty()){
                throw new Exception("There are not products to print");
            }else{
                System.out.println("Code:\t\t"+ spaces("Product Name:")+ spaces("Price:")+ spaces("Manufacturer Code:"));
                for (Product aux : products) {
                    System.out.println(aux.getCode()+"\t\t"+ spaces(aux.getName()) +"$ "+ spaces(String.valueOf(aux.getPrice()))+spaces(String.valueOf(aux.getCodeManufacturer())));
            }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
    } 
    
    public void addProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        ManufacturerService manufacturer = new ManufacturerService();
        Scanner sc = new Scanner(System.in);
        Product newProduct = new Product();
        System.out.println("Enter the product name:");
        newProduct.setName(sc.nextLine());
        System.out.println("Enter the product price:");
        newProduct.setPrice(sc.nextDouble());
        System.out.println("Enter the manufacturer code: ");
        manufacturer.listManufacturer();
        newProduct.setCodeManufacturer(sc.nextInt());sc.nextLine();
        dao.saveProduct(newProduct);
        System.out.println("Product added SUCCESFULLY!!!");
        
    }
    
    public void deleteProduct() throws Exception{
         ProductDAO dao = new ProductDAO();
         ManufacturerService manufacturer = new ManufacturerService();
         Scanner sc = new Scanner(System.in);
         System.out.println("Choose the product code to remove:");
        listCodeNameProducts();
        dao.deleteProduct(sc.nextInt()); sc.nextLine();
    }
    public void editProduct() throws Exception{
        ProductDAO dao = new ProductDAO();
        ManufacturerService manufacturer = new ManufacturerService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the product code to modify:");
        listCodeNameProducts();
        Product newProduct = dao.findProductById(sc.nextInt());sc.nextLine();
        System.out.println("Do you wish to change the name? y/n");
        String option = sc.nextLine().toUpperCase();
        if(option.equals("Y")){
            System.out.println("Enter the new name:");
            newProduct.setName(sc.nextLine());
        }
        System.out.println("Do you wish to change the price? y/n");
        option = sc.nextLine().toUpperCase();
        if(option.equals("Y")){
            System.out.println("Enter the new price:");
            newProduct.setPrice(sc.nextDouble());
            sc.nextLine();
        }
        System.out.println("Do you wish to change the manufacturer code? y/n");
        option = sc.nextLine().toUpperCase();
        if(option.equals("Y")){
            System.out.println("Choose the manufacturer's code:");
            manufacturer.listManufacturer();
            newProduct.setCodeManufacturer(sc.nextInt());sc.nextLine();
        }
        dao.editProduct(newProduct);
        
    }
    
    public static String spaces(String string){
        int nSpaces = 40-string.length();
        for (int i = 0; i < nSpaces; i++) {
            string +=" ";
        }
        return string;
    }

}
