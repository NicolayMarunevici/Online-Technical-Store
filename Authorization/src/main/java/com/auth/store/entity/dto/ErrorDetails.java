package com.auth.store.entity.dto;

import java.util.Date;

public record ErrorDetails(
    Date timestamp,
    String message,
    String details
) {

}
