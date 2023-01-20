package com.jihuanshe.base.magicindicator.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.l.h.h.e;
import e.l.h.h.g.a.b;
import e.l.h.h.g.c.a;

/* loaded from: classes2.dex */
public class SimplePagerTitleView extends AppCompatTextView implements b {
    private Context a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f3850c;

    /* renamed from: d  reason: collision with root package name */
    public float f3851d;

    /* renamed from: e  reason: collision with root package name */
    public float f3852e;

    /* renamed from: f  reason: collision with root package name */
    public int f3853f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3854g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3855h;

    /* renamed from: i  reason: collision with root package name */
    public int f3856i;

    /* renamed from: j  reason: collision with root package name */
    public int f3857j;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        this.f3851d = 0.0f;
        this.f3853f = -1;
        this.f3854g = true;
        this.f3855h = false;
        this.f3856i = 5;
        this.f3857j = 5;
        this.a = context;
        e(context);
    }

    private void e(Context context) {
        setGravity(17);
        int a = e.a(context, 5.0d);
        setPadding(a, 0, a, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void a(int i2, int i3) {
        setTextColor(this.f3850c);
        if (this.f3851d > 0.0f) {
            setTextSize(this.f3852e);
        }
        setTypeface(null, this.f3855h ? 1 : 0);
    }

    public void b(int i2, int i3, float f2, boolean z) {
    }

    public void c(int i2, int i3) {
        setTextColor(this.b);
        float f2 = this.f3851d;
        if (f2 > 0.0f) {
            setTextSize(f2);
        }
        setTypeface(null, this.f3854g ? 1 : 0);
    }

    public void d(int i2, int i3, float f2, boolean z) {
    }

    public void f() {
        setPadding(e.a(this.a, this.f3856i), 0, e.a(this.a, this.f3857j), 0);
    }

    @Override // e.l.h.h.g.a.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // e.l.h.h.g.a.b
    public int getContentLeft() {
        String charSequence;
        String[] split;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // e.l.h.h.g.a.b
    public int getContentRight() {
        String charSequence;
        String[] split;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // e.l.h.h.g.a.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getDrawable() {
        return this.f3853f;
    }

    public int getNormalColor() {
        return this.f3850c;
    }

    public int getSelectedColor() {
        return this.b;
    }

    public void setDrawable(int i2) {
        this.f3853f = i2;
        if (i2 != -1) {
            SpannableString spannableString = new SpannableString(ExpandableTextView.N);
            spannableString.setSpan(new a(this.a, Integer.valueOf(this.f3853f)), 0, 1, 33);
            setText(spannableString);
        }
    }

    public void setNormalColor(int i2) {
        this.f3850c = i2;
    }

    public void setSelectedColor(int i2) {
        this.b = i2;
    }
}
