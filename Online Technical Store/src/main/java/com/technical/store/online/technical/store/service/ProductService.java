package com.technical.store.online.technical.store.service;

import com.technical.store.online.technical.store.dto.ProductDto;
import com.technical.store.online.technical.store.exception.ProductNotFoundException;
import com.technical.store.online.technical.store.mapper.ProductMapper;
import com.technical.store.online.technical.store.repository.ProductRepository;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public String create(ProductDto productDto) {
//    PaymentDetailsDto paymentDetailsDto =
//        productDto.getOrderItems().getOrderDetails().getPaymentDetails().setProvider();
    productDto.setCreatedAt(new Date());
    productRepository.save(ProductMapper.INSTANCE.mapToProduct(productDto));
    return String.format("Product %s has been successfully created", productDto.getName());
  }

  public List<ProductDto> getAll() {
    return ProductMapper.INSTANCE.mapToProductDtoList(productRepository.findAll());
  }

  public ProductDto getById(Long id) {
    return ProductMapper.INSTANCE.mapToProductDto(productRepository.findById(id).orElseThrow(
        () -> new ProductNotFoundException(String.format("Product with id %s does not exist", id),
            HttpStatus.BAD_REQUEST)));
  }
}
