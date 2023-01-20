package com.tencent.qcloud.tuicore.component.menu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.component.action.PopMenuAction;
import com.tencent.qcloud.tuicore.component.action.PopMenuAdapter;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Menu {
    public static final int MENU_TYPE_CONTACT = 1;
    public static final int MENU_TYPE_CONVERSATION = 2;
    private List<PopMenuAction> mActions = new ArrayList();
    private Activity mActivity;
    private View mAttachView;
    private PopMenuAdapter mMenuAdapter;
    private ListView mMenuList;
    private PopupWindow mMenuWindow;

    public Menu(Activity activity, View view) {
        this.mActivity = activity;
        this.mAttachView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroundAlpha(float f2) {
        WindowManager.LayoutParams attributes = this.mActivity.getWindow().getAttributes();
        attributes.alpha = f2;
        this.mActivity.getWindow().setAttributes(attributes);
        this.mActivity.getWindow().addFlags(2);
    }

    public void hide() {
        this.mMenuWindow.dismiss();
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mMenuWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    public void setMenuAction(List<PopMenuAction> list) {
        this.mActions.clear();
        this.mActions.addAll(list);
    }

    public void show() {
        List<PopMenuAction> list = this.mActions;
        if (list == null || list.size() == 0) {
            return;
        }
        this.mMenuWindow = new PopupWindow(this.mActivity);
        PopMenuAdapter popMenuAdapter = new PopMenuAdapter();
        this.mMenuAdapter = popMenuAdapter;
        popMenuAdapter.setDataSource(this.mActions);
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.pop_menu, (ViewGroup) null);
        this.mMenuWindow.setContentView(inflate);
        ListView listView = (ListView) inflate.findViewById(R.id.conversation_pop_list);
        this.mMenuList = listView;
        listView.setAdapter((ListAdapter) this.mMenuAdapter);
        this.mMenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuicore.component.menu.Menu.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                PopMenuAction popMenuAction = (PopMenuAction) Menu.this.mMenuAdapter.getItem(i2);
                if (popMenuAction == null || popMenuAction.getActionClickListener() == null) {
                    return;
                }
                popMenuAction.getActionClickListener().onActionClick(i2, Menu.this.mActions.get(i2));
            }
        });
        this.mMenuWindow.setWidth(ScreenUtil.dip2px(160.0f));
        this.mMenuWindow.setHeight(-2);
        this.mMenuWindow.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.top_pop));
        this.mMenuWindow.setFocusable(true);
        this.mMenuWindow.setTouchable(true);
        this.mMenuWindow.setOutsideTouchable(true);
        backgroundAlpha(0.5f);
        this.mMenuWindow.showAtLocation(this.mAttachView, 53, ScreenUtil.getPxByDp(15.0f), ScreenUtil.getPxByDp(80.0f));
        this.mMenuWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.qcloud.tuicore.component.menu.Menu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                Menu.this.backgroundAlpha(1.0f);
            }
        });
    }
}
