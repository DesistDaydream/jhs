package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class cb {
    private int a;

    public cb(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public boolean a(Context context, String str, List<ak> list) {
        return true;
    }

    public abstract String b(Context context, String str, List<ak> list);
}
