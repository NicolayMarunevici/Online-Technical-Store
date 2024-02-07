package com.technical.store.online.technical.store.dto;

import com.technical.store.online.technical.store.entity.ProductCategoryEnum;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
  private String name;
  private String description;
  private ProductCategoryEnum category;
  private Integer price;
  private DiscountDto discount;
  private Date createdAt;
  private Date updatedAt;
}
