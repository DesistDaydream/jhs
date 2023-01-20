package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withLoading$4$1 extends Lambda implements a<t1> {
    public final /* synthetic */ e.g.d.a<T> $this_withLoading;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withLoading$4$1(e.g.d.a<T> aVar) {
        super(0);
        this.$this_withLoading = aVar;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_withLoading.b();
    }
}
