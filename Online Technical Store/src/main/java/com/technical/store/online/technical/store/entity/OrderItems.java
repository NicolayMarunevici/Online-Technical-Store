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
public class OrderItems {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_items_id", referencedColumnName = "id") // +
  private OrderDetails orderDetails;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id", referencedColumnName = "id") // +
  private Product product;
  private Date createdAt;
  private Date updatedAt;
}
