package com.example.functional;

import static org.junit.Assert.*;

import org.junit.Test;

public class LamdaExceptionAsserterTestHelper {

	//example problem: we don't know which of the two methods were supposed to throw the
	//exception
//	@Test(expected = RodCutterException.class)
//	public void test() {
//		rodCutter.setPrices(prices);
//		rodCutter.maxProfit(0);
//	}
	
	//refactor to the following, so that the exception from the method we are targeting is
	//guarantted to be the one to throw the exception
//	@Test
//	public void conciseExceptionTest() {
//		rodCutter.setPrices(prices);
//		assertThrows(RodCutterException.class, () -> rodCutter.maxProfit(0));
//		
//	}
	
	public static <X extends Throwable> void assertThrows(
			final Class<X> exceptionClass, final Runnable block) {
		try {
			block.run();
		} catch(Throwable ex) {
			if(exceptionClass.isInstance(ex)) {
				return;
			}
			fail("failed to throw correct exception");
			return;
		}
	}

}
