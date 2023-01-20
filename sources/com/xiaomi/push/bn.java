package com.xiaomi.push;

import com.xiaomi.push.bm;
import com.xiaomi.push.m;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class bn extends m.a {
    public final /* synthetic */ bm a;

    public bn(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<bm.a> arrayList6;
        arrayList = this.a.f8282f;
        synchronized (arrayList) {
            arrayList2 = this.a.f8282f;
            if (arrayList2.size() > 0) {
                arrayList3 = this.a.f8282f;
                if (arrayList3.size() > 1) {
                    bm bmVar = this.a;
                    arrayList6 = bmVar.f8282f;
                    bmVar.a(arrayList6);
                } else {
                    bm bmVar2 = this.a;
                    arrayList4 = bmVar2.f8282f;
                    bmVar2.b((bm.a) arrayList4.get(0));
                }
                arrayList5 = this.a.f8282f;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
