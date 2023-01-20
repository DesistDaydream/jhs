package e.l.g;

import android.graphics.Bitmap;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class o0 extends e.t.k.a.c.a<GameCard> {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12039d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final List<e.t.r.a.n.c> f12040e;

    /* renamed from: f  reason: collision with root package name */
    private int f12041f;

    /* loaded from: classes2.dex */
    public static final class a implements e.t.r.a.n.c {
        @Override // e.t.r.a.n.c
        @k.e.a.d
        public Bitmap a(@k.e.a.d Bitmap bitmap) {
            return e.l.r.h0.a.a(bitmap);
        }
    }

    public o0() {
        this(false, 1, null);
    }

    public o0(boolean z) {
        super(null, 1, null);
        this.f12039d = z;
        this.f12040e = CollectionsKt__CollectionsKt.P(new a());
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_edit_product;
    }

    public final int v() {
        return this.f12041f;
    }

    @k.e.a.d
    public final List<e.t.r.a.n.c> w() {
        return this.f12040e;
    }

    public final boolean x() {
        return this.f12039d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: y */
    public void u(@k.e.a.d GameCard gameCard, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, gameCard);
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(11, Integer.valueOf(j()));
    }

    public final void z(int i2) {
        this.f12041f = i2;
        notifyDataSetChanged();
    }

    public /* synthetic */ o0(boolean z, int i2, h.k2.v.u uVar) {
        this((i2 & 1) != 0 ? false : z);
    }
}
