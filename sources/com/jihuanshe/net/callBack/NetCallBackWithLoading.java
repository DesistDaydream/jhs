package com.jihuanshe.net.callBack;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.model.NetCode;
import com.jihuanshe.model.NetResponse;
import e.t.k.a.f.h;
import e.t.l.x;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import l.f;
import l.r;

/* loaded from: classes2.dex */
public abstract class NetCallBackWithLoading<T> implements f<NetResponse<T>> {
    @d
    private final Object a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3922c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3923d;

    /* renamed from: e  reason: collision with root package name */
    public h f3924e;

    public NetCallBackWithLoading(@d Object obj, boolean z, boolean z2, boolean z3) {
        Context requireContext;
        this.a = obj;
        this.b = z;
        this.f3922c = z2;
        this.f3923d = z3;
        if (z) {
            if (obj instanceof FragmentActivity) {
                requireContext = (Context) obj;
            } else {
                requireContext = obj instanceof Fragment ? ((Fragment) obj).requireContext() : null;
            }
            if (requireContext == null) {
                return;
            }
            e(new h(requireContext, false, 2, null));
            b().W();
            b().i(z2);
            b().J(new NetCallBackWithLoading$1$1(this));
        }
    }

    public void a() {
    }

    @d
    public final h b() {
        h hVar = this.f3924e;
        Objects.requireNonNull(hVar);
        return hVar;
    }

    public void c(boolean z, @d String str, @d String str2) {
        if (this.f3923d) {
            x.f(str2, 0, 2, null);
        }
    }

    public abstract void d(@e T t);

    public final void e(@d h hVar) {
        this.f3924e = hVar;
    }

    @Override // l.f
    public void onFailure(@d l.d<NetResponse<T>> dVar, @d Throwable th) {
        if (this.f3924e != null) {
            b().n();
        }
        c(false, NetCode.CODE_NO_SERVER_FAIL, th.getLocalizedMessage());
    }

    @Override // l.f
    public void onResponse(@d l.d<NetResponse<T>> dVar, @d r<NetResponse<T>> rVar) {
        if (this.f3924e != null) {
            b().n();
        }
        if (rVar.g() && rVar.a() != null) {
            NetResponse<T> a = rVar.a();
            if (a == null) {
                return;
            }
            if (a.isSuccessful()) {
                d(a.getData());
                return;
            } else {
                c(true, a.getCode(), a.getMessage());
                return;
            }
        }
        c(false, String.valueOf(rVar.b()), rVar.h());
    }

    public /* synthetic */ NetCallBackWithLoading(Object obj, boolean z, boolean z2, boolean z3, int i2, u uVar) {
        this(obj, z, z2, (i2 & 8) != 0 ? false : z3);
    }
}
