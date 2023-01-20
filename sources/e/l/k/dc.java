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
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public class dc extends cc {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q = null;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f12515m;
    @NonNull
    private final ImageView n;
    private long o;

    public dc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, p, q));
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
        CharSequence charSequence;
        String str7;
        Game game;
        int i2;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        RankCardInfo rankCardInfo = this.f12443l;
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
            charSequence = null;
            str7 = null;
            game = null;
            i2 = 0;
        } else {
            String nameCN = rankCardInfo.getNameCN();
            Float scoreNum = rankCardInfo.getScoreNum();
            str2 = rankCardInfo.getRarity();
            int tintColor = rankCardInfo.getTintColor();
            str3 = rankCardInfo.getGameName();
            int srcId = rankCardInfo.getSrcId();
            String imageURL = rankCardInfo.getImageURL();
            String rankStr = rankCardInfo.getRankStr();
            String nameOrigin = rankCardInfo.getNameOrigin();
            CharSequence priceStr = rankCardInfo.getPriceStr();
            Game game2 = rankCardInfo.getGame();
            str7 = rankCardInfo.getNumber();
            i2 = tintColor;
            charSequence = priceStr;
            game = game2;
            i3 = srcId;
            str6 = rankStr;
            str4 = nameOrigin;
            str5 = imageURL;
            f2 = scoreNum;
            str = nameCN;
        }
        if (i4 != 0) {
            CardImageView cardImageView = this.a;
            e.l.i.e.b(cardImageView, str5, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_transparent), game, null, null, AppCompatResources.getDrawable(this.a.getContext(), R.drawable.bg_err_image));
            e.t.j.g.x.e(this.n, Integer.valueOf(i3));
            e.t.j.g.x.f(this.n, Integer.valueOf(i2));
            e.l.i.a0.a(this.b, f2);
            TextViewBindingAdapter.setText(this.f12434c, str2);
            TextViewBindingAdapter.setText(this.f12435d, str3);
            e.l.i.a0.a(this.f12436e, f2);
            TextViewBindingAdapter.setText(this.f12437f, str);
            TextViewBindingAdapter.setText(this.f12438g, str4);
            TextViewBindingAdapter.setText(this.f12439h, str7);
            TextViewBindingAdapter.setText(this.f12440i, charSequence);
            TextViewBindingAdapter.setText(this.f12441j, str6);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // e.l.k.cc
    public void i(@Nullable e.l.g.p0 p0Var) {
        this.f12442k = p0Var;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.cc
    public void j(@Nullable RankCardInfo rankCardInfo) {
        this.f12443l = rankCardInfo;
        synchronized (this) {
            this.o |= 1;
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

    private dc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardImageView) objArr[3], (ScoreView) objArr[7], (TextView) objArr[11], (TextView) objArr[8], (ScoreView) objArr[5], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[1]);
        this.o = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12515m = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.n = imageView;
        imageView.setTag(null);
        this.b.setTag(null);
        this.f12434c.setTag(null);
        this.f12435d.setTag(null);
        this.f12436e.setTag(null);
        this.f12437f.setTag(null);
        this.f12438g.setTag(null);
        this.f12439h.setTag(null);
        this.f12440i.setTag(null);
        this.f12441j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
