package com.cv.model;

import android.support.annotation.NonNull;

import java.util.Collection;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;


@RealmClass
public class University implements RealmModel {

    @PrimaryKey
    private String uuid;
    private String universityKey;
    private RealmList<Catalog> catalogs;

    public University() {
    }

    public University(String uuid, String universityKey, RealmList<Catalog> catalogs) {
        this.uuid = uuid;
        this.universityKey = universityKey;
        this.catalogs = catalogs;
    }

    public RealmList<Catalog> getCatalogs() {
        return catalogs;
    }

    public String getUUID(){ return uuid; }

    public String getUniversityKey(){ return universityKey; }

    interface Generator {
        Catalog getCatalogForId(@NonNull String uuid);

        void recordUniversity(@NonNull RealmModel university);

        CatalogEntry getCatalogEntryForId(@NonNull String catalogId, @NonNull String catalogEntryId);

        Collection<Catalog> getCatalogs();
    }
}
