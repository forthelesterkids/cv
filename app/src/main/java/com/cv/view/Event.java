package com.cv.view;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by christopher.lester on 12/22/17.
 */

public class Event extends RealmObject {

    @PrimaryKey
    public String id = "1";
    public String name;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
