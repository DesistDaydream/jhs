package com.jihuanshe.base.ui.widget;

import android.view.LayoutInflater;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ToastDialog$layoutInflater$2 extends Lambda implements a<LayoutInflater> {
    public static final ToastDialog$layoutInflater$2 INSTANCE = new ToastDialog$layoutInflater$2();

    public ToastDialog$layoutInflater$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final LayoutInflater invoke() {
        return LayoutInflater.from(e.t.a.b());
    }
}
