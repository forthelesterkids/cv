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
import com.cv.model.CatalogEntry;

public class CatalogEntryVideoViewFragment extends Fragment implements VideoUpdateable {

    private VideoView videoView;
    private CatalogEntry catalogEntry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View videoContainer = inflater.inflate(R.layout.catalog_entry_video_view_fragment, container);
        videoView = (VideoView) videoContainer.findViewById(R.id.video_view);
        addVideoController();

        return videoContainer;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() instanceof CatalogEntryActivity) {
            catalogEntry = ((CatalogEntryActivity) getActivity()).getCatalogEntry();
        }
        updateVideoView(catalogEntry);
    }

    public void addVideoController() {
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
    }

    private void updateVideoView(CatalogEntry catalogEntry) {
        videoView.setVideoURI(Uri.parse(catalogEntry.getVideoPath()));
        videoView.start();
    }

    @Override
    public void seekToTimestamp(int timestamp) {
        videoView.seekTo(timestamp);
        videoView.start();
    }

}
