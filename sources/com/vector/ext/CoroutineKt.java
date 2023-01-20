package com.vector.ext;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import i.b.b2;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"bindLifecycle", "", "Lkotlinx/coroutines/Job;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CoroutineKt {
    public static final void a(@d final b2 b2Var, @e LifecycleOwner lifecycleOwner) {
        final Lifecycle lifecycle = lifecycleOwner == null ? null : lifecycleOwner.getLifecycle();
        if (lifecycle == null) {
            return;
        }
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.vector.ext.CoroutineKt$bindLifecycle$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@d LifecycleOwner lifecycleOwner2, @d Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    b2.a.b(b2.this, null, 1, null);
                    lifecycle.removeObserver(this);
                }
            }
        });
    }

    public static /* synthetic */ void b(b2 b2Var, LifecycleOwner lifecycleOwner, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        a(b2Var, lifecycleOwner);
    }
}
