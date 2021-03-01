package utilities;

import java.time.Instant;
import java.time.OffsetDateTime;

public class TimeConverter {
	public static String toString(Instant timestamp) {
		return timestamp.toString();
	}

	public static Instant toInstant(String timestamp) {
		return OffsetDateTime.parse(timestamp).toInstant();
	}
}
