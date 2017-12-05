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
    private String key;
    private RealmList<ListItem> headerText;
    private RealmList<ListItem> searchables;

    public CatalogEntry() {
    }

    public CatalogEntry(@NonNull String uuid, @NonNull String catalogEntryKey, @NonNull Transcription transcription,
                        @NonNull RealmList<ListItem> searchables) {
        this.uuid = uuid;
        this.catalogEntryKey = catalogEntryKey;
        this.transcription = transcription;
        this.searchables = searchables;
    }

    public String getUuid() {
        return this.uuid;
    }

    public RealmList<ListItem> getSearchables() {
        return this.searchables;
    }

    interface Generator {
        RealmList<ListItem> filteredSearchables(RealmList<ListItem> searchables, @NonNull String searchString);
    }

}
