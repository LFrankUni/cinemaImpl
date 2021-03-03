/**--- Generated at Wed Mar 03 18:26:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;

import generated.cinemaService.*;

import java.util.Collection;

import commands.*;

public class Room_scheduleMovieShow_Command extends ObjectCommand<Room, Collection<MovieShow>> {
	private static final long serialVersionUID = 671498227L;
	private Movie movie;
	private String start;
	private Integer days;
	private Boolean threeDimensional;
	private Integer price;

	public Room_scheduleMovieShow_Command(Room receiver, Movie movie, String start, Integer days,
			Boolean threeDimensional, Integer price) {
		super(receiver);
		this.movie = movie;
		this.start = start;
		this.days = days;
		this.threeDimensional = threeDimensional;
		this.price = price;
	}

	public void execute() {
		try {
			this.result = this.receiver.scheduleMovieShows(movie, start, days, threeDimensional, price);
		} catch (Exception e) {
			this.e = e;
		} finally {
			this.receiver.notifyObservers(this);
		}
	}
}
