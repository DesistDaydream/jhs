package com.jihuanshe.ui.page.im;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.im.ImConversationFragment;
import com.jihuanshe.utils.ImManager;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import e.l.r.i0;
import e.t.a;
import e.t.k.a.f.h;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ImConversationFragment extends TUIConversationFragment {
    @e
    private LinearLayout a;
    @e
    private TextView b;
    @d

    /* renamed from: c */
    private final w f4026c = z.c(new ImConversationFragment$loadingDialog$2(this));

    private final h r() {
        return (h) this.f4026c.getValue();
    }

    public final void s(int i2) {
        if (i2 == 1) {
            ViewKt.n(this.a);
            r().n();
        } else if (i2 == 2) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(Res.w(Res.a, R.string.err_im_kick, null, 2, null));
            }
            ViewKt.I(this.a);
            r().n();
        } else if (i2 == 3) {
            r().W();
        } else if (i2 == 4 || i2 == 5) {
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(Res.w(Res.a, R.string.err_im_connect_fail, null, 2, null));
            }
            ViewKt.I(this.a);
            r().n();
        }
    }

    public static final void t(ImConversationFragment imConversationFragment, View view) {
        if (i0.a.e(a.b())) {
            ImManager.k(ImManager.a, false, 1, null);
        } else {
            e.l.h.j.b.e.e(imConversationFragment, R.string.error_network, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment
    public void initView() {
        super.initView();
        this.mainTitleBar.getMiddleTitle().getPaint().setFakeBoldText(true);
        this.a = (LinearLayout) this.mBaseView.findViewById(R.id.errNoticeRoot);
        this.b = (TextView) this.mBaseView.findViewById(R.id.noticeContentTv);
        LinearLayout linearLayout = this.a;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.b.f.f
                {
                    ImConversationFragment.this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImConversationFragment.t(ImConversationFragment.this, view);
                }
            });
        }
        ImManager.a.h().f(this, new ImConversationFragment$initView$2(this));
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e.g.d.a.h(e.g.d.a.j(FlowKt.c(((e.l.n.c.h) e.l.n.a.d(e.l.n.c.h.class, true, false, false, 60L, true)).a()), null, new ImConversationFragment$onResume$1(this), 1, null), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment
    public void startChatActivity(@e ConversationInfo conversationInfo) {
        Integer valueOf = conversationInfo == null ? null : Integer.valueOf(conversationInfo.getType());
        if (valueOf != null && valueOf.intValue() == 5) {
            return;
        }
        if (valueOf != null && valueOf.intValue() == 7) {
            return;
        }
        if (valueOf != null && valueOf.intValue() == 6) {
            InteractMessageActivityCreator.create().start(getActivity());
        } else {
            super.startChatActivity(conversationInfo);
        }
    }
}
