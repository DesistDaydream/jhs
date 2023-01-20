package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class ca extends bu {

    /* renamed from: i  reason: collision with root package name */
    public bu f8321i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ bu f8322j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ by f8323k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(by byVar, String str, bu buVar) {
        super(str);
        this.f8323k = byVar;
        this.f8322j = buVar;
        this.f8321i = buVar;
        this.b = this.b;
        if (buVar != null) {
            this.f8302f = buVar.f8302f;
        }
    }

    @Override // com.xiaomi.push.bu
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        bu buVar = this.f8321i;
        if (buVar != null) {
            arrayList.addAll(buVar.a(true));
        }
        Map<String, bu> map = by.b;
        synchronized (map) {
            bu buVar2 = map.get(this.b);
            if (buVar2 != null) {
                Iterator<String> it = buVar2.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.b);
                arrayList.add(this.b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.bu
    public synchronized void a(String str, bt btVar) {
        bu buVar = this.f8321i;
        if (buVar != null) {
            buVar.a(str, btVar);
        }
    }

    @Override // com.xiaomi.push.bu
    public boolean b() {
        return false;
    }
}
