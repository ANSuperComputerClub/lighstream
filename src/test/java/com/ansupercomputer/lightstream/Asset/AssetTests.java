package com.ansupercomputer.lightstream.Asset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetTests {

    private Asset asset;

    @BeforeEach
    public void setUp() {
        asset = new Asset(BigDecimal.valueOf(100), "Asset1");
    }

    @Test
    public void testGetPrice() {
        assertEquals(BigDecimal.valueOf(100), asset.getPrice());
    }

    @Test
    public void testUpdatePrice() {
        asset.updatePrice(BigDecimal.valueOf(150));
        assertEquals(BigDecimal.valueOf(150), asset.getPrice());
    }

    @Test
    public void testGetIdentifier() {
        assertEquals("Asset1", asset.getIdentifier());
    }
}