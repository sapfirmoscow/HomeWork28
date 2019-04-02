package ru.sberbank.homework28.net.retrofit;


import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import ru.sberbank.homework28.entity.Picture;

public class ApiMapper {
    private static final String KEY = "55b011812162d0ec5e2e8628d3892bffffb66d6699f99c0d0e235315a166f5a3";
    private RetrofitHelper mHelper;

    public ApiMapper(RetrofitHelper helper) {
        mHelper = helper;
    }

    public List<Picture> getRandomPhotosSync(int countOfPhotos) throws IOException {
        return mHelper.getService().getRandomPhotos(countOfPhotos, KEY).execute().body();
    }

    public void getRandomPhotosAsync(int coountOfPhotos, Callback<List<Picture>> callback) {
        mHelper.getService().getRandomPhotos(coountOfPhotos, KEY).enqueue(callback);
    }

    public Response<List<Picture>> getPhotosSync(int page, int countOfPhotos) throws IOException {
        return mHelper.getService().getPhotos(page, countOfPhotos, KEY, "latest").execute();
    }
}
