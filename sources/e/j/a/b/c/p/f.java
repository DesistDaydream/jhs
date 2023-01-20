package e.j.a.b.c.p;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.y;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class f {
    @e.j.a.b.c.m.a
    public final DataHolder a;
    @e.j.a.b.c.m.a
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10355c;

    @e.j.a.b.c.m.a
    public f(DataHolder dataHolder, int i2) {
        this.a = (DataHolder) a0.k(dataHolder);
        n(i2);
    }

    @e.j.a.b.c.m.a
    public void a(String str, CharArrayBuffer charArrayBuffer) {
        this.a.zaa(str, this.b, this.f10355c, charArrayBuffer);
    }

    @e.j.a.b.c.m.a
    public boolean b(String str) {
        return this.a.getBoolean(str, this.b, this.f10355c);
    }

    @e.j.a.b.c.m.a
    public byte[] c(String str) {
        return this.a.getByteArray(str, this.b, this.f10355c);
    }

    @e.j.a.b.c.m.a
    public int d() {
        return this.b;
    }

    @e.j.a.b.c.m.a
    public double e(String str) {
        return this.a.zab(str, this.b, this.f10355c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (y.a(Integer.valueOf(fVar.b), Integer.valueOf(this.b)) && y.a(Integer.valueOf(fVar.f10355c), Integer.valueOf(this.f10355c)) && fVar.a == this.a) {
                return true;
            }
        }
        return false;
    }

    @e.j.a.b.c.m.a
    public float f(String str) {
        return this.a.zaa(str, this.b, this.f10355c);
    }

    @e.j.a.b.c.m.a
    public int g(String str) {
        return this.a.getInteger(str, this.b, this.f10355c);
    }

    @e.j.a.b.c.m.a
    public long h(String str) {
        return this.a.getLong(str, this.b, this.f10355c);
    }

    public int hashCode() {
        return y.b(Integer.valueOf(this.b), Integer.valueOf(this.f10355c), this.a);
    }

    @e.j.a.b.c.m.a
    public String i(String str) {
        return this.a.getString(str, this.b, this.f10355c);
    }

    @e.j.a.b.c.m.a
    public boolean j(String str) {
        return this.a.hasColumn(str);
    }

    @e.j.a.b.c.m.a
    public boolean k(String str) {
        return this.a.hasNull(str, this.b, this.f10355c);
    }

    @e.j.a.b.c.m.a
    public boolean l() {
        return !this.a.isClosed();
    }

    @e.j.a.b.c.m.a
    public Uri m(String str) {
        String string = this.a.getString(str, this.b, this.f10355c);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public final void n(int i2) {
        a0.q(i2 >= 0 && i2 < this.a.getCount());
        this.b = i2;
        this.f10355c = this.a.getWindowIndex(i2);
    }
}
