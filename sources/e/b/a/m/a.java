package e.b.a.m;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.baidu.mobads.sdk.internal.aj;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements Closeable {
    public static final String o = "journal";
    public static final String p = "journal.tmp";
    public static final String q = "journal.bkp";
    public static final String r = "libcore.io.DiskLruCache";
    public static final String s = "1";
    public static final long t = -1;
    private static final String u = "CLEAN";
    private static final String v = "DIRTY";
    private static final String w = "REMOVE";
    private static final String x = "READ";
    private final File a;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final File f9367c;

    /* renamed from: d  reason: collision with root package name */
    private final File f9368d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9369e;

    /* renamed from: f  reason: collision with root package name */
    private long f9370f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9371g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f9373i;

    /* renamed from: k  reason: collision with root package name */
    private int f9375k;

    /* renamed from: h  reason: collision with root package name */
    private long f9372h = 0;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashMap<String, d> f9374j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    private long f9376l = 0;

    /* renamed from: m  reason: collision with root package name */
    public final ThreadPoolExecutor f9377m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> n = new CallableC0303a();

    /* renamed from: e.b.a.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0303a implements Callable<Void> {
        public CallableC0303a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f9373i == null) {
                    return null;
                }
                a.this.E0();
                if (a.this.f0()) {
                    a.this.z0();
                    a.this.f9375k = 0;
                }
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(CallableC0303a callableC0303a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class c {
        private final d a;
        private final boolean[] b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9378c;

        public /* synthetic */ c(a aVar, d dVar, CallableC0303a callableC0303a) {
            this(dVar);
        }

        private InputStream h(int i2) throws IOException {
            synchronized (a.this) {
                if (this.a.f9383f == this) {
                    if (this.a.f9382e) {
                        try {
                            return new FileInputStream(this.a.j(i2));
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }
                    return null;
                }
                throw new IllegalStateException();
            }
        }

        public void a() throws IOException {
            a.this.s(this, false);
        }

        public void b() {
            if (this.f9378c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            a.this.s(this, true);
            this.f9378c = true;
        }

        public File f(int i2) throws IOException {
            File k2;
            synchronized (a.this) {
                if (this.a.f9383f == this) {
                    if (!this.a.f9382e) {
                        this.b[i2] = true;
                    }
                    k2 = this.a.k(i2);
                    a.this.a.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return k2;
        }

        public String g(int i2) throws IOException {
            InputStream h2 = h(i2);
            if (h2 != null) {
                return a.c0(h2);
            }
            return null;
        }

        public void i(int i2, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(f(i2)), e.b.a.m.c.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                e.b.a.m.c.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                e.b.a.m.c.a(outputStreamWriter2);
                throw th;
            }
        }

        private c(d dVar) {
            this.a = dVar;
            this.b = dVar.f9382e ? null : new boolean[a.this.f9371g];
        }
    }

    /* loaded from: classes.dex */
    public final class d {
        private final String a;
        private final long[] b;

        /* renamed from: c  reason: collision with root package name */
        public File[] f9380c;

        /* renamed from: d  reason: collision with root package name */
        public File[] f9381d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9382e;

        /* renamed from: f  reason: collision with root package name */
        private c f9383f;

        /* renamed from: g  reason: collision with root package name */
        private long f9384g;

        public /* synthetic */ d(a aVar, String str, CallableC0303a callableC0303a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f9371g) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.b[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i2) {
            return this.f9380c[i2];
        }

        public File k(int i2) {
            return this.f9381d[i2];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        private d(String str) {
            this.a = str;
            this.b = new long[a.this.f9371g];
            this.f9380c = new File[a.this.f9371g];
            this.f9381d = new File[a.this.f9371g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f9371g; i2++) {
                sb.append(i2);
                this.f9380c[i2] = new File(a.this.a, sb.toString());
                sb.append(aj.f1423k);
                this.f9381d[i2] = new File(a.this.a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class e {
        private final String a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f9386c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f9387d;

        public /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0303a callableC0303a) {
            this(str, j2, fileArr, jArr);
        }

        public c a() throws IOException {
            return a.this.H(this.a, this.b);
        }

        public File b(int i2) {
            return this.f9387d[i2];
        }

        public long c(int i2) {
            return this.f9386c[i2];
        }

        public String d(int i2) throws IOException {
            return a.c0(new FileInputStream(this.f9387d[i2]));
        }

        private e(String str, long j2, File[] fileArr, long[] jArr) {
            this.a = str;
            this.b = j2;
            this.f9387d = fileArr;
            this.f9386c = jArr;
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.a = file;
        this.f9369e = i2;
        this.b = new File(file, o);
        this.f9367c = new File(file, p);
        this.f9368d = new File(file, q);
        this.f9371g = i3;
        this.f9370f = j2;
    }

    private static void B0(File file, File file2, boolean z) throws IOException {
        if (z) {
            t(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() throws IOException {
        while (this.f9372h > this.f9370f) {
            A0(this.f9374j.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c H(String str, long j2) throws IOException {
        q();
        d dVar = this.f9374j.get(str);
        if (j2 == -1 || (dVar != null && dVar.f9384g == j2)) {
            if (dVar != null) {
                if (dVar.f9383f != null) {
                    return null;
                }
            } else {
                dVar = new d(this, str, null);
                this.f9374j.put(str, dVar);
            }
            c cVar = new c(this, dVar, null);
            dVar.f9383f = cVar;
            this.f9373i.append((CharSequence) v);
            this.f9373i.append(' ');
            this.f9373i.append((CharSequence) str);
            this.f9373i.append('\n');
            J(this.f9373i);
            return cVar;
        }
        return null;
    }

    @TargetApi(26)
    private static void J(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c0(InputStream inputStream) throws IOException {
        return e.b.a.m.c.c(new InputStreamReader(inputStream, e.b.a.m.c.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0() {
        int i2 = this.f9375k;
        return i2 >= 2000 && i2 >= this.f9374j.size();
    }

    public static a m0(File file, int i2, int i3, long j2) throws IOException {
        if (j2 > 0) {
            if (i3 > 0) {
                File file2 = new File(file, q);
                if (file2.exists()) {
                    File file3 = new File(file, o);
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        B0(file2, file3, false);
                    }
                }
                a aVar = new a(file, i2, i3, j2);
                if (aVar.b.exists()) {
                    try {
                        aVar.u0();
                        aVar.o0();
                        return aVar;
                    } catch (IOException e2) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i2, i3, j2);
                aVar2.z0();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void o0() throws IOException {
        t(this.f9367c);
        Iterator<d> it = this.f9374j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f9383f != null) {
                next.f9383f = null;
                while (i2 < this.f9371g) {
                    t(next.j(i2));
                    t(next.k(i2));
                    i2++;
                }
                it.remove();
            } else {
                while (i2 < this.f9371g) {
                    this.f9372h += next.b[i2];
                    i2++;
                }
            }
        }
    }

    private void q() {
        if (this.f9373i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void r(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f9383f == cVar) {
            if (z && !dVar.f9382e) {
                for (int i2 = 0; i2 < this.f9371g; i2++) {
                    if (cVar.b[i2]) {
                        if (!dVar.k(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f9371g; i3++) {
                File k2 = dVar.k(i3);
                if (z) {
                    if (k2.exists()) {
                        File j2 = dVar.j(i3);
                        k2.renameTo(j2);
                        long j3 = dVar.b[i3];
                        long length = j2.length();
                        dVar.b[i3] = length;
                        this.f9372h = (this.f9372h - j3) + length;
                    }
                } else {
                    t(k2);
                }
            }
            this.f9375k++;
            dVar.f9383f = null;
            if (dVar.f9382e | z) {
                dVar.f9382e = true;
                this.f9373i.append((CharSequence) u);
                this.f9373i.append(' ');
                this.f9373i.append((CharSequence) dVar.a);
                this.f9373i.append((CharSequence) dVar.l());
                this.f9373i.append('\n');
                if (z) {
                    long j4 = this.f9376l;
                    this.f9376l = 1 + j4;
                    dVar.f9384g = j4;
                }
            } else {
                this.f9374j.remove(dVar.a);
                this.f9373i.append((CharSequence) w);
                this.f9373i.append(' ');
                this.f9373i.append((CharSequence) dVar.a);
                this.f9373i.append('\n');
            }
            J(this.f9373i);
            if (this.f9372h > this.f9370f || f0()) {
                this.f9377m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void t(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private void u0() throws IOException {
        e.b.a.m.b bVar = new e.b.a.m.b(new FileInputStream(this.b), e.b.a.m.c.a);
        try {
            String l2 = bVar.l();
            String l3 = bVar.l();
            String l4 = bVar.l();
            String l5 = bVar.l();
            String l6 = bVar.l();
            if (!r.equals(l2) || !"1".equals(l3) || !Integer.toString(this.f9369e).equals(l4) || !Integer.toString(this.f9371g).equals(l5) || !"".equals(l6)) {
                throw new IOException("unexpected journal header: [" + l2 + ", " + l3 + ", " + l5 + ", " + l6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    x0(bVar.l());
                    i2++;
                } catch (EOFException unused) {
                    this.f9375k = i2 - this.f9374j.size();
                    if (bVar.k()) {
                        z0();
                    } else {
                        this.f9373i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), e.b.a.m.c.a));
                    }
                    e.b.a.m.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            e.b.a.m.c.a(bVar);
            throw th;
        }
    }

    private void x0(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith(w)) {
                    this.f9374j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            d dVar = this.f9374j.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.f9374j.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(u)) {
                String[] split = str.substring(indexOf2 + 1).split(ExpandableTextView.N);
                dVar.f9382e = true;
                dVar.f9383f = null;
                dVar.n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(v)) {
                dVar.f9383f = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith(x)) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z0() throws IOException {
        Writer writer = this.f9373i;
        if (writer != null) {
            r(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9367c), e.b.a.m.c.a));
        bufferedWriter.write(r);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f9369e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f9371g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.f9374j.values()) {
            if (dVar.f9383f != null) {
                bufferedWriter.write("DIRTY " + dVar.a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
            }
        }
        r(bufferedWriter);
        if (this.b.exists()) {
            B0(this.b, this.f9368d, true);
        }
        B0(this.f9367c, this.b, false);
        this.f9368d.delete();
        this.f9373i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), e.b.a.m.c.a));
    }

    public synchronized boolean A0(String str) throws IOException {
        q();
        d dVar = this.f9374j.get(str);
        if (dVar != null && dVar.f9383f == null) {
            for (int i2 = 0; i2 < this.f9371g; i2++) {
                File j2 = dVar.j(i2);
                if (j2.exists() && !j2.delete()) {
                    throw new IOException("failed to delete " + j2);
                }
                this.f9372h -= dVar.b[i2];
                dVar.b[i2] = 0;
            }
            this.f9375k++;
            this.f9373i.append((CharSequence) w);
            this.f9373i.append(' ');
            this.f9373i.append((CharSequence) str);
            this.f9373i.append('\n');
            this.f9374j.remove(str);
            if (f0()) {
                this.f9377m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public synchronized void C0(long j2) {
        this.f9370f = j2;
        this.f9377m.submit(this.n);
    }

    public synchronized long D0() {
        return this.f9372h;
    }

    public c F(String str) throws IOException {
        return H(str, -1L);
    }

    public synchronized e M(String str) throws IOException {
        q();
        d dVar = this.f9374j.get(str);
        if (dVar == null) {
            return null;
        }
        if (dVar.f9382e) {
            for (File file : dVar.f9380c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f9375k++;
            this.f9373i.append((CharSequence) x);
            this.f9373i.append(' ');
            this.f9373i.append((CharSequence) str);
            this.f9373i.append('\n');
            if (f0()) {
                this.f9377m.submit(this.n);
            }
            return new e(this, str, dVar.f9384g, dVar.f9380c, dVar.b, null);
        }
        return null;
    }

    public File X() {
        return this.a;
    }

    public synchronized long Y() {
        return this.f9370f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f9373i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f9374j.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f9383f != null) {
                dVar.f9383f.a();
            }
        }
        E0();
        r(this.f9373i);
        this.f9373i = null;
    }

    public void delete() throws IOException {
        close();
        e.b.a.m.c.b(this.a);
    }

    public synchronized void flush() throws IOException {
        q();
        E0();
        J(this.f9373i);
    }

    public synchronized boolean isClosed() {
        return this.f9373i == null;
    }
}
