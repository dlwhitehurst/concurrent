/**
 * Copyright (c) CI Wise Inc.  All rights reserved.  http://www.ciwise.com
 * The software in this package is published under the terms of the Apache
 * version 2.0 license, a copy of which has been included with this distribution 
 * in the LICENSE.md file.
 * 
 */ 

package org.ciwise.integer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  @author <a href="mailto:david@ciwise.com">David L. Whitehurst</a>
 *
 */
public class IntegerMath {
    
    public static List<Long> getIntegerFactorPairs(Long input) {
        List<Long> factorList = new ArrayList<Long>();
        factorList.add(1L);
        factorList.add(input);
        
        for (long y=2; y<=getIntegerSquareRoot(input); y++) {
            long potentialFactor = input%y;
            
            if (potentialFactor == 0) {
                factorList.add(y);
                long pair = input/y;
                factorList.add(pair);
            }
        }
        
        Collections.sort(factorList);
        return factorList;
    }

    public static long getIntegerSquareRoot(Long x) {
        long low,high,mid;
        low=1;
        high=x;
        while (low<=high){
            mid = (low+high)>>1;
            if (mid*mid == x) return mid;
            if (mid*mid > x) high = mid-1;
            else low = mid+1;
        }
        return high;
    }
}
