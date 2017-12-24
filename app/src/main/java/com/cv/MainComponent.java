package com.cv;

import com.cv.application.CVApplication;
import com.cv.view.CatalogEntryActivity;
import com.cv.view.CatalogSearchFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(CatalogEntryActivity catalogEntryActivity);

    void inject(CatalogSearchFragment catalogSearchFragment);

    void inject(CVApplication cvApplication);
}
