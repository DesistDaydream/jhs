package com.vector.util;

import e.t.l.l;
import e.t.u.i;
import h.k2.v.f0;
import h.k2.v.u;
import h.w;
import h.z;
import java.io.File;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004H\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0004J\u001c\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/vector/util/CachingEx;", "", "()V", "basePath", "", "getBasePath", "()Ljava/lang/String;", "basePath$delegate", "Lkotlin/Lazy;", "externalPath", "getExternalPath", "externalPath$delegate", "ensureFileExist", "", "file", "Ljava/io/File;", "filePath", "getCacheBasePath", "makeDir", "dir", "path", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CachingEx {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final a f7867c = new a(null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f7868d = "/.nomedia";
    @d
    private final w a = z.c(CachingEx$basePath$2.INSTANCE);
    @d
    private final w b = z.c(CachingEx$externalPath$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vector/util/CachingEx$Companion;", "", "()V", "NO_MEDIA_NAME", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public CachingEx() {
        g(this, f7868d, null, 2, null);
    }

    private final String c() {
        return (String) this.a.getValue();
    }

    public static /* synthetic */ String g(CachingEx cachingEx, String str, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str2 = cachingEx.c();
            }
            return cachingEx.f(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makeDir");
    }

    public final boolean a(@d File file) {
        return i.a.d(file);
    }

    public final boolean b(@d String str) {
        return i.a.e(str);
    }

    @d
    public final String d() {
        return c();
    }

    @d
    public final String e() {
        return (String) this.b.getValue();
    }

    @d
    public final String f(@d String str, @e String str2) {
        String C = f0.C(str2, str);
        return l.e(C, null, 1, null) ? C : c();
    }
}
