package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public abstract class AbstractAD<T> {
    public T a;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f4974e;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f4972c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f4973d = false;
    private final Handler b = new Handler(Looper.getMainLooper());

    private void c(final Context context, final String str, final String str2) {
        this.f4974e = true;
        if (b.b().d()) {
            final String a = b.b().a();
            if (a.a(context)) {
                this.f4973d = true;
                b.f5074g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = b.b().c().getPOFactory();
                            AbstractAD.this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory2 = pOFactory;
                                        if (pOFactory2 != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.a = (T) abstractAD.a(context, pOFactory2, a, str, str2);
                                            AbstractAD.this.f4972c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            T t = abstractAD2.a;
                                            if (t == null) {
                                                abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                abstractAD2.a((AbstractAD) t);
                                            }
                                        } else {
                                            AbstractAD.this.f4972c = true;
                                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("??????????????????????????????????????????????????????", th);
                                        AbstractAD.this.f4972c = true;
                                        AbstractAD.this.a(ErrorCode.INIT_ERROR);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("????????????????????????????????????????????????", th);
                            AbstractAD.this.f4972c = true;
                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                        }
                    }
                });
                return;
            }
            GDTLogger.e("Manifest?????????Activity/Service/Permission????????????????????????Permission???????????????");
            a((int) ErrorCode.MANIFEST_ERROR);
            return;
        }
        a(2003);
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(final int i2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i2);
        } else {
            this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i2);
                }
            });
        }
    }

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            c(context, str, "");
            return;
        }
        GDTLogger.e("??????????????????????????????context???posId??????");
        a((int) ErrorCode.INIT_ERROR);
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            c(context, str, str2);
            return;
        }
        GDTLogger.e("?????????????????????????????????context???posId???token ????????????");
        a((int) ErrorCode.INIT_ERROR);
    }

    public abstract void a(T t);

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":???????????? " + str + "????????????????????????????????????");
    }

    public final boolean a() {
        return this.f4974e && this.f4973d;
    }

    public abstract void b(int i2);

    public final boolean b() {
        return this.f4972c;
    }
}
