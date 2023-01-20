package com.tencent.bugly.proguard;

/* loaded from: classes3.dex */
public final class ai extends j implements Cloneable {
    public String a = "";

    /* renamed from: d  reason: collision with root package name */
    private String f6683d = "";
    public String b = "";

    /* renamed from: e  reason: collision with root package name */
    private String f6684e = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6682c = "";

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        String str = this.f6683d;
        if (str != null) {
            iVar.a(str, 1);
        }
        String str2 = this.b;
        if (str2 != null) {
            iVar.a(str2, 2);
        }
        String str3 = this.f6684e;
        if (str3 != null) {
            iVar.a(str3, 3);
        }
        String str4 = this.f6682c;
        if (str4 != null) {
            iVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.b(0, true);
        this.f6683d = hVar.b(1, false);
        this.b = hVar.b(2, false);
        this.f6684e = hVar.b(3, false);
        this.f6682c = hVar.b(4, false);
    }
}
