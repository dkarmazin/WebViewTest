package com.example.dkarmazin.webviewtest.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.webkit.WebView;

public class WebViewNonFocusable extends WebView
{
    public WebViewNonFocusable(Context context)
    {
        super(context);
    }

    public WebViewNonFocusable(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public WebViewNonFocusable(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return false;
    }
}
