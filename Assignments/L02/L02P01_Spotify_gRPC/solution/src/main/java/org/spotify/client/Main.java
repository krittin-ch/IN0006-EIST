package org.spotify.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {
    public static void main(String[] args) {
        // Create a managed channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9010) // default gRPC port
                .usePlaintext() // For development/testing only
                .build();

        try {
            SpotifyClient client = new SpotifyClient(channel);
            int[] playlist = {82763, 2791, 80673, 62523, 61703};
            System.out.println(client.displayPlaylist(playlist));

            int albumId = 24534;
            System.out.println(client.displayAlbum(albumId));

        } catch (SpotifyClientException e) {
            System.out.println("Reason: " + e.getMessage());
            channel.shutdown();
        }

    }
}
