package com.test.inditex.service;

import com.test.inditex.dto.PriceDto;
import com.test.inditex.exception.InvalidInputException;
import com.test.inditex.exception.NotFoundException;

/**
 * Price service
 */
public interface PriceService {

    /**
     * Find price (pvp) by:
     * @param priceDate Price date
     * @param productId Price productId
     * @param brandId   Price brandId
     * @return Price
     */
    PriceDto findPricePvp(String priceDate, Long productId, Long brandId) throws NotFoundException, InvalidInputException;
}