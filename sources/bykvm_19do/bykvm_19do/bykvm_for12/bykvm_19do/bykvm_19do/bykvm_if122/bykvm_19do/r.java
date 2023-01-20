package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface r extends Closeable, Flushable {
    t b();

    void b(c cVar, long j2) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
