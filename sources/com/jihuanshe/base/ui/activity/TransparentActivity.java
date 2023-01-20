package com.jihuanshe.base.ui.activity;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import e.l.h.l.b;
import e.t.u.a0;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0017J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/jihuanshe/base/ui/activity/TransparentActivity;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/jihuanshe/base/viewmodel/BaseViewModel;", "Lcom/jihuanshe/base/ui/activity/BaseActivity;", "()V", "activityCloseEnterAnimation", "", "activityCloseExitAnimation", "activityOpenEnterAnimation", "activityOpenExitAnimation", "finish", "", "flowOfSetup", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TransparentActivity<T extends b> extends BaseActivity<T> {

    /* renamed from: l  reason: collision with root package name */
    private int f3862l;

    /* renamed from: m  reason: collision with root package name */
    private int f3863m;
    private int n;
    private int o;

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    @CallSuper
    public void d() {
        b(0);
        a0.a.j(this, -1);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(this.f3862l, this.f3863m);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ResourceType"})
    public void onCreate(@e Bundle bundle) {
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{16842926});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = getTheme().obtainStyledAttributes(resourceId, new int[]{16842936, 16842937, 16842938, 16842939});
        this.n = obtainStyledAttributes2.getResourceId(0, 0);
        this.o = obtainStyledAttributes2.getResourceId(1, 0);
        this.f3862l = obtainStyledAttributes2.getResourceId(2, 0);
        this.f3863m = obtainStyledAttributes2.getResourceId(3, 0);
        obtainStyledAttributes2.recycle();
        overridePendingTransition(this.n, this.o);
        super.onCreate(bundle);
    }
}
