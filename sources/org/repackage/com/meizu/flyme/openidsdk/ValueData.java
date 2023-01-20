package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes4.dex */
public class ValueData {
    public String a;
    public int b;

    /* renamed from: c */
    public long f17120c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.f17120c + '}';
    }
}
