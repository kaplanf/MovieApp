package com.sample.movieapp.data.network.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;

import io.realm.annotations.PrimaryKey;
import java.io.Serializable;

public class MovieResponse extends RealmObject implements Serializable {

  @SerializedName("page")
  private int page;

  @SerializedName("total_results")
  private int totalResults;

  @SerializedName("total_pages")
  private int totalPages;

  @SerializedName("results")
  private RealmList<MovieObject> results;

  @PrimaryKey
  private int category;

  public int getPage() {
    return page;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public RealmList<MovieObject> getResults() {
    return results;
  }

  public void setCategory(int category) {
    this.category = category;
  }

}
