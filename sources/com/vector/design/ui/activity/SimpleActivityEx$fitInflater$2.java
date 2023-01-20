package com.vector.design.ui.activity;

import android.view.LayoutInflater;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleActivityEx$fitInflater$2 extends Lambda implements a<LayoutInflater> {
    public final /* synthetic */ SimpleActivityEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActivityEx$fitInflater$2(SimpleActivityEx simpleActivityEx) {
        super(0);
        this.this$0 = simpleActivityEx;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final LayoutInflater invoke() {
        return LayoutInflater.from(this.this$0);
    }
}
