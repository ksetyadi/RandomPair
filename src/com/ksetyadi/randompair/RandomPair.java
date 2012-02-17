package com.ksetyadi.randompair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RandomPair {
	private static List<String> originalList;
	private static Map<String, String> resultPair;
	
	public static void main(String[] args) {
		
		originalList = new ArrayList<String>();
		
		Scanner s = new Scanner(System.in);
		
		while(s.hasNextLine()) {
			originalList.add(s.nextLine());
		}
		
		if (originalList.size() % 2 != 0) {
			System.out.println("The number of entity should be even.");
			return;
		}
		
		resultPair = generateResultPair(originalList);
		
		System.out.println(resultPair.toString());
	}
	
	private static Map<String, String> generateResultPair(List<String> list) {
		Collections.shuffle(list);
		
		int threshold = list.size() / 2;
		int listSize = list.size();

		Map<String, String> result = new HashMap<String, String>();

		for (int i = 0; i < threshold; i++) {
			result.put(list.get(i), list.get((listSize - 1) - i));
		}
		
		return result;
	}
}
