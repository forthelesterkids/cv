package com.cv.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.cv.R;

public class CatalogEntryVideoViewFragment extends Fragment implements VideoUpdateable {

    private VideoView videoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View videoContainer = inflater.inflate(R.layout.catalog_entry_video_view_fragment, container);
        videoView = (VideoView)videoContainer.findViewById(R.id.video_view);
        addVideoController();

        return videoContainer;
    }

    public void addVideoController(){
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        //hard coded for now using fake data
        String uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.new_backyard;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();
    }

    @Override
    public void seekToTimestamp(int timestamp){
        videoView.seekTo(timestamp);
        videoView.start();
    }

}
