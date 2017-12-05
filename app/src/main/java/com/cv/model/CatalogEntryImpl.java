package com.cv.model;

import android.support.annotation.NonNull;

import io.realm.RealmList;

public class CatalogEntryImpl implements CatalogEntry.Generator {

    public CatalogEntryImpl() {
    }

    @Override
    public RealmList<ListItem> filteredSearchables(RealmList<ListItem> searchables, @NonNull final String searchString) {
        RealmList<ListItem> filtered = new RealmList<>();
        for (ListItem item : searchables) {
            if (item.getContent().contains(searchString)) {
                filtered.add(item);
            }
        }
        return filtered;
    }
}
