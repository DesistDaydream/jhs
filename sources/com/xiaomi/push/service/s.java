package com.xiaomi.push.service;

import com.xiaomi.push.eo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ boolean b;

    public s(List list, boolean z) {
        this.a = list;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        b = r.b("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (!b) {
                b2 = r.b(str);
                if (!b2) {
                    b = false;
                    if (!b && !this.b) {
                        break;
                    }
                }
            }
            b = true;
            if (!b) {
            }
        }
        eo.a(b ? 1 : 2);
    }
}
