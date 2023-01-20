package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class gj extends p.b {
    public final /* synthetic */ Context a;

    public gj(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.p.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gi.f8668d;
        synchronized (obj) {
            list = gi.f8669e;
            arrayList = new ArrayList(list);
            list2 = gi.f8669e;
            list2.clear();
        }
        gi.b(this.a, arrayList);
    }
}
