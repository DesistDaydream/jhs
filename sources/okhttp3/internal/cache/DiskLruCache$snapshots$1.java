package okhttp3.internal.cache;

import h.k2.v.x0.d;
import h.t1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import okhttp3.internal.cache.DiskLruCache;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR,\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012 \r*\b\u0018\u00010\fR\u00020\u00030\fR\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "", "hasNext", "()Z", "next", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lh/t1;", "remove", "()V", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "kotlin.jvm.PlatformType", "delegate", "Ljava/util/Iterator;", "removeSnapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "nextSnapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, d {
    private final Iterator<DiskLruCache.Entry> delegate;
    private DiskLruCache.Snapshot nextSnapshot;
    private DiskLruCache.Snapshot removeSnapshot;
    public final /* synthetic */ DiskLruCache this$0;

    public DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        this.delegate = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        DiskLruCache.Snapshot snapshot$okhttp;
        if (this.nextSnapshot != null) {
            return true;
        }
        synchronized (this.this$0) {
            if (this.this$0.getClosed$okhttp()) {
                return false;
            }
            while (this.delegate.hasNext()) {
                DiskLruCache.Entry next = this.delegate.next();
                if (next != null && (snapshot$okhttp = next.snapshot$okhttp()) != null) {
                    this.nextSnapshot = snapshot$okhttp;
                    return true;
                }
            }
            t1 t1Var = t1.a;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.removeSnapshot;
        if (snapshot != null) {
            try {
                this.this$0.remove(snapshot.key());
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
            return;
        }
        throw new IllegalStateException("remove() before next()".toString());
    }

    @Override // java.util.Iterator
    @k.e.a.d
    public DiskLruCache.Snapshot next() {
        if (hasNext()) {
            DiskLruCache.Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            return snapshot;
        }
        throw new NoSuchElementException();
    }
}
