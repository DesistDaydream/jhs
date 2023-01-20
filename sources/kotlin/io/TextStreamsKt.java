package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.moor.imkf.YKFConstants;
import com.qiniu.android.collect.ReportItem;
import h.g2.f;
import h.h2.a;
import h.h2.b;
import h.h2.n;
import h.k2.g;
import h.k2.u.l;
import h.k2.v.c0;
import h.q2.m;
import h.t1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt__SequencesKt;

@g(name = "TextStreamsKt")
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a8\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u0082\u0002\u000f\n\u0006\b\u0011(\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", YKFConstants.INVESTIGATE_TYPE_OUT, "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class TextStreamsKt {
    @f
    private static final BufferedReader a(Reader reader, int i2) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    @f
    private static final BufferedWriter b(Writer writer, int i2) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    public static /* synthetic */ BufferedReader c(Reader reader, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    public static /* synthetic */ BufferedWriter d(Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    public static final long e(@d Reader reader, @d Writer writer, int i2) {
        char[] cArr = new char[i2];
        int read = reader.read(cArr);
        long j2 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j2 += read;
            read = reader.read(cArr);
        }
        return j2;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return e(reader, writer, i2);
    }

    public static final void g(@d Reader reader, @d l<? super String, t1> lVar) {
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            for (String str : h(bufferedReader)) {
                lVar.invoke(str);
            }
            t1 t1Var = t1.a;
            b.a(bufferedReader, null);
        } finally {
        }
    }

    @d
    public static final m<String> h(@d BufferedReader bufferedReader) {
        return SequencesKt__SequencesKt.i(new n(bufferedReader));
    }

    @d
    public static final byte[] i(@d URL url) {
        InputStream openStream = url.openStream();
        try {
            byte[] p = a.p(openStream);
            b.a(openStream, null);
            return p;
        } finally {
        }
    }

    @d
    public static final List<String> j(@d Reader reader) {
        ArrayList arrayList = new ArrayList();
        g(reader, new TextStreamsKt$readLines$1(arrayList));
        return arrayList;
    }

    @d
    public static final String k(@d Reader reader) {
        StringWriter stringWriter = new StringWriter();
        f(reader, stringWriter, 0, 2, null);
        return stringWriter.toString();
    }

    @f
    private static final String l(URL url, Charset charset) {
        return new String(i(url), charset);
    }

    public static /* synthetic */ String m(URL url, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return new String(i(url), charset);
    }

    @f
    private static final StringReader n(String str) {
        return new StringReader(str);
    }

    public static final <T> T o(@d Reader reader, @d l<? super m<String>, ? extends T> lVar) {
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T invoke = lVar.invoke(h(bufferedReader));
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
}
