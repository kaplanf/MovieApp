package com.sample.movieapp.data.network.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

import java.io.Serializable;

public class MovieObject extends RealmObject implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("title")
    private String title;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("popularity")
    private Double popularity;

    public int getId() {
        return id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }
}
