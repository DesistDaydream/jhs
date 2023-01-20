package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import java.util.List;

/* loaded from: classes3.dex */
public class MergeMessageHolder extends MessageContentHolder {
    private LinearLayout mForwardMsgLayout;
    private TextView msgForwardContent;
    private TextView msgForwardTitle;

    public MergeMessageHolder(View view) {
        super(view);
        this.mForwardMsgLayout = (LinearLayout) view.findViewById(R.id.forward_msg_layout);
        this.msgForwardTitle = (TextView) view.findViewById(R.id.msg_forward_title);
        this.msgForwardContent = (TextView) view.findViewById(R.id.msg_forward_content);
        this.mForwardMsgLayout.setClickable(true);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.forward_msg_holder;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i2) {
        if (tUIMessageBean == null) {
            return;
        }
        if (this.isForwardMode) {
            this.msgContentFrame.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            this.statusImage.setVisibility(8);
        } else if (tUIMessageBean.isSelf()) {
            if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                this.msgContentFrame.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
            } else {
                this.msgContentFrame.setBackgroundResource(R.drawable.chat_bubble_self_cavity_bg);
            }
        } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
            this.msgContentFrame.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            FrameLayout frameLayout = this.msgContentFrame;
            frameLayout.setLayoutParams(frameLayout.getLayoutParams());
        } else {
            this.msgContentFrame.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
        }
        final MergeMessageBean mergeMessageBean = (MergeMessageBean) tUIMessageBean;
        String title = mergeMessageBean.getTitle();
        List<String> abstractList = mergeMessageBean.getAbstractList();
        this.msgForwardTitle.setText(title);
        String str = "";
        for (int i3 = 0; i3 < abstractList.size(); i3++) {
            if (i3 > 0) {
                str = str + "\n";
            }
            str = str + abstractList.get(i3);
        }
        this.msgForwardContent.setText(FaceManager.emojiJudge(str));
        if (this.isMultiSelectMode) {
            this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MergeMessageHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = MergeMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i2, mergeMessageBean);
                    }
                }
            });
            return;
        }
        this.mForwardMsgLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MergeMessageHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MergeMessageHolder.this.onItemClickListener.onMessageLongClick(view, i2, tUIMessageBean);
                return true;
            }
        });
        this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MergeMessageHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                TUICore.startActivity("TUIForwardChatActivity", bundle);
            }
        });
    }
}
