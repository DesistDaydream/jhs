package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.p.n;
import e.j.a.b.c.p.o;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SafeParcelable.a(creator = "DataHolderCreator", validate = true)
@e.j.a.b.c.m.a
@KeepName
/* loaded from: classes2.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @e.j.a.b.c.m.a
    public static final Parcelable.Creator<DataHolder> CREATOR = new o();
    private static final a zaly = new n(new String[0], null);
    private boolean mClosed;
    @SafeParcelable.g(id = 1000)
    private final int zalf;
    @SafeParcelable.c(getter = "getColumns", id = 1)
    private final String[] zalq;
    private Bundle zalr;
    @SafeParcelable.c(getter = "getWindows", id = 2)
    private final CursorWindow[] zals;
    @SafeParcelable.c(getter = "getStatusCode", id = 3)
    private final int zalt;
    @SafeParcelable.c(getter = "getMetadata", id = 4)
    private final Bundle zalu;
    private int[] zalv;
    private int zalw;
    private boolean zalx;

    /* loaded from: classes2.dex */
    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    @SafeParcelable.b
    public DataHolder(@SafeParcelable.e(id = 1000) int i2, @SafeParcelable.e(id = 1) String[] strArr, @SafeParcelable.e(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.e(id = 3) int i3, @SafeParcelable.e(id = 4) Bundle bundle) {
        this.mClosed = false;
        this.zalx = true;
        this.zalf = i2;
        this.zalq = strArr;
        this.zals = cursorWindowArr;
        this.zalt = i3;
        this.zalu = bundle;
    }

    @e.j.a.b.c.m.a
    public static a builder(String[] strArr) {
        return new a(strArr, null, null);
    }

    @e.j.a.b.c.m.a
    public static DataHolder empty(int i2) {
        return new DataHolder(zaly, i2, (Bundle) null);
    }

    private static CursorWindow[] zaa(e.j.a.b.c.v.a aVar) {
        int i2;
        ArrayList arrayList = new ArrayList();
        try {
            int count = aVar.getCount();
            CursorWindow window = aVar.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i2 = 0;
            } else {
                window.acquireReference();
                aVar.a(null);
                arrayList.add(window);
                i2 = window.getNumRows();
            }
            while (i2 < count) {
                if (!aVar.moveToPosition(i2)) {
                    break;
                }
                CursorWindow window2 = aVar.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    aVar.a(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i2);
                    aVar.fillWindow(i2, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i2 = window2.getStartPosition() + window2.getNumRows();
            }
            aVar.close();
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            aVar.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @e.j.a.b.c.m.a
    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                int i2 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zals;
                    if (i2 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i2++;
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.zalx && this.zals.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @e.j.a.b.c.m.a
    public final boolean getBoolean(String str, int i2, int i3) {
        zaa(str, i2);
        return Long.valueOf(this.zals[i3].getLong(i2, this.zalr.getInt(str))).longValue() == 1;
    }

    @e.j.a.b.c.m.a
    public final byte[] getByteArray(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].getBlob(i2, this.zalr.getInt(str));
    }

    @e.j.a.b.c.m.a
    public final int getCount() {
        return this.zalw;
    }

    @e.j.a.b.c.m.a
    public final int getInteger(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].getInt(i2, this.zalr.getInt(str));
    }

    @e.j.a.b.c.m.a
    public final long getLong(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].getLong(i2, this.zalr.getInt(str));
    }

    @e.j.a.b.c.m.a
    public final Bundle getMetadata() {
        return this.zalu;
    }

    @e.j.a.b.c.m.a
    public final int getStatusCode() {
        return this.zalt;
    }

    @e.j.a.b.c.m.a
    public final String getString(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].getString(i2, this.zalr.getInt(str));
    }

    @e.j.a.b.c.m.a
    public final int getWindowIndex(int i2) {
        int[] iArr;
        int i3 = 0;
        a0.q(i2 >= 0 && i2 < this.zalw);
        while (true) {
            iArr = this.zalv;
            if (i3 >= iArr.length) {
                break;
            } else if (i2 < iArr[i3]) {
                i3--;
                break;
            } else {
                i3++;
            }
        }
        return i3 == iArr.length ? i3 - 1 : i3;
    }

    @e.j.a.b.c.m.a
    public final boolean hasColumn(String str) {
        return this.zalr.containsKey(str);
    }

    @e.j.a.b.c.m.a
    public final boolean hasNull(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].isNull(i2, this.zalr.getInt(str));
    }

    @e.j.a.b.c.m.a
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.Y(parcel, 1, this.zalq, false);
        e.j.a.b.c.r.i0.a.b0(parcel, 2, this.zals, i2, false);
        e.j.a.b.c.r.i0.a.F(parcel, 3, getStatusCode());
        e.j.a.b.c.r.i0.a.k(parcel, 4, getMetadata(), false);
        e.j.a.b.c.r.i0.a.F(parcel, 1000, this.zalf);
        e.j.a.b.c.r.i0.a.b(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    public final double zab(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].getDouble(i2, this.zalr.getInt(str));
    }

    public final void zaca() {
        this.zalr = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.zalq;
            if (i3 >= strArr.length) {
                break;
            }
            this.zalr.putInt(strArr[i3], i3);
            i3++;
        }
        this.zalv = new int[this.zals.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zals;
            if (i2 < cursorWindowArr.length) {
                this.zalv[i2] = i4;
                i4 += this.zals[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.zalw = i4;
                return;
            }
        }
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class a {
        private final String[] a;
        private final ArrayList<HashMap<String, Object>> b;

        /* renamed from: c  reason: collision with root package name */
        private final String f2637c;

        /* renamed from: d  reason: collision with root package name */
        private final HashMap<Object, Integer> f2638d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2639e;

        /* renamed from: f  reason: collision with root package name */
        private String f2640f;

        private a(String[] strArr, String str) {
            this.a = (String[]) a0.k(strArr);
            this.b = new ArrayList<>();
            this.f2637c = str;
            this.f2638d = new HashMap<>();
            this.f2639e = false;
            this.f2640f = null;
        }

        @e.j.a.b.c.m.a
        public DataHolder a(int i2) {
            return new DataHolder(this, i2, (Bundle) null, (n) null);
        }

        @e.j.a.b.c.m.a
        public DataHolder b(int i2, Bundle bundle) {
            return new DataHolder(this, i2, bundle, -1, (n) null);
        }

        @e.j.a.b.c.m.a
        public a c(ContentValues contentValues) {
            d.c(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return d(hashMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.android.gms.common.data.DataHolder.a d(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                e.j.a.b.c.r.d.c(r5)
                java.lang.String r0 = r4.f2637c
                r1 = -1
                if (r0 != 0) goto La
            L8:
                r0 = -1
                goto L2f
            La:
                java.lang.Object r0 = r5.get(r0)
                if (r0 != 0) goto L11
                goto L8
            L11:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.f2638d
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 != 0) goto L2b
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.f2638d
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r4.b
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
                goto L8
            L2b:
                int r0 = r2.intValue()
            L2f:
                if (r0 != r1) goto L37
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.b
                r0.add(r5)
                goto L41
            L37:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.b
                r1.remove(r0)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.b
                r1.add(r0, r5)
            L41:
                r5 = 0
                r4.f2639e = r5
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.a.d(java.util.HashMap):com.google.android.gms.common.data.DataHolder$a");
        }

        public /* synthetic */ a(String[] strArr, String str, n nVar) {
            this(strArr, null);
        }
    }

    @e.j.a.b.c.m.a
    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zalx = true;
        this.zalf = 1;
        this.zalq = (String[]) a0.k(strArr);
        this.zals = (CursorWindow[]) a0.k(cursorWindowArr);
        this.zalt = i2;
        this.zalu = bundle;
        zaca();
    }

    private DataHolder(e.j.a.b.c.v.a aVar, int i2, Bundle bundle) {
        this(aVar.getColumnNames(), zaa(aVar), i2, bundle);
    }

    @e.j.a.b.c.m.a
    public DataHolder(Cursor cursor, int i2, Bundle bundle) {
        this(new e.j.a.b.c.v.a(cursor), i2, bundle);
    }

    private DataHolder(a aVar, int i2, Bundle bundle) {
        this(aVar.a, zaa(aVar, -1), i2, (Bundle) null);
    }

    private DataHolder(a aVar, int i2, Bundle bundle, int i3) {
        this(aVar.a, zaa(aVar, -1), i2, bundle);
    }

    public /* synthetic */ DataHolder(a aVar, int i2, Bundle bundle, n nVar) {
        this(aVar, i2, (Bundle) null);
    }

    private static CursorWindow[] zaa(a aVar, int i2) {
        if (aVar.a.length == 0) {
            return new CursorWindow[0];
        }
        List subList = (i2 < 0 || i2 >= aVar.b.size()) ? aVar.b : aVar.b.subList(0, i2);
        int size = subList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(aVar.a.length);
        int i3 = 0;
        boolean z = false;
        while (i3 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i3);
                    sb.append(")");
                    Log.d("DataHolder", sb.toString());
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(aVar.a.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) subList.get(i3);
                boolean z2 = true;
                for (int i4 = 0; i4 < aVar.a.length && z2; i4++) {
                    String str = aVar.a[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z2 = cursorWindow.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z2 = cursorWindow.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z2 = cursorWindow.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z2 = cursorWindow.putLong(((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z2 = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z2 = cursorWindow.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        z2 = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else if (obj instanceof Float) {
                        z2 = cursorWindow.putDouble(((Float) obj).floatValue(), i3, i4);
                    } else {
                        String valueOf = String.valueOf(obj);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length());
                        sb2.append("Unsupported object for column ");
                        sb2.append(str);
                        sb2.append(": ");
                        sb2.append(valueOf);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                if (z2) {
                    z = false;
                } else if (!z) {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i3);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(aVar.a.length);
                    arrayList.add(cursorWindow);
                    i3--;
                    z = true;
                } else {
                    throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
                i3++;
            } catch (RuntimeException e2) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e2;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public /* synthetic */ DataHolder(a aVar, int i2, Bundle bundle, int i3, n nVar) {
        this(aVar, i2, bundle, -1);
    }

    private final void zaa(String str, int i2) {
        Bundle bundle = this.zalr;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i2 < 0 || i2 >= this.zalw) {
                    throw new CursorIndexOutOfBoundsException(i2, this.zalw);
                }
                return;
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
    }

    public final float zaa(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zals[i3].getFloat(i2, this.zalr.getInt(str));
    }

    public final void zaa(String str, int i2, int i3, CharArrayBuffer charArrayBuffer) {
        zaa(str, i2);
        this.zals[i3].copyStringToBuffer(i2, this.zalr.getInt(str), charArrayBuffer);
    }
}
