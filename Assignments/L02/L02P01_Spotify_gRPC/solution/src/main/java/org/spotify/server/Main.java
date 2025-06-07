package org.spotify.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder
                    .forPort(9010) // must match with client!
                    .addService(new MetadataServiceImpl())
                    .build()
                    .start();

            System.out.println("gRPC server started on port 50051");

            // Keep the server running
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println("Failed to start gRPC server ");
            System.out.println("Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
