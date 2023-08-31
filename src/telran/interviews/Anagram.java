package telran.interviews;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
public static boolean isAnagram(String str, String anagram) {
	//TODO
//	Map<Character, Integer> res = new HashMap<>();
//	for(char ch: anagram.toCharArray()) {
//		res.merge(ch, 1, (val, newVal) -> val + newVal);
//	}
//	for(char ch: str.toCharArray()) {
//		res.merge(ch, -1, (val, newVal) -> val + newVal);
//	}
//	return res.values().stream().allMatch(val -> val == 0);
	
	int res = 0;
	if(anagram == "") {
		res++;
	}
	for(char ch: str.toCharArray()) {
		res += ch;
	}
	for(char ch: anagram.toCharArray()) {
		res -= ch;
	}
	
	return res == 0? true: false;
}
}