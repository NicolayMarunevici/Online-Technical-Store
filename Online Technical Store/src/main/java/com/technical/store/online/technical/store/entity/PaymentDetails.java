package com.technical.store.online.technical.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class PaymentDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(mappedBy = "paymentDetails")
  private OrderDetails orderDetails;
  private Integer amount;
  private String provider;
  @Enumerated(EnumType.STRING)
  private PaymentStatusEnum status;
  private Date createdAt;
  private Date updatedAt;
}
