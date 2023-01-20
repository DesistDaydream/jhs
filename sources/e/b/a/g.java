package e.b.a;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.t.k.o;
import e.b.a.t.k.p;
import e.b.a.v.n;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class g<T> implements AbsListView.OnScrollListener {
    private final int a;
    private final d b;

    /* renamed from: c  reason: collision with root package name */
    private final j f9344c;

    /* renamed from: d  reason: collision with root package name */
    private final a<T> f9345d;

    /* renamed from: e  reason: collision with root package name */
    private final b<T> f9346e;

    /* renamed from: f  reason: collision with root package name */
    private int f9347f;

    /* renamed from: g  reason: collision with root package name */
    private int f9348g;

    /* renamed from: i  reason: collision with root package name */
    private int f9350i;

    /* renamed from: h  reason: collision with root package name */
    private int f9349h = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9351j = true;

    /* loaded from: classes.dex */
    public interface a<U> {
        @NonNull
        List<U> a(int i2);

        @Nullable
        i<?> b(@NonNull U u);
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        @Nullable
        int[] a(@NonNull T t, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static final class c implements p<Object> {
        public int a;
        public int b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private e.b.a.t.e f9352c;

        @Override // e.b.a.t.k.p
        @Nullable
        public e.b.a.t.e getRequest() {
            return this.f9352c;
        }

        @Override // e.b.a.t.k.p
        public void getSize(@NonNull o oVar) {
            oVar.e(this.b, this.a);
        }

        @Override // e.b.a.q.m
        public void onDestroy() {
        }

        @Override // e.b.a.t.k.p
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f<? super Object> fVar) {
        }

        @Override // e.b.a.q.m
        public void onStart() {
        }

        @Override // e.b.a.q.m
        public void onStop() {
        }

        @Override // e.b.a.t.k.p
        public void removeCallback(@NonNull o oVar) {
        }

        @Override // e.b.a.t.k.p
        public void setRequest(@Nullable e.b.a.t.e eVar) {
            this.f9352c = eVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public final Queue<c> a;

        public d(int i2) {
            this.a = n.f(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.a.offer(new c());
            }
        }

        public c a(int i2, int i3) {
            c poll = this.a.poll();
            this.a.offer(poll);
            poll.b = i2;
            poll.a = i3;
            return poll;
        }
    }

    public g(@NonNull j jVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i2) {
        this.f9344c = jVar;
        this.f9345d = aVar;
        this.f9346e = bVar;
        this.a = i2;
        this.b = new d(i2 + 1);
    }

    private void a() {
        for (int i2 = 0; i2 < this.b.a.size(); i2++) {
            this.f9344c.r(this.b.a(0, 0));
        }
    }

    private void b(int i2, int i3) {
        int min;
        int i4;
        if (i2 < i3) {
            i4 = Math.max(this.f9347f, i2);
            min = i3;
        } else {
            min = Math.min(this.f9348g, i2);
            i4 = i3;
        }
        int min2 = Math.min(this.f9350i, min);
        int min3 = Math.min(this.f9350i, Math.max(0, i4));
        if (i2 < i3) {
            for (int i5 = min3; i5 < min2; i5++) {
                d(this.f9345d.a(i5), i5, true);
            }
        } else {
            for (int i6 = min2 - 1; i6 >= min3; i6--) {
                d(this.f9345d.a(i6), i6, false);
            }
        }
        this.f9348g = min3;
        this.f9347f = min2;
    }

    private void c(int i2, boolean z) {
        if (this.f9351j != z) {
            this.f9351j = z;
            a();
        }
        b(i2, (z ? this.a : -this.a) + i2);
    }

    private void d(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e(list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            e(list.get(i4), i2, i4);
        }
    }

    private void e(@Nullable T t, int i2, int i3) {
        int[] a2;
        i<?> b2;
        if (t == null || (a2 = this.f9346e.a(t, i2, i3)) == null || (b2 = this.f9345d.b(t)) == null) {
            return;
        }
        b2.j1(this.b.a(a2[0], a2[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.f9350i = i4;
        int i5 = this.f9349h;
        if (i2 > i5) {
            c(i3 + i2, true);
        } else if (i2 < i5) {
            c(i2, false);
        }
        this.f9349h = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
