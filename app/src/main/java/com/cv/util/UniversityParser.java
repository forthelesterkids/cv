package com.cv.util;

import android.support.annotation.NonNull;

import com.cv.model.Catalog;
import com.cv.model.CatalogEntry;
import com.cv.model.University;

import javax.inject.Inject;

/**
 * Created by christopher.lester on 12/2/17.
 */

public class UniversityParser {

    private final University university;

    @Inject
    UniversityParser(University university) {
        this.university = university;
    }

    Catalog getCatalogById(@NonNull String uuid) {
        for (Catalog catalog : university.getCatalogs()) {
            return catalog.getUUID().equals(uuid) ? catalog : null;
        }
        return null;
    }

    CatalogEntry getCatalogEntryById(@NonNull String catalogId, @NonNull String catalogEntryId) {
        for (CatalogEntry catalogEntry : getCatalogById(catalogId).getCatalogEntries()) {
            return catalogEntry.getUuid().equals(catalogEntryId) ? catalogEntry : null;
        }
        return null;
    }

}
