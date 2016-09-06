/**
 * Copyright (c) CI Wise Inc.  All rights reserved.  http://www.ciwise.com
 * The software in this package is published under the terms of the Apache
 * version 2.0 license, a copy of which has been included with this distribution 
 * in the LICENSE.md file.
 * 
 */ 

package org.ciwise.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  @author <a href="mailto:david@ciwise.com">David L. Whitehurst</a>
 *
 */
public class Main {
    
    public static void main(String[] args) {
        // where things get done
        ExecutorService es = Executors.newSingleThreadExecutor();
        // 6, 28, 496, 8128, 33,550,336
        
        // loop 100,000,000 (x hours) ... try 10,000,000,000 next
        for (long i=0; i<100000000; i++) {
            //System.out.println("submitted callable task to determine if 8128 is a perfect number"); 
            Future<Boolean> result = es.submit(new PerfectNumber(i)); 

            boolean isPerfect = false;

            try {
                isPerfect = result.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            
            if (isPerfect) {
                System.out.println("SUCCESS: " + i + " is a perfect number."); 
            }
        }
        
        es.shutdown();
    }
}
