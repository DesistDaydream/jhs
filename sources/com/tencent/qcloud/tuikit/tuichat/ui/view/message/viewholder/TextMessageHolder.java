package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.OutInject;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class TextMessageHolder extends MessageContentHolder {
    private SelectTextHelper mSelectableTextHelper;
    private final Runnable mShowSelectViewRunnable;
    private TextView msgBodyText;
    private String selectedText;

    public TextMessageHolder(View view) {
        super(view);
        this.mShowSelectViewRunnable = new Runnable() { // from class: e.s.a.b.a.b.b.b.j.a
            {
                TextMessageHolder.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextMessageHolder.this.b();
            }
        };
        this.msgBodyText = (TextView) view.findViewById(R.id.msg_body_tv);
    }

    /* renamed from: a */
    public /* synthetic */ void b() {
        this.mSelectableTextHelper.reset();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i2) {
        boolean handlerEmojiText;
        if (tUIMessageBean instanceof TextMessageBean) {
            final TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
            if (!textMessageBean.isSelf()) {
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_other_msg_text_color)));
            } else {
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_self_msg_text_color)));
            }
            this.msgBodyText.setVisibility(0);
            if (textMessageBean.getText() != null) {
                handlerEmojiText = FaceManager.handlerEmojiText(this.msgBodyText, textMessageBean.getText(), false);
            } else if (!TextUtils.isEmpty(textMessageBean.getExtra())) {
                handlerEmojiText = FaceManager.handlerEmojiText(this.msgBodyText, textMessageBean.getExtra(), false);
            } else {
                handlerEmojiText = FaceManager.handlerEmojiText(this.msgBodyText, TUIChatService.getAppContext().getString(R.string.no_support_msg), false);
            }
            if (this.properties.getChatContextFontSize() != 0) {
                this.msgBodyText.setTextSize(this.properties.getChatContextFontSize());
            }
            if (textMessageBean.isSelf()) {
                if (this.properties.getRightChatContentFontColor() != 0) {
                    this.msgBodyText.setTextColor(this.properties.getRightChatContentFontColor());
                }
            } else if (this.properties.getLeftChatContentFontColor() != 0) {
                this.msgBodyText.setTextColor(this.properties.getLeftChatContentFontColor());
            }
            this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextMessageHolder.1
                {
                    TextMessageHolder.this = this;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return true;
                }
            });
            SelectTextHelper build = new SelectTextHelper.Builder(this.msgBodyText).setCursorHandleColor(TUIChatService.getAppContext().getResources().getColor(R.color.common_color_1)).setCursorHandleSizeInDp(16.0f).setSelectedColor(TUIChatService.getAppContext().getResources().getColor(R.color.select_yellow)).setSelectAll(true).setIsEmoji(handlerEmojiText).setScrollShow(false).setSelectedAllNoPop(true).setMagnifierShow(false).build();
            this.mSelectableTextHelper = build;
            build.setSelectListener(new SelectTextHelper.OnSelectListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextMessageHolder.2
                public PopupWindow window = null;

                {
                    TextMessageHolder.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onClick(View view) {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onClickUrl(String str) {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onDismiss() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onDismissCustomPop() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onLongClick(final View view) {
                    PopupWindow copyWindow = OutInject.getInstance().getRequest().getCopyWindow(view, new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextMessageHolder.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            ((ClipboardManager) view.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", TextMessageHolder.this.selectedText));
                        }
                    });
                    this.window = copyWindow;
                    copyWindow.setOutsideTouchable(false);
                    this.window.showAsDropDown(view, Math.max((view.getMeasuredWidth() - ScreenUtil.dip2px(63.0f)) / 2, 0), -(view.getMeasuredHeight() + ScreenUtil.dip2px(52.0f)));
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onReset() {
                    PopupWindow popupWindow = this.window;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    }
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onScrolling() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onSelectAllShowCustomPop() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
                public void onTextSelected(CharSequence charSequence) {
                    TextMessageHolder.this.selectedText = charSequence.toString();
                    textMessageBean.setSelectText(TextMessageHolder.this.selectedText);
                    TUIChatLog.d("TextMessageHolder", "onTextSelected selectedText = " + TextMessageHolder.this.selectedText);
                    TextMessageHolder textMessageHolder = TextMessageHolder.this;
                    OnItemClickListener onItemClickListener = textMessageHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onTextSelected(textMessageHolder.msgContentFrame, i2, tUIMessageBean);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder, com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void layoutViews(TUIMessageBean tUIMessageBean, int i2) {
        super.layoutViews(tUIMessageBean, i2);
        this.sendingProgress.setVisibility(8);
    }

    public void resetSelectableText() {
        this.msgBodyText.postDelayed(this.mShowSelectViewRunnable, 120L);
    }
}
