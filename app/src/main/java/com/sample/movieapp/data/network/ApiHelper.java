package com.sample.movieapp.data.network;


import com.sample.movieapp.data.network.model.MovieResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    ApiHeader getApiHeader();

    @GET(ApiEndPoint.POPULAR)
    Observable<MovieResponse> getPopular(@Query("api_key") String apikey);

    @GET(ApiEndPoint.TOP_RATED)
    Observable<MovieResponse> getTopRated(@Query("api_key") String apikey);

    @GET(ApiEndPoint.UPCOMING)
    Observable<MovieResponse> getUpcoming(@Query("api_key") String apikey);
}
