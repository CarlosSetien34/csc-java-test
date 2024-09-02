package com.test.inditex.application.service;

import com.test.inditex.infrastructure.outbound.response.PriceDto;
import com.test.inditex.infrastructure.inbound.exception.InvalidInputException;
import com.test.inditex.infrastructure.inbound.exception.NotFoundException;

/**
 * Price service
 */
public interface PriceServiceAdapter {

    /**
     * Find price (pvp) by:
     * @param priceDate Price date
     * @param productId Price productId
     * @param brandId   Price brandId
     * @return Price
     */
    PriceDto findPricePvp(String priceDate, Long productId, Long brandId) throws NotFoundException, InvalidInputException;
}