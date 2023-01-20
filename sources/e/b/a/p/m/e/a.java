package e.b.a.p.m.e;

import androidx.annotation.NonNull;
import e.b.a.p.j.e;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {
    private final ByteBuffer a;

    /* renamed from: e.b.a.p.m.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0321a implements e.a<ByteBuffer> {
        @Override // e.b.a.p.j.e.a
        @NonNull
        /* renamed from: b */
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // e.b.a.p.j.e.a
        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // e.b.a.p.j.e
    public void a() {
    }

    @Override // e.b.a.p.j.e
    @NonNull
    /* renamed from: c */
    public ByteBuffer b() {
        this.a.position(0);
        return this.a;
    }
}
