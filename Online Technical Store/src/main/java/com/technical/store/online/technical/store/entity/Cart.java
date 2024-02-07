package com.technical.store.online.technical.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Entity
@Data
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long total;
  @OneToMany(mappedBy = "cart")
  private Set<CartItem> cartItems;
  private Date createdAt;
  private Date updatedAt;
}
