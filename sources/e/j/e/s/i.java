package e.j.e.s;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class i {
    private i() {
        throw new UnsupportedOperationException();
    }

    public static e.j.e.h a(e.j.e.u.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.C0();
                z = false;
                try {
                    return TypeAdapters.V.e(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return e.j.e.i.a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e3) {
                throw new JsonSyntaxException(e3);
            } catch (IOException e4) {
                throw new JsonIOException(e4);
            } catch (NumberFormatException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    public static void b(e.j.e.h hVar, e.j.e.u.c cVar) throws IOException {
        TypeAdapters.V.i(cVar, hVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes2.dex */
    public static final class a extends Writer {
        private final Appendable a;
        private final C0377a b = new C0377a();

        /* renamed from: e.j.e.s.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0377a implements CharSequence {
            public char[] a;

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.a, i2, i3 - i2);
            }
        }

        public a(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            C0377a c0377a = this.b;
            c0377a.a = cArr;
            this.a.append(c0377a, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.a.append((char) i2);
        }
    }
}
