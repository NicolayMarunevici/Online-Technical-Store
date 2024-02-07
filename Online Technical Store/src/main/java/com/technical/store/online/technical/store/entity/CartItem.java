package com.technical.store.online.technical.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer quantity;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id") // +
  private Product product;
  @ManyToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;
  private Date createdAt;
  private Date updatedAt;
}
