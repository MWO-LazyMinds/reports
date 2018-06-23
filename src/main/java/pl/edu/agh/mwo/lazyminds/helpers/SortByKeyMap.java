package pl.edu.agh.mwo.lazyminds.helpers;

import java.util.Map;

public class SortByKeyMap {

	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}
}
