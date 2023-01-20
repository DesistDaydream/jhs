package com.didichuxing.doraemonkit.kit.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH'¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/core/AbsDokitFragment;", "Lcom/didichuxing/doraemonkit/kit/core/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lh/t1;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onRequestLayout", "()I", "(Landroid/view/View;)V", "layoutId", "", "initTitle", "()Ljava/lang/String;", "getBundle", "()Landroid/os/Bundle;", TTLiveConstants.BUNDLE_KEY, "<init>", "()V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class AbsDokitFragment extends BaseFragment {
    @e
    public final Bundle getBundle() {
        return null;
    }

    @d
    public String initTitle() {
        return "";
    }

    @LayoutRes
    public abstract int layoutId();

    @Override // com.didichuxing.doraemonkit.kit.core.BaseFragment, androidx.fragment.app.Fragment
    @e
    public View onCreateView(@d LayoutInflater layoutInflater, @e ViewGroup viewGroup, @e Bundle bundle) {
        return null;
    }

    @Override // com.didichuxing.doraemonkit.kit.core.BaseFragment
    public int onRequestLayout() {
        return -1;
    }

    public void onViewCreated(@e View view) {
    }

    @Override // com.didichuxing.doraemonkit.kit.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@d View view, @e Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
