/**
 * @author Emily Topkaya
 * 
 * JUnit test for class SecondLargestElement.
 */
package main.java.ladders.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import junit.framework.Assert;
import main.java.ladders.IntegerArray.SecondLargestElement;

public class SecondLargestElementTest {

	@Test
	public void regularCaseTest () {
		SecondLargestElement finder = new SecondLargestElement();
		Collection<Integer> set = new HashSet<Integer>(
				Arrays.asList(27, 38, 72, 59, 73, 16));
	    Assert.assertTrue(finder.findSecondLargest(set) == 72);
	}
	
	@Test
	public void emptyInputTest () {
		SecondLargestElement finder = new SecondLargestElement();
		Collection<Integer> list = new ArrayList<Integer>();
		Assert.assertNull(finder.findSecondLargest(list));
	}
	
	@Test
	public void nullInputTest () {
		SecondLargestElement finder = new SecondLargestElement();
		Collection<Integer> collection = null;
		Assert.assertNull(finder.findSecondLargest(collection));
	}

}
