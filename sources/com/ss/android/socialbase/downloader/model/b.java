package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class b implements Parcelable {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long f5819c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicLong f5820d;

    /* renamed from: e  reason: collision with root package name */
    private long f5821e;

    /* renamed from: f  reason: collision with root package name */
    private long f5822f;

    /* renamed from: g  reason: collision with root package name */
    private int f5823g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicInteger f5824h;

    /* renamed from: i  reason: collision with root package name */
    private long f5825i;

    /* renamed from: j  reason: collision with root package name */
    private List<b> f5826j;

    /* renamed from: k  reason: collision with root package name */
    private b f5827k;

    /* renamed from: l  reason: collision with root package name */
    private int f5828l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5829m;
    private AtomicBoolean n;
    private com.ss.android.socialbase.downloader.h.b o;
    private static final String a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.model.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };

    /* loaded from: classes3.dex */
    public static class a {
        private int a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private long f5830c;

        /* renamed from: d  reason: collision with root package name */
        private long f5831d;

        /* renamed from: e  reason: collision with root package name */
        private long f5832e;

        /* renamed from: f  reason: collision with root package name */
        private int f5833f;

        /* renamed from: g  reason: collision with root package name */
        private long f5834g;

        /* renamed from: h  reason: collision with root package name */
        private b f5835h;

        public a(int i2) {
            this.a = i2;
        }

        public a a(long j2) {
            this.b = j2;
            return this;
        }

        public a b(long j2) {
            this.f5830c = j2;
            return this;
        }

        public a c(long j2) {
            this.f5831d = j2;
            return this;
        }

        public a d(long j2) {
            this.f5832e = j2;
            return this;
        }

        public a e(long j2) {
            this.f5834g = j2;
            return this;
        }

        public a a(int i2) {
            this.f5833f = i2;
            return this;
        }

        public a a(b bVar) {
            this.f5835h = bVar;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f5823g));
        contentValues.put("startOffset", Long.valueOf(this.f5819c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.f5821e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f5822f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public int b() {
        AtomicInteger atomicInteger = this.f5824h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public boolean c() {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean d() {
        return b() == -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b e() {
        b bVar = !d() ? this.f5827k : this;
        if (bVar == null || !bVar.f()) {
            return null;
        }
        return bVar.g().get(0);
    }

    public boolean f() {
        List<b> list = this.f5826j;
        return list != null && list.size() > 0;
    }

    public List<b> g() {
        return this.f5826j;
    }

    public boolean h() {
        b bVar = this.f5827k;
        if (bVar == null) {
            return true;
        }
        if (bVar.f()) {
            for (int i2 = 0; i2 < this.f5827k.g().size(); i2++) {
                b bVar2 = this.f5827k.g().get(i2);
                if (bVar2 != null) {
                    int indexOf = this.f5827k.g().indexOf(this);
                    if (indexOf > i2 && !bVar2.i()) {
                        return false;
                    }
                    if (indexOf == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean i() {
        long j2 = this.f5819c;
        if (d()) {
            long j3 = this.f5825i;
            if (j3 > this.f5819c) {
                j2 = j3;
            }
        }
        return n() - j2 >= this.f5822f;
    }

    public long j() {
        b bVar = this.f5827k;
        if (bVar != null && bVar.g() != null) {
            int indexOf = this.f5827k.g().indexOf(this);
            boolean z = false;
            for (int i2 = 0; i2 < this.f5827k.g().size(); i2++) {
                b bVar2 = this.f5827k.g().get(i2);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.n();
                    }
                    if (indexOf == i2) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public int k() {
        return this.b;
    }

    public long l() {
        return this.f5819c;
    }

    public long m() {
        AtomicLong atomicLong = this.f5820d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long n() {
        if (d() && f()) {
            long j2 = 0;
            for (int i2 = 0; i2 < this.f5826j.size(); i2++) {
                b bVar = this.f5826j.get(i2);
                if (bVar != null) {
                    if (!bVar.i()) {
                        return bVar.m();
                    }
                    if (j2 < bVar.m()) {
                        j2 = bVar.m();
                    }
                }
            }
            return j2;
        }
        return m();
    }

    public long o() {
        long n = n() - this.f5819c;
        if (f()) {
            n = 0;
            for (int i2 = 0; i2 < this.f5826j.size(); i2++) {
                b bVar = this.f5826j.get(i2);
                if (bVar != null) {
                    n += bVar.n() - bVar.l();
                }
            }
        }
        return n;
    }

    public long p() {
        return this.f5821e;
    }

    public long q() {
        return this.f5822f;
    }

    public void r() {
        this.f5825i = n();
    }

    public int s() {
        return this.f5823g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeLong(this.f5819c);
        AtomicLong atomicLong = this.f5820d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f5821e);
        parcel.writeLong(this.f5822f);
        parcel.writeInt(this.f5823g);
        AtomicInteger atomicInteger = this.f5824h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    private b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.b = aVar.a;
        this.f5819c = aVar.b;
        this.f5820d = new AtomicLong(aVar.f5830c);
        this.f5821e = aVar.f5831d;
        this.f5822f = aVar.f5832e;
        this.f5823g = aVar.f5833f;
        this.f5825i = aVar.f5834g;
        this.f5824h = new AtomicInteger(-1);
        a(aVar.f5835h);
        this.n = new AtomicBoolean(false);
    }

    public void b(boolean z) {
        this.f5829m = z;
    }

    public void c(int i2) {
        this.f5823g = i2;
    }

    public void b(int i2) {
        this.b = i2;
    }

    public long c(boolean z) {
        long n = n();
        long j2 = this.f5822f;
        long j3 = this.f5825i;
        long j4 = j2 - (n - j3);
        if (!z && n == j3) {
            j4 = j2 - (n - this.f5819c);
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", "contentLength:" + this.f5822f + " curOffset:" + n() + " oldOffset:" + this.f5825i + " retainLen:" + j4);
        if (j4 < 0) {
            return 0L;
        }
        return j4;
    }

    public void b(long j2) {
        AtomicLong atomicLong = this.f5820d;
        if (atomicLong != null) {
            atomicLong.set(j2);
        } else {
            this.f5820d = new AtomicLong(j2);
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.f5828l = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.f5828l + 1;
        this.f5828l = i2;
        sQLiteStatement.bindLong(i2, this.b);
        int i3 = this.f5828l + 1;
        this.f5828l = i3;
        sQLiteStatement.bindLong(i3, this.f5823g);
        int i4 = this.f5828l + 1;
        this.f5828l = i4;
        sQLiteStatement.bindLong(i4, this.f5819c);
        int i5 = this.f5828l + 1;
        this.f5828l = i5;
        sQLiteStatement.bindLong(i5, n());
        int i6 = this.f5828l + 1;
        this.f5828l = i6;
        sQLiteStatement.bindLong(i6, this.f5821e);
        int i7 = this.f5828l + 1;
        this.f5828l = i7;
        sQLiteStatement.bindLong(i7, this.f5822f);
        int i8 = this.f5828l + 1;
        this.f5828l = i8;
        sQLiteStatement.bindLong(i8, b());
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f5823g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f5819c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f5820d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f5820d = new AtomicLong(0L);
        }
        this.f5821e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f5824h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f5824h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f5822f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i2) {
        AtomicInteger atomicInteger = this.f5824h;
        if (atomicInteger == null) {
            this.f5824h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void a(com.ss.android.socialbase.downloader.h.b bVar) {
        this.o = bVar;
        r();
    }

    public void a(boolean z) {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            this.n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.o = null;
    }

    public b(Parcel parcel) {
        this.b = parcel.readInt();
        this.f5819c = parcel.readLong();
        this.f5820d = new AtomicLong(parcel.readLong());
        this.f5821e = parcel.readLong();
        this.f5822f = parcel.readLong();
        this.f5823g = parcel.readInt();
        this.f5824h = new AtomicInteger(parcel.readInt());
    }

    public void a(b bVar) {
        this.f5827k = bVar;
        if (bVar != null) {
            a(bVar.s());
        }
    }

    public void a(List<b> list) {
        this.f5826j = list;
    }

    public void a(long j2) {
        this.f5822f = j2;
    }

    public List<b> a(int i2, long j2) {
        b bVar;
        long p;
        long j3;
        long j4;
        long j5;
        long j6;
        b bVar2 = this;
        int i3 = i2;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m2 = m();
        long c2 = bVar2.c(true);
        long j7 = c2 / i3;
        com.ss.android.socialbase.downloader.c.a.b(a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j7 + " current host downloadChunk index:" + bVar2.f5823g);
        int i4 = 0;
        while (i4 < i3) {
            if (i4 == 0) {
                j4 = l();
                j3 = (m2 + j7) - 1;
            } else {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    long p2 = p();
                    j5 = p2 > m2 ? (p2 - m2) + 1 : c2 - (i5 * j7);
                    j6 = p2;
                    j4 = m2;
                    long j8 = c2;
                    long j9 = j6;
                    b a2 = new a(bVar2.b).a((-i4) - 1).a(j4).b(m2).e(m2).c(j9).d(j5).a(bVar2).a();
                    com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + j4 + " curOffset:" + m2 + " endOffset:" + j9 + " contentLen:" + j5);
                    arrayList.add(a2);
                    m2 += j7;
                    i4++;
                    bVar2 = this;
                    i3 = i2;
                    c2 = j8;
                } else {
                    j3 = (m2 + j7) - 1;
                    j4 = m2;
                }
            }
            j5 = j7;
            j6 = j3;
            long j82 = c2;
            long j92 = j6;
            b a22 = new a(bVar2.b).a((-i4) - 1).a(j4).b(m2).e(m2).c(j92).d(j5).a(bVar2).a();
            com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + j4 + " curOffset:" + m2 + " endOffset:" + j92 + " contentLen:" + j5);
            arrayList.add(a22);
            m2 += j7;
            i4++;
            bVar2 = this;
            i3 = i2;
            c2 = j82;
        }
        long j10 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j10 += bVar3.q();
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "reuseChunkContentLen:" + j10);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (p() == 0) {
                p = j2 - l();
            } else {
                p = (p() - l()) + 1;
            }
            bVar4.a(p - j10);
            bVar = this;
            bVar4.c(bVar.f5823g);
            com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.a(bVar4.p(), q() - j10);
            }
        } else {
            bVar = this;
        }
        bVar.a(arrayList);
        return arrayList;
    }
}
