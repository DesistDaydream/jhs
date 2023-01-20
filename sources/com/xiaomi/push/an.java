package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: classes3.dex */
public class an {
    private LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        private static final an f8261d = new an();
        public int a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public Object f8262c;

        public a(int i2, Object obj) {
            this.a = i2;
            this.f8262c = obj;
        }
    }

    public static an a() {
        return a.f8261d;
    }

    private void d() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        d();
    }

    public synchronized int b() {
        return this.a.size();
    }

    public synchronized LinkedList<a> c() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }
}
