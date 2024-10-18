package com.example.swipevideotest;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    /**
     * Sets the list of video items to be played
     * @param videoItems list of videos to be played
     */
    public VideoAdapter(List<VideoItem> videoItems){
        this.videoItems = videoItems;
    }

    /**
     * Creates a new video holder
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return VideoViewHolder
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false));
    }

    /**
     * Sets the video data to the next video
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    /**
     * Gets the amount of items in videoItems
     * @return number of items
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     * Holds the videos so they can be played
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder{

        TextView textVideoTitle1, textVideoDescription1, textVideoID;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         * Holds the video
         * @param itemView the next video item
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
            textVideoID = itemView.findViewById(R.id.videoID);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        /**
         * Sets the video data of the next video
         * @param videoItem the next video
         */
        void setVideoData(VideoItem videoItem){

            textVideoTitle1.setText(videoItem.videoTitle);
            textVideoDescription1.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);
            textVideoID.setText(videoItem.videoID);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();

                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if(scale >= 1f){
                        videoView.setScaleX(scale);
                    } else{
                        videoView.setScaleY(1f / scale);
                    }
                }

            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
