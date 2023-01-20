package com.tencent.bugly.proguard;

/* loaded from: classes3.dex */
public final class ap extends j implements Cloneable {
    public String a = "";
    private String b = "";

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        iVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.b(0, true);
        this.b = hVar.b(1, true);
    }
}
