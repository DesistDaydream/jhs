package e.b.a.p.k;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public abstract class h {
    public static final h a = new a();
    public static final h b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final h f9533c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final h f9534d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final h f9535e = new e();

    /* loaded from: classes.dex */
    public class a extends h {
        @Override // e.b.a.p.k.h
        public boolean a() {
            return true;
        }

        @Override // e.b.a.p.k.h
        public boolean b() {
            return true;
        }

        @Override // e.b.a.p.k.h
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // e.b.a.p.k.h
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    public class b extends h {
        @Override // e.b.a.p.k.h
        public boolean a() {
            return false;
        }

        @Override // e.b.a.p.k.h
        public boolean b() {
            return false;
        }

        @Override // e.b.a.p.k.h
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // e.b.a.p.k.h
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class c extends h {
        @Override // e.b.a.p.k.h
        public boolean a() {
            return true;
        }

        @Override // e.b.a.p.k.h
        public boolean b() {
            return false;
        }

        @Override // e.b.a.p.k.h
        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // e.b.a.p.k.h
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class d extends h {
        @Override // e.b.a.p.k.h
        public boolean a() {
            return false;
        }

        @Override // e.b.a.p.k.h
        public boolean b() {
            return true;
        }

        @Override // e.b.a.p.k.h
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // e.b.a.p.k.h
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    public class e extends h {
        @Override // e.b.a.p.k.h
        public boolean a() {
            return true;
        }

        @Override // e.b.a.p.k.h
        public boolean b() {
            return true;
        }

        @Override // e.b.a.p.k.h
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // e.b.a.p.k.h
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
