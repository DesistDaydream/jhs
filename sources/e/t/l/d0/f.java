package e.t.l.d0;

import android.view.View;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/vector/ext/view/SingleClickListener;", "Landroid/view/View$OnClickListener;", "()V", "onClick", "", "v", "Landroid/view/View;", "onSingleClick", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class f implements View.OnClickListener {
    @k.e.a.d
    public static final a a = new a(null);
    public static final int b = 500;

    /* renamed from: c  reason: collision with root package name */
    private static long f14586c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/vector/ext/view/SingleClickListener$Companion;", "", "()V", "MIN_CLICK_INTERVAL", "", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final long a() {
            return f.f14586c;
        }

        public final void b(long j2) {
            f.f14586c = j2;
        }
    }

    public abstract void c(@k.e.a.d View view);

    @Override // android.view.View.OnClickListener
    public void onClick(@k.e.a.d View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f14586c > 500) {
            f14586c = currentTimeMillis;
            c(view);
        }
    }
}
