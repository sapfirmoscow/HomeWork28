package ru.sberbank.homework28.mvvm.paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import java.util.List;

import ru.sberbank.homework28.entity.Picture;
import ru.sberbank.homework28.mvvm.MyModel;

public class MyDataSource extends PageKeyedDataSource<Integer, Picture> {

    private MyModel mModel;

    public MyDataSource() {
        mModel = new MyModel();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Picture> callback) {
        int currentPage = 1;

        List<Picture> pictureList = getPhotos(currentPage, params.requestedLoadSize);
        callback.onResult(pictureList, null, currentPage);

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Picture> callback) {
        int currentPage = params.key - 1;

        List<Picture> pictureList = getPhotos(currentPage, params.requestedLoadSize);
        callback.onResult(pictureList, currentPage);
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Picture> callback) {
        int currentPage = params.key + 1;

        List<Picture> pictureList = getPhotos(currentPage, params.requestedLoadSize);
        callback.onResult(pictureList, currentPage);
    }

    private List<Picture> getPhotos(int currentPage, int coountOfPhotos) {
        return mModel.getPictures(currentPage, coountOfPhotos);
    }
}
