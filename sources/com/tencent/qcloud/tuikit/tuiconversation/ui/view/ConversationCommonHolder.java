package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.qcloud.tuicore.GlobalConfig;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.UnreadCountTextView;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;

/* loaded from: classes3.dex */
public class ConversationCommonHolder extends ConversationBaseHolder {
    public TextView atInfoText;
    public ConversationIconView conversationIconView;
    public ImageView disturbView;
    private GlobalConfig globalConfig;
    private Gson gson;
    private boolean isForwardMode;
    public RelativeLayout leftItemLayout;
    public ImageView messageSending;
    public RelativeLayout messageStatusLayout;
    public TextView messageText;
    public ImageView messagefailed;
    public CheckBox multiSelectCheckBox;
    public ImageView officialImage;
    private SharedPreferences sp;
    public TextView timelineText;
    public TextView titleText;
    public UnreadCountTextView unreadText;

    /* loaded from: classes3.dex */
    public static class EmojiData {
        private String emojiText;
        private int end;
        private int start;

        private EmojiData() {
        }

        public String getEmojiText() {
            return this.emojiText;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public void setEmojiText(String str) {
            this.emojiText = str;
        }

        public void setEnd(int i2) {
            this.end = i2;
        }

        public void setStart(int i2) {
            this.start = i2;
        }
    }

    public ConversationCommonHolder(View view) {
        super(view);
        this.isForwardMode = false;
        this.leftItemLayout = (RelativeLayout) this.rootView.findViewById(R.id.item_left);
        this.conversationIconView = (ConversationIconView) this.rootView.findViewById(R.id.conversation_icon);
        this.titleText = (TextView) this.rootView.findViewById(R.id.conversation_title);
        this.officialImage = (ImageView) this.rootView.findViewById(R.id.official_image);
        this.messageText = (TextView) this.rootView.findViewById(R.id.conversation_last_msg);
        this.timelineText = (TextView) this.rootView.findViewById(R.id.conversation_time);
        this.unreadText = (UnreadCountTextView) this.rootView.findViewById(R.id.conversation_unread);
        this.atInfoText = (TextView) this.rootView.findViewById(R.id.conversation_at_msg);
        this.disturbView = (ImageView) this.rootView.findViewById(R.id.not_disturb);
        this.multiSelectCheckBox = (CheckBox) this.rootView.findViewById(R.id.select_checkbox);
        this.messageStatusLayout = (RelativeLayout) this.rootView.findViewById(R.id.message_status_layout);
        this.messagefailed = (ImageView) view.findViewById(R.id.message_status_failed);
        this.messageSending = (ImageView) view.findViewById(R.id.message_status_sending);
        SharedPreferences sharedPreferences = TUIConfig.getAppContext().getSharedPreferences(TUIConfig.COMMON_SP, 0);
        this.sp = sharedPreferences;
        String string = sharedPreferences.getString(TUIConfig.GLOBAL_CONFIG, "");
        this.gson = new Gson();
        if ("".equals(string)) {
            return;
        }
        this.globalConfig = (GlobalConfig) this.gson.n(string, GlobalConfig.class);
    }

    public void layoutVariableViews(ConversationInfo conversationInfo, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x006b  */
    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationBaseHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutViews(com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo r12, int r13) {
        /*
            Method dump skipped, instructions count: 674
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationCommonHolder.layoutViews(com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo, int):void");
    }

    public void setForwardMode(boolean z) {
        this.isForwardMode = z;
    }
}
