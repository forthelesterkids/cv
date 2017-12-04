package com.cv;

import com.cv.db.RealmDBHelper;
import com.cv.model.CatalogEntryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides @Singleton
    public RealmDBHelper providesRealmDBHelper() {
        return RealmDBHelper.getInstance();
    }

    @Provides @Singleton
    public CatalogEntryImpl providesCatalogEntryImpl() {
        return new CatalogEntryImpl();
    }
}
