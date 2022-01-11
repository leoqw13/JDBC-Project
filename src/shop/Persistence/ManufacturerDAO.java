
package shop.Persistence;


import java.util.ArrayList;
import java.util.List;
import shop.entities.Manufacturer;


public class ManufacturerDAO extends DAO {
    
    public void saveManufacturer(Manufacturer manufacturer) throws Exception {
        try {
            if (manufacturer == null) {
                throw new Exception("Must indicate manufacturer");
            }

            String sql = "INSERT INTO manufacturer(name)"
                    + "VALUES ( '" + manufacturer.getName()+ "' );";

            insertEditDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectBase();
        }
    }

    public void editManufacturer(Manufacturer manufacturer) throws Exception {
        try {
            if (manufacturer == null) {
                throw new Exception("Must indicate the manufacturer you want to modify");
            }

            String sql = "UPDATE manufacturer SET "
                    + "name = '" + manufacturer.getName() + "' WHERE code = '" + manufacturer.getCode() + "'";

            insertEditDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectBase();
        }
    }

      

    public Manufacturer findManufacturerById(Integer id) throws Exception {
        try {

            String sql = "SELECT * FROM manufacturer "
                    + " WHERE code = '" + id + "'";

            consultBase(sql);

            Manufacturer manufacturer = null;
            while (result.next()) {
                manufacturer = new Manufacturer();
                manufacturer.setCode(result.getInt(1));
                manufacturer.setName(result.getString(2));
                
            }
            disconnectBase();
            return manufacturer;
        } catch (Exception e) {
            disconnectBase();
            throw e;
        }
    }

    public List<Manufacturer> listManufacturer() throws Exception {
        try {
            String sql = "SELECT code, name FROM manufacturer";

            consultBase(sql);

            Manufacturer manufacturer = null;
            List<Manufacturer> manufacturers = new ArrayList();
            while (result.next()) {
                manufacturer = new Manufacturer();
                manufacturer.setCode(result.getInt(1));
                manufacturer.setName(result.getString(2));
                manufacturers.add(manufacturer);
            }
            disconnectBase();
            return manufacturers;
        } catch (Exception e) {
            e.printStackTrace();
            disconnectBase();
            throw new Exception("Sistem Error");
        }
    }

}
