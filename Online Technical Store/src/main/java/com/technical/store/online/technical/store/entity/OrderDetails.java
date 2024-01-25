package com.technical.store.online.technical.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class OrderDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long total;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id") // +
  private User user;
  @OneToOne(mappedBy = "orderDetails") // +
  private OrderItems orderItems;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "payment_details_id", referencedColumnName = "id") // +
  private PaymentDetails paymentDetails;
  private Date createdAt;
  private Date updatedAt;
}
