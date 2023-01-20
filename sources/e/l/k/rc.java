package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class rc extends qc {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13498m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13499j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ScoreView f13500k;

    /* renamed from: l  reason: collision with root package name */
    private long f13501l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.top1, 7);
        sparseIntArray.put(R.id.top2, 8);
        sparseIntArray.put(R.id.rightIv, 9);
    }

    public rc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f13498m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        Float f2;
        String str3;
        String str4;
        Game game;
        String str5;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j2 = this.f13501l;
            this.f13501l = 0L;
        }
        Product product = this.f13443i;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (product != null) {
                str5 = product.getNameCN();
                f2 = product.getScoreNum();
                str6 = product.getNumberStr();
                str7 = product.getNameOri();
                str8 = product.getImage();
                game = product.getGame();
            } else {
                game = null;
                str5 = null;
                f2 = null;
                str6 = null;
                str7 = null;
                str8 = null;
            }
            boolean z = str6 == null;
            if (i2 != 0) {
                j2 |= z ? 8L : 4L;
            }
            r11 = game != null ? game.getName() : null;
            r10 = z ? 8 : 0;
            str = r11;
            r11 = str5;
            str2 = str6;
            str3 = str8;
            str4 = str7;
        } else {
            str = null;
            str2 = null;
            f2 = null;
            str3 = null;
            str4 = null;
        }
        if ((j2 & 3) != 0) {
            TextViewBindingAdapter.setText(this.a, r11);
            NImageView nImageView = this.b;
            e.t.j.g.y.a(nImageView, str3, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_pack_top), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.f13437c, str);
            e.l.i.a0.a(this.f13500k, f2);
            TextViewBindingAdapter.setText(this.f13438d, str2);
            this.f13438d.setVisibility(r10);
            TextViewBindingAdapter.setText(this.f13439e, str4);
        }
    }

    @Override // e.l.k.qc
    public void h(@Nullable Product product) {
        this.f13443i = product;
        synchronized (this) {
            this.f13501l |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13501l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13501l = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            h((Product) obj);
            return true;
        }
        return false;
    }

    private rc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (NImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[3], (ImageView) objArr[9], (View) objArr[7], (View) objArr[8]);
        this.f13501l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13437c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13499j = constraintLayout;
        constraintLayout.setTag(null);
        ScoreView scoreView = (ScoreView) objArr[4];
        this.f13500k = scoreView;
        scoreView.setTag(null);
        this.f13438d.setTag(null);
        this.f13439e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
