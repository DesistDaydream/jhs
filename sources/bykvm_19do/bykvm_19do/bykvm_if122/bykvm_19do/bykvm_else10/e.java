package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    private static final String f795d = "e";

    /* renamed from: e  reason: collision with root package name */
    private static e f796e;
    private final Set<String> a = new HashSet(1);
    private final List<WeakReference<f>> b = new ArrayList(1);

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f797c = new ArrayList(1);

    private e() {
        b();
    }

    public static e a() {
        if (f796e == null) {
            f796e = new e();
        }
        return f796e;
    }

    private void a(@Nullable f fVar) {
        synchronized (this) {
            Iterator<WeakReference<f>> it = this.b.iterator();
            while (it.hasNext()) {
                WeakReference<f> next = it.next();
                if (next.get() == fVar || next.get() == null) {
                    it.remove();
                }
            }
            Iterator<f> it2 = this.f797c.iterator();
            while (it2.hasNext()) {
                if (it2.next() == fVar) {
                    it2.remove();
                }
            }
        }
    }

    private void a(@NonNull String[] strArr, @Nullable f fVar) {
        synchronized (this) {
            if (fVar != null) {
                fVar.a(strArr);
                this.f797c.add(fVar);
                this.b.add(new WeakReference<>(fVar));
            }
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i2;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<f>> it = this.b.iterator();
            while (it.hasNext()) {
                f fVar = it.next().get();
                while (i2 < length) {
                    i2 = (fVar == null || fVar.a(strArr[i2], iArr[i2])) ? 0 : i2 + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<f> it2 = this.f797c.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        String str;
        synchronized (this) {
            for (Field field : Manifest.permission.class.getFields()) {
                try {
                    str = (String) field.get("");
                } catch (IllegalAccessException e2) {
                    Log.e(f795d, "Could not access field", e2);
                    str = null;
                }
                this.a.add(str);
            }
        }
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        for (String str : strArr) {
            if (fVar != null) {
                try {
                    if (fVar.a(str, !this.a.contains(str) ? d.NOT_FOUND : c.a(activity, str) != 0 ? d.DENIED : d.GRANTED)) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(fVar);
    }

    @NonNull
    private List<String> c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        d dVar;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.a.contains(str)) {
                if (!a(activity, str)) {
                    arrayList.add(str);
                } else if (fVar != null) {
                    dVar = d.GRANTED;
                    fVar.a(str, dVar);
                }
            } else if (fVar != null) {
                dVar = d.NOT_FOUND;
                fVar.a(str, dVar);
            }
        }
        return arrayList;
    }

    public void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        synchronized (this) {
            if (activity != null) {
                try {
                    a(strArr, fVar);
                    if (Build.VERSION.SDK_INT < 23) {
                        b(activity, strArr, fVar);
                    } else {
                        List<String> c2 = c(activity, strArr, fVar);
                        if (c2.isEmpty()) {
                            a(fVar);
                        } else {
                            c.a(activity, (String[]) c2.toArray(new String[c2.size()]), 1);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        synchronized (this) {
            try {
                new ArrayList(3);
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    if ((iArr[i2] == -1 || (b0.t() && !b.b(activity, str))) && iArr[i2] != -1) {
                        iArr[i2] = -1;
                    }
                }
                a(strArr, iArr, (String[]) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean a(@Nullable Context context, @NonNull String str) {
        boolean z;
        synchronized (this) {
            z = false;
            if (context != null) {
                z = !b0.t() ? true : true;
            }
        }
        return z;
    }
}
