package com.cv.model;

import android.support.annotation.NonNull;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class ListItem implements RealmModel {

    @PrimaryKey
    private String uuid;
    private String content;
    private int timestamp;

    public ListItem(){}

    public ListItem(@NonNull String content, int timestamp, @NonNull String uuid){
        this.content = content;
        this.timestamp = timestamp;
        this.uuid = uuid;
    }
    public String getContent(){
        return this.content;
    }

    public int timestamp(){
        return this.timestamp;
    }
}
