package com.jamesgill.bpdts.utils;

/**
 * Simple geographic utils.
 * @author James Gill
 *
 */
public class GeoUtils {
	
	//Central London
	private static Double londonLat=51.509865;
	private static Double londonLon=-0.118092;
	
	//Arbitrary min/max lat and lon around London
	private static Double minLat=51.0;
	private static Double maxLat=52.0;
	private static Double minLon=-0.5;
	private static Double maxLon=0.3;
	

	/**
	 * Determines if a given point is within some arbitrary min/max lat and lon around London.
	 * coordinates.
	 * @param lat
	 * @param lon
	 * @return
	 */
	public static boolean isNearLondon(Double lat, Double lon) {
		boolean isNear = false;
		if(Double.compare(lat, maxLat) < 0 &&
			Double.compare(lat, minLat) > 0 &&
			Double.compare(lon, maxLon) < 0 &&
			Double.compare(lon, minLon) > 0) {
			isNear = true;
		}
		return isNear;
	}
}
