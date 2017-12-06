package com.cv.model;

import android.support.annotation.NonNull;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class Catalog implements RealmModel {

    @PrimaryKey
    private String uuid;
    private String catalogKey;
    private RealmList<CatalogEntry> catalogEntries;

    public Catalog() {
    }

    public Catalog(String uuid, String catalogKey, RealmList<CatalogEntry> catalogEntries) {
        this.uuid = uuid;
        this.catalogKey = catalogKey;
        this.catalogEntries = catalogEntries;
    }

    public String getUUID() {
        return uuid;
    }

    public RealmList<CatalogEntry> getCatalogEntries() {
        return catalogEntries;
    }

    public String getCatalogKey(){ return catalogKey; }

    interface Generator {
        CatalogEntry loadCatalogEntryById(@NonNull String uuid);
    }

}
