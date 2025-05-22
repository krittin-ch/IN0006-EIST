# Spotify gRPC

> **What is gRPC?** <br/> gRPC is a high performance, open-source framework developed by Google to handle remote procedure calls (RPCs). It enables a client application to directly call methods on a server application on a different machine as if it was a local object, making it easier for you to create distributed applications and services. Using gRPC provides a way for programmers to abstract over the details of remote communication between different machines, languages, or operating systems.

This exercise is based on a [real world, production use case of gRPC](https://www.youtube.com/watch?v=CbNimCiMqe8). Spotify uses gRPC for their Metadata Service, which we've set up a simplified version of.

To get started clone the project and familiarize yourself with the project structure. Make sure to compile the `.proto` definitions by running `./gradlew generateProto`. You need to repeat this step every time you change the `.proto` definitions.

1. **Implement displayPlaylist**

    We allow our listeners to create playlists of their favorite songs. Your task is now to implement a method `public String displayPlaylist(int[] playlist)` in the `SpotifyClient` class which takes in an array of track IDs and then returns an easy to read view of the playlist. First get information about the tracks using the `getTrackMetadata` gRPC method, once you've done that you now need to return the results in the following format:

    > **Note:** In order to provide our listeners with a nice experience we pad the seconds of a song. So a song that is `188` seconds long should be displayed as `3:08` instead of `3:8`.

    ```
    1. Track Name - Artist (Duration)
    ...
    n. Track Name - Artist (Duration)
    ```

    If the metadata service returns an empty track list while having songs in the playlist, it means something went wrong. In order to still give the user a nice experience throw a `SpotifyClientException` with the error message `Failed to get track metadata`.

2. **Add Protobuf definitions for getAlbumMetadata**

    > **Important:** After making any changes to the `spotify.proto` file make sure to re-run `./gradlew generateProto`

    After our industry-leading playlists feature turned out to be a smash hit with our customers the board has decided that our next update will add support for albums. You will now need to help the metadata service team implement it.

    Before implementing the gRPC endpoint we need to set up the Protobuf definitions for it. Protocol Buffers are language-neutral, platform-neutral extensible mechanisms for serializing structured data. This basically defines the data structures that we expect the client to send us and what we will respond with.

    The first thing we need to add to `spotify.proto` is an `Album` which has the following fields in the following order:

    1. `id` which is a `uint64`
    2. `name` which is a `string`
    3. `artist` which is a `string`
    4. `tracks` which is an array of `uint32` (*Hint:* Take a Look at how `EntitiesRequest` handles multiple IDs)

    Next we want to make sure that our service can fetch multiple albums in one request. To be able to return multiple albums we need to implement `Albums` which has the following fields:

    1. album which is an array of Album

    Finally we add our `getAlbumMetadata` method to the `MetadataService`. It's input should be an `EntitiesRequest` and it should return `Albums`. This method is very similar to our `getTrackMetadata` method.

    **Note:** Check out the other protobuf definitions for reference.


3. **Implement getAlbumMetaData**

    > **Note:** After you implemented `Album` and `Albums` in the `spotify.proto` file, manually uncomment the `findAlbumById` function in the `Database` class. Also uncomment and add missing imports at the top of the file. The repository is missing the depedency for the protobuf utilities import. So make add them to the `build.gradle` file if you want to run the task locally by adding this line to the **dependencies:** `implementation "com.google.protobuf:protobuf-java-util:${protobufVersion}"`

    > **Important:** The `getTrackMetadata` method is missing an important return statement at the end of the `if (track == null)` block. Add this statement!

    Now that we added the Protobuf defintions for our method it's time to add the functionality to the server. In the `MetadataServiceImpl` class you can now add the `getAlbumMetadata` method. It works similarly to the `getTrackMetadata` method so you can use that for inspiration. In order to actually get data about albums you can use the `database.findAlbumById` method.

    Just like in the `getTrackMetadata` method if we can't find an album in the database we abort our fetching and just return an empty albums list.

4. **Implement displayAlbum**

    Now that we have extended the metadata service we can finally head back to the client where we now add the `public String displayAlbum(int id)` method. This method does the same thing as `displayPlaylist`, except we also add a header with the album name and total duration, because of this you can probably save yourself a bit of work by using the `displayPlaylist` function and modifying it's output.

    ```
    Album Name (Total-Duration)
        1. Track Name - Artist (Duration)
        ...
        n. Track Name - Artist (Duration)
    ```

    > *Note:* Mind the tab character `\t` before the Track Name and the newline char `\n` at the end of the output!!!

    If the metadata service returns an empty album list it means something went wrong. In order to still give the user a nice experience throw a `SpotifyClientException` with the error message `Failed to get album metadata`.

    > *Note:* If you want to test your solution locally you need to fix a mistake in the test data: Remove the trailing `\"` at the tracks array inside the JSON declaration of the test albums. Otherwise the JSON syntax is invalid.

    <details>
    <summary>Example output of the SpotifyClient</summary>

    `client.displayPlaylist(new int[] {82763, 2791, 80673, 62523, 61703})`
    
    ```
    1. 6 for 6 - Central Cee (2:28)
    2. Ginseng Strip 2002 - Yung Lean (2:33)
    3. Dans På Bordet - Ballinciaga (2:23)
    4. Nun id change - Yeat (3:31)
    5. Sure of Love - The Chantels (2:27)

    ```

    `client.displayAlbum(24534)`

    ```
    Berlin lebt (46:41)
        1. Berlin lebt - Capital Bra (3:03)
        2. Kennzeichen B-TK - Capital Bra (2:40)
        3. Giselle Bünchen - Capital Bra (3:24)
        4. Neymar - Capital Bra (4:23)
        5. 5 Songs in einer Nacht - Capital Bra (2:27)
        6. Gutes Herz - Capital Bra (3:12)
        7. Panzer, Tiger - Capital Bra (2:46)
        8. Ballert - Capital Bra (2:52)
        9. Baba Flow - Capital Bra (3:05)
        10. Darby - Capital Bra (3:21)
        11. One Night Stand - Capital Bra (2:42)
        12. Packen - Capital Bra (3:52)
        13. Glaub mir - Capital Bra (3:03)
        14. Meine Welt - Capital Bra (2:42)
        15. Wann dann - Capital Bra (3:09)

    ```    
    </details>
