package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import e.j.e.e;
import e.j.e.h;
import e.j.e.i;
import e.j.e.j;
import e.j.e.l;
import e.j.e.q;
import e.j.e.r.c;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes2.dex */
public final class TypeAdapters {
    public static final TypeAdapter<BigInteger> A;
    public static final TypeAdapter<LazilyParsedNumber> B;
    public static final q C;
    public static final TypeAdapter<StringBuilder> D;
    public static final q E;
    public static final TypeAdapter<StringBuffer> F;
    public static final q G;
    public static final TypeAdapter<URL> H;
    public static final q I;
    public static final TypeAdapter<URI> J;
    public static final q K;
    public static final TypeAdapter<InetAddress> L;
    public static final q M;
    public static final TypeAdapter<UUID> N;
    public static final q O;
    public static final TypeAdapter<Currency> P;
    public static final q Q;
    public static final TypeAdapter<Calendar> R;
    public static final q S;
    public static final TypeAdapter<Locale> T;
    public static final q U;
    public static final TypeAdapter<h> V;
    public static final q W;
    public static final q X;
    public static final TypeAdapter<Class> a;
    public static final q b;

    /* renamed from: c */
    public static final TypeAdapter<BitSet> f3232c;

    /* renamed from: d */
    public static final q f3233d;

    /* renamed from: e */
    public static final TypeAdapter<Boolean> f3234e;

    /* renamed from: f */
    public static final TypeAdapter<Boolean> f3235f;

    /* renamed from: g */
    public static final q f3236g;

    /* renamed from: h */
    public static final TypeAdapter<Number> f3237h;

    /* renamed from: i */
    public static final q f3238i;

    /* renamed from: j */
    public static final TypeAdapter<Number> f3239j;

    /* renamed from: k */
    public static final q f3240k;

    /* renamed from: l */
    public static final TypeAdapter<Number> f3241l;

    /* renamed from: m */
    public static final q f3242m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final q o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final q q;
    public static final TypeAdapter<AtomicIntegerArray> r;
    public static final q s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Character> w;
    public static final q x;
    public static final TypeAdapter<String> y;
    public static final TypeAdapter<BigDecimal> z;

    /* loaded from: classes2.dex */
    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        /* loaded from: classes2.dex */
        public class a implements PrivilegedAction<Field[]> {
            public final /* synthetic */ Class a;

