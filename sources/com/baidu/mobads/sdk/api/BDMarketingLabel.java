package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ap;
import com.baidu.mobads.sdk.internal.bi;
import com.baidu.mobads.sdk.internal.v;

/* loaded from: classes.dex */
public class BDMarketingLabel extends LinearLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDMarketingLabel(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        Object[] objArr = {context};
        ClassLoader a = bi.a(context);
        this.mLoader = a;
        View view = (View) ap.a(v.f1622g, a, new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void setAdData(NativeResponse nativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            ap.a(v.f1622g, view, this.mLoader, "setAdData", new Class[]{Object.class}, nativeResponse);
        }
    }

    public void setLabelFontSizeSp(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ap.a(v.f1622g, view, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            ap.a(v.f1622g, view, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public BDMarketingLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingLabel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView(context);
    }
}
