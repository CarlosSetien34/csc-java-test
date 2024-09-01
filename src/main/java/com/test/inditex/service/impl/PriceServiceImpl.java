package com.test.inditex.service.impl;

import com.test.inditex.dto.PriceDto;
import com.test.inditex.entity.Price;
import com.test.inditex.exception.InvalidInputException;
import com.test.inditex.exception.NotFoundException;
import com.test.inditex.repository.PriceRepository;
import com.test.inditex.service.PriceService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private static final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PriceDto findPricePvp(String priceDateStr, Long productId, Long brandId) throws NotFoundException, InvalidInputException {

        validateInputData(priceDateStr, productId, brandId);
        LocalDateTime priceDate = LocalDateTime.parse(priceDateStr, DATE_TIME_FORMATTER);
        List<com.test.inditex.entity.Price> prices = priceRepository.findByParams(priceDate, productId, brandId);

        if (prices.isEmpty()) {
            throw new NotFoundException();
        }

        //If a product has 2 simultaneous prices, the one with higher priority is applied
        prices.sort(Comparator.comparing(Price::getPriority).reversed());
        Price pvpPrice = prices.get(0);
        return modelMapper.map(pvpPrice, PriceDto.class);
    }

    /**
     * Validate input data
     *
     * @param priceDateStr Price date string
     * @param productId    Product id
     * @param brandId      Brand id
     * @throws InvalidInputException The invalid input data exception
     */
    private void validateInputData(String priceDateStr, Long productId, Long brandId) throws InvalidInputException {
        boolean validData = true;
        try {
            if (productId <= 0 || brandId <= 0) {
                validData = false;
            }
            LocalDateTime.parse(priceDateStr, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            validData = false;
        } finally {
            log.info("Throw InvalidInputDataFormatException");
        }

        if (!validData) {
            log.info("Throw InvalidInputDataFormatException");
            throw new InvalidInputException();
        }
    }
}