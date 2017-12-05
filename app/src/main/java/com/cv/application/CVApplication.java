package com.cv.application;

import android.app.Application;

import com.cv.DaggerMainComponent;
import com.cv.MainComponent;
import com.cv.MainModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class CVApplication extends Application {
    private MainComponent component;

    public CVApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("cv.cvrealm").build();
        Realm.setDefaultConfiguration(config);
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .build();
    }

    public MainComponent component() {
        return component;
    }
}
