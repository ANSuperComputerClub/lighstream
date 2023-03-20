package com.ansupercomputer.lightstream.Asset;

import com.ansupercomputer.lightstream.Exceptions.IllegalOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AssetTests {

    private Asset asset;

    @BeforeEach
    public void setUp() {
        asset = new Asset(BigDecimal.valueOf(100), "Asset1");
    }

    @Test
    public void testGetPrice() throws IllegalOperationException {
        assertEquals(BigDecimal.valueOf(100), asset.getPrice());
    }

    @Test
    public void testUpdatePrice() throws IllegalOperationException {
        asset.updatePrice(BigDecimal.valueOf(150));
        assertEquals(BigDecimal.valueOf(150), asset.getPrice());
    }

    @Test
    public void testGetIdentifier() {
        assertEquals("Asset1", asset.getIdentifier());
    }
}