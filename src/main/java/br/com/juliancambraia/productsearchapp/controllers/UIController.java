package br.com.juliancambraia.productsearchapp.controllers;

import br.com.juliancambraia.productsearchapp.documents.Product;
import br.com.juliancambraia.productsearchapp.services.ProductSearchServiceWithRepo;
import br.com.juliancambraia.productsearchapp.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Slf4j
public class UIController {
    private SearchService service;
    private ProductSearchServiceWithRepo searchServiceWithRepo;

    @Autowired
    public UIController(SearchService service, ProductSearchServiceWithRepo searchServiceWithRepo) {
        this.service = service;
        this.searchServiceWithRepo = searchServiceWithRepo;
    }

    @GetMapping("/search")
    public String home(Model model) {
        List<Product> products = service.fetchProductNamesContaining("Hornby");

        List<String> names = products.stream()
                .flatMap(product -> {
                    return Stream.of(product.getName());
                })
                .collect(Collectors.toList());
        log.info("product names {}", names);

        model.addAttribute("names", names);

        return "search";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProductIndex(@RequestBody Product product) {
        searchServiceWithRepo.createProductIndex(product);
        return ResponseEntity.ok("created");
    }

    @PostMapping("/create-all")
    public ResponseEntity<String> createProductsBulck(@RequestBody List<Product> products) {
        searchServiceWithRepo.createProductIndexBulk(products);
        return ResponseEntity.ok("created all");
    }
}
