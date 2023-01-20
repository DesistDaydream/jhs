package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.moor.imkf.YKFConstants;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.k2.v.c0;
import h.t1;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a3\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\bø\u0001\u0000\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", YKFConstants.INVESTIGATE_TYPE_OUT, "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @d
    public static final byte[] readBytes(@d android.util.AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    @RequiresApi(17)
    @d
    public static final String readText(@d android.util.AtomicFile atomicFile, @d Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@d android.util.AtomicFile atomicFile, @d l<? super FileOutputStream, t1> lVar) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            lVar.invoke(startWrite);
            c0.d(1);
            atomicFile.finishWrite(startWrite);
            c0.c(1);
        } catch (Throwable th) {
            c0.d(1);
            atomicFile.failWrite(startWrite);
            c0.c(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@d android.util.AtomicFile atomicFile, @d byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@d android.util.AtomicFile atomicFile, @d String str, @d Charset charset) {
        writeBytes(atomicFile, str.getBytes(charset));
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = h.t2.d.a;
        }
        writeText(atomicFile, str, charset);
    }
}
