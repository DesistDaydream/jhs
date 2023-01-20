package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f8118c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8119d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f8120e;

    public j(h hVar, int i2, List list, List list2, String str) {
        this.f8120e = hVar;
        this.a = i2;
        this.b = list;
        this.f8118c = list2;
        this.f8119d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f8120e;
        PushMessageCallback pushMessageCallback = ((z) hVar).b;
        context = hVar.a;
        pushMessageCallback.onDelAlias(context, this.a, this.b, this.f8118c, this.f8119d);
    }
}
