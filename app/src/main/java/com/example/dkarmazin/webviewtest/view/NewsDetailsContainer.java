package com.example.dkarmazin.webviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.example.dkarmazin.webviewtest.R;

import java.lang.ref.WeakReference;

public class NewsDetailsContainer extends RelativeLayout {
    private WebViewNonFocusable newsWebView;

    public NewsDetailsContainer(Context context) {
        super(context);
    }

    public NewsDetailsContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewsDetailsContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        newsWebView = (WebViewNonFocusable) findViewById(R.id.newsWebView);
        newsWebView.setWebViewClient(new ContentWebViewClient(this));
        newsWebView.loadUrl("http://apple.com");
    }

    private static class ContentWebViewClient extends WebViewClient {
        private WeakReference<NewsDetailsContainer> ref;
        private ContentWebViewClient(NewsDetailsContainer container) {
            ref = new WeakReference<NewsDetailsContainer>(container);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            NewsDetailsContainer container = ref.get();
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            NewsDetailsContainer container = ref.get();
            if (container == null) return;
            container.newsWebView.setVisibility(VISIBLE);
            super.onPageFinished(view, url);
        }
    }
}
