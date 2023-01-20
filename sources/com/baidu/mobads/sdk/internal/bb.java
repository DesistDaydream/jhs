package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.ay;
import java.util.HashMap;

/* loaded from: classes.dex */
public class bb implements Runnable {
    public final /* synthetic */ IOAdEvent a;
    public final /* synthetic */ ay.a b;

    public bb(ay.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.a.getType();
        if (v.H.equals(type)) {
            ay.this.a(this.a);
        } else if (v.K.equals(type)) {
            ay.this.n = this.a.getMessage();
            ay.this.q();
        } else if (v.L.equals(type)) {
            ay.this.e(this.a);
        } else if (v.M.equals(type)) {
            ay.this.f(this.a);
        } else if (v.U.equals(type)) {
            ay.this.g(this.a);
        } else {
            String str = "";
            int i2 = 0;
            int i3 = 0;
            r5 = false;
            boolean z = false;
            if (v.p.equals(type)) {
                HashMap hashMap2 = (HashMap) this.a.getData();
                if (hashMap2 != null) {
                    str = (String) hashMap2.get("error_message");
                    Object obj = hashMap2.get("error_code");
                    Integer num = obj;
                    if (obj == null) {
                        num = 0;
                    }
                    i2 = ((Integer) num).intValue();
                }
                ay.this.b(str, i2);
            } else if (v.J.equals(type)) {
                HashMap hashMap3 = (HashMap) this.a.getData();
                if (hashMap3 != null) {
                    str = (String) hashMap3.get("error_message");
                    Object obj2 = hashMap3.get("error_code");
                    Integer num2 = obj2;
                    if (obj2 == null) {
                        num2 = 0;
                    }
                    i3 = ((Integer) num2).intValue();
                }
                ay.this.a(i3, str);
            } else if (v.F.equals(type)) {
                ay.this.h(this.a);
            } else if (v.V.equals(type)) {
                ay.this.d();
            } else if (v.W.equals(type)) {
                ay.this.d(this.a);
            } else if (v.Y.equals(type)) {
                ay.this.s();
            } else if (v.Z.equals(type)) {
                IOAdEvent iOAdEvent2 = this.a;
                if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                    z = "1".equals((String) hashMap.get("serverVerify"));
                }
                ay.this.b(z);
            } else if (v.aa.equals(type)) {
                ay.this.b_();
            } else if (v.ab.equals(type)) {
                ay.this.c_();
            } else if (v.I.equals(type)) {
                ay.this.b(this.a);
            } else if (v.ac.equals(type)) {
                ay.this.a(this.a.getMessage(), 1 == this.a.getCode());
            } else if (v.ad.equals(type)) {
                ay.this.e(this.a.getMessage());
            } else if (v.ae.equals(type)) {
                ay.this.d(this.a.getMessage());
            } else if (v.B.equals(type)) {
                ay.this.f(this.a.getMessage());
            } else if (v.X.equals(type)) {
                ay.this.t();
            } else if (v.af.equals(type)) {
                ay.this.b(this.a.getMessage(), 1 == this.a.getCode());
            } else if (v.ah.equals(type)) {
                ay.this.c(this.a);
            } else if (v.ag.equals(type)) {
                ay.this.u();
            } else if (v.ai.equals(type)) {
                ay.this.i(this.a);
            } else if (v.aj.equals(type)) {
                ay.this.j(this.a);
            }
        }
    }
}
