package com.test.inditex.infrastructure.outbound.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.inditex.domain.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.test.inditex.domain.entity.Price} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceDto implements Serializable {
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Brand brand;

    @Size(min = 1)
    @NotNull
    private Long brandId;

    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    @JsonIgnore
    @NotNull
    private Integer priceList;
    @Size(min = 1)
    @NotNull
    private Long productId;
    @NotNull
    @JsonIgnore
    private Integer priority;
    @NotNull
    @JsonProperty("price")
    private BigDecimal price;
    @JsonIgnore
    @Size(max = 5)
    @NotNull
    private String curr;
}