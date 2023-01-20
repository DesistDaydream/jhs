package com.meizu.cloud.pushsdk.c.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class g {
    private static final Logger a = Logger.getLogger(g.class.getName());

    private g() {
    }

    public static c a(l lVar) {
        if (lVar != null) {
            return new h(lVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static d a(m mVar) {
        if (mVar != null) {
            return new i(mVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static l a(OutputStream outputStream) {
        return a(outputStream, new n());
    }

    private static l a(final OutputStream outputStream, final n nVar) {
        if (outputStream != null) {
            if (nVar != null) {
                return new l() { // from class: com.meizu.cloud.pushsdk.c.g.g.1
                    @Override // com.meizu.cloud.pushsdk.c.g.l
                    public void a(b bVar, long j2) {
                        o.a(bVar.b, 0L, j2);
                        while (j2 > 0) {
                            n.this.a();
                            j jVar = bVar.a;
                            int min = (int) Math.min(j2, jVar.f4795c - jVar.b);
                            outputStream.write(jVar.a, jVar.b, min);
                            int i2 = jVar.b + min;
                            jVar.b = i2;
                            long j3 = min;
                            j2 -= j3;
                            bVar.b -= j3;
                            if (i2 == jVar.f4795c) {
                                bVar.a = jVar.a();
                                k.a(jVar);
                            }
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
                    public void close() {
                        outputStream.close();
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
                    public void flush() {
                        outputStream.flush();
                    }

                    public String toString() {
                        return "sink(" + outputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static m a(File file) {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static m a(InputStream inputStream) {
        return a(inputStream, new n());
    }

    private static m a(final InputStream inputStream, final n nVar) {
        if (inputStream != null) {
            if (nVar != null) {
                return new m() { // from class: com.meizu.cloud.pushsdk.c.g.g.2
                    @Override // com.meizu.cloud.pushsdk.c.g.m
                    public long b(b bVar, long j2) {
                        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                        if (i2 < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j2);
                        } else if (i2 == 0) {
                            return 0L;
                        } else {
                            n.this.a();
                            j c2 = bVar.c(1);
                            int read = inputStream.read(c2.a, c2.f4795c, (int) Math.min(j2, 2048 - c2.f4795c));
                            if (read == -1) {
                                return -1L;
                            }
                            c2.f4795c += read;
                            long j3 = read;
                            bVar.b += j3;
                            return j3;
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.m, java.lang.AutoCloseable
                    public void close() {
                        inputStream.close();
                    }

                    public String toString() {
                        return "source(" + inputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }
}
