package com.cv.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class CatalogEntry implements RealmModel, Serializable {
    @PrimaryKey
    private String uuid;
    private String catalogEntryKey;
    private Transcription transcription;
    private RealmList<ListItem> searchables;
    private String videoPath;

    public CatalogEntry() {
    }

    public CatalogEntry(@NonNull String uuid, @NonNull String catalogEntryKey, @NonNull Transcription transcription,
                        @NonNull RealmList<ListItem> searchables, @NonNull String videoPath) {
        this.uuid = uuid;
        this.catalogEntryKey = catalogEntryKey;
        this.transcription = transcription;
        this.searchables = searchables;
        this.videoPath = videoPath;
    }

    public String getUuid() {
        return uuid;
    }

    public RealmList<ListItem> getSearchables() {
        return searchables;
    }

    public Transcription getTranscription(){ return transcription; }

    public String getCatalogEntryKey(){ return catalogEntryKey; }

    public String getVideoPath(){ return videoPath; }

    interface Generator {
        RealmList<ListItem> filteredSearchables(RealmList<ListItem> searchables, @NonNull String searchString);
    }

}
