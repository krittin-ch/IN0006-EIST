package de.tum.in.ase.eist;

import de.tum.in.ase.eist.grpc.*;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WeatherReporterServer {
    private static final Logger logger = Logger.getLogger(WeatherReporterServer.class.getName());

    private final int port;
    private final Server server;

    /**
     * Create a WeatherReporterServer server listening on {@code port} using {@code cityWeatherData}.
     */
    public WeatherReporterServer(int port, ArrayList<CityWeatherData> cityWeatherData) throws IOException {
        this(Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create()),
                port, cityWeatherData);
    }

    /**
     * Create a WeatherReporterServer server using serverBuilder as a base
     */
    public WeatherReporterServer(ServerBuilder<?> serverBuilder, int port, ArrayList<CityWeatherData> cityWeatherData) {
        this.port = port;
        server = serverBuilder.addService(new WeatherReporterService(cityWeatherData)).build();
    }

    /**
     * Start serving requests.
     */
    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    WeatherReporterServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    /**
     * Stop serving requests and shutdown resources.
     */
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<CityWeatherData> cityWeatherData = new ArrayList<>();
        WeatherReporterServer server = new WeatherReporterServer(8980, cityWeatherData);
        server.start();
        server.blockUntilShutdown();
    }

    /**
     * Implementation of WeatherReport service.
     *
     * <p>See weather_reporter.proto for details of the methods.
     */
    private static class WeatherReporterService extends WeatherReporterGrpc.WeatherReporterImplBase {
        private final ArrayList<CityWeatherData> allWeatherData;

        private WeatherReporterService(ArrayList<CityWeatherData> allWeatherData) {
            this.allWeatherData = allWeatherData;
        }

        // TODO: Task 2: Write an Implementation for the rpc methods
        // unary
        @Override
        public void getCityWeatherSingleDay(LocationDate req, StreamObserver<CityWeatherData> out) {
             for (CityWeatherData data: allWeatherData) {
                LocationDate storedLocationDate = data.getLocationDate();

                if (storedLocationDate == req) {
                    out.onNext(data);
                    out.onCompleted();
                    return;
                }
             }   
        }

        // streaming
        public void getCityWeatherMultipleDays(LocationDatePeriod req, StreamObserver<CityWeatherData> out) {
            Location targetLoc = req.getLocation();
            Date start = req.getStartDate();
            Date end = req.getEndDate();

            for (CityWeatherData data: allWeatherData) {
                LocationDate locDate = data.getLocationDate();

                boolean cityMatch = locDate.getLocation().getCity().equalsIgnoreCase(targetLoc.getCity());
                boolean countryMatch = locDate.getLocation().getCountry().equalsIgnoreCase(targetLoc.getCountry());
                boolean inRange = isDateInRange(locDate.getDate(), start, end);

                if (cityMatch & countryMatch & inRange) {
                    out.onNext(data);
                }
            }
            out.onCompleted();
            return;
        }

        private boolean isDateInRange(Date date, Date start, Date end) {
            int d = toInt(date);
            int s = toInt(start);
            int e = toInt(end);

            return (s <= d) & (d <= e);
        }

        private int toInt(Date date) {
            // YYYYMMDD
            return date.getYear() * 10000 + date.getMonth() * 100 + date.getDay();
        }
        
    }
}