package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuicore.component.gatherimage.SynthesizedImageView;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationIconPresenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationIconView extends RelativeLayout {
    private static final int icon_size = ScreenUtil.getPxByDp(50.0f);
    private ImageView mIconView;
    private ConversationIconPresenter presenter;

    public ConversationIconView(Context context) {
        super(context);
        init();
    }

    private void fillConversationUrlForGroup(final ConversationInfo conversationInfo) {
        if (conversationInfo.getIconUrlList() != null && conversationInfo.getIconUrlList().size() != 0) {
            setIconUrls(conversationInfo.getIconUrlList(), conversationInfo.getConversationId());
        } else {
            ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationIconView.2
                @Override // java.lang.Runnable
                public void run() {
                    String groupConversationAvatar = ImageUtil.getGroupConversationAvatar(conversationInfo.getConversationId());
                    if (TextUtils.isEmpty(groupConversationAvatar)) {
                        ConversationIconView.this.fillFaceUrlList(conversationInfo.getId(), conversationInfo);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(groupConversationAvatar);
                    conversationInfo.setIconUrlList(arrayList);
                    ConversationIconView.this.setIconUrls(arrayList, conversationInfo.getConversationId());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillFaceUrlList(String str, final ConversationInfo conversationInfo) {
        clearImage();
        this.presenter.getGroupMemberIconList(str, new IUIKitCallback<List<Object>>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationIconView.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<Object> list) {
                conversationInfo.setIconUrlList(list);
                ConversationIconView.this.setIconUrls(list, conversationInfo.getConversationId());
            }
        });
    }

    private void init() {
        RelativeLayout.inflate(getContext(), R.layout.profile_icon_view, this);
        ImageView imageView = (ImageView) findViewById(R.id.profile_icon);
        this.mIconView = imageView;
        ((SynthesizedImageView) imageView).defaultImage(R.drawable.default_user_icon);
        this.presenter = new ConversationIconPresenter();
    }

    public void clearImage() {
        ImageView imageView = this.mIconView;
        if (imageView instanceof SynthesizedImageView) {
            ((SynthesizedImageView) imageView).clear();
        }
    }

    public void setBitmapResId(int i2) {
        this.mIconView.setImageBitmap(ImageUtil.toRoundBitmap(((BitmapDrawable) getContext().getResources().getDrawable(i2)).getBitmap()));
    }

    public void setConversation(ConversationInfo conversationInfo) {
        ImageView imageView = this.mIconView;
        if (imageView instanceof SynthesizedImageView) {
            ((SynthesizedImageView) imageView).setImageId(conversationInfo.getConversationId());
            if (conversationInfo.isGroup()) {
                fillConversationUrlForGroup(conversationInfo);
            } else {
                setIconUrls(conversationInfo.getIconUrlList(), conversationInfo.getConversationId());
            }
        }
    }

    public void setDefaultImageResId(int i2) {
        this.mIconView.setImageBitmap(((BitmapDrawable) getContext().getResources().getDrawable(i2)).getBitmap());
    }

    public void setIconUrls(final List<Object> list, final String str) {
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationIconView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ConversationIconView.this.mIconView instanceof SynthesizedImageView) {
                    ((SynthesizedImageView) ConversationIconView.this.mIconView).displayImage(list).load(str);
                }
            }
        });
    }

    public void setRadius(int i2) {
        ImageView imageView = this.mIconView;
        if (imageView instanceof SynthesizedImageView) {
            ((SynthesizedImageView) imageView).setRadius(i2);
        }
    }

    public ConversationIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ConversationIconView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
