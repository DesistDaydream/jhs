package com.tencent.qcloud.tuikit.tuiconversation.ui.page;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.effective.android.panel.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.action.PopActionClickListener;
import com.tencent.qcloud.tuicore.component.action.PopDialogAdapter;
import com.tencent.qcloud.tuicore.component.action.PopMenuAction;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.menu.Menu;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter;
import com.tencent.qcloud.tuikit.tuiconversation.setting.ConversationLayoutSetting;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationLayout;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TUIConversationFragment extends BaseFragment {
    public View mBaseView;
    public ConversationLayout mConversationLayout;
    private List<PopMenuAction> mConversationPopActions = new ArrayList();
    private PopDialogAdapter mConversationPopAdapter;
    private ListView mConversationPopList;
    private PopupWindow mConversationPopWindow;
    public TitleBarLayout mainTitleBar;
    private Menu menu;
    private ConversationPresenter presenter;

    private void initMenuAction() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.btn_height);
        this.mainTitleBar.getLeftIcon().setMaxHeight(dimensionPixelSize);
        this.mainTitleBar.getLeftIcon().setMaxWidth(dimensionPixelSize);
        this.mainTitleBar.getRightIcon().setMaxHeight(dimensionPixelSize);
        this.mainTitleBar.getRightIcon().setMaxWidth(dimensionPixelSize);
        this.mainTitleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TUIConversationFragment.this.menu == null) {
                    return;
                }
                if (TUIConversationFragment.this.menu.isShowing()) {
                    TUIConversationFragment.this.menu.hide();
                } else {
                    TUIConversationFragment.this.menu.show();
                }
            }
        });
    }

    private void initPopMenuAction() {
        ArrayList arrayList = new ArrayList();
        new PopMenuAction();
        PopMenuAction popMenuAction = new PopMenuAction();
        popMenuAction.setActionClickListener(new PopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.5
            @Override // com.tencent.qcloud.tuicore.component.action.PopActionClickListener
            public void onActionClick(int i2, Object obj) {
                TUIConversationFragment.this.mConversationLayout.deleteConversation((ConversationInfo) obj);
            }
        });
        popMenuAction.setActionName(getResources().getString(R.string.chat_delete));
        arrayList.add(popMenuAction);
        this.mConversationPopActions.clear();
        this.mConversationPopActions.addAll(arrayList);
    }

    private void setContactTitleBar() {
        this.mainTitleBar.setTitle("消息", ITitleBarLayout.Position.MIDDLE);
        this.mainTitleBar.getLeftGroup().setVisibility(8);
        this.mainTitleBar.getRightGroup().setVisibility(8);
        this.mainTitleBar.getRightIcon().setImageResource(17301555);
        setConversationMenu();
    }

    private void setConversationMenu() {
        this.menu = new Menu(getActivity(), this.mainTitleBar);
        PopActionClickListener popActionClickListener = new PopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.4
            @Override // com.tencent.qcloud.tuicore.component.action.PopActionClickListener
            public void onActionClick(int i2, Object obj) {
                PopMenuAction popMenuAction = (PopMenuAction) obj;
                TUIConversationFragment.this.menu.hide();
            }
        };
        ArrayList arrayList = new ArrayList();
        PopMenuAction popMenuAction = new PopMenuAction();
        popMenuAction.setActionName("开始聊天");
        popMenuAction.setActionClickListener(popActionClickListener);
        popMenuAction.setIconResId(R.drawable.create_c2c);
        arrayList.add(popMenuAction);
        this.menu.setMenuAction(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showItemPopMenu(View view, final ConversationInfo conversationInfo) {
        List<PopMenuAction> list = this.mConversationPopActions;
        if (list == null || list.size() == 0) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.conversation_pop_menu_layout, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.pop_menu_list);
        this.mConversationPopList = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                PopMenuAction popMenuAction = (PopMenuAction) TUIConversationFragment.this.mConversationPopActions.get(i2);
                if (popMenuAction.getActionClickListener() != null) {
                    popMenuAction.getActionClickListener().onActionClick(i2, conversationInfo);
                }
                TUIConversationFragment.this.mConversationPopWindow.dismiss();
                TUIConversationFragment.this.restoreConversationItemBackground();
            }
        });
        for (int i2 = 0; i2 < this.mConversationPopActions.size(); i2++) {
            PopMenuAction popMenuAction = this.mConversationPopActions.get(i2);
            if (conversationInfo.isTop()) {
                if (popMenuAction.getActionName().equals(getResources().getString(R.string.chat_top))) {
                    popMenuAction.setActionName(getResources().getString(R.string.quit_chat_top));
                }
            } else if (popMenuAction.getActionName().equals(getResources().getString(R.string.quit_chat_top))) {
                popMenuAction.setActionName(getResources().getString(R.string.chat_top));
            }
        }
        PopDialogAdapter popDialogAdapter = new PopDialogAdapter();
        this.mConversationPopAdapter = popDialogAdapter;
        this.mConversationPopList.setAdapter((ListAdapter) popDialogAdapter);
        this.mConversationPopAdapter.setDataSource(this.mConversationPopActions);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        this.mConversationPopWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.mConversationPopWindow.setOutsideTouchable(true);
        this.mConversationPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.7
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                TUIConversationFragment.this.restoreConversationItemBackground();
            }
        });
        int width = view.getWidth() / 2;
        int i3 = (-view.getHeight()) / 3;
        int dip2px = ScreenUtil.dip2px(45.0f) * 3;
        if (i3 + dip2px + view.getY() + view.getHeight() > this.mConversationLayout.getBottom()) {
            i3 -= dip2px;
        }
        this.mConversationPopWindow.showAsDropDown(view, width, i3, BadgeDrawable.r);
    }

    public void initView() {
        this.mConversationLayout = (ConversationLayout) this.mBaseView.findViewById(R.id.conversation_layout);
        int identifier = getResources().getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        TitleBarLayout titleBarLayout = (TitleBarLayout) this.mBaseView.findViewById(R.id.titleBar);
        this.mainTitleBar = titleBarLayout;
        titleBarLayout.setPadding(0, dimensionPixelSize, 0, 0);
        ConversationPresenter conversationPresenter = new ConversationPresenter();
        this.presenter = conversationPresenter;
        conversationPresenter.setConversationListener();
        this.mConversationLayout.setPresenter(this.presenter);
        this.mConversationLayout.initDefault();
        ConversationLayoutSetting.customizeConversation(this.mConversationLayout);
        this.mConversationLayout.getConversationList().setOnItemClickListener(new ConversationListLayout.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.1
            @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout.OnItemClickListener
            public void onItemClick(View view, int i2, ConversationInfo conversationInfo) {
                TUIConversationFragment.this.startChatActivity(conversationInfo);
            }
        });
        this.mConversationLayout.getConversationList().setOnItemLongClickListener(new ConversationListLayout.OnItemLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIConversationFragment.2
            @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout.OnItemLongClickListener
            public void OnItemLongClick(View view, int i2, ConversationInfo conversationInfo) {
                TUIConversationFragment.this.showItemPopMenu(view, conversationInfo);
            }
        });
        initMenuAction();
        setContactTitleBar();
        initPopMenuAction();
        restoreConversationItemBackground();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        this.mBaseView = layoutInflater.inflate(R.layout.conversation_fragment, viewGroup, false);
        initView();
        return this.mBaseView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter.isError) {
            conversationPresenter.loadConversation(0L);
        }
    }

    public void restoreConversationItemBackground() {
        if (this.mConversationLayout.getConversationList().getAdapter() == null || !this.mConversationLayout.getConversationList().getAdapter().isClick()) {
            return;
        }
        this.mConversationLayout.getConversationList().getAdapter().setClick(false);
        this.mConversationLayout.getConversationList().getAdapter().notifyItemChanged(this.mConversationLayout.getConversationList().getAdapter().getCurrentPosition());
    }

    public void startChatActivity(ConversationInfo conversationInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(TUIConstants.TUIChat.CHAT_TYPE, conversationInfo.isGroup() ? 2 : 1);
        bundle.putString("chatId", conversationInfo.getId());
        bundle.putString(TUIConstants.TUIChat.CHAT_NAME, conversationInfo.getTitle());
        if (conversationInfo.getDraft() != null) {
            bundle.putString(TUIConstants.TUIChat.DRAFT_TEXT, conversationInfo.getDraft().getDraftText());
            bundle.putLong(TUIConstants.TUIChat.DRAFT_TIME, conversationInfo.getDraft().getDraftTime());
        }
        bundle.putBoolean(TUIConstants.TUIChat.IS_TOP_CHAT, conversationInfo.isTop());
        if (conversationInfo.isGroup()) {
            bundle.putString(TUIConstants.TUIChat.FACE_URL, conversationInfo.getIconPath());
            bundle.putString(TUIConstants.TUIChat.GROUP_TYPE, conversationInfo.getGroupType());
            bundle.putSerializable(TUIConstants.TUIChat.AT_INFO_LIST, (Serializable) conversationInfo.getGroupAtInfoList());
        }
        TUICore.startActivity(TUIConstants.TUIChat.CUSTOM_C2C_CHAT_ACTIVITY_NAME, bundle);
    }
}
