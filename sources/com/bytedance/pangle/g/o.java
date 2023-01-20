package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class o {
    public static final o a = new o(null, 0, null, null, null);
    @Nullable
    public final Signature[] b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2301c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final ArraySet<PublicKey> f2302d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Signature[] f2303e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final int[] f2304f;

    public o(Signature[] signatureArr, int i2, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.b = signatureArr;
        this.f2301c = i2;
        this.f2302d = arraySet;
        this.f2303e = signatureArr2;
        this.f2304f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method a2 = com.bytedance.pangle.a.a.a.a(Signature.class, "getPublicKey", new Class[0]);
            if (a2 != null && a2.isAccessible()) {
                try {
                    arraySet.add((PublicKey) a2.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f2301c == oVar.f2301c && a(this.b, oVar.b)) {
                ArraySet<PublicKey> arraySet = this.f2302d;
                if (arraySet != null) {
                    if (!arraySet.equals(oVar.f2302d)) {
                        return false;
                    }
                } else if (oVar.f2302d != null) {
                    return false;
                }
                return Arrays.equals(this.f2303e, oVar.f2303e) && Arrays.equals(this.f2304f, oVar.f2304f);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((Arrays.hashCode(this.b) * 31) + this.f2301c) * 31;
        ArraySet<PublicKey> arraySet = this.f2302d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f2303e)) * 31) + Arrays.hashCode(this.f2304f);
    }

    public o(Signature[] signatureArr, int i2, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i2, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.c.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.c.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
