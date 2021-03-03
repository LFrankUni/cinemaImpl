package utilities;

import java.time.Instant;

public class TimeConverter {
	public static String toString(Instant timestamp) {
		return timestamp.toString();
	}

	public static Instant toInstant(String timestamp) {
		return Instant.parse(timestamp);
	}
}
