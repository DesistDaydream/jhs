package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.g.b;
import h.p2.b0.g.t.i.h;
import h.p2.b0.g.t.i.i;
import h.p2.b0.g.t.i.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* loaded from: classes3.dex */
public final class g<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    private static final g f15441d = new g(true);
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15442c = false;
    private final s<FieldDescriptorType, Object> a = s.p(16);

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[WireFormat.FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[WireFormat.FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[WireFormat.FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[WireFormat.FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        boolean I();

        WireFormat.FieldType J();

        WireFormat.JavaType K();

        boolean L();

        n.a c(n.a aVar, n nVar);

        int getNumber();
    }

    private g() {
    }

    private Object c(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private static int d(WireFormat.FieldType fieldType, int i2, Object obj) {
        int D = CodedOutputStream.D(i2);
        if (fieldType == WireFormat.FieldType.GROUP) {
            D *= 2;
        }
        return D + e(fieldType, obj);
    }

    private static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (a.b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.g(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.m(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.F(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.p(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.k(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.j(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.b(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.C((String) obj);
            case 10:
                if (obj instanceof d) {
                    return CodedOutputStream.e((d) obj);
                }
                return CodedOutputStream.c((byte[]) obj);
            case 11:
                return CodedOutputStream.E(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.z(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.B(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.n((n) obj);
            case 17:
                if (obj instanceof i) {
                    return CodedOutputStream.r((i) obj);
                }
                return CodedOutputStream.t((n) obj);
            case 18:
                if (obj instanceof h.a) {
                    return CodedOutputStream.i(((h.a) obj).getNumber());
                }
                return CodedOutputStream.i(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        WireFormat.FieldType J = bVar.J();
        int number = bVar.getNumber();
        if (bVar.I()) {
            int i2 = 0;
            if (bVar.L()) {
                for (Object obj2 : (List) obj) {
                    i2 += e(J, obj2);
                }
                return CodedOutputStream.D(number) + i2 + CodedOutputStream.v(i2);
            }
            for (Object obj3 : (List) obj) {
                i2 += d(J, number, obj3);
            }
            return i2;
        }
        return d(J, number, obj);
    }

    public static <T extends b<T>> g<T> g() {
        return f15441d;
    }

    public static int l(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.K() == WireFormat.JavaType.MESSAGE) {
            if (key.I()) {
                for (n nVar : (List) entry.getValue()) {
                    if (!nVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof n) {
                    if (!((n) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof i) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof i) {
            value = ((i) value).e();
        }
        if (key.I()) {
            Object h2 = h(key);
            if (h2 == null) {
                h2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) h2).add(c(obj));
            }
            this.a.put(key, h2);
        } else if (key.K() == WireFormat.JavaType.MESSAGE) {
            Object h3 = h(key);
            if (h3 == null) {
                this.a.put(key, c(value));
                return;
            }
            this.a.put(key, key.c(((n) h3).toBuilder(), (n) value).build());
        } else {
            this.a.put(key, c(value));
        }
    }

    public static <T extends b<T>> g<T> t() {
        return new g<>();
    }

    public static Object u(e eVar, WireFormat.FieldType fieldType, boolean z) throws IOException {
        switch (a.b[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.m());
            case 2:
                return Float.valueOf(eVar.q());
            case 3:
                return Long.valueOf(eVar.t());
            case 4:
                return Long.valueOf(eVar.M());
            case 5:
                return Integer.valueOf(eVar.s());
            case 6:
                return Long.valueOf(eVar.p());
            case 7:
                return Integer.valueOf(eVar.o());
            case 8:
                return Boolean.valueOf(eVar.k());
            case 9:
                if (z) {
                    return eVar.J();
                }
                return eVar.I();
            case 10:
                return eVar.l();
            case 11:
                return Integer.valueOf(eVar.L());
            case 12:
                return Integer.valueOf(eVar.E());
            case 13:
                return Long.valueOf(eVar.F());
            case 14:
                return Integer.valueOf(eVar.G());
            case 15:
                return Long.valueOf(eVar.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        if ((r3 instanceof h.p2.b0.g.t.i.h.a) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        if ((r3 instanceof byte[]) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r3 instanceof h.p2.b0.g.t.i.i) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void w(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
            java.util.Objects.requireNonNull(r3)
            int[] r0 = h.p2.b0.g.t.i.g.a.a
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L42;
                case 2: goto L3f;
                case 3: goto L3c;
                case 4: goto L39;
                case 5: goto L36;
                case 6: goto L33;
                case 7: goto L27;
                case 8: goto L1e;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof h.p2.b0.g.t.i.n
            if (r2 != 0) goto L31
            boolean r2 = r3 instanceof h.p2.b0.g.t.i.i
            if (r2 == 0) goto L30
            goto L31
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L31
            boolean r2 = r3 instanceof h.p2.b0.g.t.i.h.a
            if (r2 == 0) goto L30
            goto L31
        L27:
            boolean r2 = r3 instanceof h.p2.b0.g.t.i.d
            if (r2 != 0) goto L31
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L30
            goto L31
        L30:
            r0 = 0
        L31:
            r1 = r0
            goto L44
        L33:
            boolean r1 = r3 instanceof java.lang.String
            goto L44
        L36:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L44
        L39:
            boolean r1 = r3 instanceof java.lang.Double
            goto L44
        L3c:
            boolean r1 = r3 instanceof java.lang.Float
            goto L44
        L3f:
            boolean r1 = r3 instanceof java.lang.Long
            goto L44
        L42:
            boolean r1 = r3 instanceof java.lang.Integer
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.i.g.w(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    private static void x(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i2, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.Y(i2, (n) obj);
            return;
        }
        codedOutputStream.w0(i2, l(fieldType, false));
        y(codedOutputStream, fieldType, obj);
    }

    private static void y(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.R(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.X(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.c0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.z0(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.b0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.V(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.U(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.M(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.v0((String) obj);
                return;
            case 10:
                if (obj instanceof d) {
                    codedOutputStream.P((d) obj);
                    return;
                } else {
                    codedOutputStream.N((byte[]) obj);
                    return;
                }
            case 11:
                codedOutputStream.y0(((Integer) obj).intValue());
                return;
            case 12:
                codedOutputStream.q0(((Integer) obj).intValue());
                return;
            case 13:
                codedOutputStream.r0(((Long) obj).longValue());
                return;
            case 14:
                codedOutputStream.s0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.u0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.Z((n) obj);
                return;
            case 17:
                codedOutputStream.e0((n) obj);
                return;
            case 18:
                if (obj instanceof h.a) {
                    codedOutputStream.T(((h.a) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.T(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void z(b<?> bVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType J = bVar.J();
        int number = bVar.getNumber();
        if (bVar.I()) {
            List<Object> list = (List) obj;
            if (bVar.L()) {
                codedOutputStream.w0(number, 2);
                int i2 = 0;
                for (Object obj2 : list) {
                    i2 += e(J, obj2);
                }
                codedOutputStream.o0(i2);
                for (Object obj3 : list) {
                    y(codedOutputStream, J, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                x(codedOutputStream, J, number, obj4);
            }
        } else if (obj instanceof i) {
            x(codedOutputStream, J, number, ((i) obj).e());
        } else {
            x(codedOutputStream, J, number, obj);
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.I()) {
            w(fielddescriptortype.J(), obj);
            Object h2 = h(fielddescriptortype);
            if (h2 == null) {
                list = new ArrayList();
                this.a.put(fielddescriptortype, list);
            } else {
                list = (List) h2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public g<FieldDescriptorType> clone() {
        g<FieldDescriptorType> t = t();
        for (int i2 = 0; i2 < this.a.k(); i2++) {
            Map.Entry<FieldDescriptorType, Object> j2 = this.a.j(i2);
            t.v(j2.getKey(), j2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.l()) {
            t.v(entry.getKey(), entry.getValue());
        }
        t.f15442c = this.f15442c;
        return t;
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.a.get(fielddescriptortype);
        return obj instanceof i ? ((i) obj).e() : obj;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i2) {
        if (fielddescriptortype.I()) {
            Object h2 = h(fielddescriptortype);
            if (h2 != null) {
                return ((List) h2).get(i2);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.I()) {
            Object h2 = h(fielddescriptortype);
            if (h2 == null) {
                return 0;
            }
            return ((List) h2).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.k(); i3++) {
            Map.Entry<FieldDescriptorType, Object> j2 = this.a.j(i3);
            i2 += f(j2.getKey(), j2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.l()) {
            i2 += f(entry.getKey(), entry.getValue());
        }
        return i2;
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.I()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.a.get(fielddescriptortype) != null;
    }

    public boolean n() {
        for (int i2 = 0; i2 < this.a.k(); i2++) {
            if (!o(this.a.j(i2))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.l()) {
            if (!o(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        if (this.f15442c) {
            return new i.c(this.a.entrySet().iterator());
        }
        return this.a.entrySet().iterator();
    }

    public void q() {
        if (this.b) {
            return;
        }
        this.a.o();
        this.b = true;
    }

    public void r(g<FieldDescriptorType> gVar) {
        for (int i2 = 0; i2 < gVar.a.k(); i2++) {
            s(gVar.a.j(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : gVar.a.l()) {
            s(entry);
        }
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.I()) {
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    w(fielddescriptortype.J(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            w(fielddescriptortype.J(), obj);
        }
        if (obj instanceof i) {
            this.f15442c = true;
        }
        this.a.put(fielddescriptortype, obj);
    }

    private g(boolean z) {
        q();
    }
}
