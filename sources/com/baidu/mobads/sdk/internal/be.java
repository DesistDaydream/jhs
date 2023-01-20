package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bp;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class be {
    public static final String a = "ContainerFactoryBuilder";

    /* renamed from: e  reason: collision with root package name */
    private static IXAdContainerFactory f1479e;

    /* renamed from: c  reason: collision with root package name */
    private Context f1480c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f1481d;
    public double b = 0.1d;

    /* renamed from: f  reason: collision with root package name */
    private bj f1482f = bj.a();

    public be(Class<?> cls, Context context) {
        this.f1481d = null;
        this.f1481d = cls;
        this.f1480c = context;
    }

    public IXAdContainerFactory a() {
        if (f1479e == null) {
            try {
                f1479e = (IXAdContainerFactory) this.f1481d.getDeclaredConstructor(Context.class).newInstance(this.f1480c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.am.bd, "9.24");
                f1479e.initConfig(jSONObject);
                this.b = f1479e.getRemoteVersion();
                f1479e.onTaskDistribute(as.a, MobadsPermissionSettings.getPermissionInfo());
                f1479e.initCommonModuleObj(p.a());
            } catch (Throwable th) {
                this.f1482f.b(a, th.getMessage());
                throw new bp.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f1479e;
    }

    public void b() {
        f1479e = null;
    }
}
