package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.jihuanshe.R;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import h.k2.h;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class StarView extends FrameLayout {

    /* renamed from: c */
    public static final /* synthetic */ n<Object>[] f4243c = {n0.r(new PropertyReference1Impl(n0.d(StarView.class), "allIv", "getAllIv()Landroid/widget/ImageView;")), n0.r(new PropertyReference1Impl(n0.d(StarView.class), "half", "getHalf()Landroid/widget/ImageView;"))};
    @d
    private final e a;
    @d
    private final e b;

    /* loaded from: classes2.dex */
    public enum StarState {
        NONE,
        HALF,
        ALL
    }

    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[StarState.values().length];
            iArr[StarState.HALF.ordinal()] = 1;
            iArr[StarState.ALL.ordinal()] = 2;
            a = iArr;
        }
    }

    @h
    public StarView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ StarView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final ImageView getAllIv() {
        return (ImageView) this.a.a(this, f4243c[0]);
    }

    private final ImageView getHalf() {
        return (ImageView) this.b.a(this, f4243c[1]);
    }

    public final void setState(@d StarState starState) {
        int i2 = a.a[starState.ordinal()];
        if (i2 == 1) {
            getAllIv().setImageResource(R.drawable.svg_rating_star);
            getAllIv().setImageTintList(ColorStateList.valueOf(Res.k(R.color.black_1A000000)));
            ViewKt.I(getHalf());
        } else if (i2 != 2) {
            getAllIv().setImageResource(R.drawable.svg_rating_star);
            getAllIv().setImageTintList(ColorStateList.valueOf(Res.k(R.color.black_1A000000)));
            ViewKt.n(getHalf());
        } else {
            getAllIv().setImageTintList(null);
            getAllIv().setImageResource(R.drawable.svg_rating_star_);
            ViewKt.n(getHalf());
        }
    }

    @h
    public StarView(@d Context context, @k.e.a.e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = BindViewKt.p(this, R.id.allIv);
        this.b = BindViewKt.p(this, R.id.halfIv);
        LayoutInflater.from(context).inflate(R.layout.view_rating_star, this);
        setState(StarState.NONE);
    }
}
