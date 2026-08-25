package com.yukitey.spring.vtmv20.vtmv20cadtool.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackgroundPointValueDto {
    private Integer dots = 0;
    private String definition;
}