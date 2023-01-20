package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f8115c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8116d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f8117e;

    public i(h hVar, int i2, List list, List list2, String str) {
        this.f8117e = hVar;
        this.a = i2;
        this.b = list;
        this.f8115c = list2;
        this.f8116d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f8117e;
        PushMessageCallback pushMessageCallback = ((z) hVar).b;
        context = hVar.a;
        pushMessageCallback.onDelTags(context, this.a, this.b, this.f8115c, this.f8116d);
    }
}
