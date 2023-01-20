package e.j.a.b.c.r.i0;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.x.c;
import e.j.a.b.c.x.d0;
import java.util.ArrayList;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public final class b {
    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        a0.k(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> T b(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) a(byteArrayExtra, creator);
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> T c(String str, Parcelable.Creator<T> creator) {
        return (T) a(c.b(str), creator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends SafeParcelable> ArrayList<T> d(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            arrayList2.add(a((byte[]) obj, creator));
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> ArrayList<T> e(Intent intent, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            arrayList2.add(a((byte[]) obj, creator));
        }
        return arrayList2;
    }

    public static <T extends SafeParcelable> void f(Iterable<T> iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(h(t));
        }
        bundle.putSerializable(str, arrayList);
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> void g(Iterable<T> iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(h(t));
        }
        intent.putExtra(str, arrayList);
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> byte[] h(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> void i(T t, Intent intent, String str) {
        intent.putExtra(str, h(t));
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> String j(T t) {
        return c.e(h(t));
    }
}
