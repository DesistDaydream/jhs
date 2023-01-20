package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class aj extends j implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<String> f6685c;
    private String a = "";
    private ArrayList<String> b = null;

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a(this.a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            iVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        this.a = hVar.b(0, true);
        if (f6685c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f6685c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) hVar.a((h) f6685c, 1, false);
    }
}
