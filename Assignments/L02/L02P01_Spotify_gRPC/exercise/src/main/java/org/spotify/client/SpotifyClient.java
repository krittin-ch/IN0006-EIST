package org.spotify.client;

import io.grpc.Channel;
import org.spotify.grpc.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpotifyClient {
    @SuppressWarnings("unused")
    private final SpotifyConnection spotifyConnection;

    @SuppressWarnings("unused")
    public SpotifyClient(Channel channel) {
        this.spotifyConnection = new SpotifyConnection(channel);
    }

    public SpotifyClient() throws SpotifyClientException {
        this.spotifyConnection = new SpotifyConnection();
    }

    public String displayPlaylist(int[] playlist) throws SpotifyClientException {
        // TODO: Implement displayPlaylist
        return "displayPlaylist is not implemented yet";
    }

    public String displayAlbum(int id) throws SpotifyClientException {
        // TODO: Implement displayAlbum
        return "displayAlbum is not implemented yet";
    }

    public static void main(String[] args) throws SpotifyClientException {
        SpotifyClient client = new SpotifyClient();

        // Examples from Artemis
        // System.out.println(client.displayPlaylist(new int[] {82763, 2791, 80673, 62523, 61703}));
        // System.out.println(client.displayAlbum(24534));
    }
}
