package com.cv.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ListFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.cv.R;
import com.cv.adapter.ListItemAdapter;
import com.cv.application.CVApplication;
import com.cv.model.CatalogEntry;
import com.cv.model.CatalogEntryImpl;
import com.cv.model.ListItem;

import javax.inject.Inject;

import io.realm.RealmList;

public class CatalogSearchFragment extends ListFragment {

    private ListView listView;
    private EditText searchText;
    private CatalogEntry catalogEntry;
    @Inject
    CatalogEntryImpl catalogEntryImpl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View searchView = inflater.inflate(R.layout.catalog_search_fragment, container);
        ((CVApplication) getActivity().getApplication()).getComponent().inject(this);
        listView = (ListView) searchView.findViewById(android.R.id.list);
        searchText = (EditText) searchView.findViewById(R.id.search);
        addListeners();

        return searchView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() instanceof CatalogEntryActivity) {
            catalogEntry = ((CatalogEntryActivity) getActivity()).getCatalogEntry();
        }
    }

    private void addListeners() {
        searchText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    updateList(catalogEntryImpl.filteredSearchables(catalogEntry.getSearchables(),
                            searchText.getText().toString()));
                }
                return false;
            }
        });

    }

    public void updateList(@NonNull RealmList<ListItem> transcriptionEntries) {

        ListItemAdapter searchAdapter = new ListItemAdapter(getActivity(), android.R.layout.simple_list_item_1,
                transcriptionEntries);
        listView.setAdapter(searchAdapter);
    }

}
