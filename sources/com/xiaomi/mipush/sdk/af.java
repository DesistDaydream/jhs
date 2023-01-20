package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class af {
    private static volatile af a;

    /* renamed from: a  reason: collision with other field name */
    private Context f17a;

    /* renamed from: a  reason: collision with other field name */
    private List<x> f18a = new ArrayList();

    private af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f17a = applicationContext;
        if (applicationContext == null) {
            this.f17a = context;
        }
    }

    public static af a(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        synchronized (this.f18a) {
            x xVar = new x();
            xVar.f58a = str;
            if (this.f18a.contains(xVar)) {
                for (x xVar2 : this.f18a) {
                    if (xVar2.equals(xVar)) {
                        return xVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(au auVar) {
        return this.f17a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public synchronized void a(au auVar, String str) {
        SharedPreferences sharedPreferences = this.f17a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m52a(String str) {
        synchronized (this.f18a) {
            x xVar = new x();
            xVar.a = 0;
            xVar.f58a = str;
            if (this.f18a.contains(xVar)) {
                this.f18a.remove(xVar);
            }
            this.f18a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m53a(String str) {
        synchronized (this.f18a) {
            x xVar = new x();
            xVar.f58a = str;
            return this.f18a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f18a) {
            x xVar = new x();
            xVar.f58a = str;
            if (this.f18a.contains(xVar)) {
                Iterator<x> it = this.f18a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    x next = it.next();
                    if (xVar.equals(next)) {
                        xVar = next;
                        break;
                    }
                }
            }
            xVar.a++;
            this.f18a.remove(xVar);
            this.f18a.add(xVar);
        }
    }

    public void c(String str) {
        synchronized (this.f18a) {
            x xVar = new x();
            xVar.f58a = str;
            if (this.f18a.contains(xVar)) {
                this.f18a.remove(xVar);
            }
        }
    }
}
