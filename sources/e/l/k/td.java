package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
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
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.widget.CardImageView;
import com.vector.databinding.adapter.TextViewBinding;

/* loaded from: classes2.dex */
public class td extends sd {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13641m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13642g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f13643h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13644i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f13645j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13646k;

    /* renamed from: l  reason: collision with root package name */
    private long f13647l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.ll_vision, 8);
    }

    public td(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13641m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        int i2;
        String str;
        int i3;
        boolean z;
        int i4;
        String str2;
        int i5;
        String str3;
        Game game;
        String str4;
        String str5;
        CharSequence charSequence;
        boolean z2;
        int i6;
        String str6;
        boolean z3;
        String str7;
        String str8;
        CharSequence charSequence2;
        Game game2;
        synchronized (this) {
            j2 = this.f13647l;
            this.f13647l = 0L;
        }
        WantCard wantCard = this.f13574e;
        int i7 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i7 != 0) {
            if (wantCard != null) {
                z2 = wantCard.isShowNum();
                str = wantCard.getNwName();
                str2 = wantCard.getRarity();
                int ignoreVersion = wantCard.getIgnoreVersion();
                str6 = wantCard.getImg();
                z3 = wantCard.noPrice();
                str7 = wantCard.getLanText();
                str8 = wantCard.getQuantityContent();
                charSequence2 = wantCard.getPriceStr();
                game2 = wantCard.getGame();
                i6 = ignoreVersion;
            } else {
                z2 = false;
                str = null;
                i6 = 0;
                str2 = null;
                str6 = null;
                z3 = false;
                str7 = null;
                str8 = null;
                charSequence2 = null;
                game2 = null;
            }
            if (i7 != 0) {
                j2 |= z2 ? 16L : 8L;
            }
            if ((j2 & 5) != 0) {
                j2 |= z3 ? 64L : 32L;
            }
            i2 = z2 ? 0 : 8;
            boolean z4 = i6 == 1;
            boolean z5 = i6 == 0;
            i5 = z3 ? 12 : 14;
            boolean z6 = str7 == null;
            if ((j2 & 5) != 0) {
                j2 |= z4 ? 1024L : 512L;
            }
            if ((j2 & 5) != 0) {
                j2 = z5 ? j2 | 4096 : j2 | 2048;
            }
            if ((j2 & 5) != 0) {
                j2 |= z6 ? 256L : 128L;
            }
            str4 = str7;
            str5 = str8;
            charSequence = charSequence2;
            game = game2;
            i4 = z4 ? 8 : 0;
            str3 = str6;
            int i8 = z6 ? 8 : 0;
            z = z5;
            i3 = i8;
        } else {
            i2 = 0;
            str = null;
            i3 = 0;
            z = false;
            i4 = 0;
            str2 = null;
            i5 = 0;
            str3 = null;
            game = null;
            str4 = null;
            str5 = null;
            charSequence = null;
        }
        String versionNum = ((4096 & j2) == 0 || wantCard == null) ? null : wantCard.getVersionNum();
        int i9 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i9 == 0) {
            versionNum = null;
        } else if (!z) {
            versionNum = this.f13643h.getResources().getString(R.string.common_anyway_version);
        }
        if (i9 != 0) {
            CardImageView cardImageView = this.a;
            e.l.i.e.b(cardImageView, str3, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            TextViewBindingAdapter.setText(this.f13643h, versionNum);
            TextViewBindingAdapter.setText(this.f13644i, str2);
            this.f13644i.setVisibility(i4);
            TextViewBindingAdapter.setText(this.f13645j, charSequence);
            TextViewBinding.l(this.f13645j, Integer.valueOf(i5));
            this.f13646k.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f13646k, str5);
            TextViewBindingAdapter.setText(this.f13572c, str);
            TextViewBindingAdapter.setText(this.f13573d, str4);
            this.f13573d.setVisibility(i3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13647l != 0;
        }
    }

    @Override // e.l.k.sd
    public void i(@Nullable WantCard wantCard) {
        this.f13574e = wantCard;
        synchronized (this) {
            this.f13647l |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13647l = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.sd
    public void j(@Nullable e.t.r.a.h hVar) {
        this.f13575f = hVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((WantCard) obj);
        } else if (17 != i2) {
            return false;
        } else {
            j((e.t.r.a.h) obj);
        }
        return true;
    }

    private td(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardImageView) objArr[1], (LinearLayout) objArr[8], (TextView) objArr[2], (TextView) objArr[6]);
        this.f13647l = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13642g = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13643h = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f13644i = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.f13645j = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[7];
        this.f13646k = textView4;
        textView4.setTag(null);
        this.f13572c.setTag(null);
        this.f13573d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
