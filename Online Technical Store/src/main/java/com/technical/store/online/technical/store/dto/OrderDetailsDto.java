package com.technical.store.online.technical.store.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDto{
    private Long total;
    private PaymentDetailsDto paymentDetails;
    private Date createdAt;
    private Date updatedAt;
}