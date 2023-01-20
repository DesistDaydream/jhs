package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ e f52a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f53a;

    public j(String str, Context context, e eVar) {
        this.f53a = str;
        this.a = context;
        this.f52a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.f53a)) {
            return;
        }
        String[] split = this.f53a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = "";
                break;
            }
            String str2 = split[i2];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(Constants.COLON_SEPARATOR) + 1);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.a, this.f52a, str);
        i.m94a(this.a);
    }
}
