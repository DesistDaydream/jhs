package com.vector.design.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RecyclerClickSupport$onChildViewAttachedToWindow$2 extends Lambda implements l<View, Boolean> {
    public final /* synthetic */ RecyclerClickSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerClickSupport$onChildViewAttachedToWindow$2(RecyclerClickSupport recyclerClickSupport) {
        super(1);
        this.this$0 = recyclerClickSupport;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(View view) {
        return Boolean.valueOf(invoke2(view));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d View view) {
        RecyclerView recyclerView;
        p<View, Integer, Boolean> c2 = this.this$0.c();
        if (c2 == null) {
            return false;
        }
        recyclerView = this.this$0.a;
        Boolean invoke = c2.invoke(view, Integer.valueOf(recyclerView.getChildLayoutPosition(view)));
        if (invoke == null) {
            return false;
        }
        return invoke.booleanValue();
    }
}
