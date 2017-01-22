package com.example.queenabergen.memestudio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yojanasharma on 1/20/17.
 */

public class YojanaFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yojana_fragment, parent, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.images_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        adapter = new ImageAdapter();
        recyclerView.setAdapter(adapter);
    }

}
