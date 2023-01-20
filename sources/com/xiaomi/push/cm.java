package com.xiaomi.push;

/* loaded from: classes3.dex */
public class cm implements com.xiaomi.a.a.a.a {
    private com.xiaomi.a.a.a.a a;
    private com.xiaomi.a.a.a.a b;

    public cm(com.xiaomi.a.a.a.a aVar, com.xiaomi.a.a.a.a aVar2) {
        this.a = null;
        this.b = null;
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.xiaomi.a.a.a.a
    public void a(String str) {
        com.xiaomi.a.a.a.a aVar = this.a;
        if (aVar != null) {
            aVar.a(str);
        }
        com.xiaomi.a.a.a.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(str);
        }
    }

    @Override // com.xiaomi.a.a.a.a
    public void a(String str, Throwable th) {
        com.xiaomi.a.a.a.a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, th);
        }
        com.xiaomi.a.a.a.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(str, th);
        }
    }
}
