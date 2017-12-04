package com.cv.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.cv.R;
import com.cv.application.CVApplication;
import com.cv.db.RealmDBHelper;
import com.cv.model.CatalogEntry;
import com.cv.model.ListItem;

import javax.inject.Inject;

public class CatalogEntryActivity extends FragmentActivity implements TimestampCallback {

    private CatalogEntry catalogEntry;

    @Inject RealmDBHelper realmDBHelper;
    private CatalogEntryVideoViewFragment catalogEntryVideoViewFragment;
    private CatalogSearchFragment catalogSearchFragment;
    private static final String UUID = "UUID";

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        ((CVApplication) getApplication()).component().inject(this);
        setContentView(R.layout.activity_catalog_entry);
        catalogEntryVideoViewFragment = (CatalogEntryVideoViewFragment) getSupportFragmentManager().findFragmentById(R.id.video_view);
        catalogSearchFragment = (CatalogSearchFragment) getSupportFragmentManager().findFragmentById(R.id.catalog_entry_search);
    }

    @Override
    protected void onStart() {
        super.onStart();
        catalogEntry = realmDBHelper.getStubCatalogEntryById(UUID);
        catalogSearchFragment.setCatalogEntry(catalogEntry);
    }

    @Override
    public void updateTimestamp(ListItem listable){
        catalogEntryVideoViewFragment.seekToTimestamp(listable.timestamp());
    }
}
