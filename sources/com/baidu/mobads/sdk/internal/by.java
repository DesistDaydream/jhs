package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.t;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public class by implements Observer {
    private static final String a = "APKParser";

    /* renamed from: g  reason: collision with root package name */
    private static final String f1539g = "__xadsdk_downloaded__version__";

    /* renamed from: h  reason: collision with root package name */
    private static final String f1540h = "version";
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private URL f1541c;

    /* renamed from: d  reason: collision with root package name */
    private String f1542d;

    /* renamed from: e  reason: collision with root package name */
    private final bn f1543e;

    /* renamed from: f  reason: collision with root package name */
    private a f1544f;

    /* renamed from: i  reason: collision with root package name */
    private SharedPreferences f1545i;

    /* renamed from: j  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f1546j;

    /* loaded from: classes.dex */
    public interface a {
        void a(bn bnVar);

        void b(bn bnVar);
    }

    public by(Context context, URL url, bn bnVar, a aVar) {
        this.f1541c = null;
        this.f1542d = null;
        this.f1546j = new bz(this);
        this.f1541c = url;
        this.f1543e = bnVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.b = context;
        this.f1544f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f1539g, 0);
        this.f1545i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f1546j);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        t tVar = (t) observable;
        if (tVar.l() == t.a.COMPLETED) {
            this.f1544f.a(new bn(this.f1543e, tVar.g(), Boolean.TRUE));
        }
        if (tVar.l() == t.a.ERROR) {
            this.f1544f.b(new bn(this.f1543e, tVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        aj ajVar = new aj(this.b, this.f1542d != null ? new URL(this.f1542d) : this.f1541c, str, str2, false);
        ajVar.addObserver(this);
        ajVar.a();
        SharedPreferences.Editor edit = this.f1545i.edit();
        edit.putString("version", this.f1543e.toString());
        edit.apply();
    }

    public by(Context context, String str, bn bnVar, a aVar) {
        this.f1541c = null;
        this.f1542d = null;
        this.f1546j = new bz(this);
        this.f1542d = str;
        this.f1543e = bnVar;
        a(context, aVar);
    }
}
