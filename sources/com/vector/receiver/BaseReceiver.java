package com.vector.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.receiver.BaseReceiver;
import com.xiaomi.mipush.sdk.MiPushClient;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vector/receiver/BaseReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "filter", "Landroid/content/IntentFilter;", "getFilter", "()Landroid/content/IntentFilter;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "isDestroyed", "", MiPushClient.COMMAND_REGISTER, "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "register$vector_release", "unRegister", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseReceiver extends BroadcastReceiver {
    @e
    private Lifecycle a;

    public static /* synthetic */ void c(BaseReceiver baseReceiver, LifecycleOwner lifecycleOwner, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        d(baseReceiver, lifecycleOwner, lifecycleOwner2, event);
    }

    public static final void d(BaseReceiver baseReceiver, LifecycleOwner lifecycleOwner, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            baseReceiver.f(lifecycleOwner);
        }
    }

    private final void f(LifecycleOwner lifecycleOwner) {
        Context context;
        if (lifecycleOwner instanceof Activity) {
            ((Activity) lifecycleOwner).unregisterReceiver(this);
        } else if (!(lifecycleOwner instanceof Fragment) || (context = ((Fragment) lifecycleOwner).getContext()) == null) {
        } else {
            context.unregisterReceiver(this);
        }
    }

    @d
    public abstract IntentFilter a();

    public final boolean b() {
        Lifecycle lifecycle = this.a;
        return (lifecycle == null ? null : lifecycle.getCurrentState()) == Lifecycle.State.DESTROYED;
    }

    public final void e(@d final LifecycleOwner lifecycleOwner) {
        Context context;
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        this.a = lifecycle;
        if ((lifecycle == null ? null : lifecycle.getCurrentState()) == Lifecycle.State.DESTROYED) {
            return;
        }
        if (lifecycleOwner instanceof Activity) {
            ((Activity) lifecycleOwner).registerReceiver(this, a());
        } else if ((lifecycleOwner instanceof Fragment) && (context = ((Fragment) lifecycleOwner).getContext()) != null) {
            context.registerReceiver(this, a());
        }
        Lifecycle lifecycle2 = this.a;
        if (lifecycle2 == null) {
            return;
        }
        lifecycle2.addObserver(new LifecycleEventObserver() { // from class: e.t.s.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                BaseReceiver.c(BaseReceiver.this, lifecycleOwner, lifecycleOwner2, event);
            }
        });
    }
}
