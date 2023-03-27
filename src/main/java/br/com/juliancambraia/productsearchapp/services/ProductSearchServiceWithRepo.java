package br.com.juliancambraia.productsearchapp.services;

import br.com.juliancambraia.productsearchapp.documents.Product;
import br.com.juliancambraia.productsearchapp.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductSearchServiceWithRepo {
    private ProductRepository productRepository;

    @Autowired
    public ProductSearchServiceWithRepo(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProductIndexBulk(final List<Product> products) {
        productRepository.saveAll(products);
    }

    public void createProductIndex(final Product product) {
        productRepository.save(product);
    }

    public List<Product> findProductsByManufacturerAndCategory(final String manufacturer, final String category) {
        return productRepository.findByManufacturerAndCategory(manufacturer, category);
    }

    public List<Product> findByProductName(final String productName) {
        return productRepository.findByName(productName);
    }

    public List<Product> findByProductMatchingNames(final String productName) {
        return productRepository.findByNameContaining(productName);
    }
}
