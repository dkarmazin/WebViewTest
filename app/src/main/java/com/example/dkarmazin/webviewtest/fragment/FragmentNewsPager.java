package com.example.dkarmazin.webviewtest.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dkarmazin.webviewtest.R;
import com.example.dkarmazin.webviewtest.adapter.ArticlesListViewPageAdapter;

public class FragmentNewsPager extends Fragment {
    private View view;
    private ViewPager articleSwiper;
    private ArticlesListViewPageAdapter adapter;

    public FragmentNewsPager() {}

    public static FragmentNewsPager newInstance() {
        return new FragmentNewsPager();
    }

    @Override
    public void onStart() {
        super.onStart();

        int[] itemProvider = {1,2,3,4,5};
        adapter = new ArticlesListViewPageAdapter(getActivity(), itemProvider);

        articleSwiper.setAdapter(adapter);
        articleSwiper.setCurrentItem(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_pager, container, false);
        articleSwiper = (ViewPager) view.findViewById(R.id.article_gallery);

        return view;
    }
}
