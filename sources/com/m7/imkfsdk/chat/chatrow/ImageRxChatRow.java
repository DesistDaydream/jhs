package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.ImageViewHolder;
import com.m7.imkfsdk.chat.model.MoorImageInfoBean;
import com.m7.imkfsdk.utils.GlideUtil;
import com.m7.imkfsdk.view.imageviewer.MoorImagePreview;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class ImageRxChatRow extends BaseChatRow {
    public ImageRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_image_rx, (ViewGroup) null);
            inflate.setTag(new ImageViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        ImageViewHolder imageViewHolder = (ImageViewHolder) baseHolder;
        if (fromToMessage != null) {
            if (fromToMessage.withDrawStatus) {
                imageViewHolder.getWithdrawTextView().setVisibility(0);
                imageViewHolder.getContainer().setVisibility(8);
                return;
            }
            imageViewHolder.getWithdrawTextView().setVisibility(8);
            imageViewHolder.getContainer().setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageViewHolder.getImageView().getLayoutParams();
            int screenWidth = MoorDensityUtil.getScreenWidth(context);
            int screenHeight = MoorDensityUtil.getScreenHeight(context);
            int i3 = screenWidth / 2;
            imageViewHolder.getImageView().setMaxWidth(i3);
            imageViewHolder.getImageView().setMaxHeight(screenHeight / 3);
            layoutParams.width = i3;
            layoutParams.height = -2;
            imageViewHolder.getImageView().setLayoutParams(layoutParams);
            GlideUtil.loadImage(context, fromToMessage.message, imageViewHolder.getImageView());
            imageViewHolder.getImageView().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.ImageRxChatRow.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MoorImageInfoBean moorImageInfoBean = new MoorImageInfoBean();
                    moorImageInfoBean.setFrom(YKFConstants.INVESTIGATE_TYPE_IN).setPath(fromToMessage.message);
                    MoorImagePreview.getInstance().setContext(context).setIndex(0).setImage(moorImageInfoBean).start();
                }
            });
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.IMAGE_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
