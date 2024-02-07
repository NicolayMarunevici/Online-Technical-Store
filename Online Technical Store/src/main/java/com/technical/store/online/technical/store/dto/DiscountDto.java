package com.technical.store.online.technical.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountDto {
  private String name;
  private String description;
  private Integer discountPercent;
}
