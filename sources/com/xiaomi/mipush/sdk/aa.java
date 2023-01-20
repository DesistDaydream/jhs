package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.gu;

/* loaded from: classes3.dex */
public class aa implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0296a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ gu f16a;

    public aa(MiTinyDataClient.a.C0296a c0296a, gu guVar) {
        this.a = c0296a;
        this.f16a = guVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f11a.add(this.f16a);
        this.a.a();
    }
}
