package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IContactLayout;

/* loaded from: classes3.dex */
public class ContactLayout extends LinearLayout implements IContactLayout {
    private static final String TAG = ContactLayout.class.getSimpleName();
    private ContactListView mContactListView;
    private ContactPresenter presenter;

    public ContactLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LinearLayout.inflate(getContext(), R.layout.contact_layout, this);
        this.mContactListView = (ContactListView) findViewById(R.id.contact_listview);
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IContactLayout
    public ContactListView getContactListView() {
        return this.mContactListView;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public TitleBarLayout getTitleBar() {
        return null;
    }

    public void initDefault() {
        this.mContactListView.setPresenter(this.presenter);
        this.presenter.setContactListView(this.mContactListView);
        this.mContactListView.loadDataSource(4);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public void setParentLayout(Object obj) {
    }

    public void setPresenter(ContactPresenter contactPresenter) {
        this.presenter = contactPresenter;
    }

    public ContactLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ContactLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
