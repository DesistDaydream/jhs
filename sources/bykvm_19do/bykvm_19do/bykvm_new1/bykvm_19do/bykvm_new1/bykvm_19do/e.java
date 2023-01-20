package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static volatile e f1202e;
    private Context a;
    private Map<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c, c> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private b f1203c;

    /* renamed from: d  reason: collision with root package name */
    private d f1204d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.values().length];
            a = iArr;
            try {
                iArr[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private e(@NonNull Context context) {
        this.a = context;
        this.f1203c = new b(context);
        this.f1204d = new d(this.a);
    }

    @Nullable
    private c a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar) {
        c cVar2 = this.b.get(cVar);
        if (cVar2 == null) {
            int i2 = a.a[cVar.ordinal()];
            if (i2 == 1) {
                cVar2 = new g(this.a, this.f1203c, this.f1204d);
            } else if (i2 == 2) {
                cVar2 = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.a(this.a, this.f1203c, this.f1204d);
            } else if (i2 == 3) {
                cVar2 = new f(this.a, this.f1203c, this.f1204d);
            }
            if (cVar2 != null) {
                this.b.put(cVar, cVar2);
            }
        }
        return cVar2;
    }

    public static e a() {
        if (f1202e != null) {
            return f1202e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void a(Context context) {
        if (f1202e == null) {
            f1202e = new e(context);
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        c a2;
        return (cVar == null || (a2 = a(cVar)) == null) ? aVar : a2.b(aVar);
    }
}
