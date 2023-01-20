package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
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
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.ui.dialog.WaitCheckDialog;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class b6 extends a6 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts A = null;
    @Nullable
    private static final SparseIntArray B;
    @NonNull
    private final ConstraintLayout s;
    @NonNull
    private final ImageView t;
    @NonNull
    private final TextView u;
    @NonNull
    private final TextView v;
    @NonNull
    private final TextView w;
    @NonNull
    private final TextView x;
    @NonNull
    private final TextView y;
    private long z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R.id.divider, 13);
        sparseIntArray.put(R.id.ll_price, 14);
        sparseIntArray.put(R.id.priceTitle, 15);
        sparseIntArray.put(R.id.yuanTv, 16);
        sparseIntArray.put(R.id.tv_avg_title, 17);
        sparseIntArray.put(R.id.tv_min_title, 18);
        sparseIntArray.put(R.id.tv_num_title, 19);
        sparseIntArray.put(R.id.tv_condition_title, 20);
        sparseIntArray.put(R.id.tv_condition_desc, 21);
        sparseIntArray.put(R.id.ll_tip, 22);
        sparseIntArray.put(R.id.divider2, 23);
    }

    public b6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, A, B));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        e.t.j.h.g gVar2;
        CharSequence charSequence;
        CharSequence charSequence2;
        e.t.j.h.g gVar3;
        String str6;
        String str7;
        String str8;
        CardProductNew cardProductNew;
        e.t.j.h.g gVar4;
        e.t.j.h.g gVar5;
        e.t.j.h.g gVar6;
        synchronized (this) {
            j2 = this.z;
            this.z = 0L;
        }
        WaitCheckDialog waitCheckDialog = this.r;
        e.t.j.h.g gVar7 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (waitCheckDialog != null) {
                str8 = waitCheckDialog.getHintText();
                str2 = waitCheckDialog.D();
                cardProductNew = waitCheckDialog.getCardProduct();
                gVar4 = waitCheckDialog.getOnDescClick();
                gVar5 = waitCheckDialog.C(this.a);
                gVar6 = waitCheckDialog.getOnSave();
                gVar = waitCheckDialog.getOnClickClose();
            } else {
                gVar = null;
                str8 = null;
                str2 = null;
                cardProductNew = null;
                gVar4 = null;
                gVar5 = null;
                gVar6 = null;
            }
            if (cardProductNew != null) {
                String cardNameCn = cardProductNew.getCardNameCn();
                CharSequence cardAvgPrice = cardProductNew.getCardAvgPrice();
                String cardSubName = cardProductNew.getCardSubName();
                String cardVerRarity = cardProductNew.getCardVerRarity();
                CharSequence cardMinPrice = cardProductNew.getCardMinPrice();
                str7 = cardVerRarity;
                charSequence2 = cardAvgPrice;
                gVar2 = gVar4;
                str4 = cardProductNew.getCardVersionNum();
                str6 = str8;
                str = cardNameCn;
                gVar7 = gVar5;
                e.t.j.h.g gVar8 = gVar6;
                str5 = cardProductNew.getCardVersionImage();
                str3 = cardSubName;
                charSequence = cardMinPrice;
                gVar3 = gVar8;
            } else {
                str6 = str8;
                gVar2 = gVar4;
                str = null;
                str3 = null;
                str4 = null;
                charSequence = null;
                charSequence2 = null;
                str7 = null;
                gVar3 = gVar6;
                str5 = null;
                gVar7 = gVar5;
            }
        } else {
            gVar = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            gVar2 = null;
            charSequence = null;
            charSequence2 = null;
            gVar3 = null;
            str6 = null;
            str7 = null;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar7);
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            e.t.j.g.e0.F(this.t, gVar);
            TextViewBindingAdapter.setText(this.u, str2);
            TextViewBindingAdapter.setText(this.v, str);
            TextViewBindingAdapter.setText(this.w, str3);
            TextViewBindingAdapter.setText(this.x, str4);
            TextViewBindingAdapter.setText(this.y, str7);
            TextViewBindingAdapter.setText(this.f12265f, str6);
            e.t.j.g.e0.F(this.f12267h, gVar3);
            TextViewBindingAdapter.setText(this.f12268i, charSequence2);
            TextViewBindingAdapter.setText(this.f12272m, charSequence);
            e.t.j.g.e0.F(this.p, gVar2);
        }
    }

    @Override // e.l.k.a6
    public void h(@Nullable WaitCheckDialog waitCheckDialog) {
        this.r = waitCheckDialog;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 2L;
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
            h((WaitCheckDialog) obj);
            return true;
        }
        return false;
    }

    private b6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[2], (View) objArr[13], (View) objArr[23], (ConstraintLayout) objArr[14], (LinearLayout) objArr[22], (EditText) objArr[7], (TextView) objArr[15], (TextView) objArr[12], (TextView) objArr[8], (TextView) objArr[17], (TextView) objArr[21], (TextView) objArr[20], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[19], (TextView) objArr[11], (TextView) objArr[16]);
        this.z = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.s = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.t = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.u = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.v = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.w = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.x = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.y = textView5;
        textView5.setTag(null);
        this.f12265f.setTag(null);
        this.f12267h.setTag(null);
        this.f12268i.setTag(null);
        this.f12272m.setTag(null);
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
