package com.technical.store.online.technical.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  @Enumerated(EnumType.STRING)
  private ProductCategoryEnum category;
  private Integer price;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "discount_id", referencedColumnName = "id") // +
  private Discount discount;
  private Date createdAt;
  private Date updatedAt;
}
