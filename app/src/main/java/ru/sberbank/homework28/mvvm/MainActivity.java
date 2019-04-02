package ru.sberbank.homework28.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import ru.sberbank.homework28.R;
import ru.sberbank.homework28.databinding.ActivityMainBinding;
import ru.sberbank.homework28.entity.Picture;
import ru.sberbank.homework28.mvvm.paging.PagingAdapter;
import ru.sberbank.homework28.mvvm.recycler.SpacesItemDecoration;

public class MainActivity extends AppCompatActivity {

    private PagingAdapter mPagingAdapter;
    private ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();

        final MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.getPictures().observe(this, new Observer<PagedList<Picture>>() {
            @Override
            public void onChanged(@Nullable PagedList<Picture> pictures) {
                mPagingAdapter.submitList(pictures);
            }
        });
    }

    private void initRecyclerView() {
        mMainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mMainBinding.recyclerView.addItemDecoration(new SpacesItemDecoration(25));
        mPagingAdapter = new PagingAdapter(MainActivity.this, new DiffCallback());
        mMainBinding.recyclerView.setAdapter(mPagingAdapter);
    }
}
