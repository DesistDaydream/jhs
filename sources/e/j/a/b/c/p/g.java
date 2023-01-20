package e.j.a.b.c.p;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class g<T extends SafeParcelable> extends a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f10356c = {"data"};
    private final Parcelable.Creator<T> b;

    @e.j.a.b.c.m.a
    public g(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.b = creator;
    }

    @e.j.a.b.c.m.a
    public static <T extends SafeParcelable> void a(DataHolder.a aVar, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        aVar.c(contentValues);
        obtain.recycle();
    }

    @e.j.a.b.c.m.a
    public static DataHolder.a b() {
        return DataHolder.builder(f10356c);
    }

    @Override // e.j.a.b.c.p.a, e.j.a.b.c.p.b
    @e.j.a.b.c.m.a
    /* renamed from: d */
    public T get(int i2) {
        DataHolder dataHolder = this.a;
        byte[] byteArray = dataHolder.getByteArray("data", i2, dataHolder.getWindowIndex(i2));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.b.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
