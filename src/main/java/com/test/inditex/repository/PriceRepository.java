package com.test.inditex.repository;


import com.test.inditex.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The Price repository.
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Find price by params.
     *
     * @param priceDate The price date.
     * @param productId The product id.
     * @param brandId   The brand id.
     * @return The resulted price list.
     */
    @Query("SELECT p FROM Price p WHERE (p.startDate<=:priceDate AND p.endDate>=:priceDate) AND p.productId=:productId AND p.brand.id=:brandId")
    List<Price> findByParams(@Param("priceDate") LocalDateTime priceDate, @Param("productId") Long productId, @Param("brandId") Long brandId);
}

