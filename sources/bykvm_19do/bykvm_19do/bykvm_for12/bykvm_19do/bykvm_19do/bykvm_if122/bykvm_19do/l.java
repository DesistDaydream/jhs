package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class l {
    public static final Logger a = Logger.getLogger(l.class.getName());

    /* loaded from: classes.dex */
    public static final class a implements r {
        public final /* synthetic */ t a;
        public final /* synthetic */ OutputStream b;

        public a(t tVar, OutputStream outputStream) {
            this.a = tVar;
            this.b = outputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                u.a(cVar.b, 0L, j2);
                while (j2 > 0) {
                    this.a.e();
                    o oVar = cVar.a;
                    int min = (int) Math.min(j2, oVar.f289c - oVar.b);
                    this.b.write(oVar.a, oVar.b, min);
                    int i2 = oVar.b + min;
                    oVar.b = i2;
                    long j3 = min;
                    j2 -= j3;
                    cVar.b -= j3;
                    if (i2 == oVar.f289c) {
                        cVar.a = oVar.b();
                        p.a(oVar);
                    }
                }
            } catch (IOException e2) {
                throw e2;
            } catch (Exception unused) {
                throw new IOException("Okio write error");
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        public String toString() {
            return "sink(" + this.b + ")";
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements s {
        public final /* synthetic */ t a;
        public final /* synthetic */ InputStream b;

        public b(t tVar, InputStream inputStream) {
            this.a = tVar;
            this.b = inputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (i2 == 0) {
                return 0L;
            } else {
                try {
                    this.a.e();
                    o b = cVar.b(1);
                    int read = this.b.read(b.a, b.f289c, (int) Math.min(j2, 8192 - b.f289c));
                    if (read == -1) {
                        return -1L;
                    }
                    b.f289c += read;
                    long j3 = read;
                    cVar.b += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        public String toString() {
            return "source(" + this.b + ")";
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a {

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Socket f286k;

        public c(Socket socket) {
            this.f286k = socket;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        public IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        public void i() {
            Level level;
            StringBuilder sb;
            Logger logger;
            Exception exc;
            try {
                this.f286k.close();
            } catch (AssertionError e2) {
                if (!l.a(e2)) {
                    throw e2;
                }
                Logger logger2 = l.a;
                level = Level.WARNING;
                sb = new StringBuilder();
                exc = e2;
                logger = logger2;
                sb.append("Failed to close timed out socket ");
                sb.append(this.f286k);
                logger.log(level, sb.toString(), (Throwable) exc);
            } catch (Exception e3) {
                Logger logger3 = l.a;
                level = Level.WARNING;
                sb = new StringBuilder();
                exc = e3;
                logger = logger3;
                sb.append("Failed to close timed out socket ");
                sb.append(this.f286k);
                logger.log(level, sb.toString(), (Throwable) exc);
            }
        }
    }

    private l() {
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    private static r a(OutputStream outputStream, t tVar) {
        if (outputStream != null) {
            if (tVar != null) {
                return new a(tVar, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c2 = c(socket);
                return c2.a(a(socket.getOutputStream(), c2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(InputStream inputStream, t tVar) {
        if (inputStream != null) {
            if (tVar != null) {
                return new b(tVar, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static s b(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c2 = c(socket);
                return c2.a(a(socket.getInputStream(), c2));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c(Socket socket) {
        return new c(socket);
    }
}
