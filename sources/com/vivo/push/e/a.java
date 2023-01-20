package com.vivo.push.e;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class a {
    private static String[] a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};
    private ArrayList<String> b;

    /* renamed from: com.vivo.push.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0294a {
        private static a a = new a((byte) 0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0294a.a;
    }

    public final ArrayList<String> b() {
        return new ArrayList<>(this.b);
    }

    public final boolean c() {
        ArrayList<String> arrayList = this.b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.b = null;
        this.b = new ArrayList<>();
    }
}
