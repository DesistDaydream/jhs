package com.vivo.push.b;

import com.qiniu.android.collect.ReportItem;

/* loaded from: classes3.dex */
public class s extends com.vivo.push.o {
    private String a;
    private int b;

    public s(int i2) {
        super(i2);
        this.a = null;
        this.b = 0;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a(ReportItem.RequestKeyRequestId, this.a);
        aVar.a("status_msg_code", this.b);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a(ReportItem.RequestKeyRequestId);
        this.b = aVar.b("status_msg_code", this.b);
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "OnReceiveCommand";
    }
}
