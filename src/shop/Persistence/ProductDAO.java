
package shop.Persistence;



import java.util.ArrayList;
import java.util.List;
import shop.entities.Product;

public class ProductDAO extends DAO{
    
    public void saveProduct(Product product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("Must indicate product");
            }

            String sql = "INSERT INTO product (code, name, price, code_manufacturer)"
                    + "VALUES ( '" +product.getCode()+ "' , '" + product.getName()+ "', '" + product.getPrice()+ "', '" + product.getCodeManufacturer()+ "' );";

            insertEditDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectBase();
        }
    }

    public void editProduct(Product product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("You must indicate the product you wish to modify");
            }

            String sql = "UPDATE product SET name = '" + product.getName()+ "',price='"+product.getPrice()+"',code_manufacturer='"+product.getCodeManufacturer()+"' WHERE code = '" + product.getCode()+"';";

            insertEditDelete(sql);
            System.out.println("Product modified SUCCESSFULLY!!!!!");
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectBase();
        }
    }
    
     public void deleteProduct(Integer id) throws Exception {
        try {

            String sql = "DELETE FROM product WHERE code = '" + id + "'";

            insertEditDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectBase();
        }
    }


    public Product findProductById(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM product "
                    + " WHERE code = '" + id + "'";
            consultBase(sql);
           Product product = null;
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setCodeManufacturer(result.getInt(4));
                
                
            }
            disconnectBase();
            return product;
        } catch (Exception e) {
            disconnectBase();
            throw e;
        }
    }

    public List<Product> listNameProducts() throws Exception {
        try {
                      
            String sql = "SELECT name FROM product";
            consultBase(sql);
            Product product = null;
            List<Product> products = new ArrayList<>();
            
            while (result.next()) {
                product = new Product();
                product.setName(result.getString(2));
                products.add(product);
            }
            disconnectBase();
            return products;
        } catch (Exception e) {
            disconnectBase();
            throw e;
        }
    }
    
    public List<Product> listProducts() throws Exception {
        try {
                      
            String sql = "SELECT * FROM product";
            consultBase(sql);
            Product product = null;
            List<Product> products = new ArrayList<>();
            
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setCodeManufacturer(result.getInt(4));
                products.add(product);
            }
            disconnectBase();
            
            return products;
            
        } catch (Exception e) {
            
            disconnectBase();
            throw e;
        }
    }
    
    public List<Product> listPriceRange() throws Exception {
        try {
                      
            String sql = "SELECT * FROM product WHERE price BETWEEN 120 AND 202";
            consultBase(sql);
            Product product = null;
            List<Product> products = new ArrayList<>();
            
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setCodeManufacturer(result.getInt(4));
                products.add(product);
            }
            disconnectBase();
            return products;
        } catch (Exception e) {
            disconnectBase();
            throw e;
        }
    }
    public List<Product> listPortable() throws Exception {
        try {
                      
            String sql = "SELECT * FROM product WHERE name LIKE \"Port%\"";
            consultBase(sql);
            Product product = null;
            List<Product> products = new ArrayList<>();
            
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setCodeManufacturer(result.getInt(4));
                products.add(product);
            }
            disconnectBase();
            return products;
        } catch (Exception e) {
            disconnectBase();
            throw e;
        }
    }
    
    public List<Product> listCheapestProduct() throws Exception {
        try {
                      
            String sql = "SELECT * FROM product ORDER BY price ASC LIMIT 1";
            consultBase(sql);
            Product product = null;
            List<Product> products = new ArrayList<>();
            
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setCodeManufacturer(result.getInt(4));
                products.add(product);
            }
            disconnectBase();
            return products;
        } catch (Exception e) {
            disconnectBase();
            throw e;
        }
    }


}
