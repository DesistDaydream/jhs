package com.xiaomi.push;

/* loaded from: classes3.dex */
public class ai implements ak {
    private final String a;
    private final String b;

    public ai(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.ak
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ak
    public String b() {
        return this.b;
    }
}
