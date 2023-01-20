package com.jihuanshe.base.ext;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import java.util.ArrayDeque;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", AdvanceSetting.NETWORK_TYPE, "com/vector/ext/view/ViewKt$findAll$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withAllListState$$inlined$findAll$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ArrayDeque $deque;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withAllListState$$inlined$findAll$1(ArrayDeque arrayDeque) {
        super(1);
        this.$deque = arrayDeque;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.$deque.addLast(view);
    }
}
