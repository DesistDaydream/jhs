package e.t.l;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.qiniu.android.collect.ReportItem;
import h.k2.v.f0;
import h.t1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\b\u001a\f\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\u0002\u001a \u0010\u0010\u001a\u00020\u000f*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\b\u001a\"\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\b\u001a2\u0010\u0014\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u0016\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u001a"}, d2 = {"copy", "", "Landroid/net/Uri;", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "destPath", "", "exist", "getFileName", "getFilePath", "dir", "isUri", "keepPermission", "", "obtainPermission", "mode", "openDescriptor", "Landroid/content/res/AssetFileDescriptor;", "safeDescriptor", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "toInputStream", "Ljava/io/InputStream;", "writeFile", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    public static final boolean a(@k.e.a.d Uri uri, @k.e.a.d File file, @k.e.a.d Context context) {
        return b(uri, file.getAbsolutePath(), context);
    }

    public static final boolean b(@k.e.a.d Uri uri, @k.e.a.d String str, @k.e.a.d Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            h.h2.a.l(openInputStream, fileOutputStream, 0, 2, null);
            i.a(openInputStream);
            i.a(fileOutputStream);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean c(Uri uri, File file, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return a(uri, file, context);
    }

    public static /* synthetic */ boolean d(Uri uri, String str, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return b(uri, str, context);
    }

    public static final boolean e(@k.e.a.e Uri uri, @k.e.a.d Context context) {
        if (uri == null) {
            return false;
        }
        try {
            AssetFileDescriptor o = o(uri, null, null, 3, null);
            if (o != null) {
                o.close();
            }
            return o != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean f(Uri uri, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return e(uri, context);
    }

    @k.e.a.e
    public static final String g(@k.e.a.d Uri uri, @k.e.a.d Context context) {
        int E3;
        String str = null;
        if (f0.g("content", uri.getScheme())) {
            try {
                Cursor query = context.getApplicationContext().getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (query != null) {
                    try {
                        String string = query.moveToFirst() ? query.getString(query.getColumnIndex("_display_name")) : null;
                        try {
                            t1 t1Var = t1.a;
                            try {
                                h.h2.b.a(query, null);
                            } catch (Exception unused) {
                            }
                            str = string;
                        } catch (Throwable th) {
                            str = string;
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        if (str == null) {
            String path = uri.getPath();
            return (path == null || (E3 = StringsKt__StringsKt.E3(path, Attributes.InternalPrefix, 0, false, 6, null)) == -1) ? path : path.substring(E3 + 1);
        }
        return str;
    }

    @k.e.a.e
    public static final String h(@k.e.a.d Uri uri, @k.e.a.e String str, @k.e.a.d Context context) {
        File file = str == null ? null : new File(str);
        if (file == null) {
            file = context.getCacheDir();
        }
        String g2 = g(uri, context);
        if (g2 == null || g2.length() == 0) {
            return null;
        }
        String str2 = file.toString() + ((Object) File.separator) + ((Object) g2);
        b(uri, str2, context);
        return str2;
    }

    public static /* synthetic */ String i(Uri uri, String str, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return h(uri, str, context);
    }

    public static final boolean j(@k.e.a.d String str) {
        return h.t2.u.u2(str, "content://", false, 2, null) || h.t2.u.u2(str, "file://", false, 2, null);
    }

    public static final void k(@k.e.a.e Uri uri) {
        if (uri != null) {
            e.t.a.b().getContentResolver().takePersistableUriPermission(uri, 1);
        }
    }

    public static final void l(@k.e.a.e Uri uri, @k.e.a.d Context context, @k.e.a.d String str) {
        i.a(uri == null ? null : n(uri, context, str));
    }

    public static /* synthetic */ void m(Uri uri, Context context, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        if ((i2 & 2) != 0) {
            str = "r";
        }
        l(uri, context, str);
    }

    @k.e.a.e
    public static final AssetFileDescriptor n(@k.e.a.e Uri uri, @k.e.a.d Context context, @k.e.a.d String str) {
        if (uri != null) {
            return context.getContentResolver().openAssetFileDescriptor(uri, str);
        }
        return null;
    }

    public static /* synthetic */ AssetFileDescriptor o(Uri uri, Context context, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        if ((i2 & 2) != 0) {
            str = "r";
        }
        return n(uri, context, str);
    }

    public static final void p(@k.e.a.d Uri uri, @k.e.a.d Context context, @k.e.a.d String str, @k.e.a.d h.k2.u.l<? super AssetFileDescriptor, t1> lVar) {
        AssetFileDescriptor n = n(uri, context, str);
        if (n == null) {
            return;
        }
        lVar.invoke(n);
        i.a(n);
    }

    public static /* synthetic */ void q(Uri uri, Context context, String str, h.k2.u.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        if ((i2 & 2) != 0) {
            str = "r";
        }
        p(uri, context, str, lVar);
    }

    @k.e.a.e
    public static final InputStream r(@k.e.a.d Uri uri, @k.e.a.d Context context) throws Exception {
        if (uri.getScheme() != null && !f0.g("file", uri.getScheme())) {
            if (f0.g("content", uri.getScheme())) {
                return context.getContentResolver().openInputStream(uri);
            }
            return null;
        }
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        return new FileInputStream(path);
    }

    public static /* synthetic */ InputStream s(Uri uri, Context context, int i2, Object obj) throws Exception {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return r(uri, context);
    }

    public static final boolean t(@k.e.a.d Uri uri, @k.e.a.d Context context, @k.e.a.d File file) {
        boolean z;
        FileInputStream fileInputStream = new FileInputStream(file);
        Boolean bool = null;
        try {
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(uri);
            if (openOutputStream == null) {
                h.h2.b.a(openOutputStream, null);
                z = false;
            } else {
                h.h2.a.l(fileInputStream, openOutputStream, 0, 2, null);
                openOutputStream.flush();
                t1 t1Var = t1.a;
                h.h2.b.a(openOutputStream, null);
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            h.h2.b.a(fileInputStream, null);
            bool = valueOf;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
