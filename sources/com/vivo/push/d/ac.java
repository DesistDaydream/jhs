package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes3.dex */
public final class ac implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f8111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8112d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f8113e;

    public ac(aa aaVar, int i2, List list, List list2, String str) {
        this.f8113e = aaVar;
        this.a = i2;
        this.b = list;
        this.f8111c = list2;
        this.f8112d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        aa aaVar = this.f8113e;
        PushMessageCallback pushMessageCallback = ((z) aaVar).b;
        context = aaVar.a;
        pushMessageCallback.onSetAlias(context, this.a, this.b, this.f8111c, this.f8112d);
    }
}
