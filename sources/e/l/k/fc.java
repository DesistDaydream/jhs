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
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class fc extends ec {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final ConstraintLayout f12652l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f12653m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.clImage, 10);
    }

    public fc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        RankCardInfo rankCardInfo = this.f12586k;
        int i3 = 0;
        Float f2 = null;
        int i4 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i4 == 0 || rankCardInfo == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            i2 = 0;
        } else {
            String nameCN = rankCardInfo.getNameCN();
            Float scoreNum = rankCardInfo.getScoreNum();
            int tintColor = rankCardInfo.getTintColor();
            str2 = rankCardInfo.getGameName();
            int srcId = rankCardInfo.getSrcId();
            String imageURL = rankCardInfo.getImageURL();
            String rankStr = rankCardInfo.getRankStr();
            String nameOrigin = rankCardInfo.getNameOrigin();
            str6 = rankStr;
            str4 = rankCardInfo.getNumber();
            i2 = tintColor;
            i3 = srcId;
            str3 = nameOrigin;
            str5 = imageURL;
            f2 = scoreNum;
            str = nameCN;
        }
        if (i4 != 0) {
            NImageView nImageView = this.b;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_transparent), null, null, null, null, null, null, null, null, null, AppCompatResources.getDrawable(this.b.getContext(), R.drawable.bg_err_image));
            e.t.j.g.x.e(this.f12653m, Integer.valueOf(i3));
            e.t.j.g.x.f(this.f12653m, Integer.valueOf(i2));
            e.l.i.a0.a(this.f12578c, f2);
            TextViewBindingAdapter.setText(this.f12579d, str2);
            e.l.i.a0.a(this.f12580e, f2);
            TextViewBindingAdapter.setText(this.f12581f, str);
            TextViewBindingAdapter.setText(this.f12582g, str3);
            TextViewBindingAdapter.setText(this.f12583h, str4);
            TextViewBindingAdapter.setText(this.f12584i, str6);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // e.l.k.ec
    public void i(@Nullable e.l.g.p0 p0Var) {
        this.f12585j = p0Var;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ec
    public void j(@Nullable RankCardInfo rankCardInfo) {
        this.f12586k = rankCardInfo;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((RankCardInfo) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((e.l.g.p0) obj);
        }
        return true;
    }

    private fc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[10], (NImageView) objArr[3], (ScoreView) objArr[7], (TextView) objArr[8], (ScoreView) objArr[5], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[1]);
        this.n = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12652l = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f12653m = imageView;
        imageView.setTag(null);
        this.f12578c.setTag(null);
        this.f12579d.setTag(null);
        this.f12580e.setTag(null);
        this.f12581f.setTag(null);
        this.f12582g.setTag(null);
        this.f12583h.setTag(null);
        this.f12584i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
