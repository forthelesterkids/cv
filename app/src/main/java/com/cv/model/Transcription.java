package com.cv.model;

import android.support.annotation.NonNull;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

@RealmClass
public class Transcription implements RealmModel {

    private String uuid;
    private String transcription;

    public Transcription() {
    }

    public Transcription(@NonNull String uuid, @NonNull String transcription) {
        this.uuid = uuid;
        this.transcription = transcription;
    }

    public String getTranscription() {
        return this.transcription;
    }

}
