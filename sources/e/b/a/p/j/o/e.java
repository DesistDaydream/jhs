package e.b.a.p.j.o;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9477f = "ThumbStreamOpener";

    /* renamed from: g  reason: collision with root package name */
    private static final a f9478g = new a();
    private final a a;
    private final d b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.k.x.b f9479c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f9480d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f9481e;

    public e(List<ImageHeaderParser> list, d dVar, e.b.a.p.k.x.b bVar, ContentResolver contentResolver) {
        this(list, f9478g, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(@androidx.annotation.NonNull android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            e.b.a.p.j.o.d r2 = r6.b     // Catch: java.lang.Throwable -> L24 java.lang.SecurityException -> L26
            android.database.Cursor r2 = r2.query(r7)     // Catch: java.lang.Throwable -> L24 java.lang.SecurityException -> L26
            if (r2 == 0) goto L1e
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.SecurityException -> L1c java.lang.Throwable -> L49
            if (r3 == 0) goto L1e
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: java.lang.SecurityException -> L1c java.lang.Throwable -> L49
            if (r2 == 0) goto L1b
            r2.close()
        L1b:
            return r7
        L1c:
            r3 = move-exception
            goto L28
        L1e:
            if (r2 == 0) goto L23
            r2.close()
        L23:
            return r1
        L24:
            r7 = move-exception
            goto L4b
        L26:
            r3 = move-exception
            r2 = r1
        L28:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L43
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r4.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L49
            r4.append(r7)     // Catch: java.lang.Throwable -> L49
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L49
            android.util.Log.d(r0, r7, r3)     // Catch: java.lang.Throwable -> L49
        L43:
            if (r2 == 0) goto L48
            r2.close()
        L48:
            return r1
        L49:
            r7 = move-exception
            r1 = r2
        L4b:
            if (r1 == 0) goto L50
            r1.close()
        L50:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.p.j.o.e.b(android.net.Uri):java.lang.String");
    }

    private boolean c(File file) {
        return this.a.a(file) && 0 < this.a.c(file);
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f9480d.openInputStream(uri);
                int b = e.b.a.p.b.b(this.f9481e, inputStream, this.f9479c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b;
            } catch (IOException | NullPointerException e2) {
                if (Log.isLoggable(f9477f, 3)) {
                    Log.d(f9477f, "Failed to open uri: " + uri, e2);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused2) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b = b(uri);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        File b2 = this.a.b(b);
        if (c(b2)) {
            Uri fromFile = Uri.fromFile(b2);
            try {
                return this.f9480d.openInputStream(fromFile);
            } catch (NullPointerException e2) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
            }
        }
        return null;
    }

    public e(List<ImageHeaderParser> list, a aVar, d dVar, e.b.a.p.k.x.b bVar, ContentResolver contentResolver) {
        this.a = aVar;
        this.b = dVar;
        this.f9479c = bVar;
        this.f9480d = contentResolver;
        this.f9481e = list;
    }
}
