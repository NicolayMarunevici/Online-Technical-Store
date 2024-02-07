package com.technical.store.online.technical.store.mapper;

import com.technical.store.online.technical.store.dto.ProductDto;
import com.technical.store.online.technical.store.entity.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  List<ProductDto> mapToProductDtoList(List<Product> product);
  ProductDto mapToProductDto(Product product);

  Product mapToProduct(ProductDto productDto);

}
