package h.h2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.u.p;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.AccessDeniedException;
import kotlin.io.FileWalkDirection;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", MessageKey.MSG_ACCEPT_TIME_START, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", com.huawei.hms.push.e.a, "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class h implements h.q2.m<File> {
    private final File a;
    private final FileWalkDirection b;

    /* renamed from: c  reason: collision with root package name */
    private final h.k2.u.l<File, Boolean> f14873c;

    /* renamed from: d  reason: collision with root package name */
    private final h.k2.u.l<File, t1> f14874d;

    /* renamed from: e  reason: collision with root package name */
    private final p<File, IOException, t1> f14875e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14876f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static abstract class a extends c {
        public a(@k.e.a.d File file) {
            super(file);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class b extends h.a2.b<File> {

        /* renamed from: c  reason: collision with root package name */
        private final ArrayDeque<c> f14877c;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes3.dex */
        public final class a extends a {
            private boolean b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f14879c;

            /* renamed from: d  reason: collision with root package name */
            private int f14880d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f14881e;

            public a(@k.e.a.d File file) {
                super(file);
            }

            @Override // h.h2.h.c
            @k.e.a.e
            public File b() {
                if (!this.f14881e && this.f14879c == null) {
                    h.k2.u.l lVar = h.this.f14873c;
                    if (lVar != null && !((Boolean) lVar.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f14879c = listFiles;
                    if (listFiles == null) {
                        p pVar = h.this.f14875e;
                        if (pVar != null) {
                            t1 t1Var = (t1) pVar.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f14881e = true;
                    }
                }
                File[] fileArr = this.f14879c;
                if (fileArr != null && this.f14880d < fileArr.length) {
                    File[] fileArr2 = this.f14879c;
                    int i2 = this.f14880d;
                    this.f14880d = i2 + 1;
                    return fileArr2[i2];
                } else if (this.b) {
                    h.k2.u.l lVar2 = h.this.f14874d;
                    if (lVar2 != null) {
                        t1 t1Var2 = (t1) lVar2.invoke(a());
                    }
                    return null;
                } else {
                    this.b = true;
                    return a();
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* renamed from: h.h2.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0424b extends c {
            private boolean b;

            public C0424b(@k.e.a.d File file) {
                super(file);
            }

            @Override // h.h2.h.c
            @k.e.a.e
            public File b() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return a();
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes3.dex */
        public final class c extends a {
            private boolean b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f14884c;

            /* renamed from: d  reason: collision with root package name */
            private int f14885d;

            public c(@k.e.a.d File file) {
                super(file);
            }

            @Override // h.h2.h.c
            @k.e.a.e
            public File b() {
                p pVar;
                if (!this.b) {
                    h.k2.u.l lVar = h.this.f14873c;
                    if (lVar == null || ((Boolean) lVar.invoke(a())).booleanValue()) {
                        this.b = true;
                        return a();
                    }
                    return null;
                }
                File[] fileArr = this.f14884c;
                if (fileArr != null && this.f14885d >= fileArr.length) {
                    h.k2.u.l lVar2 = h.this.f14874d;
                    if (lVar2 != null) {
                        t1 t1Var = (t1) lVar2.invoke(a());
                    }
                    return null;
                }
                if (this.f14884c == null) {
                    File[] listFiles = a().listFiles();
                    this.f14884c = listFiles;
                    if (listFiles == null && (pVar = h.this.f14875e) != null) {
                        t1 t1Var2 = (t1) pVar.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                    }
                    File[] fileArr2 = this.f14884c;
                    if (fileArr2 == null || fileArr2.length == 0) {
                        h.k2.u.l lVar3 = h.this.f14874d;
                        if (lVar3 != null) {
                            t1 t1Var3 = (t1) lVar3.invoke(a());
                        }
                        return null;
                    }
                }
                File[] fileArr3 = this.f14884c;
                int i2 = this.f14885d;
                this.f14885d = i2 + 1;
                return fileArr3[i2];
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f14877c = arrayDeque;
            if (h.this.a.isDirectory()) {
                arrayDeque.push(h(h.this.a));
            } else if (h.this.a.isFile()) {
                arrayDeque.push(new C0424b(h.this.a));
            } else {
                d();
            }
        }

        private final a h(File file) {
            int i2 = i.a[h.this.b.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return new a(file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new c(file);
        }

        private final File i() {
            File b;
            while (true) {
                c peek = this.f14877c.peek();
                if (peek == null) {
                    return null;
                }
                b = peek.b();
                if (b == null) {
                    this.f14877c.pop();
                } else if (f0.g(b, peek.a()) || !b.isDirectory() || this.f14877c.size() >= h.this.f14876f) {
                    break;
                } else {
                    this.f14877c.push(h(b));
                }
            }
            return b;
        }

        @Override // h.a2.b
        public void a() {
            File i2 = i();
            if (i2 != null) {
                f(i2);
            } else {
                d();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static abstract class c {
        @k.e.a.d
        private final File a;

        public c(@k.e.a.d File file) {
            this.a = file;
        }

        @k.e.a.d
        public final File a() {
            return this.a;
        }

        @k.e.a.e
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(File file, FileWalkDirection fileWalkDirection, h.k2.u.l<? super File, Boolean> lVar, h.k2.u.l<? super File, t1> lVar2, p<? super File, ? super IOException, t1> pVar, int i2) {
        this.a = file;
        this.b = fileWalkDirection;
        this.f14873c = lVar;
        this.f14874d = lVar2;
        this.f14875e = pVar;
        this.f14876f = i2;
    }

    @k.e.a.d
    public final h i(int i2) {
        if (i2 > 0) {
            return new h(this.a, this.b, this.f14873c, this.f14874d, this.f14875e, i2);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i2 + '.');
    }

    @Override // h.q2.m
    @k.e.a.d
    public Iterator<File> iterator() {
        return new b();
    }

    @k.e.a.d
    public final h j(@k.e.a.d h.k2.u.l<? super File, Boolean> lVar) {
        return new h(this.a, this.b, lVar, this.f14874d, this.f14875e, this.f14876f);
    }

    @k.e.a.d
    public final h k(@k.e.a.d p<? super File, ? super IOException, t1> pVar) {
        return new h(this.a, this.b, this.f14873c, this.f14874d, pVar, this.f14876f);
    }

    @k.e.a.d
    public final h l(@k.e.a.d h.k2.u.l<? super File, t1> lVar) {
        return new h(this.a, this.b, this.f14873c, lVar, this.f14875e, this.f14876f);
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, h.k2.u.l lVar, h.k2.u.l lVar2, p pVar, int i2, int i3, u uVar) {
        this(file, (i3 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, lVar, lVar2, pVar, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }

    public h(@k.e.a.d File file, @k.e.a.d FileWalkDirection fileWalkDirection) {
        this(file, fileWalkDirection, null, null, null, 0, 32, null);
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, int i2, u uVar) {
        this(file, (i2 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}
