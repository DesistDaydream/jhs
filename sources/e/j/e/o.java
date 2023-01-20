package e.j.e;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class o implements Iterator<h> {
    private final e.j.e.u.a a;
    private final Object b;

    public o(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public h next() throws JsonParseException {
        if (hasNext()) {
            try {
                return e.j.e.s.i.a(this.a);
            } catch (JsonParseException e2) {
                if (e2.getCause() instanceof EOFException) {
                    throw new NoSuchElementException();
                }
                throw e2;
            } catch (OutOfMemoryError e3) {
                throw new JsonParseException("Failed parsing JSON source to Json", e3);
            } catch (StackOverflowError e4) {
                throw new JsonParseException("Failed parsing JSON source to Json", e4);
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.b) {
            try {
                try {
                    try {
                        z = this.a.C0() != JsonToken.END_DOCUMENT;
                    } catch (MalformedJsonException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } catch (IOException e3) {
                    throw new JsonIOException(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public o(Reader reader) {
        e.j.e.u.a aVar = new e.j.e.u.a(reader);
        this.a = aVar;
        aVar.H0(true);
        this.b = new Object();
    }
}
