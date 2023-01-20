package com.vector.fitter;

import android.app.Activity;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.t.o.e;
import e.t.o.f;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/vector/fitter/FitStrategy;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityLifecycleCallbackImpl$onActivityResumed$1 extends Lambda implements l<e, t1> {
    public final /* synthetic */ Activity $activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityLifecycleCallbackImpl$onActivityResumed$1(Activity activity) {
        super(1);
        this.$activity = activity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(e eVar) {
        invoke2(eVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d e eVar) {
        f.a.a(this.$activity, eVar.value());
    }
}
