package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class n extends m.b {
    public final /* synthetic */ boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9031c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m f9032d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, m.a aVar, boolean z, String str) {
        super(aVar);
        this.f9032d = mVar;
        this.b = z;
        this.f9031c = str;
    }

    @Override // com.xiaomi.push.m.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        SharedPreferences sharedPreferences;
        if (this.b) {
            return;
        }
        sharedPreferences = this.f9032d.f9030e;
        sharedPreferences.edit().putLong(this.f9031c, System.currentTimeMillis()).commit();
    }
}
