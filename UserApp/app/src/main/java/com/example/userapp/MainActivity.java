package com.example.userapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String[][]> {

    RecyclerView recyclerViewList;
    LoaderManager loaderManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("User Data");

        recyclerViewList = findViewById(R.id.recyclerViewList);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));

        loaderManager = getSupportLoaderManager();

        if (loaderManager.getLoader(1) != null) {
            loaderManager.initLoader(1, null, this);
        } else {
            startProfileAsyncTaskLoader();
        }

    }

    public void startProfileAsyncTaskLoader() {
        loaderManager.initLoader(1, null, this);
    }

    @NonNull
    @Override
    public Loader<String[][]> onCreateLoader(int id, @Nullable Bundle args) {
        return new UserAsyncTaskLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String[][]> loader, String[][] data) {
        recyclerViewList.setAdapter(new RecyclerAdapter(data));
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String[][]> loader) {

    }
}
