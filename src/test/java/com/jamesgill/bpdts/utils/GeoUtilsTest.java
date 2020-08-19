package com.jamesgill.bpdts.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GeoUtilsTest {

	@Test
    public void pointIsTooFarNorth() {
    	boolean isNear = GeoUtils.isNearLondon(52.1, -0.1);
    	Assertions.assertFalse(isNear);
    }
	
	@Test
    public void pointIsTooFarSouth() {
    	boolean isNear = GeoUtils.isNearLondon(50.9, -0.1);
    	Assertions.assertFalse(isNear);
    }
	
	@Test
    public void pointIsTooFarWest() {
    	boolean isNear = GeoUtils.isNearLondon(51.5, -0.6);
    	Assertions.assertFalse(isNear);
    }
	
	@Test
    public void pointIsTooFarEast() {
    	boolean isNear = GeoUtils.isNearLondon(51.5, 0.4);
    	Assertions.assertFalse(isNear);
    }
	
	@Test
    public void pointIsNearLondon() {
    	boolean isNear = GeoUtils.isNearLondon(51.5, -0.1);
    	Assertions.assertTrue(isNear);
    }
}
