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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public class n9 extends m9 {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13198j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f13199k;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13200g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f13201h;

    /* renamed from: i  reason: collision with root package name */
    private long f13202i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13199k = sparseIntArray;
        sparseIntArray.put(R.id.rightIv, 6);
    }

    public n9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13198j, f13199k));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        Game game;
        String str5;
        String str6;
        Game game2;
        boolean z;
        synchronized (this) {
            j2 = this.f13202i;
            this.f13202i = 0L;
        }
        GameCard gameCard = this.f13125f;
        String str7 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (gameCard != null) {
                str7 = gameCard.getVersionNum();
                z = gameCard.isSelling();
                str3 = gameCard.getNwName();
                str6 = gameCard.getRarity();
                game2 = gameCard.getGame();
                str5 = gameCard.getImg();
            } else {
                str5 = null;
                str3 = null;
                str6 = null;
                game2 = null;
                z = false;
            }
            if (i2 != 0) {
                j2 |= z ? 8L : 4L;
            }
            r10 = z ? 0 : 8;
            str4 = str5;
            str2 = str7;
            str = str6;
            game = game2;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            game = null;
        }
        if ((j2 & 3) != 0) {
            CardImageView cardImageView = this.a;
            e.l.i.e.b(cardImageView, str4, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            TextViewBindingAdapter.setText(this.f13201h, str);
            TextViewBindingAdapter.setText(this.b, str3);
            this.f13123d.setVisibility(r10);
            TextViewBindingAdapter.setText(this.f13124e, str2);
        }
    }

    @Override // e.l.k.m9
    public void h(@Nullable GameCard gameCard) {
        this.f13125f = gameCard;
        synchronized (this) {
            this.f13202i |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13202i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13202i = 2L;
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
            h((GameCard) obj);
            return true;
        }
        return false;
    }

    private n9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardImageView) objArr[1], (TextView) objArr[2], (ImageView) objArr[6], (TextView) objArr[5], (TextView) objArr[3]);
        this.f13202i = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13200g = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13201h = textView;
        textView.setTag(null);
        this.b.setTag(null);
        this.f13123d.setTag(null);
        this.f13124e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
