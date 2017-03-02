package com.user.reg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.print.Collation;

public class test {

	public static void main(String[] args) {
		List<Integer> l1=new ArrayList<Integer>(); 
		List<Integer> l2=new ArrayList<Integer>();
		l1.addAll(Arrays.asList(78,6,94));
		l2.addAll(Arrays.asList(67,42,73));
		l1.addAll(l2);
		for(int i:l1){
			System.out.print(i+",");
		}
		System.out.println();
		Collections.sort(l1);
		for(int i:l1){
			System.out.print(i+",");
		}
		System.out.println(l1.toString());
	}

}
