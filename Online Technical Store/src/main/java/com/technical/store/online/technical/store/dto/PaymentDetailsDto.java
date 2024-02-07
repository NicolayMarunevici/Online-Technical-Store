package com.technical.store.online.technical.store.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetailsDto {
  private Integer amount;
  private String provider;
  private String status;
  private Date createdAt;
  private Date updatedAt;
}
