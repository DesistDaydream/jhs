package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class o {
    private static volatile o a;
    private List<y.a> b = new CopyOnWriteArrayList();

    private o() {
    }

    public static o a() {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o();
                }
            }
        }
        return a;
    }

    private void b(y.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(y.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    public void a(int i2) {
        for (y.a aVar : this.b) {
            if (i2 == 1) {
                aVar.onSuccess();
            } else if (i2 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
