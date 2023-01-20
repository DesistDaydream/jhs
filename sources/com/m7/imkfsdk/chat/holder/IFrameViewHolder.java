package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.webkit.WebView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class IFrameViewHolder extends BaseHolder {
    private WebView mWebView;

    public IFrameViewHolder(int i2) {
        super(i2);
    }

    public WebView getWebView() {
        if (this.mWebView == null) {
            this.mWebView = (WebView) getBaseView().findViewById(R.id.chat_webview);
        }
        return this.mWebView;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.mWebView = (WebView) view.findViewById(R.id.chat_webview);
        if (z) {
            this.type = 10;
        }
        return this;
    }
}
