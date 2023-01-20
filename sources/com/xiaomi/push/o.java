package com.xiaomi.push;

import com.xiaomi.push.m;
import java.util.Map;

/* loaded from: classes3.dex */
public class o extends m.b {
    public final /* synthetic */ m b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(m mVar, m.a aVar) {
        super(aVar);
        this.b = mVar;
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        Object obj;
        Map map;
        obj = this.b.f9029d;
        synchronized (obj) {
            map = this.b.f9028c;
            map.remove(this.a.a());
        }
    }
}
