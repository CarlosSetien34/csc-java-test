package com.test.inditex.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICE")
@Getter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private Brand brand;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "PRICE_LIST", nullable = false)
    private Integer priceList;

    @NotNull
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @NotNull
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @NotNull
    @Column(name = "PRICE", nullable = false, precision = 6, scale = 2)
    private BigDecimal price;

    @NotNull
    @Column(name = "CURR", nullable = false, length = 5)
    private String curr;
}
