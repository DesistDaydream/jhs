package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public class rb extends qb {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13493m = null;
    @Nullable
    private static final SparseIntArray n = null;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f13494i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f13495j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13496k;

    /* renamed from: l  reason: collision with root package name */
    private long f13497l;

    public rb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13493m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        long j3;
        String str;
        String str2;
        CharSequence charSequence;
        Float f2;
        String str3;
        String str4;
        Game game;
        String str5;
        String str6;
        Game game2;
        synchronized (this) {
            j2 = this.f13497l;
            this.f13497l = 0L;
        }
        CardVersionInfo cardVersionInfo = this.f13435g;
        String str7 = null;
        Integer num = null;
        int i2 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (cardVersionInfo != null) {
                String nameCN = cardVersionInfo.getNameCN();
                str5 = cardVersionInfo.getRarity();
                charSequence = cardVersionInfo.getPrice();
                f2 = cardVersionInfo.getScoreNum();
                str6 = cardVersionInfo.getImg();
                Integer numMore = cardVersionInfo.getNumMore();
                game2 = cardVersionInfo.getGame();
                str3 = cardVersionInfo.getNumber();
                str = nameCN;
                num = numMore;
            } else {
                str = null;
                str5 = null;
                charSequence = null;
                f2 = null;
                str6 = null;
                str3 = null;
                game2 = null;
            }
            str2 = this.f13496k.getResources().getString(R.string.more_card_num, num);
            boolean z = ViewDataBinding.safeUnbox(num) > 0;
            if (i2 != 0) {
                j2 |= z ? 32L : 16L;
            }
            r10 = z ? 0 : 8;
            str7 = str5;
            str4 = str6;
            game = game2;
            j3 = 9;
        } else {
            j3 = 9;
            str = null;
            str2 = null;
            charSequence = null;
            f2 = null;
            str3 = null;
            str4 = null;
            game = null;
        }
        if ((j2 & j3) != 0) {
            CardImageView cardImageView = this.a;
            e.l.i.e.b(cardImageView, str4, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            TextViewBindingAdapter.setText(this.f13495j, str7);
            TextViewBindingAdapter.setText(this.f13496k, str2);
            this.f13496k.setVisibility(r10);
            e.l.i.a0.a(this.b, f2);
            TextViewBindingAdapter.setText(this.f13431c, charSequence);
            TextViewBindingAdapter.setText(this.f13432d, str);
            TextViewBindingAdapter.setText(this.f13433e, str3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13497l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13497l = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.qb
    public void j(@Nullable e.l.g.l lVar) {
        this.f13434f = lVar;
    }

    @Override // e.l.k.qb
    public void k(@Nullable CardVersionInfo cardVersionInfo) {
        this.f13435g = cardVersionInfo;
        synchronized (this) {
            this.f13497l |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.qb
    public void l(@Nullable e.t.r.a.h hVar) {
        this.f13436h = hVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((CardVersionInfo) obj);
        } else if (17 == i2) {
            l((e.t.r.a.h) obj);
        } else if (2 != i2) {
            return false;
        } else {
            j((e.l.g.l) obj);
        }
        return true;
    }

    private rb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardImageView) objArr[1], (ScoreView) objArr[4], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[5]);
        this.f13497l = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13494i = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.f13495j = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.f13496k = textView2;
        textView2.setTag(null);
        this.b.setTag(null);
        this.f13431c.setTag(null);
        this.f13432d.setTag(null);
        this.f13433e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
