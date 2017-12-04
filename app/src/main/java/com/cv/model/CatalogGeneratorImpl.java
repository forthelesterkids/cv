package com.cv.model;

import android.support.annotation.NonNull;

import com.cv.util.UUIDGenerator;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmModel;

public class CatalogGeneratorImpl implements Catalog.Generator {

    private final UUIDGenerator uuidGenerator;
    private final ModelRecorder<? extends RealmModel> modelRecorder;
    private final Catalog catalog;

    @Inject
    public CatalogGeneratorImpl(@NonNull UUIDGenerator uuidGenerator,
                                   @NonNull ModelRecorder<Catalog> modelRecorder,
                                   @NonNull Catalog catalog) {
        this.uuidGenerator = uuidGenerator;
        this.modelRecorder = modelRecorder;
        this.catalog = catalog;
    }

    @Override
    public CatalogEntry loadCatalogEntryById(@NonNull String uuid){
        Realm realm = Realm.getDefaultInstance();
        CatalogEntry catalog = (CatalogEntry) realm.where(CatalogEntry.class).equalTo("uuid", uuid).findFirst();
        realm.close();

        return catalog;
    }
}
