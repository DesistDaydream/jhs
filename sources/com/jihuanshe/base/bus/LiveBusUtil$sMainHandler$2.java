package com.jihuanshe.base.bus;

import android.os.Handler;
import android.os.Looper;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/os/Handler;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class LiveBusUtil$sMainHandler$2 extends Lambda implements a<Handler> {
    public static final LiveBusUtil$sMainHandler$2 INSTANCE = new LiveBusUtil$sMainHandler$2();

    public LiveBusUtil$sMainHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
