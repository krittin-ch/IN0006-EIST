package de.tum.in.ase.eist;

import io.grpc.*;
import de.tum.in.ase.eist.grpc.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Sample client code that makes gRPC calls to the server.
 */
public class WeatherClient {

    private static final Logger logger = Logger.getLogger(WeatherClient.class.getName());

    private final WeatherReporterGrpc.WeatherReporterBlockingStub blockingStub;

    /**
     * Construct client for accessing WeatherReporter server using the existing channel.
     */
    public WeatherClient(Channel channel) {
        blockingStub = WeatherReporterGrpc.newBlockingStub(channel);
    }

    /**
     * Blocking unary call example. Calls getCityWeatherSingleDay and prints the response.
     *
     * @param day
     * @param month
     * @param year
     * @param city
     * @param country
     */
    public void getCityWeatherSingleDay(int day, int month, int year, String city, String country) {
        // TODO: Task 3 (Optional): Call the WeatherReporterService via the blockingStub
    }

    /**
     * Blocking server-streaming example. Calls getCityWeatherMultipleDays with a locationDatePeriod. Prints each
     * response CityWeatherData as it arrives.
     */
    public void getCityWeatherMultipleDays(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear, String city, String country) {
        // TODO: Task 3 (Optional): Call the WeatherReporterService via the blockingStub
    }

    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:8980";
        if (args.length > 0) {
            if ("--help".equals(args[0])) {
                System.err.println("Usage: [target]");
                System.err.println("");
                System.err.println("  target  The server to connect to. Defaults to " + target);
                System.exit(1);
            }
            target = args[0];
        }

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        try {
            WeatherClient weatherClient = new WeatherClient(channel);

            // Here you can test some calls the WeatherReporterServer
            // For example:
            weatherClient.getCityWeatherSingleDay(1, 11, 2023, "Munich", "Germany");
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}