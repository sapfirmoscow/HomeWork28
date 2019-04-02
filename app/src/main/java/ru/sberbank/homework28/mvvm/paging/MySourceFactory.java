package ru.sberbank.homework28.mvvm.paging;

import android.arch.paging.DataSource;

import ru.sberbank.homework28.model.Picture;

public class MySourceFactory extends DataSource.Factory<Integer, Picture> {

    @Override
    public DataSource<Integer, Picture> create() {
        return new MyDataSource();
    }
}
