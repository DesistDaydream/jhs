package com.tencent.bugly.proguard;

/* loaded from: classes3.dex */
public final class ak extends j implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static byte[] f6686d;
    private byte a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f6687c;

    public ak() {
        this.a = (byte) 0;
        this.b = "";
        this.f6687c = null;
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
        byte[] bArr = this.f6687c;
        if (bArr != null) {
            iVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
    }

    public ak(byte b, String str, byte[] bArr) {
        this.a = (byte) 0;
        this.b = "";
        this.f6687c = null;
        this.a = b;
        this.b = str;
        this.f6687c = bArr;
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.a(this.a, 0, true);
        this.b = hVar.b(1, true);
        if (f6686d == null) {
            f6686d = r0;
            byte[] bArr = {0};
        }
        this.f6687c = hVar.c(2, false);
    }
}
