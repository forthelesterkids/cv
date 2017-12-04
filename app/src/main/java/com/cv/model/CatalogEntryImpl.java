package com.cv.model;

import android.support.annotation.NonNull;

import java.util.Iterator;

import io.realm.RealmList;

public class CatalogEntryImpl implements CatalogEntry.Generator {

    public CatalogEntryImpl(){}
    @Override
    public RealmList<ListItem> filteredSearchables(RealmList<ListItem> searchables, @NonNull final String searchString) {
        for (Iterator iterator = searchables.iterator(); iterator.hasNext();) {
            ListItem searchable = (ListItem) iterator.next();
            if (!searchable.getContent().contains(searchString)) {
                iterator.remove();
            }
        }
        return searchables;
    }
}
