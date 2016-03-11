package de.synyx.tutorials.spring.reactjs.demo.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.synyx.tutorials.spring.reactjs.demo.react.React;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptException;
import java.util.List;

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
    public String products (Model model) throws JsonProcessingException, ScriptException {

        List<Product> products = repo.findAll();


        String                         renderedHtml = react.renderProducts(products);
        model.addAttribute ("content", renderedHtml);

        return "index";
    }
}
