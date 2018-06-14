package ru.sandbox.websocks.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by kurdyukovpv on 14.06.2018.
 */
@Data
@Builder
public class PayloadDto {
    private Long id;
    private String text;
}
