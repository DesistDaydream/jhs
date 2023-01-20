package e.t.u;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.k2.v.f0;
import h.k2.v.n0;
import h.t1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\bH\u0007J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0004J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u000fJ \u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'H\u0002J'\u0010(\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0006\u0010+\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010,R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/vector/util/FileUtil;", "", "()V", RemoteMessageConst.Notification.TAG, "", "getTag", "()Ljava/lang/String;", "copy", "", "uri", "Landroid/net/Uri;", "pathTo", "pathFrom", "delete", "file", "Ljava/io/File;", "path", "ensureFileExist", "getFileByPath", "filePath", "getSize", "", "getSuffix", "ignoreDot", "needToLowerCase", "read", "save", "bytes", "", "text", "fileName", "write", "", k.b.a.a.n.n.c.b, "f", "zipFiles", "folderString", "fileString", "zipOutputSteam", "Ljava/util/zip/ZipOutputStream;", "zipFolder", "srcFileSString", "", "zipFileString", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    @k.e.a.d
    public static final i a = new i();

    private i() {
    }

    public static /* synthetic */ String i(i iVar, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        return iVar.h(str, z, z2);
    }

    public final void q(String str, String str2, ZipOutputStream zipOutputStream) {
        File file = new File(f0.C(str, str2));
        d(file);
        int i2 = 0;
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(str2);
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            for (int read = fileInputStream.read(bArr); read != -1; read = fileInputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            return;
        }
        String[] list = file.list();
        if (list.length == 0) {
            zipOutputStream.putNextEntry(new ZipEntry(f0.C(str2, File.separator)));
            zipOutputStream.closeEntry();
        }
        int length = list.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            q(str + str2 + Attributes.InternalPrefix, list[i2], zipOutputStream);
            if (i3 > length) {
                return;
            }
            i2 = i3;
        }
    }

    public final boolean b(@k.e.a.d Uri uri, @k.e.a.d String str) {
        try {
            InputStream openInputStream = e.t.a.b().getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(e.t.l.w.m(str).getAbsoluteFile());
            if (openInputStream != null) {
                h.h2.a.l(openInputStream, fileOutputStream, 0, 2, null);
            }
            if (openInputStream != null) {
                openInputStream.close();
            }
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean c(@k.e.a.d String str, @k.e.a.d String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(e.t.l.w.m(str).getAbsoluteFile());
            FileOutputStream fileOutputStream = new FileOutputStream(e.t.l.w.m(str2).getAbsoluteFile());
            h.h2.a.l(fileInputStream, fileOutputStream, 0, 2, null);
            fileInputStream.close();
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean d(@k.e.a.d File file) {
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public final boolean delete(@k.e.a.d String str) {
        return delete(new File(str));
    }

    public final boolean e(@k.e.a.d String str) {
        return d(new File(str));
    }

    @k.e.a.e
    public final File f(@k.e.a.d String str) {
        if (str.length() == 0) {
            return null;
        }
        return new File(str);
    }

    public final long g(@k.e.a.d File file) {
        return e.t.l.l.h(file);
    }

    @SuppressLint({"DefaultLocale"})
    @k.e.a.d
    public final String h(@k.e.a.d String str, boolean z, boolean z2) {
        int F3;
        if (!(str.length() > 0) || (F3 = StringsKt__StringsKt.F3(str, ".", 0, false, 6, null)) < 0) {
            return "";
        }
        if (!z) {
            String substring = str.substring(F3);
            Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
            return substring.toLowerCase();
        } else if (z2) {
            String substring2 = str.substring(F3 + 1);
            Objects.requireNonNull(substring2, "null cannot be cast to non-null type java.lang.String");
            return substring2.toLowerCase();
        } else {
            return str.substring(F3 + 1);
        }
    }

    @k.e.a.e
    public final String j() {
        return n0.d(i.class).E();
    }

    @k.e.a.d
    public final String k(@k.e.a.d File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        String b = e.a.b(fileInputStream);
        fileInputStream.close();
        return b;
    }

    @k.e.a.d
    public final String l(@k.e.a.d String str) throws Exception {
        return k(new File(str));
    }

    public final boolean m(@k.e.a.d File file, @k.e.a.d String str) {
        return n(file, str.getBytes(h.t2.d.a));
    }

    public final boolean n(@k.e.a.d File file, @k.e.a.d byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            a.e(file.getAbsolutePath());
            fileOutputStream.write(bArr);
            h.h2.b.a(fileOutputStream, null);
            return true;
        } finally {
        }
    }

    public final boolean o(@k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d byte[] bArr) {
        return n(new File(str, str2), bArr);
    }

    public final void p(@k.e.a.d Object obj, @k.e.a.d File file) {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        try {
            objectOutputStream.writeObject(obj);
            t1 t1Var = t1.a;
            h.h2.b.a(objectOutputStream, null);
        } finally {
        }
    }

    @k.e.a.e
    public final Object r(@k.e.a.d List<String> list, @k.e.a.d String str, @k.e.a.d h.e2.c<? super Boolean> cVar) {
        i.b.o oVar = new i.b.o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            for (String str2 : list) {
                File file = new File(str2);
                i iVar = a;
                iVar.d(file);
                iVar.q(f0.C(file.getParent(), File.separator), file.getName(), zipOutputStream);
            }
            zipOutputStream.finish();
            zipOutputStream.close();
            Boolean a2 = h.e2.k.a.a.a(true);
            Result.a aVar = Result.Companion;
            oVar.resumeWith(Result.m106constructorimpl(a2));
        } catch (Exception unused) {
            Boolean a3 = h.e2.k.a.a.a(false);
            Result.a aVar2 = Result.Companion;
            oVar.resumeWith(Result.m106constructorimpl(a3));
        }
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    public final boolean delete(@k.e.a.e File file) {
        return e.t.l.l.a(file);
    }
}
