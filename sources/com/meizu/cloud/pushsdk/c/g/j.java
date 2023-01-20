package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes2.dex */
public final class j {
    public final byte[] a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f4795c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4796d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4797e;

    /* renamed from: f  reason: collision with root package name */
    public j f4798f;

    /* renamed from: g  reason: collision with root package name */
    public j f4799g;

    public j() {
        this.a = new byte[2048];
        this.f4797e = true;
        this.f4796d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.b, jVar.f4795c);
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.b = i2;
        this.f4795c = i3;
        this.f4797e = false;
        this.f4796d = true;
    }

    public j a() {
        j jVar = this.f4798f;
        j jVar2 = jVar != this ? jVar : null;
        j jVar3 = this.f4799g;
        jVar3.f4798f = jVar;
        this.f4798f.f4799g = jVar3;
        this.f4798f = null;
        this.f4799g = null;
        return jVar2;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f4795c - this.b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f4795c = jVar.b + i2;
        this.b += i2;
        this.f4799g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f4799g = this;
        jVar.f4798f = this.f4798f;
        this.f4798f.f4799g = jVar;
        this.f4798f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f4797e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f4795c;
        if (i3 + i2 > 2048) {
            if (jVar.f4796d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f4795c -= jVar.b;
            jVar.b = 0;
        }
        System.arraycopy(this.a, this.b, jVar.a, jVar.f4795c, i2);
        jVar.f4795c += i2;
        this.b += i2;
    }

    public void b() {
        j jVar = this.f4799g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f4797e) {
            int i2 = this.f4795c - this.b;
            if (i2 > (2048 - jVar.f4795c) + (jVar.f4796d ? 0 : jVar.b)) {
                return;
            }
            a(jVar, i2);
            a();
            k.a(this);
        }
    }
}
