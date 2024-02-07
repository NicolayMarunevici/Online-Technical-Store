package com.technical.store.online.technical.store.service;

import com.technical.store.online.technical.store.dto.ProductDto;
import java.util.List;

public interface ProductService {

  String create(ProductDto productDto);
  List<ProductDto> getAll();
  ProductDto getById(Long id);
}
