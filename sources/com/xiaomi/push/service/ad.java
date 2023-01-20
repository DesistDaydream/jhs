package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ad {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ad f9072c;
    public SharedPreferences a;
    public SharedPreferences b;

    /* renamed from: d  reason: collision with root package name */
    private HashSet<a> f9073d = new HashSet<>();

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i2, String str) {
            this.mId = i2;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private ad(Context context) {
        this.a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static ad a(Context context) {
        if (f9072c == null) {
            synchronized (ad.class) {
                if (f9072c == null) {
                    f9072c = new ad(context);
                }
            }
        }
        return f9072c;
    }

    private String a(int i2) {
        return "oc_" + i2;
    }

    private String a(gw gwVar) {
        return "oc_version_" + gwVar.a();
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        } else {
            String str2 = (String) obj;
            if (str.equals(a(gv.AppIsInstalledList.a()))) {
                str2 = com.xiaomi.push.ao.a(str2);
            }
            editor.putString(str, str2);
        }
    }

    public int a(int i2, int i3) {
        try {
            String a2 = a(i2);
            return this.b.contains(a2) ? this.b.getInt(a2, 0) : this.a.contains(a2) ? this.a.getInt(a2, 0) : i3;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(i2 + " oc int error " + e2);
            return i3;
        }
    }

    public int a(gw gwVar, int i2) {
        try {
            return this.a.getInt(a(gwVar), i2);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(gwVar + " version error " + e2);
            return i2;
        }
    }

    public long a(int i2, long j2) {
        try {
            String a2 = a(i2);
            return this.b.contains(a2) ? this.b.getLong(a2, 0L) : this.a.contains(a2) ? this.a.getLong(a2, 0L) : j2;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(i2 + " oc long error " + e2);
            return j2;
        }
    }

    public String a(int i2, String str) {
        try {
            String a2 = a(i2);
            return this.b.contains(a2) ? this.b.getString(a2, null) : this.a.contains(a2) ? this.a.getString(a2, null) : str;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(i2 + " oc string error " + e2);
            return str;
        }
    }

    public synchronized void a() {
        this.f9073d.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f9073d.contains(aVar)) {
            this.f9073d.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.h.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String a2 = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(a2);
                } else {
                    a(edit, pair, a2);
                }
            }
        }
        edit.apply();
    }

    public void a(List<Pair<gw, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (com.xiaomi.push.h.a(list) || com.xiaomi.push.h.a(list2)) {
            com.xiaomi.a.a.a.c.a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        for (Pair<gw, Integer> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                edit.putInt(a((gw) obj), ((Integer) pair.second).intValue());
            }
        }
        for (Pair<Integer, Object> pair2 : list2) {
            Object obj2 = pair2.first;
            if (obj2 != null && pair2.second != null) {
                a(edit, pair2, a(((Integer) obj2).intValue()));
            }
        }
        edit.apply();
    }

    public boolean a(int i2, boolean z) {
        try {
            String a2 = a(i2);
            return this.b.contains(a2) ? this.b.getBoolean(a2, false) : this.a.contains(a2) ? this.a.getBoolean(a2, false) : z;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(i2 + " oc boolean error " + e2);
            return z;
        }
    }

    public void b() {
        com.xiaomi.a.a.a.c.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f9073d);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}
