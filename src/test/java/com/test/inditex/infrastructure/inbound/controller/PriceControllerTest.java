package com.test.inditex.infrastructure.inbound.controller;


import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {
    public static final String PRODUCT_ID = "35455";
    public static final String BRAND_ID = "1";
    public static final String URL_TEMPLATE = "/price/find-price-pvp/pricedate/{pricedate}/productid/{productid}/brandid/{brandid}";
    @Autowired
    private MockMvc mockMvc;


    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    void findPrice_test1() throws Exception {
        String pricedate = "2020-06-14-10.00";
        this.mockMvc.perform(get(URL_TEMPLATE, pricedate, PRODUCT_ID, BRAND_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.price", Is.is(35.50)));

    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    void findPrice_test2() throws Exception {
        String pricedate = "2020-06-14-16.00";
        this.mockMvc.perform(get(URL_TEMPLATE, pricedate, PRODUCT_ID, BRAND_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.price", Is.is(25.45)));

    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    void findPrice_test3() throws Exception {
        String pricedate = "2020-06-14-21.00";
        this.mockMvc.perform(get(URL_TEMPLATE, pricedate, PRODUCT_ID, BRAND_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.price", Is.is(35.50)));

    }

    /**
     * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    void findPrice_test4() throws Exception {
        String pricedate = "2020-06-15-10.00";
        this.mockMvc.perform(get(URL_TEMPLATE, pricedate, PRODUCT_ID, BRAND_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.price", Is.is(30.50)));

    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    void findPrice_test5() throws Exception {
        String pricedate = "2020-06-16-21.00";
        this.mockMvc.perform(get(URL_TEMPLATE, pricedate, PRODUCT_ID, BRAND_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.price", Is.is(38.95)));

    }
}