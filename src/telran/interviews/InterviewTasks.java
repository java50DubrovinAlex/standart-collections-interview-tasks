package telran.interviews;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;


public class InterviewTasks implements Words{
	
	TreeMap<String, String> words = new TreeMap<>();
	
	public static  void displayShuffled(int[]ar) {
//	Arrays.stream(ar).boxed().sorted((a, b) ->  new Random().nextInt(3) - b).forEach(elm -> System.out.printf("%s ", elm));
	Arrays.stream(ar).boxed().collect(Collectors
			.collectingAndThen(Collectors.toList(), list -> {Collections.shuffle(list);
    return list;}));
	}
	
	static public List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates){
		List<DateRole> result = dates.stream()
				.map(date -> getRol(datesRoles, date)).collect(Collectors.toList());
	        return result;
	}
	public static DateRole getRol(List<DateRole> datesRoles, LocalDate date) {
		DateRole res = datesRoles.stream()
	            .filter(dateRole -> dateRole.date().isBefore(date))
	            .max(Comparator.comparing(DateRole::date))
	            .orElse(null);
		return res == null? new DateRole(date, null) : new DateRole(date, res.rol());
	}

	@Override
	public boolean addWord(String word) {
		boolean isAdded = false;
		if(!words.containsKey(word.toLowerCase())) {
			this.words.put(word.toLowerCase(), word);
			isAdded =  true;
		}
		return isAdded;
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		
		return new ArrayList <>(this.words.subMap(prefix.toLowerCase(), true,  prefix.toLowerCase() + "\uFFFF" , true).values()); 
	}
}
