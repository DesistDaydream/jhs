package com.xiaomi.push;

/* loaded from: classes3.dex */
public class ey extends Thread {
    public final /* synthetic */ ex a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ey(ex exVar, String str) {
        super(str);
        this.a = exVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        es esVar;
        try {
            esVar = this.a.w;
            esVar.a();
        } catch (Exception e2) {
            this.a.c(9, e2);
        }
    }
}
