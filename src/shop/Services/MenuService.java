package shop.Services;

import java.util.Scanner;


public class MenuService {

    public void Menu() throws Exception {
        Scanner sc = new Scanner(System.in);
        ProductService product = new ProductService();
        ManufacturerService manufacturer = new ManufacturerService();
        int option = 0;
        boolean exit = true;
        while (exit) {
            System.out.println("----------MENU----------");
            System.out.println("1) List products names\n2) List name and price of products\n3) List products whose price is between $ 120 and $ 202\n4) List portables\n5) Name and price of the cheapest product\n6) Add a product\n7) Add a manufacturer\n8) Edit product\n9) Exit");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    product.listNameProducts();
                    System.out.println("");
                    sc.nextLine();
                    break;
                case 2:
                    product.listNamePriceProducts();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;
                case 3:
                    product.listPricesRange();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;
                case 4:
                    product.listPortable();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;

                case 5:
                    product.listCheapestProduct();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;
                case 6:
                    product.addProduct();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;
                case 7:
                    manufacturer.addManufacturer();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;
                case 8:
                    menuop();

                    break;
                case 9:
                    exit = false;
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Choose a valid option");
                    break;
            }
        }

    }

    private void menuop() throws Exception {

        ProductService product = new ProductService();
        ManufacturerService manufacturer = new ManufacturerService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wish to Edit(E) or Delete (D) the product?");
        String option2 = sc.next().toUpperCase();
        switch (option2) {
            case "E":
                product.editProduct();
                System.out.println("Press enter to continue");
                sc.nextLine();

                break;

            case "D":
                product.deleteProduct();
                System.out.println("Press enter to continue");
                sc.nextLine();

                break;

            default:
                System.out.println("Choose a valid option");
                System.out.println("Press enter to continue");
                sc.nextLine();

                break;
        }
    }
}
