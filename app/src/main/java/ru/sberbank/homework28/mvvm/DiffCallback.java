package ru.sberbank.homework28.mvvm;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import ru.sberbank.homework28.model.Picture;

class DiffCallback extends DiffUtil.ItemCallback<Picture> {
    @Override
    public boolean areItemsTheSame(@NonNull Picture picture, @NonNull Picture t1) {
        return picture.getId().equals(t1.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Picture picture, @NonNull Picture t1) {
        return picture.equals(t1);
    }
}
