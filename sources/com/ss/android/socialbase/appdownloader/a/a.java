package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class a implements e {
    public final Context a;
    public final com.ss.android.socialbase.downloader.g.a b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5421c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        this.a = context;
        this.b = aVar;
        this.f5421c = str;
    }

    public boolean a() {
        if (this.a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.a.getPackageManager()) != null;
    }
}
