package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class c implements Runnable, Comparable<c> {
    private int a;

    public c(String str) {
        this.a = 0;
        this.a = 5;
        String str2 = UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.nanoTime());
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        if (a() < cVar.a()) {
            return 1;
        }
        return a() >= cVar.a() ? -1 : 0;
    }
}
