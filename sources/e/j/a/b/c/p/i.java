package e.j.a.b.c.p;

import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class i<T> extends a<T> {
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Integer> f10357c;

    @e.j.a.b.c.m.a
    public i(DataHolder dataHolder) {
        super(dataHolder);
        this.b = false;
    }

    private final void e() {
        synchronized (this) {
            if (!this.b) {
                int count = this.a.getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.f10357c = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String d2 = d();
                    String string = this.a.getString(d2, 0, this.a.getWindowIndex(0));
                    for (int i2 = 1; i2 < count; i2++) {
                        int windowIndex = this.a.getWindowIndex(i2);
                        String string2 = this.a.getString(d2, i2, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.f10357c.add(Integer.valueOf(i2));
                                string = string2;
                            }
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(d2);
                            sb.append(", at row: ");
                            sb.append(i2);
                            sb.append(", for window: ");
                            sb.append(windowIndex);
                            throw new NullPointerException(sb.toString());
                        }
                    }
                }
                this.b = true;
            }
        }
    }

    private final int f(int i2) {
        if (i2 >= 0 && i2 < this.f10357c.size()) {
            return this.f10357c.get(i2).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i2);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    @e.j.a.b.c.m.a
    public String a() {
        return null;
    }

    @e.j.a.b.c.m.a
    public abstract T b(int i2, int i3);

    @e.j.a.b.c.m.a
    public abstract String d();

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        if (r6.a.getString(r4, r7, r3) == null) goto L16;
     */
    @Override // e.j.a.b.c.p.a, e.j.a.b.c.p.b
    @e.j.a.b.c.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T get(int r7) {
        /*
            r6 = this;
            r6.e()
            int r0 = r6.f(r7)
            r1 = 0
            if (r7 < 0) goto L67
            java.util.ArrayList<java.lang.Integer> r2 = r6.f10357c
            int r2 = r2.size()
            if (r7 != r2) goto L13
            goto L67
        L13:
            java.util.ArrayList<java.lang.Integer> r2 = r6.f10357c
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            if (r7 != r2) goto L30
            com.google.android.gms.common.data.DataHolder r2 = r6.a
            int r2 = r2.getCount()
            java.util.ArrayList<java.lang.Integer> r4 = r6.f10357c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            goto L4a
        L30:
            java.util.ArrayList<java.lang.Integer> r2 = r6.f10357c
            int r4 = r7 + 1
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.ArrayList<java.lang.Integer> r4 = r6.f10357c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
        L4a:
            int r2 = r2 - r4
            if (r2 != r3) goto L66
            int r7 = r6.f(r7)
            com.google.android.gms.common.data.DataHolder r3 = r6.a
            int r3 = r3.getWindowIndex(r7)
            java.lang.String r4 = r6.a()
            if (r4 == 0) goto L66
            com.google.android.gms.common.data.DataHolder r5 = r6.a
            java.lang.String r7 = r5.getString(r4, r7, r3)
            if (r7 != 0) goto L66
            goto L67
        L66:
            r1 = r2
        L67:
            java.lang.Object r7 = r6.b(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.c.p.i.get(int):java.lang.Object");
    }

    @Override // e.j.a.b.c.p.a, e.j.a.b.c.p.b
    @e.j.a.b.c.m.a
    public int getCount() {
        e();
        return this.f10357c.size();
    }
}
