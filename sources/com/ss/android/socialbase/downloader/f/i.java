package com.ss.android.socialbase.downloader.f;

import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class i {
    public volatile m a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5668c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f5669d;

    /* renamed from: e  reason: collision with root package name */
    private volatile long f5670e;

    /* renamed from: f  reason: collision with root package name */
    private long f5671f;

    /* renamed from: g  reason: collision with root package name */
    private int f5672g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f5673h;

    public i(long j2, long j3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f5669d = atomicLong;
        this.b = 0;
        this.f5668c = j2;
        atomicLong.set(j2);
        this.f5670e = j2;
        if (j3 >= j2) {
            this.f5671f = j3;
        } else {
            this.f5671f = -1L;
        }
    }

    public long a() {
        return this.f5669d.get() - this.f5668c;
    }

    public long b() {
        long j2 = this.f5671f;
        if (j2 >= this.f5668c) {
            return (j2 - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.f5668c;
    }

    public long d() {
        long j2 = this.f5669d.get();
        long j3 = this.f5671f;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j2 > j4) {
                return j4;
            }
        }
        return j2;
    }

    public long e() {
        m mVar = this.a;
        if (mVar != null) {
            long d2 = mVar.d();
            if (d2 > this.f5670e) {
                return d2;
            }
        }
        return this.f5670e;
    }

    public long f() {
        return this.f5671f;
    }

    public int g() {
        return this.f5672g;
    }

    public void h() {
        this.b++;
    }

    public void i() {
        this.b--;
    }

    public int j() {
        return this.b;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.f5673h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f5673h = jSONObject;
        }
        jSONObject.put("st", c());
        jSONObject.put("cu", d());
        jSONObject.put("en", f());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f5668c + ",\t currentOffset=" + this.f5669d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f5671f + '}';
    }

    public void a(long j2) {
        long j3 = this.f5668c;
        if (j2 < j3) {
            j2 = j3;
        }
        long j4 = this.f5671f;
        if (j4 > 0) {
            long j5 = j4 + 1;
            if (j2 > j5) {
                j2 = j5;
            }
        }
        this.f5669d.set(j2);
    }

    public void c(long j2) {
        if (j2 >= this.f5668c) {
            this.f5671f = j2;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j2 + ", segment = " + this);
        if (j2 == -1) {
            this.f5671f = j2;
        }
    }

    public void b(long j2) {
        this.f5669d.addAndGet(j2);
    }

    public void d(long j2) {
        if (j2 >= this.f5669d.get()) {
            this.f5670e = j2;
        }
    }

    public void b(int i2) {
        this.b = i2;
    }

    public void a(int i2) {
        this.f5672g = i2;
    }

    public static String a(List<i> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<i>() { // from class: com.ss.android.socialbase.downloader.f.i.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(i iVar, i iVar2) {
                return (int) (iVar.c() - iVar2.c());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (i iVar : list) {
            sb.append(iVar);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f5669d = atomicLong;
        this.b = 0;
        this.f5668c = iVar.f5668c;
        this.f5671f = iVar.f5671f;
        atomicLong.set(iVar.f5669d.get());
        this.f5670e = atomicLong.get();
        this.f5672g = iVar.f5672g;
    }

    public i(JSONObject jSONObject) {
        this.f5669d = new AtomicLong();
        this.b = 0;
        this.f5668c = jSONObject.optLong("st");
        c(jSONObject.optLong("en"));
        a(jSONObject.optLong("cu"));
        d(d());
    }
}
