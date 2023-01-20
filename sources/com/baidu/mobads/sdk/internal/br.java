package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bp;

/* loaded from: classes.dex */
public class br extends Handler {
    public final /* synthetic */ bp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bp bpVar, Looper looper) {
        super(looper);
        this.a = bpVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bj bjVar;
        boolean z;
        Context context;
        bj bjVar2;
        boolean z2;
        boolean p;
        String string = message.getData().getString(bp.n);
        bn bnVar = (bn) message.getData().getParcelable(bp.f1534m);
        if (bp.f1532k.equals(string)) {
            String e2 = bnVar.e();
            context = this.a.y;
            bi biVar = new bi(e2, context, bnVar);
            try {
                try {
                    bp bpVar = this.a;
                    if (bpVar.u != bp.t) {
                        bpVar.a(biVar);
                        biVar.a(bp.f());
                        this.a.a(true);
                    } else {
                        biVar.a();
                        biVar.a(bp.f());
                        if (bp.p != null) {
                            bp.p.b = bnVar.b();
                        }
                        this.a.l();
                        z2 = this.a.A;
                        if (z2) {
                            this.a.A = false;
                            bp bpVar2 = this.a;
                            p = bpVar2.p();
                            bpVar2.a(p, "load remote file just downloaded");
                        }
                    }
                } catch (bp.a e3) {
                    this.a.a(false);
                    bjVar2 = this.a.z;
                    bjVar2.a(bp.a, "download apk file failed: " + e3.toString());
                }
                return;
            } finally {
                biVar.delete();
            }
        }
        bjVar = this.a.z;
        bjVar.a(bp.a, "mOnApkDownloadCompleted: download failed, code: " + string);
        this.a.a(false);
        z = this.a.A;
        if (z) {
            this.a.A = false;
            this.a.a(false, "Refused to download remote for version...");
        }
    }
}
