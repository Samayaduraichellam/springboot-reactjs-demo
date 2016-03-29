package de.synyx.tutorials.spring.reactjs.demo.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.synyx.tutorials.spring.reactjs.demo.react.React;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private final React react;
    private final ProductRepository repo;

    @Autowired
    public ProductController (React react, ProductRepository repo) {
        this.react = react;
        this.repo = repo;
    }

    @RequestMapping ("/")
    public String products (@RequestParam(name = "sort", defaultValue = "name") String sortBy,
                            Model model) throws JsonProcessingException, ScriptException {

        List<Product> products = repo.findAllSorted (getProductComparator (sortBy));


        String                         renderedHtml = react.renderProducts(products, sortBy);
        model.addAttribute ("content", renderedHtml);
        model.addAttribute ("initialProducts", products);
        model.addAttribute ("initialSortBy", sortBy);

        return "index";
    }

    private Comparator<Product> getProductComparator (String sortBy) {
        return "price".equals (sortBy)
                ? (p1, p2) -> p1.getValue () < p2.getValue () ? -1 : 0
                : (p1, p2) -> p1.getName ().compareToIgnoreCase (p2.getName ());
    }

    private Map<String, Object> getInitialState(List<Product> products, String sortBy) {

        Map<String, Object> state = new HashMap<> ();

               state.put ("products", products);
               state.put ("sortBy", sortBy);
        return state;
    }
}
