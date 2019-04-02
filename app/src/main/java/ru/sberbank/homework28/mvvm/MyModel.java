package ru.sberbank.homework28.mvvm;

import java.io.IOException;
import java.util.List;

import ru.sberbank.homework28.entity.Picture;
import ru.sberbank.homework28.net.retrofit.ApiMapper;
import ru.sberbank.homework28.net.retrofit.RetrofitHelper;

public class MyModel {

    private final ApiMapper apiMapper;
    private List<Picture> pictures;


    public MyModel() {
        apiMapper = new ApiMapper(new RetrofitHelper());
    }

    public List<Picture> getPictures(int currentPage, int coountOfPhotos) {
        try {
            return apiMapper.getPhotosSync(currentPage, coountOfPhotos).body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}