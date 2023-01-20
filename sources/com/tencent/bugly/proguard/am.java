package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class am extends j implements Cloneable {
    private static ArrayList<al> b;
    public ArrayList<al> a = null;

    @Override // com.tencent.bugly.proguard.j
    public final void a(i iVar) {
        iVar.a((Collection) this.a, 0);
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.j
    public final void a(h hVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new al());
        }
        this.a = (ArrayList) hVar.a((h) b, 0, true);
    }
}
