package ru.sberbank.homework28.mvvm.paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ru.sberbank.homework28.R;
import ru.sberbank.homework28.databinding.ImageItemBinding;
import ru.sberbank.homework28.model.Picture;
import ru.sberbank.homework28.mvp.ImageActivity;
import ru.sberbank.homework28.mvvm.recycler.ImageViewHolder;
import ru.sberbank.homework28.mvvm.recycler.PictureEventListener;

public class PagingAdapter extends PagedListAdapter<Picture, ImageViewHolder> implements PictureEventListener {

    private Context mContext;

    public PagingAdapter(Context context, @NonNull DiffUtil.ItemCallback<Picture> diffCallback) {
        super(diffCallback);
        mContext = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ImageItemBinding imageItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.image_item, viewGroup, false);
        return new ImageViewHolder(imageItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.bind(getItem(i), this);
    }

    @Override
    public void openPicture(Picture picture) {
        mContext.startActivity(ImageActivity.newIntent(mContext, picture.getUrls().getRegular()));
    }
}