            public a(Class cls) {
                EnumTypeAdapter.this = r1;
                this.a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a */
            public Field[] run() {
                Field[] declaredFields = this.a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public EnumTypeAdapter(Class<T> cls) {
            Field[] fieldArr;
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String name = r4.name();
                    c cVar = (c) field.getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.a.put(str, r4);
                        }
                    }
                    this.a.put(name, r4);
                    this.b.put(r4, name);
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public T e(e.j.e.u.a aVar) throws IOException {
            if (aVar.C0() == JsonToken.NULL) {
                aVar.x0();
                return null;
            }
            return this.a.get(aVar.A0());
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public void i(e.j.e.u.c cVar, T t) throws IOException {
            cVar.G0(t == null ? null : this.b.get(t));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        TypeAdapter<Class> d2 = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Class e(e.j.e.u.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.d();
        a = d2;
        b = b(Class.class, d2);
        TypeAdapter<BitSet> d3 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public BitSet e(e.j.e.u.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.j();
                JsonToken C0 = aVar.C0();
                int i2 = 0;
                while (C0 != JsonToken.END_ARRAY) {
                    int i3 = a.a[C0.ordinal()];
                    boolean z2 = true;
                    if (i3 == 1 || i3 == 2) {
                        int f0 = aVar.f0();
                        if (f0 == 0) {
                            z2 = false;
                        } else if (f0 != 1) {
                            throw new JsonSyntaxException("Invalid bitset value " + f0 + ", expected 0 or 1; at path " + aVar.F());
                        }
                    } else if (i3 == 3) {
                        z2 = aVar.Y();
                    } else {
                        throw new JsonSyntaxException("Invalid bitset value type: " + C0 + "; at path " + aVar.getPath());
                    }
                    if (z2) {
                        bitSet.set(i2);
                    }
                    i2++;
                    C0 = aVar.C0();
                }
                aVar.q();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, BitSet bitSet) throws IOException {
                cVar.l();
                int length = bitSet.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.D0(bitSet.get(i2) ? 1L : 0L);
                }
                cVar.q();
            }
        }.d();
        f3232c = d3;
        f3233d = b(BitSet.class, d3);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Boolean e(e.j.e.u.a aVar) throws IOException {
                JsonToken C0 = aVar.C0();
                if (C0 == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                } else if (C0 == JsonToken.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.A0()));
                } else {
                    return Boolean.valueOf(aVar.Y());
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Boolean bool) throws IOException {
                cVar.E0(bool);
            }
        };
        f3234e = typeAdapter;
        f3235f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Boolean e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return Boolean.valueOf(aVar.A0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Boolean bool) throws IOException {
                cVar.G0(bool == null ? "null" : bool.toString());
            }
        };
        f3236g = c(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                try {
                    int f0 = aVar.f0();
                    if (f0 <= 255 && f0 >= -128) {
                        return Byte.valueOf((byte) f0);
                    }
                    throw new JsonSyntaxException("Lossy conversion from " + f0 + " to byte; at path " + aVar.F());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                cVar.F0(number);
            }
        };
        f3237h = typeAdapter2;
        f3238i = c(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                try {
                    int f0 = aVar.f0();
                    if (f0 <= 65535 && f0 >= -32768) {
                        return Short.valueOf((short) f0);
                    }
                    throw new JsonSyntaxException("Lossy conversion from " + f0 + " to short; at path " + aVar.F());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                cVar.F0(number);
            }
        };
        f3239j = typeAdapter3;
        f3240k = c(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.f0());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                cVar.F0(number);
            }
        };
        f3241l = typeAdapter4;
        f3242m = c(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter<AtomicInteger> d4 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public AtomicInteger e(e.j.e.u.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.f0());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.D0(atomicInteger.get());
            }
        }.d();
        n = d4;
        o = b(AtomicInteger.class, d4);
        TypeAdapter<AtomicBoolean> d5 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public AtomicBoolean e(e.j.e.u.a aVar) throws IOException {
                return new AtomicBoolean(aVar.Y());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.H0(atomicBoolean.get());
            }
        }.d();
        p = d5;
        q = b(AtomicBoolean.class, d5);
        TypeAdapter<AtomicIntegerArray> d6 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public AtomicIntegerArray e(e.j.e.u.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.j();
                while (aVar.H()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.f0()));
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                }
                aVar.q();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                cVar.l();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.D0(atomicIntegerArray.get(i2));
                }
                cVar.q();
            }
        }.d();
        r = d6;
        s = b(AtomicIntegerArray.class, d6);
        t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.m0());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                cVar.F0(number);
            }
        };
        u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return Float.valueOf((float) aVar.c0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                cVar.F0(number);
            }
        };
        v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return Double.valueOf(aVar.c0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                cVar.F0(number);
            }
        };
        TypeAdapter<Character> typeAdapter5 = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Character e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                String A0 = aVar.A0();
                if (A0.length() == 1) {
                    return Character.valueOf(A0.charAt(0));
                }
                throw new JsonSyntaxException("Expecting character, got: " + A0 + "; at " + aVar.F());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Character ch) throws IOException {
                cVar.G0(ch == null ? null : String.valueOf(ch));
            }
        };
        w = typeAdapter5;
        x = c(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter<String> typeAdapter6 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public String e(e.j.e.u.a aVar) throws IOException {
                JsonToken C0 = aVar.C0();
                if (C0 == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                } else if (C0 == JsonToken.BOOLEAN) {
                    return Boolean.toString(aVar.Y());
                } else {
                    return aVar.A0();
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, String str) throws IOException {
                cVar.G0(str);
            }
        };
        y = typeAdapter6;
        z = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public BigDecimal e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                String A0 = aVar.A0();
                try {
                    return new BigDecimal(A0);
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException("Failed parsing '" + A0 + "' as BigDecimal; at path " + aVar.F(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, BigDecimal bigDecimal) throws IOException {
                cVar.F0(bigDecimal);
            }
        };
        A = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public BigInteger e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                String A0 = aVar.A0();
                try {
                    return new BigInteger(A0);
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException("Failed parsing '" + A0 + "' as BigInteger; at path " + aVar.F(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, BigInteger bigInteger) throws IOException {
                cVar.F0(bigInteger);
            }
        };
        B = new TypeAdapter<LazilyParsedNumber>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public LazilyParsedNumber e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return new LazilyParsedNumber(aVar.A0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, LazilyParsedNumber lazilyParsedNumber) throws IOException {
                cVar.F0(lazilyParsedNumber);
            }
        };
        C = b(String.class, typeAdapter6);
        TypeAdapter<StringBuilder> typeAdapter7 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public StringBuilder e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return new StringBuilder(aVar.A0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, StringBuilder sb) throws IOException {
                cVar.G0(sb == null ? null : sb.toString());
            }
        };
        D = typeAdapter7;
        E = b(StringBuilder.class, typeAdapter7);
        TypeAdapter<StringBuffer> typeAdapter8 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public StringBuffer e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return new StringBuffer(aVar.A0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, StringBuffer stringBuffer) throws IOException {
                cVar.G0(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        F = typeAdapter8;
        G = b(StringBuffer.class, typeAdapter8);
        TypeAdapter<URL> typeAdapter9 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public URL e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                String A0 = aVar.A0();
                if ("null".equals(A0)) {
                    return null;
                }
                return new URL(A0);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, URL url) throws IOException {
                cVar.G0(url == null ? null : url.toExternalForm());
            }
        };
        H = typeAdapter9;
        I = b(URL.class, typeAdapter9);
        TypeAdapter<URI> typeAdapter10 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public URI e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                try {
                    String A0 = aVar.A0();
                    if ("null".equals(A0)) {
                        return null;
                    }
                    return new URI(A0);
                } catch (URISyntaxException e2) {
                    throw new JsonIOException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, URI uri) throws IOException {
                cVar.G0(uri == null ? null : uri.toASCIIString());
            }
        };
        J = typeAdapter10;
        K = b(URI.class, typeAdapter10);
        TypeAdapter<InetAddress> typeAdapter11 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public InetAddress e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return InetAddress.getByName(aVar.A0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, InetAddress inetAddress) throws IOException {
                cVar.G0(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        L = typeAdapter11;
        M = e(InetAddress.class, typeAdapter11);
        TypeAdapter<UUID> typeAdapter12 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public UUID e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                String A0 = aVar.A0();
                try {
                    return UUID.fromString(A0);
                } catch (IllegalArgumentException e2) {
                    throw new JsonSyntaxException("Failed parsing '" + A0 + "' as UUID; at path " + aVar.F(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, UUID uuid) throws IOException {
                cVar.G0(uuid == null ? null : uuid.toString());
            }
        };
        N = typeAdapter12;
        O = b(UUID.class, typeAdapter12);
        TypeAdapter<Currency> d7 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Currency e(e.j.e.u.a aVar) throws IOException {
                String A0 = aVar.A0();
                try {
                    return Currency.getInstance(A0);
                } catch (IllegalArgumentException e2) {
                    throw new JsonSyntaxException("Failed parsing '" + A0 + "' as Currency; at path " + aVar.F(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Currency currency) throws IOException {
                cVar.G0(currency.getCurrencyCode());
            }
        }.d();
        P = d7;
        Q = b(Currency.class, d7);
        TypeAdapter<Calendar> typeAdapter13 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            private static final String a = "year";
            private static final String b = "month";

            /* renamed from: c */
            private static final String f3243c = "dayOfMonth";

            /* renamed from: d */
            private static final String f3244d = "hourOfDay";

            /* renamed from: e */
            private static final String f3245e = "minute";

            /* renamed from: f */
            private static final String f3246f = "second";

            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Calendar e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                aVar.k();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.C0() != JsonToken.END_OBJECT) {
                    String o0 = aVar.o0();
                    int f0 = aVar.f0();
                    if (a.equals(o0)) {
                        i2 = f0;
                    } else if (b.equals(o0)) {
                        i3 = f0;
                    } else if (f3243c.equals(o0)) {
                        i4 = f0;
                    } else if (f3244d.equals(o0)) {
                        i5 = f0;
                    } else if (f3245e.equals(o0)) {
                        i6 = f0;
                    } else if (f3246f.equals(o0)) {
                        i7 = f0;
                    }
                }
                aVar.r();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    cVar.Y();
                    return;
                }
                cVar.n();
                cVar.M(a);
                cVar.D0(calendar.get(1));
                cVar.M(b);
                cVar.D0(calendar.get(2));
                cVar.M(f3243c);
                cVar.D0(calendar.get(5));
                cVar.M(f3244d);
                cVar.D0(calendar.get(11));
                cVar.M(f3245e);
                cVar.D0(calendar.get(12));
                cVar.M(f3246f);
                cVar.D0(calendar.get(13));
                cVar.r();
            }
        };
        R = typeAdapter13;
        S = d(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter<Locale> typeAdapter14 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Locale e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.A0(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (nextToken2 == null && nextToken3 == null) {
                    return new Locale(nextToken);
                }
                if (nextToken3 == null) {
                    return new Locale(nextToken, nextToken2);
                }
                return new Locale(nextToken, nextToken2, nextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Locale locale) throws IOException {
                cVar.G0(locale == null ? null : locale.toString());
            }
        };
        T = typeAdapter14;
        U = b(Locale.class, typeAdapter14);
        TypeAdapter<h> typeAdapter15 = new TypeAdapter<h>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public h e(e.j.e.u.a aVar) throws IOException {
                if (aVar instanceof e.j.e.s.k.a) {
                    return ((e.j.e.s.k.a) aVar).P0();
                }
                switch (a.a[aVar.C0().ordinal()]) {
                    case 1:
                        return new l(new LazilyParsedNumber(aVar.A0()));
                    case 2:
                        return new l(aVar.A0());
                    case 3:
                        return new l(Boolean.valueOf(aVar.Y()));
                    case 4:
                        aVar.x0();
                        return i.a;
                    case 5:
                        e eVar = new e();
                        aVar.j();
                        while (aVar.H()) {
                            eVar.B(e(aVar));
                        }
                        aVar.q();
                        return eVar;
                    case 6:
                        j jVar = new j();
                        aVar.k();
                        while (aVar.H()) {
                            jVar.B(aVar.o0(), e(aVar));
                        }
                        aVar.r();
                        return jVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, h hVar) throws IOException {
                if (hVar != null && !hVar.y()) {
                    if (hVar.A()) {
                        l s2 = hVar.s();
                        if (s2.E()) {
                            cVar.F0(s2.u());
                            return;
                        } else if (s2.C()) {
                            cVar.H0(s2.e());
                            return;
                        } else {
                            cVar.G0(s2.w());
                            return;
                        }
                    } else if (hVar.x()) {
                        cVar.l();
                        Iterator<h> it = hVar.p().iterator();
                        while (it.hasNext()) {
                            i(cVar, it.next());
                        }
                        cVar.q();
                        return;
                    } else if (hVar.z()) {
                        cVar.n();
                        for (Map.Entry<String, h> entry : hVar.r().H()) {
                            cVar.M(entry.getKey());
                            i(cVar, entry.getValue());
                        }
                        cVar.r();
                        return;
                    } else {
                        throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
                    }
                }
                cVar.Y();
            }
        };
        V = typeAdapter15;
        W = e(h.class, typeAdapter15);
        X = new q() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
                Class rawType = aVar.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = (Class<? super Object>) rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> q a(final e.j.e.t.a<TT> aVar, final TypeAdapter<TT> typeAdapter) {
        return new q() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> q b(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new q() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> q c(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new q() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> q d(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new q() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> q e(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new q() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // e.j.e.q
            public <T2> TypeAdapter<T2> a(Gson gson, e.j.e.t.a<T2> aVar) {
                final Class<? super T2> rawType = aVar.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                        {
                            AnonymousClass34.this = this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, T1] */
                        @Override // com.google.gson.TypeAdapter
                        public T1 e(e.j.e.u.a aVar2) throws IOException {
                            ?? e2 = typeAdapter.e(aVar2);
                            if (e2 == 0 || rawType.isInstance(e2)) {
                                return e2;
                            }
                            throw new JsonSyntaxException("Expected a " + rawType.getName() + " but was " + e2.getClass().getName() + "; at path " + aVar2.F());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void i(e.j.e.u.c cVar, T1 t1) throws IOException {
                            typeAdapter.i(cVar, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
