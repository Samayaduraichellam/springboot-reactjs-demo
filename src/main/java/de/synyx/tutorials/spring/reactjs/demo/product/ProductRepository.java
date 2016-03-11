package de.synyx.tutorials.spring.reactjs.demo.product;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private final static IdCounter ID = new IdCounter ();

    private static final List<Product> PRODUCTS = Arrays.asList (
            new Product (ID.next (), "jeans", 63),
            new Product (ID.next (), "cardigan", 42)
    );

    public List<Product> findAll () {
        return Collections.unmodifiableList (PRODUCTS);
    }

    static class IdCounter {

        private int current = 0;

        public int next () {
            return ++current;
        }
    }
}
