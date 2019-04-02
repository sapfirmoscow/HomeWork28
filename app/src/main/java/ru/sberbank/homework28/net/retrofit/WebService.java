package ru.sberbank.homework28.net.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.sberbank.homework28.entity.Picture;

public interface WebService {


    @GET("photos/random")
    Call<List<Picture>> getRandomPhotos(@Query("count") int countOfPhotos, @Query("client_id") String clientKey);

    @GET("photos/")
    Call<List<Picture>> getPhotos(@Query("page") int page, @Query("per_page") int countOfPhotos, @Query("client_id") String clientKey, @Query("order_by") String sort);
}
