package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class bm {
    private static volatile bm a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private bl f8279c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, bk> f8280d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private ThreadPoolExecutor f8281e = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<a> f8282f = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {
        private String a;
        public String b;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<Context> f8284d;

        /* renamed from: g  reason: collision with root package name */
        private a f8287g;

        /* renamed from: c  reason: collision with root package name */
        public bk f8283c = null;

        /* renamed from: e  reason: collision with root package name */
        private Random f8285e = new Random();

        /* renamed from: f  reason: collision with root package name */
        private int f8286f = 0;

        public a(String str) {
            this.a = str;
        }

        public Object a() {
            return null;
        }

        public void a(Context context) {
            a aVar = this.f8287g;
            if (aVar != null) {
                aVar.a(context, a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            bm.a(context).a(this);
        }

        public void a(bk bkVar, Context context) {
            this.f8283c = bkVar;
            this.b = bkVar.a();
            this.f8284d = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f8287g = aVar;
        }

        public void b(Context context) {
        }

        public boolean b() {
            return this.f8283c == null || TextUtils.isEmpty(this.b) || this.f8284d == null;
        }

        public String c() {
            return this.a;
        }

        public SQLiteDatabase d() {
            return this.f8283c.getWritableDatabase();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f8284d;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f8283c == null || TextUtils.isEmpty(this.a)) {
                return;
            }
            File file = new File(this.a);
            jo.a(context, new File(file.getParentFile(), aq.b(file.getAbsolutePath())), new bo(this, context));
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b<T> extends a {
        private List<String> a;

        /* renamed from: d  reason: collision with root package name */
        private String f8288d;

        /* renamed from: e  reason: collision with root package name */
        private String[] f8289e;

        /* renamed from: f  reason: collision with root package name */
        private String f8290f;

        /* renamed from: g  reason: collision with root package name */
        private String f8291g;

        /* renamed from: h  reason: collision with root package name */
        private String f8292h;

        /* renamed from: i  reason: collision with root package name */
        private int f8293i;

        /* renamed from: j  reason: collision with root package name */
        private List<T> f8294j;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.f8294j = new ArrayList();
            this.a = list;
            this.f8288d = str2;
            this.f8289e = strArr;
            this.f8290f = str3;
            this.f8291g = str4;
            this.f8292h = str5;
            this.f8293i = i2;
        }

        @Override // com.xiaomi.push.bm.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f8294j.clear();
            List<String> list = this.a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.a.size()];
                this.a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.f8293i;
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f8288d, this.f8289e, this.f8290f, this.f8291g, this.f8292h, i2 > 0 ? String.valueOf(i2) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T b = b(context, query);
                    if (b != null) {
                        this.f8294j.add(b);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.f8294j);
        }

        public abstract void a(Context context, List<T> list);

        public abstract T b(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bm.a
        public SQLiteDatabase d() {
            return this.f8283c.getReadableDatabase();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bm.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.bm.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends a {
        private String a;

        /* renamed from: d  reason: collision with root package name */
        public String[] f8295d;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f8295d = strArr;
        }

        @Override // com.xiaomi.push.bm.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f8295d);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bm.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private bm(Context context) {
        this.b = context;
    }

    public static bm a(Context context) {
        if (a == null) {
            synchronized (bm.class) {
                if (a == null) {
                    a = new bm(context);
                }
            }
        }
        return a;
    }

    private void a() {
        m.a(this.b).b(new bn(this), com.xiaomi.push.service.ad.a(this.b).a(gv.StatDataProcessFrequency.a(), 5));
    }

    private bk b(String str) {
        bk bkVar = this.f8280d.get(str);
        if (bkVar == null) {
            synchronized (this.f8280d) {
                if (bkVar == null) {
                    bkVar = this.f8279c.a(this.b, str);
                    this.f8280d.put(str, bkVar);
                }
            }
        }
        return bkVar;
    }

    public String a(String str) {
        return b(str).a();
    }

    public void a(a aVar) {
        bk bkVar;
        if (aVar == null) {
            return;
        }
        if (this.f8279c == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String c2 = aVar.c();
        synchronized (this.f8280d) {
            bkVar = this.f8280d.get(c2);
            if (bkVar == null) {
                bkVar = this.f8279c.a(this.b, c2);
                this.f8280d.put(c2, bkVar);
            }
        }
        if (this.f8281e.isShutdown()) {
            return;
        }
        aVar.a(bkVar, this.b);
        synchronized (this.f8282f) {
            this.f8282f.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f8281e.isShutdown()) {
            return;
        }
        this.f8281e.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f8279c == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f8281e.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b()) {
                next.a(b(next.c()), this.b);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.c());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.c(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f8283c, this.b);
                this.f8281e.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bk bkVar;
        if (aVar == null) {
            return;
        }
        if (this.f8279c == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String c2 = aVar.c();
        synchronized (this.f8280d) {
            bkVar = this.f8280d.get(c2);
            if (bkVar == null) {
                bkVar = this.f8279c.a(this.b, c2);
                this.f8280d.put(c2, bkVar);
            }
        }
        if (this.f8281e.isShutdown()) {
            return;
        }
        aVar.a(bkVar, this.b);
        a((Runnable) aVar);
    }
}
