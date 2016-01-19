package com.maxdemarzi.Helpers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Sort by Score
 * Sort by Departure
 * Sort by Distance
 * Sort by First Flight Code
 */
public class FlightComparator <T extends Comparable<T>> implements Comparator<HashMap> {
    @Override
    public int compare(HashMap flights1, HashMap flights2) {
        int c;
        c = ((Double)flights1.get("score")).compareTo((Double)flights2.get("score"));

        if (c == 0) {
            HashMap firstFlight1 = (HashMap)((ArrayList)flights1.get("flights")).get(0);
            HashMap firstFlight2 = (HashMap)((ArrayList)flights2.get("flights")).get(0);

            Long l1 = new Long(Long.parseLong(""+firstFlight1.get("departs")));
            Long l2 = new Long(Long.parseLong(""+firstFlight2.get("departs")));
            c = l1.compareTo(l2);

            if (c == 0) {
		l1 = new Long(Long.parseLong(""+flights1.get("distance")));
		l2 = new Long(Long.parseLong(""+flights2.get("distance")));
		c = l1.compareTo(l2);
                
                if (c == 0) {
                    c = ((String)firstFlight1.get("code")).compareTo((String)(firstFlight2.get("code")));
                }
            }
        }

        return c;
    }
}