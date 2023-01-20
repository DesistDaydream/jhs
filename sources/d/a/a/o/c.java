package d.a.a.o;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class c implements cn.thinkingdata.android.utils.h {
    private String b(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes().length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return new String(a.a(byteArray));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v5 */
    @Override // cn.thinkingdata.android.utils.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r6, java.lang.String r7, boolean r8, javax.net.ssl.SSLSocketFactory r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.o.c.a(java.lang.String, java.lang.String, boolean, javax.net.ssl.SSLSocketFactory, java.util.Map):java.lang.String");
    }
}
