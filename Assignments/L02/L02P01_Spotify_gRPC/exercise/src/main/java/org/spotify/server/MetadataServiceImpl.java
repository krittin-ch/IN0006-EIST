package org.spotify.server;

import io.grpc.stub.StreamObserver;
import org.spotify.db.Database;
import org.spotify.grpc.*;

public class MetadataServiceImpl extends MetadataServiceGrpc.MetadataServiceImplBase {
    private final Database database;

    @SuppressWarnings("unused")
    public MetadataServiceImpl(Database database) {
        this.database = database;
    }

    public MetadataServiceImpl() {
        this.database = new Database();
    }

    @Override
    public void getTrackMetadata(EntitiesRequest request, StreamObserver<Tracks> responseObserver) {
        Tracks.Builder tracks = Tracks.newBuilder();

        for(int i = 0; i < request.getIdCount(); i++) {
            Track track = database.findTrackById(request.getId(i));

            if(track == null) {
                responseObserver.onNext(Tracks.newBuilder().build());
                responseObserver.onCompleted();
            }

            tracks.addTrack(track);
        }

        responseObserver.onNext(tracks.build());
        responseObserver.onCompleted();
    }
}
