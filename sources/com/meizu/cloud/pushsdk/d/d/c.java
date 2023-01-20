package com.meizu.cloud.pushsdk.d.d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class c implements d {
    private final int a;
    private final AtomicLong b = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    private final Map<Long, byte[]> f4852c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final List<Long> f4853d = new CopyOnWriteArrayList();

    public c(int i2) {
        this.a = i2;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        b(aVar);
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a() {
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a(long j2) {
        return this.f4853d.remove(Long.valueOf(j2)) && this.f4852c.remove(Long.valueOf(j2)) != null;
    }

    public long b(com.meizu.cloud.pushsdk.d.a.a aVar) {
        byte[] a = a.a(aVar.a());
        long andIncrement = this.b.getAndIncrement();
        this.f4853d.add(Long.valueOf(andIncrement));
        this.f4852c.put(Long.valueOf(andIncrement), a);
        return andIncrement;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public long c() {
        return this.f4853d.size();
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public com.meizu.cloud.pushsdk.d.b.c d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        int c2 = (int) c();
        int i2 = this.a;
        if (c2 > i2) {
            c2 = i2;
        }
        for (int i3 = 0; i3 < c2; i3++) {
            Long l2 = this.f4853d.get(i3);
            if (l2 != null) {
                com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
                cVar.a(a.a(this.f4852c.get(l2)));
                com.meizu.cloud.pushsdk.d.f.c.c("MemoryStore", " current key " + l2 + " payload " + cVar, new Object[0]);
                linkedList.add(l2);
                arrayList.add(cVar);
            }
        }
        return new com.meizu.cloud.pushsdk.d.b.c(arrayList, linkedList);
    }
}
