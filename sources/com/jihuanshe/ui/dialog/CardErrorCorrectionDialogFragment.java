package com.jihuanshe.ui.dialog;

import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.repo.ReportRepo;
import com.vector.ext.AnyKt;
import com.vector.util.Res;
import e.n.f;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CardErrorCorrectionDialogFragment extends BaseUploadInfoDialogFragment implements e.l.s.l.b.a {
    @d
    public static final a A = new a(null);
    private final /* synthetic */ e.l.s.l.a.a u = new e.l.s.l.a.a();
    @d
    private final String v;
    @d
    private final String w;
    @d
    private final String x;
    @e
    private Integer y;
    @e
    private String z;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final CardErrorCorrectionDialogFragment a(int i2, @d String str) {
            CardErrorCorrectionDialogFragment cardErrorCorrectionDialogFragment = new CardErrorCorrectionDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.KEY_PARAM_CARD_VERSION_ID, i2);
            bundle.putString(Constants.KEY_PARAM_GAME_KEY, str);
            cardErrorCorrectionDialogFragment.setArguments(bundle);
            return cardErrorCorrectionDialogFragment;
        }
    }

    public CardErrorCorrectionDialogFragment() {
        Res res = Res.a;
        this.v = Res.w(res, R.string.card_choose_error, null, 2, null);
        this.w = Res.w(res, R.string.card_error_content_tip, null, 2, null);
        this.x = Res.w(res, R.string.card_error_correction_pic_tips, null, 2, null);
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment
    @d
    public f<List<String>> K() {
        return ReportRepo.a.c();
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment
    @d
    public String L() {
        return this.w;
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment
    @d
    public String V() {
        return this.v;
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment
    @d
    public String Y() {
        return this.x;
    }

    @Override // e.l.s.l.b.a
    @d
    public e.g.d.a<t1> c(int i2, @d String str, @d String str2, @d List<String> list, @d String str3, @d LifecycleCoroutineScope lifecycleCoroutineScope) {
        return this.u.c(i2, str, str2, list, str3, lifecycleCoroutineScope);
    }

    @Override // com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment
    public void d0(@d ImageErrorInfo imageErrorInfo) {
        Integer num = this.y;
        int intValue = num == null ? 0 : num.intValue();
        String reason = imageErrorInfo.getReason();
        String content = imageErrorInfo.getContent();
        List<String> images = imageErrorInfo.getImages();
        String str = this.z;
        if (str == null) {
            str = "";
        }
        BinderKt.p(BinderKt.j(e.g.d.a.j(c(intValue, reason, content, images, str, LifecycleOwnerKt.getLifecycleScope(this)), null, new CardErrorCorrectionDialogFragment$submit$1(this), 1, null), this, false, 2, null));
    }

    @Override // e.l.q.a.w
    public void y(@e Bundle bundle) {
        this.y = bundle == null ? null : Integer.valueOf(bundle.getInt(Constants.KEY_PARAM_CARD_VERSION_ID));
        this.z = bundle != null ? bundle.getString(Constants.KEY_PARAM_GAME_KEY) : null;
        if (!AnyKt.l(this.y)) {
            String str = this.z;
            if (!(str == null || str.length() == 0)) {
                return;
            }
        }
        dismiss();
    }
}
