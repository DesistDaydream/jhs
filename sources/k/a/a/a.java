package k.a.a;

import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes4.dex */
public class a implements c {
    private final int a;
    private final int b;

    public a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    @Override // k.a.a.c
    public int H() {
        return this.b;
    }

    public boolean a(int i2) {
        return this.a <= i2 && i2 <= this.b;
    }

    public boolean b(a aVar) {
        return this.a <= aVar.H() && this.b >= aVar.getStart();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            int start = this.a - cVar.getStart();
            return start != 0 ? start : this.b - cVar.H();
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a == cVar.getStart() && this.b == cVar.H();
        }
        return false;
    }

    @Override // k.a.a.c
    public int getStart() {
        return this.a;
    }

    public int hashCode() {
        return (this.a % 100) + (this.b % 100);
    }

    @Override // k.a.a.c
    public int size() {
        return (this.b - this.a) + 1;
    }

    public String toString() {
        return this.a + Constants.COLON_SEPARATOR + this.b;
    }
}
