package com.technical.store.online.technical.store.entity;

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
//  private Long userId;
//  private String userAccessToken;

  private String username;
  private String email;
//  private String password;
  private String firstName;
  private String lastName;
  @OneToOne
  @JoinColumn(name = "cart_id")
  private Cart cart; // +
  @OneToOne
  @JoinColumn(name = "order_details_id")
  private OrderDetails orderDetails; // +
  private Date createdAt;
  private Date updatedAt;
}
