package h.h2.p;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.g2.f;
import h.k2.u.l;
import h.k2.v.c0;
import h.q2.m;
import h.s0;
import h.t1;
import h.x1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\bø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010,\u001a?\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes3.dex */
public class d {
    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path A(Path path, m<? extends CharSequence> mVar, Charset charset, OpenOption... openOptionArr) throws IOException {
        return Files.write(path, SequencesKt___SequencesKt.G(mVar), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public static /* synthetic */ Path B(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        return Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public static /* synthetic */ Path C(Path path, m mVar, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        return Files.write(path, SequencesKt___SequencesKt.G(mVar), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static final void D(@k.e.a.d Path path, @k.e.a.d CharSequence charSequence, @k.e.a.d Charset charset, @k.e.a.d OpenOption... openOptionArr) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
        try {
            outputStreamWriter.append(charSequence);
            h.h2.b.a(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final OutputStreamWriter F(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    public static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final void a(Path path, byte[] bArr) throws IOException {
        Files.write(path, bArr, StandardOpenOption.APPEND);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path b(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        return Files.write(path, iterable, charset, StandardOpenOption.APPEND);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path c(Path path, m<? extends CharSequence> mVar, Charset charset) throws IOException {
        return Files.write(path, SequencesKt___SequencesKt.G(mVar), charset, StandardOpenOption.APPEND);
    }

    public static /* synthetic */ Path d(Path path, Iterable iterable, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        return Files.write(path, iterable, charset, StandardOpenOption.APPEND);
    }

    public static /* synthetic */ Path e(Path path, m mVar, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        return Files.write(path, SequencesKt___SequencesKt.G(mVar), charset, StandardOpenOption.APPEND);
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    public static final void f(@k.e.a.d Path path, @k.e.a.d CharSequence charSequence, @k.e.a.d Charset charset) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(path, StandardOpenOption.APPEND), charset);
        try {
            outputStreamWriter.append(charSequence);
            h.h2.b.a(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        f(path, charSequence, charset);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final BufferedReader h(Path path, Charset charset, int i2, OpenOption... openOptionArr) throws IOException {
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    public static /* synthetic */ BufferedReader i(Path path, Charset charset, int i2, OpenOption[] openOptionArr, int i3, Object obj) throws IOException {
        if ((i3 & 1) != 0) {
            charset = h.t2.d.a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final BufferedWriter j(Path path, Charset charset, int i2, OpenOption... openOptionArr) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    public static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i2, OpenOption[] openOptionArr, int i3, Object obj) throws IOException {
        if ((i3 & 1) != 0) {
            charset = h.t2.d.a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final void l(Path path, Charset charset, l<? super String, t1> lVar) throws IOException {
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        if (!(newBufferedReader instanceof BufferedReader)) {
            newBufferedReader = new BufferedReader(newBufferedReader, 8192);
        }
        try {
            for (String str : TextStreamsKt.h(newBufferedReader)) {
                lVar.invoke(str);
            }
            t1 t1Var = t1.a;
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newBufferedReader, th);
                } else {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void m(Path path, Charset charset, l lVar, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        if (!(newBufferedReader instanceof BufferedReader)) {
            newBufferedReader = new BufferedReader(newBufferedReader, 8192);
        }
        try {
            for (String str : TextStreamsKt.h(newBufferedReader)) {
                lVar.invoke(str);
            }
            t1 t1Var = t1.a;
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            c0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newBufferedReader, th);
                } else {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final InputStream n(Path path, OpenOption... openOptionArr) throws IOException {
        return Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final OutputStream o(Path path, OpenOption... openOptionArr) throws IOException {
        return Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final byte[] p(Path path) throws IOException {
        return Files.readAllBytes(path);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final List<String> q(Path path, Charset charset) throws IOException {
        return Files.readAllLines(path, charset);
    }

    public static /* synthetic */ List r(Path path, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return Files.readAllLines(path, charset);
    }

    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final String s(@k.e.a.d Path path, @k.e.a.d Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String k2 = TextStreamsKt.k(inputStreamReader);
            h.h2.b.a(inputStreamReader, null);
            return k2;
        } finally {
        }
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return s(path, charset);
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final InputStreamReader u(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    public static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final <T> T w(Path path, Charset charset, l<? super m<String>, ? extends T> lVar) throws IOException {
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            T invoke = lVar.invoke(TextStreamsKt.h(newBufferedReader));
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newBufferedReader, null);
            } else if (newBufferedReader != null) {
                newBufferedReader.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newBufferedReader, th);
                } else if (newBufferedReader != null) {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ Object x(Path path, Charset charset, l lVar, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            Object invoke = lVar.invoke(TextStreamsKt.h(newBufferedReader));
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                h.h2.b.a(newBufferedReader, null);
            } else if (newBufferedReader != null) {
                newBufferedReader.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    h.h2.b.a(newBufferedReader, th);
                } else if (newBufferedReader != null) {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    @f
    @x1(markerClass = {a.class})
    @s0(version = "1.5")
    private static final void y(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @s0(version = "1.5")
    @f
    @x1(markerClass = {a.class})
    private static final Path z(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        return Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }
}
