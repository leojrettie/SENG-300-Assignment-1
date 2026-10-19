package trip;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Trip {
    private final String tripID;
    private final User user;
    private final Vehicle vehicle;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public Trip(User user, Vehicle vehicle) {
        this.tripID = UUID.randomUUID().toString();
        this.startTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.user = user;
    }
}
