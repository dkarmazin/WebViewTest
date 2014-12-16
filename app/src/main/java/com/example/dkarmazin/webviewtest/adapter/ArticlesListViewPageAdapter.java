package com.example.dkarmazin.webviewtest.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dkarmazin.webviewtest.R;
import com.example.dkarmazin.webviewtest.view.NewsDetailsContainer;


public class ArticlesListViewPageAdapter extends PagerAdapter {
    private int[] itemProvider;
    private LayoutInflater layoutInfater;
    private Activity activity;

    SparseArray<View> views = new SparseArray<View>();

    public ArticlesListViewPageAdapter(Activity activity, int[] itemProvider) {
	    this.itemProvider = itemProvider;
		this.activity = activity;
		layoutInfater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
	    return itemProvider.length;
	}

    @Override
    public View instantiateItem(ViewGroup collection, int position) {
		NewsDetailsContainer view = (NewsDetailsContainer) layoutInfater.inflate(R.layout.webview_pager_item, null);
        collection.addView(view);

        views.put(position, view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object viewObject) {
        View view = (View)viewObject;
        ((ViewPager) collection).removeView(view);
        views.remove(position);
        view = null;
    }

    @Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
}
