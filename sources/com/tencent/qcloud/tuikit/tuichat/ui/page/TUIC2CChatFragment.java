package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.GlobalConfig;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.List;

/* loaded from: classes3.dex */
public class TUIC2CChatFragment extends TUIBaseChatFragment {
    private static final String TAG = TUIC2CChatFragment.class.getSimpleName();
    private ChatInfo chatInfo;
    private C2CChatPresenter presenter = new C2CChatPresenter();

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public void initView() {
        List<String> officials;
        super.initView();
        C2CChatPresenter c2CChatPresenter = this.presenter;
        if (c2CChatPresenter == null) {
            try {
                getActivity().finish();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        this.chatView.setPresenter(c2CChatPresenter);
        this.presenter.setChatInfo(this.chatInfo);
        this.chatView.setChatInfo(this.chatInfo);
        GlobalConfig globalConfig = this.presenter.globalConfig;
        if (globalConfig == null || (officials = globalConfig.getOfficials()) == null || !officials.contains(this.chatInfo.getId())) {
            return;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.svg_official);
        drawable.setBounds(0, ScreenUtil.dip2px(1.0f), ScreenUtil.dip2px(26.0f), ScreenUtil.dip2px(17.0f));
        this.titleBar.getMiddleTitle().setCompoundDrawablePadding(ScreenUtil.dip2px(6.0f));
        this.titleBar.getMiddleTitle().setCompoundDrawablesRelative(null, null, drawable, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.presenter.initListener();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        ChatInfo chatInfo = (ChatInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.chatInfo = chatInfo;
        if (chatInfo == null) {
            return this.baseView;
        }
        initView();
        return this.baseView;
    }

    public void setPresenter(C2CChatPresenter c2CChatPresenter) {
        this.presenter = c2CChatPresenter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public C2CChatPresenter getPresenter() {
        return this.presenter;
    }
}
