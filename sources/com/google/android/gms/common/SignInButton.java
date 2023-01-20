package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2618e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2619f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2620g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2621h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2622i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f2623j = 2;
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private View f2624c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f2625d;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface b {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public final void a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
        Context context = getContext();
        View view = this.f2624c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f2624c = SignInButtonCreator.createView(context, this.a, this.b);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i4 = this.a;
            int i5 = this.b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.a(context.getResources(), i4, i5);
            this.f2624c = signInButtonImpl;
        }
        addView(this.f2624c);
        this.f2624c.setEnabled(isEnabled());
        this.f2624c.setOnClickListener(this);
    }

    @Deprecated
    public final void b(int i2, int i3, Scope[] scopeArr) {
        a(i2, i3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f2625d;
        if (onClickListener == null || view != this.f2624c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void setColorScheme(int i2) {
        a(this.a, i2);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2624c.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2625d = onClickListener;
        View view = this.f2624c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        a(this.a, this.b);
    }

    public final void setSize(int i2) {
        a(i2, this.b);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2625d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.gms.base.R.styleable.SignInButton, 0, 0);
        try {
            this.a = obtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_buttonSize, 0);
            this.b = obtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            a(this.a, this.b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
