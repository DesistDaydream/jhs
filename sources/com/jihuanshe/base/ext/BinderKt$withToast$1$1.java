package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.g.e.a;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lcom/eth/model/Error;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withToast$1$1 extends Lambda implements l<a, t1> {
    public final /* synthetic */ e.g.d.a<T> $this_withToast;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withToast$1$1(e.g.d.a<T> aVar) {
        super(1);
        this.$this_withToast = aVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        e.f(this.$this_withToast, aVar.h(), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
    }
}
