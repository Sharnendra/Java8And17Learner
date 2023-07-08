package MaoStructVersionIdentifier;

import modal.ListOfProducts;
import modal.Product;

import java.util.Map;
import java.util.stream.Collectors;

public class MapStructVerIdentifierMain {
    public static void main(String[] args) {
        Map<String, String> collect = ListOfProducts.getListOfProducts().stream()
                .collect(Collectors.toMap(Product::getProductName, Product::getVersion, (x1, x2) -> {
                    Integer previousValue = Integer.valueOf(x1.charAt(x1.length() - 1));
                    Integer nextValue = Integer.valueOf(x2.charAt(x2.length() - 1));
                    if (previousValue > nextValue) {
                        return x1;
                    } else {
                        return x2;
                    }
                }));
        System.out.println(collect);
    }
}
