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
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String address;
  private Integer phone;
  @OneToOne(mappedBy = "user") // +
  private ShoppingSession shoppingSession;
  @OneToOne(mappedBy = "user") // +
  private OrderDetails orderDetails;
  private Date createdAt;
  private Date updatedAt;
}
