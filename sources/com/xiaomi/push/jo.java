package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class jo implements Runnable {
    private Context a;
    private File b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f9027c;

    private jo(Context context, File file) {
        this.a = context;
        this.b = file;
    }

    public /* synthetic */ jo(Context context, File file, jp jpVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new jp(context, file, runnable).run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        jn jnVar = null;
        try {
            try {
                if (this.b == null) {
                    this.b = new File(this.a.getFilesDir(), "default_locker");
                }
                jnVar = jn.a(this.a, this.b);
                Runnable runnable = this.f9027c;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.a);
                if (jnVar == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (jnVar == null) {
                    return;
                }
            }
            jnVar.a();
        } catch (Throwable th) {
            if (jnVar != null) {
                jnVar.a();
            }
            throw th;
        }
    }
}
