package modal;

import java.util.ArrayList;
import java.util.List;

public class ListOfProducts {
    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getListOfProducts(){
        productList.add(new Product("MAC", "V1"));
        productList.add(new Product("MAC", "V2"));
        productList.add(new Product("MAC", "V3"));
        productList.add(new Product("MAC", "V4"));
        productList.add(new Product("MAC", "V2"));

        productList.add(new Product("HP", "V1"));
        productList.add(new Product("HP", "V2"));
        productList.add(new Product("HP", "V3"));
        return productList;
    }
}
