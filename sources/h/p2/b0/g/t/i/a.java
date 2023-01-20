package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.n;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes3.dex */
public abstract class a implements n {
    public int memoizedHashCode = 0;

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream J = CodedOutputStream.J(outputStream, CodedOutputStream.u(CodedOutputStream.v(serializedSize) + serializedSize));
        J.o0(serializedSize);
        writeTo(J);
        J.I();
    }

    /* renamed from: h.p2.b0.g.t.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0459a<BuilderType extends AbstractC0459a> implements n.a {
        public static UninitializedMessageException c(n nVar) {
            return new UninitializedMessageException(nVar);
        }

        @Override // 
        /* renamed from: a */
        public abstract BuilderType clone();

        @Override // h.p2.b0.g.t.i.n.a
        /* renamed from: b */
        public abstract BuilderType d(e eVar, f fVar) throws IOException;

        /* renamed from: h.p2.b0.g.t.i.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0460a extends FilterInputStream {
            private int a;

            public C0460a(InputStream inputStream, int i2) {
                super(inputStream);
                this.a = i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j2) throws IOException {
                long skip = super.skip(Math.min(j2, this.a));
                if (skip >= 0) {
                    this.a = (int) (this.a - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = this.a;
                if (i4 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i2, Math.min(i3, i4));
                if (read >= 0) {
                    this.a -= read;
                }
                return read;
            }
        }
    }
}
