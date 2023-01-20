package e.b.a.p.m.h;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.n.a;

/* loaded from: classes.dex */
public final class b implements a.InterfaceC0304a {
    private final e.b.a.p.k.x.e a;
    @Nullable
    private final e.b.a.p.k.x.b b;

    public b(e.b.a.p.k.x.e eVar) {
        this(eVar, null);
    }

    @Override // e.b.a.n.a.InterfaceC0304a
    public void a(@NonNull Bitmap bitmap) {
        this.a.d(bitmap);
    }

    @Override // e.b.a.n.a.InterfaceC0304a
    @NonNull
    public byte[] b(int i2) {
        e.b.a.p.k.x.b bVar = this.b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.c(i2, byte[].class);
    }

    @Override // e.b.a.n.a.InterfaceC0304a
    @NonNull
    public Bitmap c(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.a.g(i2, i3, config);
    }

    @Override // e.b.a.n.a.InterfaceC0304a
    @NonNull
    public int[] d(int i2) {
        e.b.a.p.k.x.b bVar = this.b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.c(i2, int[].class);
    }

    @Override // e.b.a.n.a.InterfaceC0304a
    public void e(@NonNull byte[] bArr) {
        e.b.a.p.k.x.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.e(bArr);
    }

    @Override // e.b.a.n.a.InterfaceC0304a
    public void f(@NonNull int[] iArr) {
        e.b.a.p.k.x.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.e(iArr);
    }

    public b(e.b.a.p.k.x.e eVar, @Nullable e.b.a.p.k.x.b bVar) {
        this.a = eVar;
        this.b = bVar;
    }
}
