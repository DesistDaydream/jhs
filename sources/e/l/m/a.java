package e.l.m;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.mmkv.UserKV;
import com.tencent.mmkv.MMKV;
import h.k2.v.f0;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public abstract class a {
    public static final /* synthetic */ n<Object>[] b = {n0.r(new PropertyReference1Impl(n0.d(a.class), "kv", "getKv()Lcom/tencent/mmkv/MMKV;"))};
    @d
    private final C0389a a = d();

    /* renamed from: e.l.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0389a implements e<a, MMKV> {
        private int a;
        @k.e.a.e
        private MMKV b;

        public C0389a() {
        }

        @Override // h.m2.e
        @d
        /* renamed from: c */
        public MMKV a(@d a aVar, @d n<?> nVar) {
            if (this.b == null || (a.this.p() && this.a != UserKV.f3913c.v())) {
                if (a.this.p()) {
                    this.a = UserKV.f3913c.v();
                }
                int i2 = a.this.j() ? 2 : 1;
                this.b = MMKV.mmkvWithID(this.a + '_' + a.this.c(), i2, "jihuanshe_cbc");
            }
            return this.b;
        }
    }

    private final C0389a d() {
        return new C0389a();
    }

    public final void a() {
        f().clearAll();
    }

    public final double b(@d String str, double d2) {
        return f().decodeDouble(str, d2);
    }

    @d
    public abstract String c();

    public final int e(@d String str, int i2) {
        return f().decodeInt(str, i2);
    }

    @d
    public final MMKV f() {
        return this.a.a(this, b[0]);
    }

    public final long g(@d String str, long j2) {
        return f().decodeLong(str, j2);
    }

    public final /* synthetic */ <T extends Parcelable> T h(String str) {
        MMKV f2 = f();
        f0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) f2.decodeParcelable(str, Parcelable.class);
    }

    @k.e.a.e
    public final String i(@d String str, @k.e.a.e String str2) {
        return f().decodeString(str, str2);
    }

    public abstract boolean j();

    public final void k(@d String str, double d2) {
        f().encode(str, d2);
    }

    public final void l(@d String str, int i2) {
        f().encode(str, i2);
    }

    public final void m(@d String str, long j2) {
        f().encode(str, j2);
    }

    public final void n(@d String str, @k.e.a.e Parcelable parcelable) {
        f().encode(str, parcelable);
    }

    public final void o(@d String str, @d String str2) {
        f().encode(str, str2);
    }

    public boolean p() {
        return false;
    }
}
