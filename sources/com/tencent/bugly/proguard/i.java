package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class i {
    private ByteBuffer a;
    private String b;

    public i(int i2) {
        this.b = "GBK";
        this.a = ByteBuffer.allocate(i2);
    }

    public final ByteBuffer a() {
        return this.a;
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.a.position()];
        System.arraycopy(this.a.array(), 0, bArr, 0, this.a.position());
        return bArr;
    }

    private void a(int i2) {
        if (this.a.remaining() < i2) {
            ByteBuffer allocate = ByteBuffer.allocate((this.a.capacity() + i2) << 1);
            allocate.put(this.a.array(), 0, this.a.position());
            this.a = allocate;
        }
    }

    private void b(byte b, int i2) {
        if (i2 < 15) {
            this.a.put((byte) (b | (i2 << 4)));
        } else if (i2 < 256) {
            this.a.put((byte) (b | 240));
            this.a.put((byte) i2);
        } else {
            throw new b("tag is too large: " + i2);
        }
    }

    public i() {
        this(128);
    }

    public final void a(boolean z, int i2) {
        a(z ? (byte) 1 : (byte) 0, i2);
    }

    public final void a(byte b, int i2) {
        a(3);
        if (b == 0) {
            b((byte) 12, i2);
            return;
        }
        b((byte) 0, i2);
        this.a.put(b);
    }

    public final void a(short s, int i2) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i2);
            return;
        }
        b((byte) 1, i2);
        this.a.putShort(s);
    }

    public final void a(int i2, int i3) {
        a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            a((short) i2, i3);
            return;
        }
        b((byte) 2, i3);
        this.a.putInt(i2);
    }

    public final void a(long j2, int i2) {
        a(10);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            a((int) j2, i2);
            return;
        }
        b((byte) 3, i2);
        this.a.putLong(j2);
    }

    public final void a(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i2);
            this.a.putInt(bytes.length);
            this.a.put(bytes);
            return;
        }
        b((byte) 6, i2);
        this.a.put((byte) bytes.length);
        this.a.put(bytes);
    }

    public final <K, V> void a(Map<K, V> map, int i2) {
        a(8);
        b((byte) 8, i2);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public final void a(byte[] bArr, int i2) {
        a(bArr.length + 8);
        b((byte) 13, i2);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.a.put(bArr);
    }

    public final <T> void a(Collection<T> collection, int i2) {
        a(8);
        b((byte) 9, i2);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                a(t, 0);
            }
        }
    }

    public final void a(j jVar, int i2) {
        a(2);
        b((byte) 10, i2);
        jVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i2) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i2);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i2);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i2);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i2);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i2);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            a(6);
            b((byte) 4, i2);
            this.a.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i2);
            this.a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            a((String) obj, i2);
        } else if (obj instanceof Map) {
            a((Map) obj, i2);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i2);
        } else if (obj instanceof j) {
            a(2);
            b((byte) 10, i2);
            ((j) obj).a(this);
            a(2);
            b((byte) 11, 0);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i2);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i2);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z ? (byte) 1 : (byte) 0, 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i2);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i2);
            a(iArr.length, 0);
            for (int i3 : iArr) {
                a(i3, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i2);
            a(jArr.length, 0);
            for (long j2 : jArr) {
                a(j2, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i2);
            a(fArr.length, 0);
            for (float f2 : fArr) {
                a(6);
                b((byte) 4, 0);
                this.a.putFloat(f2);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i2);
            a(dArr.length, 0);
            for (double d2 : dArr) {
                a(10);
                b((byte) 5, 0);
                this.a.putDouble(d2);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i2);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
        } else if (obj instanceof Collection) {
            a((Collection) obj, i2);
        } else {
            throw new b("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
