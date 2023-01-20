package e.t.m;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import androidx.core.content.FileProvider;
import e.t.l.i;
import e.t.l.n;
import e.t.l.z;
import e.t.u.g;
import h.k2.v.f0;
import h.t1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u0017"}, d2 = {"Lcom/vector/filecompat/FileCompat;", "", "()V", "exists", "", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "path", "", "getDescriptor", "Landroid/content/res/AssetFileDescriptor;", "getMimeTypeByOptions", "filePath", "readString", "save", "", "uri", "Landroid/net/Uri;", "saveToAlbum", "write", k.b.a.a.n.n.c.b, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();

    private d() {
    }

    private final AssetFileDescriptor c(File file, Context context) {
        Uri fromFile;
        if (Build.VERSION.SDK_INT >= 24) {
            fromFile = FileProvider.getUriForFile(context, e.a(), file);
        } else {
            fromFile = Uri.fromFile(file);
        }
        return context.getContentResolver().openAssetFileDescriptor(fromFile, "r");
    }

    private final String d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outMimeType;
    }

    public final boolean a(@k.e.a.d File file, @k.e.a.d Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor c2 = c(file, context);
                if (c2 == null) {
                    return false;
                }
                i.a(c2);
                return true;
            } catch (FileNotFoundException unused) {
                return false;
            }
        }
        return file.exists();
    }

    public final boolean b(@k.e.a.d String str, @k.e.a.d Context context) {
        return a(new File(str), context);
    }

    @k.e.a.e
    public final String e(@k.e.a.d File file, @k.e.a.d Context context) {
        if (g.a.p()) {
            AssetFileDescriptor c2 = c(file, context);
            if (c2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c2.getFileDescriptor());
            try {
                String a2 = n.a(fileInputStream);
                h.h2.b.a(fileInputStream, null);
                return a2;
            } catch (Throwable th) {
                Log.e("safeUse", String.valueOf(th.getMessage()));
                i.a(c2);
            }
        } else {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String a3 = n.a(fileInputStream2);
                h.h2.b.a(fileInputStream2, null);
                return a3;
            } catch (Throwable th2) {
                Log.e("safeUse", String.valueOf(th2.getMessage()));
            }
        }
        return null;
    }

    public final void f(@k.e.a.d File file, @k.e.a.d Uri uri) {
        z.c(uri, file, null, 2, null);
    }

    public final boolean g(@k.e.a.d File file, @k.e.a.d Context context) {
        ContentValues contentValues = new ContentValues();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        g gVar = g.a;
        if (gVar.p()) {
            contentValues.put("relative_path", f0.C("DCIM", file.getParent()));
        } else {
            contentValues.put("_data", file.getAbsolutePath());
        }
        contentValues.put("mime_type", d(file.getAbsolutePath()));
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return false;
        }
        if (gVar.p()) {
            return z.t(insert, context, file);
        }
        return true;
    }

    public final void h(@k.e.a.d File file, @k.e.a.d Object obj, @k.e.a.d Context context) {
        if (g.a.p()) {
            AssetFileDescriptor c2 = c(file, context);
            if (c2 == null) {
                return;
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(c2.getFileDescriptor()));
            try {
                objectOutputStream.writeObject(obj);
                t1 t1Var = t1.a;
                h.h2.b.a(objectOutputStream, null);
            } catch (Throwable th) {
                Log.e("safeUse", String.valueOf(th.getMessage()));
            }
            i.a(c2);
            return;
        }
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
        try {
            objectOutputStream2.writeObject(obj);
            t1 t1Var2 = t1.a;
            h.h2.b.a(objectOutputStream2, null);
        } catch (Throwable th2) {
            Log.e("safeUse", String.valueOf(th2.getMessage()));
        }
    }
}
