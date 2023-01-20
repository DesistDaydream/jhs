package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.dialog.ContactDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.CopyTextView;

/* loaded from: classes2.dex */
public class j4 extends i4 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts u = null;
    @Nullable
    private static final SparseIntArray v;
    @NonNull
    private final ConstraintLayout p;
    @NonNull
    private final TextView q;
    @NonNull
    private final TextView r;
    @NonNull
    private final TextView s;
    private long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.reportIv, 12);
        sparseIntArray.put(R.id.divider, 13);
        sparseIntArray.put(R.id.productTitle, 14);
        sparseIntArray.put(R.id.content1, 15);
        sparseIntArray.put(R.id.content2, 16);
        sparseIntArray.put(R.id.divider2, 17);
    }

    public j4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, u, v));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        long j3;
        String str;
        CharSequence charSequence;
        String str2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        String str3;
        String str4;
        String str5;
        String str6;
        Game game;
        boolean z;
        e.t.j.h.g gVar4;
        GameCard gameCard;
        e.t.j.h.g gVar5;
        String str7;
        String str8;
        String str9;
        CharSequence charSequence2;
        String str10;
        String str11;
        Game game2;
        int i2;
        synchronized (this) {
            j2 = this.t;
            this.t = 0L;
        }
        ContactDialog contactDialog = this.o;
        int i3 = 0;
        String str12 = null;
        int i4 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i4 != 0) {
            if (contactDialog != null) {
                gVar3 = contactDialog.C(this.f12849f);
                gameCard = contactDialog.getProduct();
                gVar5 = contactDialog.getOnClickClose();
                gVar4 = contactDialog.getOnContact();
            } else {
                gVar4 = null;
                gVar3 = null;
                gameCard = null;
                gVar5 = null;
            }
            if (gameCard != null) {
                String nwName = gameCard.getNwName();
                String remark = gameCard.getRemark();
                str9 = gameCard.getImg();
                charSequence2 = gameCard.getWishPrice();
                str10 = gameCard.getCnocgname();
                str11 = gameCard.getRarity();
                i2 = gameCard.getQuantity();
                game2 = gameCard.getGame();
                str7 = gameCard.getVersionNum();
                str8 = nwName;
                str12 = remark;
            } else {
                str7 = null;
                str8 = null;
                str9 = null;
                charSequence2 = null;
                str10 = null;
                str11 = null;
                game2 = null;
                i2 = 0;
            }
            z = str12 == null;
            String string = this.f12855l.getResources().getString(R.string.common_ra, str11);
            String string2 = this.s.getResources().getString(R.string.common_number, Integer.valueOf(i2));
            String string3 = this.f12851h.getResources().getString(R.string.common_no, str7);
            if (i4 == 0) {
                j3 = 16;
            } else if (z) {
                j2 |= 32;
                gVar2 = gVar4;
                str3 = string;
                str5 = string2;
                str4 = string3;
                gVar = gVar5;
                str = str8;
                str6 = str9;
                charSequence = charSequence2;
                str2 = str10;
                game = game2;
                j3 = 16;
            } else {
                j3 = 16;
                j2 |= 16;
            }
            gVar2 = gVar4;
            str3 = string;
            str5 = string2;
            str4 = string3;
            gVar = gVar5;
            str = str8;
            str6 = str9;
            charSequence = charSequence2;
            str2 = str10;
            game = game2;
        } else {
            j3 = 16;
            str = null;
            charSequence = null;
            str2 = null;
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            game = null;
            z = false;
        }
        boolean isEmpty = ((j3 & j2) == 0 || str12 == null) ? false : str12.isEmpty();
        int i5 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i5 != 0) {
            boolean z2 = z ? true : isEmpty;
            if (i5 != 0) {
                j2 |= z2 ? 8L : 4L;
            }
            if (z2) {
                i3 = 8;
            }
        }
        if ((j2 & 3) != 0) {
            e.t.j.g.e0.F(this.a, gVar);
            e.t.j.g.e0.F(this.f12849f, gVar3);
            CardImageView cardImageView = this.f12849f;
            e.l.i.e.b(cardImageView, str6, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            e.t.j.g.e0.F(this.q, gVar2);
            TextViewBindingAdapter.setText(this.r, charSequence);
            TextViewBindingAdapter.setText(this.s, str5);
            TextViewBindingAdapter.setText(this.f12850g, str);
            TextViewBindingAdapter.setText(this.f12851h, str4);
            this.f12853j.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f12854k, str12);
            this.f12854k.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f12855l, str3);
            TextViewBindingAdapter.setText(this.n, str2);
        }
    }

    @Override // e.l.k.i4
    public void h(@Nullable ContactDialog contactDialog) {
        this.o = contactDialog;
        synchronized (this) {
            this.t |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((ContactDialog) obj);
            return true;
        }
        return false;
    }

    private j4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[15], (LinearLayout) objArr[16], (View) objArr[13], (View) objArr[17], (CardImageView) objArr[2], (CopyTextView) objArr[3], (CopyTextView) objArr[5], (TextView) objArr[14], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[6], (ImageView) objArr[12], (CopyTextView) objArr[4]);
        this.t = -1L;
        this.a.setTag(null);
        this.f12849f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.q = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.r = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.s = textView3;
        textView3.setTag(null);
        this.f12850g.setTag(null);
        this.f12851h.setTag(null);
        this.f12853j.setTag(null);
        this.f12854k.setTag(null);
        this.f12855l.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
