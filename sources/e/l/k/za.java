package e.l.k;

import android.graphics.drawable.Drawable;
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
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.MatchResult;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.RankImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class za extends ya {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull
    private final ConstraintLayout n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.countTv, 9);
        sparseIntArray.put(R.id.priceTv, 10);
        sparseIntArray.put(R.id.rightIv, 11);
    }

    public za(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, p, q));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        Integer num;
        String str;
        String str2;
        String str3;
        CharSequence charSequence;
        String str4;
        CharSequence charSequence2;
        Drawable drawable;
        String str5;
        e.t.r.a.a aVar;
        String str6;
        String str7;
        String str8;
        CharSequence charSequence3;
        CharSequence charSequence4;
        String str9;
        Integer num2;
        Game game;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        MatchResult matchResult = this.f13996l;
        e.l.g.e0 e0Var = this.f13997m;
        Game game2 = null;
        Integer num3 = null;
        game2 = null;
        if ((j2 & 7) != 0) {
            String avatar = matchResult != null ? matchResult.getAvatar() : null;
            e.t.r.a.a v = e0Var != null ? e0Var.v() : null;
            int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i2 != 0) {
                if (matchResult != null) {
                    String title = matchResult.getTitle();
                    Integer uid = matchResult.getUid();
                    str8 = matchResult.getCover();
                    charSequence3 = matchResult.getCountStr();
                    charSequence4 = matchResult.getPriceStr();
                    str9 = matchResult.getName();
                    num2 = matchResult.getCreditRankDrawable();
                    game = matchResult.getGame();
                    str7 = matchResult.getLocationStr();
                    str6 = title;
                    num3 = uid;
                } else {
                    str6 = null;
                    str7 = null;
                    str8 = null;
                    charSequence3 = null;
                    charSequence4 = null;
                    str9 = null;
                    num2 = null;
                    game = null;
                }
                boolean z = ViewDataBinding.safeUnbox(num3) == 1000;
                if (i2 != 0) {
                    j2 |= z ? 16L : 8L;
                }
                Drawable drawable2 = AppCompatResources.getDrawable(this.n.getContext(), z ? R.drawable.bg_white_corner_10_highlight : R.drawable.bg_white_corner_10);
                str4 = str6;
                aVar = v;
                str5 = avatar;
                str = str7;
                str3 = str8;
                charSequence2 = charSequence3;
                charSequence = charSequence4;
                str2 = str9;
                num = num2;
                drawable = drawable2;
                game2 = game;
            } else {
                aVar = v;
                str5 = avatar;
                num = null;
                str = null;
                str2 = null;
                str3 = null;
                charSequence = null;
                str4 = null;
                charSequence2 = null;
                drawable = null;
            }
        } else {
            num = null;
            str = null;
            str2 = null;
            str3 = null;
            charSequence = null;
            str4 = null;
            charSequence2 = null;
            drawable = null;
            str5 = null;
            aVar = null;
        }
        if ((7 & j2) != 0) {
            e.t.j.g.y.a(this.a, str5, null, null, null, null, null, null, null, null, null, aVar, null, null, null, null, null);
        }
        if ((j2 & 5) != 0) {
            CardImageView cardImageView = this.f13987c;
            e.l.i.e.b(cardImageView, str3, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game2, null, null, null);
            e.t.j.g.x.e(this.f13988d, num);
            TextViewBindingAdapter.setText(this.f13989e, str);
            ViewBindingAdapter.setBackground(this.n, drawable);
            TextViewBindingAdapter.setText(this.f13990f, charSequence2);
            TextViewBindingAdapter.setText(this.f13991g, str4);
            TextViewBindingAdapter.setText(this.f13992h, charSequence);
            TextViewBindingAdapter.setText(this.f13995k, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // e.l.k.ya
    public void i(@Nullable e.l.g.e0 e0Var) {
        this.f13997m = e0Var;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ya
    public void j(@Nullable MatchResult matchResult) {
        this.f13996l = matchResult;
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
            j((MatchResult) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((e.l.g.e0) obj);
        }
        return true;
    }

    private za(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[9], (CardImageView) objArr[6], (RankImageView) objArr[3], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[10], (ImageView) objArr[11], (TextView) objArr[2]);
        this.o = -1L;
        this.a.setTag(null);
        this.f13987c.setTag(null);
        this.f13988d.setTag(null);
        this.f13989e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.n = constraintLayout;
        constraintLayout.setTag(null);
        this.f13990f.setTag(null);
        this.f13991g.setTag(null);
        this.f13992h.setTag(null);
        this.f13995k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
