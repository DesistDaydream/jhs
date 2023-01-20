package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f8100d;
    private b a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private Context f8101c;

    private d(Context context) {
        if (this.a == null) {
            this.f8101c = ContextDelegate.getContext(context.getApplicationContext());
            this.a = new e(this.f8101c);
        }
        if (this.b == null) {
            this.b = new a();
        }
    }

    public static d a(Context context) {
        if (f8100d == null) {
            synchronized (d.class) {
                if (f8100d == null && context != null) {
                    f8100d = new d(context);
                }
            }
        }
        return f8100d;
    }

    public final b a() {
        return this.a;
    }
}
