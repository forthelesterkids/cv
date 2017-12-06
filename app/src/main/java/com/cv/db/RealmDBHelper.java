package com.cv.db;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cv.model.Catalog;
import com.cv.model.CatalogEntry;
import com.cv.model.ListItem;
import com.cv.model.Transcription;
import com.cv.model.University;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by christopher.lester on 12/3/17.
 */

public class RealmDBHelper {

    private static final String TAG = "RealmDBHelper";

    private static final RealmDBHelper instance = new RealmDBHelper();

    private RealmDBHelper() {
    }

    public static RealmDBHelper getInstance() {
        return instance;
    }

    public University getUniversityById(@NonNull String uuid) {
        Realm realm = Realm.getDefaultInstance();
        University university = null;
        try {
            university = realm.where(University.class).equalTo("uuid", uuid).findFirst();
        } catch (Exception exception) {
            Log.e(TAG, "Exception hit while trying to fetch University");
        } finally {
            realm.close();
            return university;
        }
    }

    public Catalog getCatalogById(@NonNull String uuid) {
        Realm realm = Realm.getDefaultInstance();
        Catalog catalog = null;
        try {
            catalog = realm.where(Catalog.class).equalTo("uuid", uuid).findFirst();
        } catch (Exception exception) {
            Log.e(TAG, "Exception hit while trying to fetch Catalog");
        } finally {
            realm.close();
            return catalog;
        }
    }

    public CatalogEntry getStubCatalogEntryById(@NonNull String uuid) {
        Transcription transcription = new Transcription("1", "ok lets try this again first video i made was 5 way too big to use my free converter 10 so lets try to cap it out at about 15 twenty seconds\n" +
                "my backyard by the way one more time thats my grill ok cool");
        RealmList<ListItem> listItems = new RealmList<>();
        listItems.add(new ListItem("ok lets try this again first video i made was", 0, "1"));
        listItems.add(new ListItem("way too big to use my free converter", 5000, "1"));
        listItems.add(new ListItem("so lets try to cap it out at about", 10000, "1"));
        listItems.add(new ListItem("twenty seconds my backyard by the way one more time thats my grill ok cool", 15000, "1"));
        String videoUri = "android.resource://com.cv/raw/new_backyard";
        CatalogEntry catalogEntry = new CatalogEntry(uuid, "1", transcription, listItems, videoUri);
        return catalogEntry;
    }

    public void persistCatalogEntry(final CatalogEntry catalogEntry) {
    }
}
