package com.cv.db;


import com.cv.model.Catalog;
import com.cv.model.CatalogEntry;
import com.cv.model.ListItem;
import com.cv.model.Transcription;
import com.cv.model.University;

import io.realm.annotations.RealmModule;

@RealmModule(classes = { Catalog.class, CatalogEntry.class, ListItem.class, Transcription.class,
        University.class})

public class CVRealmModule {}

