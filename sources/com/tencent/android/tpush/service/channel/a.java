package com.tencent.android.tpush.service.channel;

import android.util.SparseArray;

/* loaded from: classes3.dex */
public class a {
    private static a a = new a();
    private SparseArray<Object> b = new SparseArray<>();

    public a() {
    }

    public boolean a() {
        return ((Boolean) this.b.get(2, Boolean.FALSE)).booleanValue();
    }

    public String b() {
        return (String) this.b.get(0, "");
    }

    public int c() {
        return ((Integer) this.b.get(1, 0)).intValue();
    }

    public a(Object... objArr) {
        for (int i2 = 0; i2 < objArr.length; i2 += 2) {
            this.b.put(((Integer) objArr[i2]).intValue(), objArr[i2 + 1]);
        }
    }
}
