package telran.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks {
	static final int N_GRUP_NUMBERS = 10_000_000;
	int[] randomNumbers = getRandomNumbers(N_GRUP_NUMBERS);
	
	
	public void printDigitStatistics() {
		String allNumbers = Arrays.stream(randomNumbers).mapToObj(String::valueOf).collect(Collectors.joining(""));
		Map<Integer, Long> map = allNumbers.chars()
              .mapToObj(Character::getNumericValue)
              .collect(Collectors.groupingBy(digit -> digit, Collectors.counting()));
		
		System.out.println("Digit Statistics:");
        map.forEach((digit, count) -> System.out.printf("%d: %d%n", digit, count));
//        Map<Integer, Long> map1 = Arrays.stream(randomNumbers).mapToObj(null)
		
	}
	private int [] getRandomNumbers(int nGroupNumbers) {
		
		return new Random().ints(nGroupNumbers, 0, N_GRUP_NUMBERS).toArray();
		
	}
	
}
