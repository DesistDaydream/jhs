package com.jihuanshe.ui.page.im;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CommonReportDialog;
import com.jihuanshe.ui.dialog.UseDialog;
import com.jihuanshe.ui.page.im.ImChatFragment;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.utils.ImManager;
import com.tencent.qcloud.tuicore.GlobalConfig;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.ui.page.MorePopupWindow;
import com.tencent.qcloud.tuikit.tuichat.ui.page.TUIC2CChatFragment;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import e.l.m.b;
import e.l.r.i0;
import e.t.a;
import e.t.k.a.f.h;
import h.r0;
import h.t1;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class ImChatFragment extends TUIC2CChatFragment {
    @e
    private LinearLayout a;
    @e
    private TextView b;
    @d

    /* renamed from: c */
    private final w f4025c = z.c(new ImChatFragment$loadingDialog$2(this));

    private final h q() {
        return (h) this.f4025c.getValue();
    }

    public final void r(int i2) {
        if (i2 == 1) {
            if (b.f14084c.x()) {
                ViewKt.I(this.chatView.getNoticeLayout());
            }
            ViewKt.n(this.a);
            q().n();
        } else if (i2 == 2) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(Res.w(Res.a, R.string.err_im_kick, null, 2, null));
            }
            ViewKt.I(this.a);
            ViewKt.n(this.chatView.getNoticeLayout());
            q().n();
        } else if (i2 == 3) {
            q().W();
        } else if (i2 == 4 || i2 == 5) {
            ViewKt.n(this.chatView.getNoticeLayout());
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(Res.w(Res.a, R.string.err_im_connect_fail, null, 2, null));
            }
            ViewKt.I(this.a);
            q().n();
        }
    }

    public static final void s(ImChatFragment imChatFragment, View view) {
        try {
            Result.a aVar = Result.Companion;
            SellerDetailActivityCreator.create(Integer.valueOf(Integer.parseInt(imChatFragment.getChatInfo().getId())), null).start(imChatFragment.getActivity());
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }

    public static final void t(ImChatFragment imChatFragment, View view) {
        new MorePopupWindow(view.getContext(), new MorePopupWindow.OnClickPosListener() { // from class: e.l.q.b.f.b
            {
                ImChatFragment.this = imChatFragment;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.MorePopupWindow.OnClickPosListener
            public final void onClick(int i2) {
                ImChatFragment.u(ImChatFragment.this, i2);
            }
        }).showAsDropDown(view, -ScreenUtil.dip2px(40.0f), 0);
    }

    public static final void u(ImChatFragment imChatFragment, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            new CommonReportDialog(Integer.parseInt(imChatFragment.getChatInfo().getId()), imChatFragment.requireActivity()).y();
            return;
        }
        UseDialog useDialog = new UseDialog(imChatFragment.requireActivity());
        Res res = Res.a;
        useDialog.setContent(Res.w(res, R.string.ban_confirm, null, 2, null));
        useDialog.setRightButtonText(Res.w(res, R.string.common_confirm, null, 2, null));
        useDialog.setOnClickRightButton(new ImChatFragment$initView$2$1$1$1(imChatFragment, useDialog));
        useDialog.y();
    }

    public static final void v(View view) {
        b.f14084c.C();
    }

    public static final void w(ImChatFragment imChatFragment, View view) {
        if (i0.a.e(a.b())) {
            ImManager.k(ImManager.a, false, 1, null);
        } else {
            e.l.h.j.b.e.e(imChatFragment, R.string.error_network, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIC2CChatFragment, com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public void initView() {
        String imNotice;
        super.initView();
        this.titleBar.getMiddleTitle().getPaint().setFakeBoldText(true);
        this.titleBar.getMiddleTitle().setOnClickListener(new View.OnClickListener() { // from class: e.l.q.b.f.c
            {
                ImChatFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImChatFragment.s(ImChatFragment.this, view);
            }
        });
        this.titleBar.setOnRightClickListener(new View.OnClickListener() { // from class: e.l.q.b.f.d
            {
                ImChatFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImChatFragment.t(ImChatFragment.this, view);
            }
        });
        if (getPresenter() == null) {
            return;
        }
        GlobalConfig globalConfig = getPresenter().globalConfig;
        if (globalConfig != null && (imNotice = globalConfig.getImNotice()) != null) {
            if (!(imNotice.length() == 0)) {
                if (b.f14084c.x()) {
                    ViewKt.I(this.chatView.getNoticeLayout());
                }
                int r3 = StringsKt__StringsKt.r3(imNotice, "“官方”", 0, false, 6, null);
                if (r3 >= 0) {
                    Drawable q = Res.q(Res.a, R.drawable.svg_official, null, 2, null);
                    q.setBounds(0, ScreenUtil.dip2px(1.0f), ScreenUtil.dip2px(26.0f), ScreenUtil.dip2px(17.0f));
                    TextView content = this.chatView.getNoticeLayout().getContent();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(imNotice);
                    spannableStringBuilder.setSpan(new ImageSpan(q), r3, r3 + 4, 17);
                    t1 t1Var = t1.a;
                    content.setText(spannableStringBuilder);
                } else {
                    this.chatView.getNoticeLayout().getContent().setText(imNotice);
                }
                this.chatView.getNoticeLayout().setOnCloseListener(e.l.q.b.f.e.a);
            }
        }
        this.a = (LinearLayout) this.baseView.findViewById(R.id.errNoticeRoot);
        this.b = (TextView) this.baseView.findViewById(R.id.noticeContentTv);
        LinearLayout linearLayout = this.a;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.b.f.a
                {
                    ImChatFragment.this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImChatFragment.w(ImChatFragment.this, view);
                }
            });
        }
        ImManager.a.h().f(this, new ImChatFragment$initView$5(this));
    }
}
