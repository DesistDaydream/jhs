package com.google.gson;

import com.google.gson.stream.JsonToken;
import e.j.e.h;
import e.j.e.s.k.b;
import e.j.e.u.a;
import e.j.e.u.c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes2.dex */
public abstract class TypeAdapter<T> {
    public final T a(Reader reader) throws IOException {
        return e(new a(reader));
    }

    public final T b(String str) throws IOException {
        return a(new StringReader(str));
    }

    public final T c(h hVar) {
        try {
            return e(new e.j.e.s.k.a(hVar));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final TypeAdapter<T> d() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public T e(a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return (T) TypeAdapter.this.e(aVar);
            }

            @Override // com.google.gson.TypeAdapter
            public void i(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.Y();
                } else {
                    TypeAdapter.this.i(cVar, t);
                }
            }
        };
    }

    public abstract T e(a aVar) throws IOException;

    public final String f(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            g(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void g(Writer writer, T t) throws IOException {
        i(new c(writer), t);
    }

    public final h h(T t) {
        try {
            b bVar = new b();
            i(bVar, t);
            return bVar.J0();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void i(c cVar, T t) throws IOException;
}
