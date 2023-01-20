package com.vector.design.ui.dialog;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.vector.design.ui.dialog.DialogEx;
import com.vector.design.ui.dialog.DialogEx$eventObserver$2;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleEventObserver;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DialogEx$eventObserver$2 extends Lambda implements h.k2.u.a<LifecycleEventObserver> {
    public final /* synthetic */ DialogEx this$0;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
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
    public DialogEx$eventObserver$2(DialogEx dialogEx) {
        super(0);
        this.this$0 = dialogEx;
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m42invoke$lambda0(DialogEx dialogEx, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i2 = a.a[event.ordinal()];
        if (i2 == 1) {
            dialogEx.H();
        } else if (i2 == 2) {
            dialogEx.N();
        } else if (i2 == 3) {
            dialogEx.O();
        } else if (i2 != 4) {
        } else {
            dialogEx.I();
        }
    }

    @Override // h.k2.u.a
    @d
    public final LifecycleEventObserver invoke() {
        final DialogEx dialogEx = this.this$0;
        return new LifecycleEventObserver() { // from class: e.t.k.a.f.c
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogEx$eventObserver$2.m42invoke$lambda0(DialogEx.this, lifecycleOwner, event);
            }
        };
    }
}
