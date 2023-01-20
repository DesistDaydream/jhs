package com.jihuanshe.ui.widget.imagepreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.jihuanshe.ui.page.preview.ImagePreviewActivity;
import com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo;
import com.vivo.push.PushClientConstants;
import e.l.q.c.t0.c.c;
import e.l.q.c.t0.e.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class GPreviewBuilder {

    /* renamed from: e  reason: collision with root package name */
    public static final int f4292e = 30;
    private Activity a;
    private Intent b = new Intent();

    /* renamed from: c  reason: collision with root package name */
    private Class f4293c;

    /* renamed from: d  reason: collision with root package name */
    private c f4294d;

    /* loaded from: classes2.dex */
    public enum IndicatorType {
        Dot,
        Number,
        NONE
    }

    private GPreviewBuilder(@NonNull Activity activity) {
        this.a = activity;
    }

    public static GPreviewBuilder a(@NonNull Activity activity) {
        return new GPreviewBuilder(activity);
    }

    public static GPreviewBuilder b(@NonNull Fragment fragment) {
        return new GPreviewBuilder(fragment.requireActivity());
    }

    public GPreviewBuilder c(boolean z) {
        this.b.putExtra("isDrag", z);
        return this;
    }

    public GPreviewBuilder d(boolean z, float f2) {
        this.b.putExtra("isDrag", z);
        this.b.putExtra("sensitivity", f2);
        return this;
    }

    public GPreviewBuilder e(int i2) {
        this.b.putExtra("position", i2);
        return this;
    }

    public <T extends IThumbViewInfo> GPreviewBuilder f(@NonNull List<T> list) {
        this.b.putParcelableArrayListExtra("imagePaths", new ArrayList<>(list));
        return this;
    }

    public GPreviewBuilder g(int i2) {
        this.b.putExtra("duration", i2);
        return this;
    }

    public GPreviewBuilder h(boolean z) {
        this.b.putExtra("isFullscreen", z);
        return this;
    }

    public GPreviewBuilder i(boolean z) {
        this.b.putExtra("isScale", z);
        return this;
    }

    public GPreviewBuilder j(boolean z) {
        this.b.putExtra("isSelect", z);
        return this;
    }

    public GPreviewBuilder k(c cVar) {
        this.f4294d = cVar;
        return this;
    }

    public <E extends IThumbViewInfo> GPreviewBuilder l(@NonNull E e2) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(e2);
        this.b.putParcelableArrayListExtra("imagePaths", arrayList);
        return this;
    }

    public GPreviewBuilder m(boolean z) {
        this.b.putExtra("isSingleFling", z);
        return this;
    }

    public GPreviewBuilder n(boolean z) {
        this.b.putExtra("isShow", z);
        return this;
    }

    public GPreviewBuilder o(@NonNull IndicatorType indicatorType) {
        this.b.putExtra("type", indicatorType);
        return this;
    }

    public GPreviewBuilder p(@NonNull Class<? extends a> cls) {
        this.b.putExtra(PushClientConstants.TAG_CLASS_NAME, cls);
        return this;
    }

    public void q() {
        Class<?> cls = this.f4293c;
        if (cls == null) {
            this.b.setClass(this.a, ImagePreviewActivity.class);
        } else {
            this.b.setClass(this.a, cls);
        }
        a.f14242m = this.f4294d;
        this.a.startActivityForResult(this.b, 30);
        this.a.overridePendingTransition(0, 0);
        this.b = null;
        this.a = null;
    }

    public GPreviewBuilder r(@NonNull Class cls) {
        this.f4293c = cls;
        this.b.setClass(this.a, cls);
        return this;
    }

    public GPreviewBuilder s(@NonNull Class cls, @NonNull Bundle bundle) {
        this.f4293c = cls;
        this.b.setClass(this.a, cls);
        this.b.putExtras(bundle);
        return this;
    }
}
