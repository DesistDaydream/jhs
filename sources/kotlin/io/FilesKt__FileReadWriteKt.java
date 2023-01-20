package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.o;
import h.a2.n;
import h.g2.f;
import h.h2.a;
import h.h2.b;
import h.h2.k;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.c0;
import h.o2.q;
import h.q2.m;
import h.t1;
import h.t2.d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001aB\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010/\u001a\u000200*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u0082\u0002\u000f\n\u0006\b\u0011(+0\u0001\n\u0005\b\u009920\u0001¨\u00061"}, d2 = {"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class FilesKt__FileReadWriteKt extends k {
    @f
    private static final InputStreamReader A(File file, Charset charset) {
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static /* synthetic */ InputStreamReader B(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T C(@k.e.a.d File file, @k.e.a.d Charset charset, @k.e.a.d l<? super m<String>, ? extends T> lVar) {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T invoke = lVar.invoke(TextStreamsKt.h(bufferedReader));
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                b.a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    b.a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ Object D(File file, Charset charset, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object invoke = lVar.invoke(TextStreamsKt.h(bufferedReader));
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                b.a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            c0.c(1);
            return invoke;
        } finally {
        }
    }

    public static final void E(@k.e.a.d File file, @k.e.a.d byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            t1 t1Var = t1.a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void F(@k.e.a.d File file, @k.e.a.d String str, @k.e.a.d Charset charset) {
        E(file, str.getBytes(charset));
    }

    public static /* synthetic */ void G(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = d.a;
        }
        F(file, str, charset);
    }

    @f
    private static final OutputStreamWriter H(File file, Charset charset) {
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static /* synthetic */ OutputStreamWriter I(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void g(@k.e.a.d File file, @k.e.a.d byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bArr);
            t1 t1Var = t1.a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void h(@k.e.a.d File file, @k.e.a.d String str, @k.e.a.d Charset charset) {
        g(file, str.getBytes(charset));
    }

    public static /* synthetic */ void i(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = d.a;
        }
        h(file, str, charset);
    }

    @f
    private static final BufferedReader j(File file, Charset charset, int i2) {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i2);
    }

    public static /* synthetic */ BufferedReader k(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = d.a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i2);
    }

    @f
    private static final BufferedWriter l(File file, Charset charset, int i2) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i2);
    }

    public static /* synthetic */ BufferedWriter m(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = d.a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void n(@k.e.a.d File file, int i2, @k.e.a.d p<? super byte[], ? super Integer, t1> pVar) {
        ?? r2 = new byte[q.n(i2, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(r2);
                if (read <= 0) {
                    t1 t1Var = t1.a;
                    b.a(fileInputStream, null);
                    return;
                }
                pVar.invoke(r2, Integer.valueOf(read));
            } finally {
            }
        }
    }

    public static final void o(@k.e.a.d File file, @k.e.a.d p<? super byte[], ? super Integer, t1> pVar) {
        n(file, 4096, pVar);
    }

    public static final void p(@k.e.a.d File file, @k.e.a.d Charset charset, @k.e.a.d l<? super String, t1> lVar) {
        TextStreamsKt.g(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), lVar);
    }

    public static /* synthetic */ void q(File file, Charset charset, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        p(file, charset, lVar);
    }

    @f
    private static final FileInputStream r(File file) {
        return new FileInputStream(file);
    }

    @f
    private static final FileOutputStream s(File file) {
        return new FileOutputStream(file);
    }

    @f
    private static final PrintWriter t(File file, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    public static /* synthetic */ PrintWriter u(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    @k.e.a.d
    public static final byte[] v(@k.e.a.d File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= Integer.MAX_VALUE) {
                int i2 = (int) length;
                byte[] bArr = new byte[i2];
                int i3 = i2;
                int i4 = 0;
                while (i3 > 0) {
                    int read = fileInputStream.read(bArr, i4, i3);
                    if (read < 0) {
                        break;
                    }
                    i3 -= read;
                    i4 += read;
                }
                if (i3 > 0) {
                    bArr = Arrays.copyOf(bArr, i4);
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        h.h2.f fVar = new h.h2.f(o.a.q);
                        fVar.write(read2);
                        a.l(fileInputStream, fVar, 0, 2, null);
                        int size = fVar.size() + i2;
                        if (size >= 0) {
                            bArr = n.W0(fVar.j(), Arrays.copyOf(bArr, size), i2, 0, fVar.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                b.a(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    @k.e.a.d
    public static final List<String> w(@k.e.a.d File file, @k.e.a.d Charset charset) {
        ArrayList arrayList = new ArrayList();
        p(file, charset, new FilesKt__FileReadWriteKt$readLines$1(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        return w(file, charset);
    }

    @k.e.a.d
    public static final String y(@k.e.a.d File file, @k.e.a.d Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String k2 = TextStreamsKt.k(inputStreamReader);
            b.a(inputStreamReader, null);
            return k2;
        } finally {
        }
    }

    public static /* synthetic */ String z(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        return y(file, charset);
    }
}
