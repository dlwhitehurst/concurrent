/**
 * Copyright (c) CI Wise Inc.  All rights reserved.  http://www.ciwise.com
 * The software in this package is published under the terms of the Apache
 * version 2.0 license, a copy of which has been included with this distribution 
 * in the LICENSE.md file.
 * 
 */ 

package org.ciwise.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.ciwise.integer.util.IntegerMath;

/**
 *  @author <a href="mailto:david@ciwise.com">David L. Whitehurst</a>
 *
 */
public class PerfectNumber implements Callable<Boolean>{

    private long number;
    
    public PerfectNumber(long number) {
        this.number = number;
        
    }
    /* (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Boolean call() throws Exception {
        // TODO Auto-generated method stub
        return isPerfectNumber(number);
    }

    private boolean isPerfectNumber(long checkNum) {
        boolean retVal = false;
        Long sum = new Long(0);
        
        List<Long> list = new ArrayList<Long>();
        list = IntegerMath.getIntegerFactorPairs(checkNum);
        
        for (int i=0; i < list.size()-1; i++) {
            sum += list.get(i);
        }
        
        list.clear(); // flush container
        
        if (sum.equals(checkNum)) {
            retVal = true;
        }
        return retVal;
    }
}
