package com.google.android.gms.common.internal.safeparcel;

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
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SafeParcelReader {

    /* loaded from: classes2.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    public static ArrayList<Parcel> A(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                arrayList.add(null);
            }
        }
        parcel.setDataPosition(dataPosition + f0);
        return arrayList;
    }

    public static SparseArray<Parcel> B(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray.append(readInt2, null);
            }
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    public static <T extends Parcelable> T C(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + f0);
        return createFromParcel;
    }

    public static SparseBooleanArray D(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(dataPosition + f0);
        return readSparseBooleanArray;
    }

    public static SparseIntArray E(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseIntArray;
    }

    public static SparseLongArray F(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseLongArray;
    }

    public static String G(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + f0);
        return readString;
    }

    public static String[] H(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + f0);
        return createStringArray;
    }

    public static ArrayList<String> I(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + f0);
        return createStringArrayList;
    }

    public static SparseArray<String> J(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    public static <T> T[] K(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + f0);
        return tArr;
    }

    public static <T> ArrayList<T> L(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + f0);
        return createTypedArrayList;
    }

    public static <T> SparseArray<T> M(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<T> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    public static void N(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new ParseException(sb.toString(), parcel);
    }

    public static int O(int i2) {
        return i2 & 65535;
    }

    public static boolean P(Parcel parcel, int i2) {
        i0(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean Q(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        if (f0 == 0) {
            return null;
        }
        j0(parcel, i2, f0, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte R(Parcel parcel, int i2) {
        i0(parcel, i2, 4);
        return (byte) parcel.readInt();
    }

    public static char S(Parcel parcel, int i2) {
        i0(parcel, i2, 4);
        return (char) parcel.readInt();
    }

    public static double T(Parcel parcel, int i2) {
        i0(parcel, i2, 8);
        return parcel.readDouble();
    }

    public static Double U(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        if (f0 == 0) {
            return null;
        }
        j0(parcel, i2, f0, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float V(Parcel parcel, int i2) {
        i0(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float W(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        if (f0 == 0) {
            return null;
        }
        j0(parcel, i2, f0, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int X(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder Y(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + f0);
        return readStrongBinder;
    }

    public static int Z(Parcel parcel, int i2) {
        i0(parcel, i2, 4);
        return parcel.readInt();
    }

    public static BigDecimal a(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + f0);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static Integer a0(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        if (f0 == 0) {
            return null;
        }
        j0(parcel, i2, f0, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static BigDecimal[] b(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + f0);
        return bigDecimalArr;
    }

    public static void b0(Parcel parcel, int i2, List list, ClassLoader classLoader) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(dataPosition + f0);
    }

    public static BigInteger c(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + f0);
        return new BigInteger(createByteArray);
    }

    public static long c0(Parcel parcel, int i2) {
        i0(parcel, i2, 8);
        return parcel.readLong();
    }

    public static BigInteger[] d(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + f0);
        return bigIntegerArr;
    }

    public static Long d0(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        if (f0 == 0) {
            return null;
        }
        j0(parcel, i2, f0, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static boolean[] e(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + f0);
        return createBooleanArray;
    }

    public static short e0(Parcel parcel, int i2) {
        i0(parcel, i2, 4);
        return (short) parcel.readInt();
    }

    public static ArrayList<Boolean> f(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + f0);
        return arrayList;
    }

    public static int f0(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static Bundle g(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + f0);
        return readBundle;
    }

    public static void g0(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + f0(parcel, i2));
    }

    public static byte[] h(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + f0);
        return createByteArray;
    }

    public static int h0(Parcel parcel) {
        int X = X(parcel);
        int f0 = f0(parcel, X);
        int dataPosition = parcel.dataPosition();
        if (O(X) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(X));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = f0 + dataPosition;
        if (i2 < dataPosition || i2 > parcel.dataSize()) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i2);
            throw new ParseException(sb.toString(), parcel);
        }
        return i2;
    }

    public static byte[][] i(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + f0);
        return bArr;
    }

    private static void i0(Parcel parcel, int i2, int i3) {
        int f0 = f0(parcel, i2);
        if (f0 == i3) {
            return;
        }
        String hexString = Integer.toHexString(f0);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(f0);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static SparseArray<byte[]> j(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    private static void j0(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        String hexString = Integer.toHexString(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(i3);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static char[] k(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(dataPosition + f0);
        return createCharArray;
    }

    public static double[] l(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + f0);
        return createDoubleArray;
    }

    public static ArrayList<Double> m(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + f0);
        return arrayList;
    }

    public static SparseArray<Double> n(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    public static float[] o(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + f0);
        return createFloatArray;
    }

    public static ArrayList<Float> p(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + f0);
        return arrayList;
    }

    public static SparseArray<Float> q(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    public static IBinder[] r(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(dataPosition + f0);
        return createBinderArray;
    }

    public static ArrayList<IBinder> s(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(dataPosition + f0);
        return createBinderArrayList;
    }

    public static SparseArray<IBinder> t(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + f0);
        return sparseArray;
    }

    public static int[] u(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + f0);
        return createIntArray;
    }

    public static ArrayList<Integer> v(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + f0);
        return arrayList;
    }

    public static long[] w(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + f0);
        return createLongArray;
    }

    public static ArrayList<Long> x(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + f0);
        return arrayList;
    }

    public static Parcel y(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, f0);
        parcel.setDataPosition(dataPosition + f0);
        return obtain;
    }

    public static Parcel[] z(Parcel parcel, int i2) {
        int f0 = f0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (f0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + f0);
        return parcelArr;
    }
}
