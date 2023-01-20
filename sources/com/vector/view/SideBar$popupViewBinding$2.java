package com.vector.view;

import android.content.Context;
import android.view.LayoutInflater;
import e.t.j.d;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/databinding/LayoutSideBarPopBinding;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SideBar$popupViewBinding$2 extends Lambda implements a<d> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ SideBar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideBar$popupViewBinding$2(Context context, SideBar sideBar) {
        super(0);
        this.$context = context;
        this.this$0 = sideBar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @k.e.a.d
    public final d invoke() {
        d d2 = d.d(LayoutInflater.from(this.$context));
        d2.h(this.this$0);
        return d2;
    }
}
