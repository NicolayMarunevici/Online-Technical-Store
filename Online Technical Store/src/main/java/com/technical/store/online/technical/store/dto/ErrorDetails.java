package com.technical.store.online.technical.store.dto;

import java.util.Date;

public record ErrorDetails(
    Date timestamp,
    String message,
    String details
) {
}
