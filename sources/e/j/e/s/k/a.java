package e.j.e.s.k;

import com.google.gson.stream.JsonToken;
import e.j.e.e;
import e.j.e.h;
import e.j.e.i;
import e.j.e.j;
import e.j.e.l;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a extends e.j.e.u.a {
    private static final Reader V = new C0378a();
    private static final Object W = new Object();
    private Object[] R;
    private int S;
    private String[] T;
    private int[] U;

    /* renamed from: e.j.e.s.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0378a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    public a(h hVar) {
        super(V);
        this.R = new Object[32];
        this.S = 0;
        this.T = new String[32];
        this.U = new int[32];
        T0(hVar);
    }

    private void O0(JsonToken jsonToken) throws IOException {
        if (C0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + C0() + X());
    }

    private Object Q0() {
        return this.R[this.S - 1];
    }

    private Object R0() {
        Object[] objArr = this.R;
        int i2 = this.S - 1;
        this.S = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    private void T0(Object obj) {
        int i2 = this.S;
        Object[] objArr = this.R;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.R = Arrays.copyOf(objArr, i3);
            this.U = Arrays.copyOf(this.U, i3);
            this.T = (String[]) Arrays.copyOf(this.T, i3);
        }
        Object[] objArr2 = this.R;
        int i4 = this.S;
        this.S = i4 + 1;
        objArr2[i4] = obj;
    }

    private String X() {
        return " at path " + getPath();
    }

    private String t(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (true) {
            int i3 = this.S;
            if (i2 < i3) {
                Object[] objArr = this.R;
                if (objArr[i2] instanceof e) {
                    i2++;
                    if (i2 < i3 && (objArr[i2] instanceof Iterator)) {
                        int i4 = this.U[i2];
                        if (z && i4 > 0 && (i2 == i3 - 1 || i2 == i3 - 2)) {
                            i4--;
                        }
                        sb.append('[');
                        sb.append(i4);
                        sb.append(']');
                    }
                } else if ((objArr[i2] instanceof j) && (i2 = i2 + 1) < i3 && (objArr[i2] instanceof Iterator)) {
                    sb.append('.');
                    String[] strArr = this.T;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
                i2++;
            } else {
                return sb.toString();
            }
        }
    }

    @Override // e.j.e.u.a
    public String A0() throws IOException {
        JsonToken C0 = C0();
        JsonToken jsonToken = JsonToken.STRING;
        if (C0 != jsonToken && C0 != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + C0 + X());
        }
        String w = ((l) R0()).w();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return w;
    }

    @Override // e.j.e.u.a
    public JsonToken C0() throws IOException {
        if (this.S == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object Q0 = Q0();
        if (Q0 instanceof Iterator) {
            boolean z = this.R[this.S - 2] instanceof j;
            Iterator it = (Iterator) Q0;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                T0(it.next());
                return C0();
            }
        } else if (Q0 instanceof j) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (Q0 instanceof e) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (Q0 instanceof l) {
                l lVar = (l) Q0;
                if (lVar.F()) {
                    return JsonToken.STRING;
                }
                if (lVar.C()) {
                    return JsonToken.BOOLEAN;
                }
                if (lVar.E()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (Q0 instanceof i) {
                return JsonToken.NULL;
            } else {
                if (Q0 == W) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // e.j.e.u.a
    public String F() {
        return t(true);
    }

    @Override // e.j.e.u.a
    public boolean H() throws IOException {
        JsonToken C0 = C0();
        return (C0 == JsonToken.END_OBJECT || C0 == JsonToken.END_ARRAY || C0 == JsonToken.END_DOCUMENT) ? false : true;
    }

    @Override // e.j.e.u.a
    public void M0() throws IOException {
        if (C0() == JsonToken.NAME) {
            o0();
            this.T[this.S - 2] = "null";
        } else {
            R0();
            int i2 = this.S;
            if (i2 > 0) {
                this.T[i2 - 1] = "null";
            }
        }
        int i3 = this.S;
        if (i3 > 0) {
            int[] iArr = this.U;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public h P0() throws IOException {
        JsonToken C0 = C0();
        if (C0 != JsonToken.NAME && C0 != JsonToken.END_ARRAY && C0 != JsonToken.END_OBJECT && C0 != JsonToken.END_DOCUMENT) {
            h hVar = (h) Q0();
            M0();
            return hVar;
        }
        throw new IllegalStateException("Unexpected " + C0 + " when reading a JsonElement.");
    }

    public void S0() throws IOException {
        O0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) Q0()).next();
        T0(entry.getValue());
        T0(new l((String) entry.getKey()));
    }

    @Override // e.j.e.u.a
    public boolean Y() throws IOException {
        O0(JsonToken.BOOLEAN);
        boolean e2 = ((l) R0()).e();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return e2;
    }

    @Override // e.j.e.u.a
    public double c0() throws IOException {
        JsonToken C0 = C0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (C0 != jsonToken && C0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + C0 + X());
        }
        double h2 = ((l) Q0()).h();
        if (!J() && (Double.isNaN(h2) || Double.isInfinite(h2))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + h2);
        }
        R0();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return h2;
    }

    @Override // e.j.e.u.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.R = new Object[]{W};
        this.S = 1;
    }

    @Override // e.j.e.u.a
    public int f0() throws IOException {
        JsonToken C0 = C0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (C0 != jsonToken && C0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + C0 + X());
        }
        int m2 = ((l) Q0()).m();
        R0();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return m2;
    }

    @Override // e.j.e.u.a
    public String getPath() {
        return t(false);
    }

    @Override // e.j.e.u.a
    public void j() throws IOException {
        O0(JsonToken.BEGIN_ARRAY);
        T0(((e) Q0()).iterator());
        this.U[this.S - 1] = 0;
    }

    @Override // e.j.e.u.a
    public void k() throws IOException {
        O0(JsonToken.BEGIN_OBJECT);
        T0(((j) Q0()).H().iterator());
    }

    @Override // e.j.e.u.a
    public long m0() throws IOException {
        JsonToken C0 = C0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (C0 != jsonToken && C0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + C0 + X());
        }
        long t = ((l) Q0()).t();
        R0();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return t;
    }

    @Override // e.j.e.u.a
    public String o0() throws IOException {
        O0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) Q0()).next();
        String str = (String) entry.getKey();
        this.T[this.S - 1] = str;
        T0(entry.getValue());
        return str;
    }

    @Override // e.j.e.u.a
    public void q() throws IOException {
        O0(JsonToken.END_ARRAY);
        R0();
        R0();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // e.j.e.u.a
    public void r() throws IOException {
        O0(JsonToken.END_OBJECT);
        R0();
        R0();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // e.j.e.u.a
    public String toString() {
        return a.class.getSimpleName() + X();
    }

    @Override // e.j.e.u.a
    public void x0() throws IOException {
        O0(JsonToken.NULL);
        R0();
        int i2 = this.S;
        if (i2 > 0) {
            int[] iArr = this.U;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }
}
