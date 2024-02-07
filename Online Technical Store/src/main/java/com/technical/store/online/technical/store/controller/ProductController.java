package com.technical.store.online.technical.store.controller;

import com.technical.store.online.technical.store.dto.ProductDto;
import com.technical.store.online.technical.store.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }


  @PostMapping("product")
  public String create(@RequestBody ProductDto productDto) {
    return productService.create(productDto);
  }

  @GetMapping("products")
  public List<ProductDto> getAll() {
    return productService.getAll();
  }

  @GetMapping("product/{id}")
  public ProductDto getById(@PathVariable Long id) {
    return productService.getById(id);
  }
}
