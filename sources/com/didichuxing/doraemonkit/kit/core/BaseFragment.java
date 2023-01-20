package com.didichuxing.doraemonkit.kit.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import h.k2.d;
import h.k2.h;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H%¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J+\u0010\u001d\u001a\u00020\u00132\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0013¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/BaseFragment;", "Landroidx/fragment/app/Fragment;", "", "onRequestLayout", "()I", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "id", "findViewById", "(I)Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lh/t1;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "interceptTouchEvents", "()Z", "onBackPressed", "Ljava/lang/Class;", "fragmentClass", TTLiveConstants.BUNDLE_KEY, "showContent", "(Ljava/lang/Class;Landroid/os/Bundle;)V", "finish", "()V", "", "TAG", "Ljava/lang/String;", "<init>", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {
    @d
    @k.e.a.d
    public final String TAG = getClass().getSimpleName();

    public static /* synthetic */ void showContent$default(BaseFragment baseFragment, Class cls, Bundle bundle, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bundle = null;
            }
            baseFragment.showContent(cls, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showContent");
    }

    @k.e.a.d
    public final <T extends View> T findViewById(@IdRes int i2) {
        return (T) new Activity().findViewById(i2);
    }

    public final void finish() {
    }

    public final boolean interceptTouchEvents() {
        return false;
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @e
    public View onCreateView(@k.e.a.d LayoutInflater layoutInflater, @e ViewGroup viewGroup, @e Bundle bundle) {
        return null;
    }

    @LayoutRes
    public abstract int onRequestLayout();

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k.e.a.d View view, @e Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @h
    public final void showContent(@k.e.a.d Class<? extends BaseFragment> cls) {
        showContent$default(this, cls, null, 2, null);
    }

    @h
    public final void showContent(@k.e.a.d Class<? extends BaseFragment> cls, @e Bundle bundle) {
    }
}
