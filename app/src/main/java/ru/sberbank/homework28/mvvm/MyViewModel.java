package ru.sberbank.homework28.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import ru.sberbank.homework28.model.Picture;
import ru.sberbank.homework28.mvvm.paging.MySourceFactory;

public class MyViewModel extends ViewModel {

    private LiveData<PagedList<Picture>> mPictures;
    private PagedList.Config mConfig;

    public MyViewModel() {
        super();
        mConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPrefetchDistance(15)
                .setPageSize(30)
                .setInitialLoadSizeHint(30)
                .build();
    }

    public LiveData<PagedList<Picture>> getPictures() {
        if (mPictures == null) {
            mPictures = new LivePagedListBuilder<>(new MySourceFactory(), mConfig).build();
        }
        return mPictures;
    }
}
