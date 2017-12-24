package com.cv.application;

import android.app.Application;

import com.cv.DaggerMainComponent;
import com.cv.MainComponent;
import com.cv.MainModule;
import com.cv.db.CVRealmModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by christopher.lester on 12/22/17.
 */

public class CVApplication extends Application {

    public MainComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .modules(new CVRealmModule())
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        component = DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .build();
        component.inject(this);
    }

    public MainComponent getComponent(){
        return component;
    }
}
