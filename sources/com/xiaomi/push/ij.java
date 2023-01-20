package com.xiaomi.push;

import com.xiaomi.push.ik;
import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public class ij {
    private final ByteArrayOutputStream a;
    private final iv b;

    /* renamed from: c  reason: collision with root package name */
    private io f8992c;

    public ij() {
        this(new ik.a());
    }

    public ij(iq iqVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        iv ivVar = new iv(byteArrayOutputStream);
        this.b = ivVar;
        this.f8992c = iqVar.a(ivVar);
    }

    public byte[] a(ic icVar) {
        this.a.reset();
        icVar.b(this.f8992c);
        return this.a.toByteArray();
    }
}
