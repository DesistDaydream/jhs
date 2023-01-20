package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class b implements IGDTAdManager {

    /* renamed from: g  reason: collision with root package name */
    public static final ExecutorService f5074g = Executors.newSingleThreadExecutor();
    private volatile Boolean a;
    private volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Context f5075c;

    /* renamed from: d  reason: collision with root package name */
    private volatile PM f5076d;

    /* renamed from: e  reason: collision with root package name */
    private volatile DevTools f5077e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f5078f;

    /* loaded from: classes3.dex */
    public static final class a {
        private static b a = new b(null);
    }

    private b() {
        this.a = Boolean.FALSE;
        this.b = false;
    }

    public /* synthetic */ b(com.qq.e.comm.managers.a aVar) {
        this();
    }

    public static b b() {
        return a.a;
    }

    public String a() {
        return this.f5078f;
    }

    public synchronized boolean b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
            return false;
        } else if (this.a.booleanValue()) {
            return true;
        } else {
            if (context == null || TextUtils.isEmpty(str)) {
                GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
                return false;
            }
            this.f5078f = str;
            this.f5075c = context.getApplicationContext();
            this.f5076d = new PM(this.f5075c, null);
            f5074g.submit(new com.qq.e.comm.managers.a(this));
            this.a = Boolean.TRUE;
            return true;
        }
    }

    public PM c() {
        return this.f5076d;
    }

    public boolean d() {
        if (this.a == null || !this.a.booleanValue()) {
            GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
            return false;
        }
        return true;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (d()) {
            try {
                return this.f5076d.getPOFactory().getBuyerId(map);
            } catch (Exception e2) {
                GDTLogger.e("SDK 初始化异常", e2);
                return "";
            }
        }
        return "";
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f5077e == null) {
            this.f5077e = new DevTools();
        }
        return this.f5077e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (d()) {
            try {
                return this.f5076d.getPOFactory().getSDKInfo(str);
            } catch (Exception e2) {
                GDTLogger.e("SDK 初始化异常", e2);
                return "";
            }
        }
        return "";
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (this.b) {
            try {
                return this.f5076d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
            } catch (Exception e2) {
                GDTLogger.e("SDK 初始化异常", e2);
                return 0;
            }
        }
        return 0;
    }
}
