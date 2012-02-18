package com.ksetyadi.randompair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RandomPair {
	private static List<String> originalList;
	private static List<String> playoffList;
	private static Map<String, String> resultPair;
	
	private static boolean playoffMode = false;
	
	public static void main(String[] args) {
		
		originalList = new ArrayList<String>();
		
		Scanner s = new Scanner(System.in);
		
		while(s.hasNextLine()) {
			String line = s.nextLine();
			
			if (line.charAt(0) == '#') {
				
				if (!playoffMode) {
					playoffList = new ArrayList<String>();
					playoffMode = true;
				}
				
				playoffList.add(line.substring(1, line.length()));
				continue;
			}
			
			originalList.add(line);
		}
		
		if (playoffMode) {
			if (playoffList.size() != originalList.size()) {
				System.out.println("The list between playoff (" +
						playoffList.size() + ") and non-playoff (" +
								originalList.size() + ") is different. ");
				
				return;
			}
		} else {
			if (originalList.size() % 2 != 0) {
				System.out.println("The number of entities should be even.");
				return;
			}
		}
		
		if (playoffMode) {
			resultPair = generateResultPair(playoffList, originalList);
		} else {
			resultPair = generateResultPair(originalList);
		}
		
		Set<String> keySet = resultPair.keySet();

		int i = 1;
		
		for (String key : keySet) {
			System.out.printf("Team #%d: %s - %s\n", i, key, resultPair.get(key));
			i++;
		}
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
	
	private static Map<String, String> generateResultPair(List<String> playoffList,
			List<String> originalList) {
		
		Collections.shuffle(playoffList);
		Collections.shuffle(originalList);
		
		int size = playoffList.size();
		
		Map<String, String> result = new HashMap<String, String>();
		
		for (int i = 0; i < size; i++) {
			result.put(playoffList.get(i), originalList.get(i));
		}
		
		return result;
	}
}
