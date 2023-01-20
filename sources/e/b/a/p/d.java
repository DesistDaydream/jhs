package e.b.a.p;

import android.content.Context;
import androidx.annotation.NonNull;
import e.b.a.p.k.s;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
public class d<T> implements i<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Collection<? extends i<T>> f9443c;

    @SafeVarargs
    public d(@NonNull i<T>... iVarArr) {
        if (iVarArr.length != 0) {
            this.f9443c = Arrays.asList(iVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f9443c.equals(((d) obj).f9443c);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return this.f9443c.hashCode();
    }

    @Override // e.b.a.p.i
    @NonNull
    public s<T> transform(@NonNull Context context, @NonNull s<T> sVar, int i2, int i3) {
        s<T> sVar2 = sVar;
        for (i<T> iVar : this.f9443c) {
            s<T> transform = iVar.transform(context, sVar2, i2, i3);
            if (sVar2 != null && !sVar2.equals(sVar) && !sVar2.equals(transform)) {
                sVar2.recycle();
            }
            sVar2 = transform;
        }
        return sVar2;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (i<T> iVar : this.f9443c) {
            iVar.updateDiskCacheKey(messageDigest);
        }
    }

    public d(@NonNull Collection<? extends i<T>> collection) {
        if (!collection.isEmpty()) {
            this.f9443c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
