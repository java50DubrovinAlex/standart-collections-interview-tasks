package telran.interviews.test;
import telran.interviews.DateRole;
import telran.interviews.InterviewTasks;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InterviewsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	
	void displayShuffledTest() {
		InterviewTasks exp = null;
		int []ar = {1, 2, 3, 4, 5};
		 exp.displayShuffled(ar);
		
	}
	
	@Test
	void rolesInDatesTest() {
		InterviewTasks exp = null;
		List<DateRole> dateRoles = List.of(
                new DateRole(LocalDate.of(2017, 10, 12), "Developer"),
                new DateRole(LocalDate.of(2020, 1, 1), "Team Leader"),
                new DateRole(LocalDate.of(2023, 8, 15), "Project Manager")
        );

        List<LocalDate> dates = List.of(
                LocalDate.of(2015, 1, 1),
                LocalDate.of(2018, 1, 1),
                LocalDate.of(2023, 1, 1)
        );
        List<DateRole> expected = List.of(
                new DateRole(LocalDate.of(2015, 1, 1), null),
                new DateRole(LocalDate.of(2018, 1, 1), "Developer"),
                new DateRole(LocalDate.of(2023, 1, 1),  "Team Leader")
        );
        
        List<DateRole> result = exp.rolesInDates(dateRoles, dates);
        assertEquals(expected, result);
//        List<DateRole> result = exp.rolesInDates(dateRoles, dates);
//        result = null;
	}
	

}
