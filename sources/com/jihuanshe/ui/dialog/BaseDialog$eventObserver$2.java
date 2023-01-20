package com.jihuanshe.ui.dialog;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.ui.dialog.BaseDialog;
import com.jihuanshe.ui.dialog.BaseDialog$eventObserver$2;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BaseDialog$eventObserver$2 extends Lambda implements h.k2.u.a<LifecycleEventObserver> {
    public final /* synthetic */ BaseDialog this$0;

    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog$eventObserver$2(BaseDialog baseDialog) {
        super(0);
        this.this$0 = baseDialog;
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m15invoke$lambda0(BaseDialog baseDialog, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i2 = a.a[event.ordinal()];
        if (i2 == 1) {
            baseDialog.t();
        } else if (i2 == 2) {
            baseDialog.w();
        } else if (i2 == 3) {
            baseDialog.x();
        } else if (i2 != 4) {
        } else {
            baseDialog.u();
        }
    }

    @Override // h.k2.u.a
    @d
    public final LifecycleEventObserver invoke() {
        final BaseDialog baseDialog = this.this$0;
        return new LifecycleEventObserver() { // from class: e.l.q.a.e
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                BaseDialog$eventObserver$2.m15invoke$lambda0(BaseDialog.this, lifecycleOwner, event);
            }
        };
    }
}
