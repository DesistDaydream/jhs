package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class aj {
    public int a;
    public Map<String, String> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public String f8259c;

    public String a() {
        return this.f8259c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.b.toString(), this.f8259c);
    }
}
