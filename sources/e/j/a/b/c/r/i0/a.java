package e.j.a.b.c.r.i0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    public static void A(Parcel parcel, int i2, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
        }
        g0(parcel, e0);
    }

    public static void B(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeStrongBinder(iBinder);
        g0(parcel, e0);
    }

    public static void C(Parcel parcel, int i2, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeBinderArray(iBinderArr);
        g0(parcel, e0);
    }

    public static void D(Parcel parcel, int i2, List<IBinder> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeBinderList(list);
        g0(parcel, e0);
    }

    public static void E(Parcel parcel, int i2, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeStrongBinder(sparseArray.valueAt(i3));
        }
        g0(parcel, e0);
    }

    public static void F(Parcel parcel, int i2, int i3) {
        h0(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void G(Parcel parcel, int i2, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeIntArray(iArr);
        g0(parcel, e0);
    }

    public static void H(Parcel parcel, int i2, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).intValue());
        }
        g0(parcel, e0);
    }

    public static void I(Parcel parcel, int i2, Integer num, boolean z) {
        if (num != null) {
            h0(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void J(Parcel parcel, int i2, List list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeList(list);
        g0(parcel, e0);
    }

    public static void K(Parcel parcel, int i2, long j2) {
        h0(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void L(Parcel parcel, int i2, long[] jArr, boolean z) {
        if (jArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeLongArray(jArr);
        g0(parcel, e0);
    }

    public static void M(Parcel parcel, int i2, List<Long> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeLong(list.get(i3).longValue());
        }
        g0(parcel, e0);
    }

    public static void N(Parcel parcel, int i2, Long l2, boolean z) {
        if (l2 != null) {
            h0(parcel, i2, 8);
            parcel.writeLong(l2.longValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void O(Parcel parcel, int i2, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        g0(parcel, e0);
    }

    public static void P(Parcel parcel, int i2, Parcel[] parcelArr, boolean z) {
        if (parcelArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, e0);
    }

    public static void Q(Parcel parcel, int i2, List<Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcel parcel2 = list.get(i3);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, e0);
    }

    public static void R(Parcel parcel, int i2, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            Parcel valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, e0);
    }

    public static void S(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        g0(parcel, e0);
    }

    public static void T(Parcel parcel, int i2, short s) {
        h0(parcel, i2, 4);
        parcel.writeInt(s);
    }

    public static void U(Parcel parcel, int i2, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeSparseBooleanArray(sparseBooleanArray);
        g0(parcel, e0);
    }

    public static void V(Parcel parcel, int i2, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseIntArray.keyAt(i3));
            parcel.writeInt(sparseIntArray.valueAt(i3));
        }
        g0(parcel, e0);
    }

    public static void W(Parcel parcel, int i2, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseLongArray.keyAt(i3));
            parcel.writeLong(sparseLongArray.valueAt(i3));
        }
        g0(parcel, e0);
    }

    public static void X(Parcel parcel, int i2, String str, boolean z) {
        if (str == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeString(str);
        g0(parcel, e0);
    }

    public static void Y(Parcel parcel, int i2, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeStringArray(strArr);
        g0(parcel, e0);
    }

    public static void Z(Parcel parcel, int i2, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeStringList(list);
        g0(parcel, e0);
    }

    public static int a(Parcel parcel) {
        return e0(parcel, 20293);
    }

    public static void a0(Parcel parcel, int i2, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeString(sparseArray.valueAt(i3));
        }
        g0(parcel, e0);
    }

    public static void b(Parcel parcel, int i2) {
        g0(parcel, i2);
    }

    public static <T extends Parcelable> void b0(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                f0(parcel, t, i3);
            }
        }
        g0(parcel, e0);
    }

    public static void c(Parcel parcel, int i2, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        g0(parcel, e0);
    }

    public static <T extends Parcelable> void c0(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                f0(parcel, t, 0);
            }
        }
        g0(parcel, e0);
    }

    public static void d(Parcel parcel, int i2, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i3 = 0; i3 < length; i3++) {
            parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i3].scale());
        }
        g0(parcel, e0);
    }

    public static <T extends Parcelable> void d0(Parcel parcel, int i2, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            T valueAt = sparseArray.valueAt(i3);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                f0(parcel, valueAt, 0);
            }
        }
        g0(parcel, e0);
    }

    public static void e(Parcel parcel, int i2, BigInteger bigInteger, boolean z) {
        if (bigInteger == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeByteArray(bigInteger.toByteArray());
        g0(parcel, e0);
    }

    private static int e0(Parcel parcel, int i2) {
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void f(Parcel parcel, int i2, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        g0(parcel, e0);
    }

    private static <T extends Parcelable> void f0(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void g(Parcel parcel, int i2, boolean z) {
        h0(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    private static void g0(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void h(Parcel parcel, int i2, boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeBooleanArray(zArr);
        g0(parcel, e0);
    }

    private static void h0(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | (-65536));
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static void i(Parcel parcel, int i2, List<Boolean> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).booleanValue() ? 1 : 0);
        }
        g0(parcel, e0);
    }

    public static void j(Parcel parcel, int i2, Boolean bool, boolean z) {
        if (bool != null) {
            h0(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void k(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeBundle(bundle);
        g0(parcel, e0);
    }

    public static void l(Parcel parcel, int i2, byte b) {
        h0(parcel, i2, 4);
        parcel.writeInt(b);
    }

    public static void m(Parcel parcel, int i2, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeByteArray(bArr);
        g0(parcel, e0);
    }

    public static void n(Parcel parcel, int i2, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        g0(parcel, e0);
    }

    public static void o(Parcel parcel, int i2, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeByteArray(sparseArray.valueAt(i3));
        }
        g0(parcel, e0);
    }

    public static void p(Parcel parcel, int i2, char c2) {
        h0(parcel, i2, 4);
        parcel.writeInt(c2);
    }

    public static void q(Parcel parcel, int i2, char[] cArr, boolean z) {
        if (cArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeCharArray(cArr);
        g0(parcel, e0);
    }

    public static void r(Parcel parcel, int i2, double d2) {
        h0(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void s(Parcel parcel, int i2, double[] dArr, boolean z) {
        if (dArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeDoubleArray(dArr);
        g0(parcel, e0);
    }

    public static void t(Parcel parcel, int i2, List<Double> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeDouble(list.get(i3).doubleValue());
        }
        g0(parcel, e0);
    }

    public static void u(Parcel parcel, int i2, Double d2, boolean z) {
        if (d2 != null) {
            h0(parcel, i2, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }

    public static void v(Parcel parcel, int i2, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
        }
        g0(parcel, e0);
    }

    public static void w(Parcel parcel, int i2, float f2) {
        h0(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void x(Parcel parcel, int i2, float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        parcel.writeFloatArray(fArr);
        g0(parcel, e0);
    }

    public static void y(Parcel parcel, int i2, List<Float> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i2, 0);
                return;
            }
            return;
        }
        int e0 = e0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeFloat(list.get(i3).floatValue());
        }
        g0(parcel, e0);
    }

    public static void z(Parcel parcel, int i2, Float f2, boolean z) {
        if (f2 != null) {
            h0(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            h0(parcel, i2, 0);
        }
    }
}
