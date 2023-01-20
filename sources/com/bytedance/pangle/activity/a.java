package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {
    private final Activity a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2208c;

    /* renamed from: d  reason: collision with root package name */
    private Method f2209d;

    public a(@NonNull Activity activity, int i2, @NonNull String str) {
        this.a = activity;
        this.b = str;
        this.f2208c = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f2209d == null) {
            try {
                Method method = this.a.getClass().getMethod(this.b, View.class);
                if (method != null) {
                    this.f2209d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f2208c);
        }
        try {
            this.f2209d.invoke(this.a, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Could not execute method for android:onClick", e3);
        }
    }
}
