package com.cv.model;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.realm.RealmList;
import io.realm.RealmModel;

public class UniversityGeneratorImpl implements University.Generator {

    private ModelRecorder<University> modelRecorder;
    private final University university;

    @Inject
    public UniversityGeneratorImpl(@NonNull University university, @NonNull ModelRecorder<University> modelRecorder) {
        this.university = university;
        this.modelRecorder = modelRecorder;
    }

    @Override
    public void recordUniversity(@NonNull RealmModel university) {
        modelRecorder.persistModel(university);
    }

    @Override
    public RealmList<Catalog> getCatalogs() {
        return university.getCatalogs();
    }

    @Override
    public Catalog getCatalogForId(@NonNull String uuid) {
        for (Catalog catalog : university.getCatalogs()) {
            return catalog.getUUID().equals(uuid) ? catalog : null;
        }
        return null;
    }

    @Override
    public CatalogEntry getCatalogEntryForId(@NonNull String catalogId, @NonNull String catalogEntryId) {
        for (CatalogEntry catalogEntry : getCatalogForId(catalogId).getCatalogEntries()) {
            return catalogEntry.getUuid().equals(catalogEntryId) ? catalogEntry : null;
        }
        return null;
    }
}
