package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TestForStream {
public static void main(String[] args) {
	List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	List <Integer> l2=new ArrayList<Integer>();
	for(int i=0;i<nums.size();i++) {
		l2.add(i, nums.get(i)+2);
	}
	System.out.println(l2);
	
	
	//nums.stream().map((n)->n+2).forEach((n)->System.out.println(n));
	
	
	
	//stream are lazy in nature
	//terminal :-	forEach()
	//intermediate :- stream,filter
	
	//System.out.println(IntStream.of(1,2,3,4,5,6,7,8,9,10).summaryStatistics());
	
}
}
