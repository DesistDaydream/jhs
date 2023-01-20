package com.vector.util;

import android.content.SharedPreferences;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SpEx$sp$2 extends Lambda implements a<SharedPreferences> {
    public final /* synthetic */ SpEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpEx$sp$2(SpEx spEx) {
        super(0);
        this.this$0 = spEx;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final SharedPreferences invoke() {
        return e.t.a.b().getSharedPreferences(this.this$0.e(), 0);
    }
}
