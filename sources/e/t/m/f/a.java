package e.t.m.f;

import android.content.Context;
import android.util.Log;
import e.t.l.l;
import e.t.l.n;
import e.t.m.b;
import h.t1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import k.b.a.a.n.n.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/vector/filecompat/executor/NormalFileExecutor;", "Lcom/vector/filecompat/CompatFile;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile$vector_release", "()Ljava/io/File;", "copy", "", "context", "Landroid/content/Context;", "exists", "", "getAbsolutePath", "", "rootDir", "getInputStream", "Ljava/io/InputStream;", "getName", "parent", "readString", "saveToAlbum", "(Landroid/content/Context;)Ljava/lang/Boolean;", "write", c.b, "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements b {
    @d
    private final File a;

    public a(@d File file) {
        this.a = file;
    }

    @Override // e.t.m.b
    @d
    public Boolean a(@d Context context) {
        return Boolean.valueOf(l.n(this.a, context));
    }

    @Override // e.t.m.b
    @e
    public String b(@d Context context) {
        return this.a.getName();
    }

    @Override // e.t.m.b
    public void c(@d File file, @d Context context) {
        FilesKt__UtilsKt.Q(file, file, false, 0, 6, null);
    }

    @Override // e.t.m.b
    public boolean d() {
        return this.a.exists();
    }

    @Override // e.t.m.b
    public void e(@d Object obj, @d Context context) {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.a));
        try {
            objectOutputStream.writeObject(obj);
            t1 t1Var = t1.a;
            h.h2.b.a(objectOutputStream, null);
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
    }

    @Override // e.t.m.b
    @e
    public b f(@e String str) {
        File parentFile = this.a.getParentFile();
        if (parentFile == null) {
            return null;
        }
        return new a(parentFile);
    }

    @Override // e.t.m.b
    @e
    public String g(@e String str) {
        return this.a.getAbsolutePath();
    }

    @Override // e.t.m.b
    @e
    public InputStream h(@d Context context) {
        return new FileInputStream(this.a);
    }

    @Override // e.t.m.b
    @e
    public String i() {
        FileInputStream fileInputStream = new FileInputStream(this.a);
        try {
            String a = n.a(fileInputStream);
            h.h2.b.a(fileInputStream, null);
            return a;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
            return null;
        }
    }

    @d
    public final File j() {
        return this.a;
    }
}
