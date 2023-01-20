package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class z {

    /* loaded from: classes.dex */
    public static final class a extends z {
        public final /* synthetic */ u a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f678c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f679d;

        public a(u uVar, int i2, byte[] bArr, int i3) {
            this.a = uVar;
            this.b = i2;
            this.f678c = bArr;
            this.f679d = i3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public long a() {
            return this.b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException {
            dVar.write(this.f678c, this.f679d, this.b);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public u b() {
            return this.a;
        }
    }

    public static z a(u uVar, String str) {
        Charset charset = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f548i;
        if (uVar != null) {
            Charset a2 = uVar.a();
            if (a2 == null) {
                uVar = u.a(uVar + "; charset=utf-8");
            } else {
                charset = a2;
            }
        }
        return a(uVar, str.getBytes(charset));
    }

    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static z a(u uVar, byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "content == null");
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bArr.length, i2, i3);
        return new a(uVar, i3, bArr, i2);
    }

    public abstract long a() throws IOException;

    public abstract void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException;

    public abstract u b();
}
