package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import generated.cinemaService.Cinema;
import generated.cinemaService.ModelException;
import generated.cinemaService.Movie;

class CinemaTest {

	@Test
	void addMovieTest() throws ModelException {
		Cinema testCinema = Cinema.createFresh("TestCinema");
		Movie testMovie = Movie.createFresh("Test Film", "Einfach nur zum Testen", 90);
		
		testCinema.addMovie(testMovie);
		assertEquals(testCinema.getMovies().stream().findFirst().get().getId(), testMovie.getId());
	}

	
}
