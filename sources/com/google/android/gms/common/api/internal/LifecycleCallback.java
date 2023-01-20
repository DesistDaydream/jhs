package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import e.j.a.b.c.m.a;
import e.j.a.b.c.n.u.j;
import e.j.a.b.c.n.u.k;
import e.j.a.b.c.n.u.r3;
import e.j.a.b.c.n.u.t3;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@a
/* loaded from: classes2.dex */
public class LifecycleCallback {
    @a
    public final k a;

    @a
    public LifecycleCallback(k kVar) {
        this.a = kVar;
    }

    @a
    public static k b(Activity activity) {
        return d(new j(activity));
    }

    @a
    public static k c(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @a
    public static k d(j jVar) {
        if (jVar.e()) {
            return t3.q(jVar.b());
        }
        if (jVar.f()) {
            return r3.c(jVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static k getChimeraLifecycleFragmentImpl(j jVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @a
    @MainThread
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @a
    @MainThread
    public void e(int i2, int i3, Intent intent) {
    }

    @a
    @MainThread
    public void f(Bundle bundle) {
    }

    @a
    @MainThread
    public void g() {
    }

    @a
    public Activity getActivity() {
        return this.a.n();
    }

    @a
    @MainThread
    public void h() {
    }

    @a
    @MainThread
    public void i(Bundle bundle) {
    }

    @a
    @MainThread
    public void j() {
    }

    @a
    @MainThread
    public void k() {
    }
}
