package com.vector.filecompat.executor;

import android.content.Context;
import android.net.Uri;
import e.t.l.l;
import e.t.l.z;
import e.t.m.b;
import e.t.m.f.a;
import java.io.File;
import java.io.InputStream;
import k.b.a.a.n.n.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/vector/filecompat/executor/DescriptorFileExecutor;", "Lcom/vector/filecompat/CompatFile;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri$vector_release", "()Landroid/net/Uri;", "copy", "", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "exists", "", "getAbsolutePath", "", "rootDir", "getInputStream", "Ljava/io/InputStream;", "getName", "parent", "readString", "saveToAlbum", "(Landroid/content/Context;)Ljava/lang/Boolean;", "write", c.b, "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DescriptorFileExecutor implements b {
    @d
    private final Uri a;

    public DescriptorFileExecutor(@d Uri uri) {
        this.a = uri;
    }

    @Override // e.t.m.b
    @d
    public Boolean a(@d Context context) {
        String i2 = z.i(this.a, null, null, 3, null);
        if (i2 == null) {
            return Boolean.FALSE;
        }
        File file = new File(i2);
        return Boolean.valueOf(file.exists() ? l.n(file, context) : false);
    }

    @Override // e.t.m.b
    @e
    public String b(@d Context context) {
        return z.g(this.a, context);
    }

    @Override // e.t.m.b
    public void c(@d File file, @d Context context) {
        z.a(this.a, file, context);
    }

    @Override // e.t.m.b
    public boolean d() {
        return z.f(this.a, null, 1, null);
    }

    @Override // e.t.m.b
    public void e(@d Object obj, @d Context context) {
        z.q(this.a, null, null, new DescriptorFileExecutor$write$1(obj), 3, null);
    }

    @Override // e.t.m.b
    @e
    public b f(@e String str) {
        String g2 = g(str);
        if (g2 == null) {
            return null;
        }
        File file = new File(g2);
        if (!file.exists() || file.getParentFile() == null) {
            return null;
        }
        return new a(file.getParentFile());
    }

    @Override // e.t.m.b
    @e
    public String g(@e String str) {
        return z.i(this.a, str, null, 2, null);
    }

    @Override // e.t.m.b
    @e
    public InputStream h(@d Context context) {
        return z.r(this.a, context);
    }

    @Override // e.t.m.b
    @e
    public String i() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        z.q(this.a, null, null, new DescriptorFileExecutor$readString$1(objectRef), 3, null);
        return (String) objectRef.element;
    }

    @d
    public final Uri j() {
        return this.a;
    }
}
