package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.reply.TextReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class ReplyMessageHolder extends MessageContentHolder {
    private View line;
    private View originMsgLayout;
    private FrameLayout quoteFrameLayout;
    private TextView replyContentTv;
    private TextView senderNameTv;

    public ReplyMessageHolder(View view) {
        super(view);
        this.senderNameTv = (TextView) view.findViewById(R.id.sender_tv);
        this.replyContentTv = (TextView) view.findViewById(R.id.reply_content_tv);
        this.originMsgLayout = view.findViewById(R.id.origin_msg_abs_layout);
        this.quoteFrameLayout = (FrameLayout) view.findViewById(R.id.quote_frame_layout);
        this.line = view.findViewById(R.id.reply_line);
    }

    private void performMsgAbstract(final ReplyMessageBean replyMessageBean, final int i2) {
        TUIMessageBean originMessageBean = replyMessageBean.getOriginMessageBean();
        TUIReplyQuoteBean replyQuoteBean = replyMessageBean.getReplyQuoteBean();
        if (originMessageBean != null) {
            performQuote(replyQuoteBean, replyMessageBean);
        } else {
            performNotFound(replyQuoteBean, replyMessageBean);
        }
        this.originMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ReplyMessageHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnItemClickListener onItemClickListener = ReplyMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReplyMessageClick(view, i2, replyMessageBean.getOriginMsgId());
                }
            }
        });
    }

    private void performNotFound(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(tUIReplyQuoteBean.getMessageType());
        String defaultAbstract = tUIReplyQuoteBean.getDefaultAbstract();
        if (ChatMessageParser.isFileType(tUIReplyQuoteBean.getMessageType())) {
            defaultAbstract = "";
        }
        TextReplyQuoteBean textReplyQuoteBean = new TextReplyQuoteBean();
        textReplyQuoteBean.setText(msgTypeStr + defaultAbstract);
        TextReplyQuoteView textReplyQuoteView = new TextReplyQuoteView(this.itemView.getContext());
        textReplyQuoteView.onDrawReplyQuote(textReplyQuoteBean);
        textReplyQuoteView.setSelf(replyMessageBean.isSelf());
        this.quoteFrameLayout.removeAllViews();
        this.quoteFrameLayout.addView(textReplyQuoteView);
    }

    private void performQuote(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        Class<? extends TUIReplyQuoteView> replyQuoteViewClass = tUIReplyQuoteBean.getReplyQuoteViewClass();
        if (replyQuoteViewClass != null) {
            TUIReplyQuoteView tUIReplyQuoteView = null;
            try {
                tUIReplyQuoteView = replyQuoteViewClass.getConstructor(Context.class).newInstance(this.itemView.getContext());
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
            if (tUIReplyQuoteView != null) {
                tUIReplyQuoteView.onDrawReplyQuote(tUIReplyQuoteBean);
                this.quoteFrameLayout.removeAllViews();
                this.quoteFrameLayout.addView(tUIReplyQuoteView);
                tUIReplyQuoteView.setSelf(replyMessageBean.isSelf());
            }
        }
    }

    private void setThemeColor(TUIMessageBean tUIMessageBean) {
        Context context = this.itemView.getContext();
        Resources resources = this.itemView.getResources();
        if (!tUIMessageBean.isSelf()) {
            this.originMsgLayout.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_quote_bg_color)));
            this.senderNameTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_quote_text_color)));
            this.replyContentTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_text_color)));
            this.line.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_line_bg_color)));
            return;
        }
        this.originMsgLayout.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_quote_bg_color)));
        this.senderNameTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_quote_text_color)));
        this.replyContentTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_text_color)));
        this.line.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_line_bg_color)));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_reply;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i2) {
        ReplyMessageBean replyMessageBean = (ReplyMessageBean) tUIMessageBean;
        String extra = replyMessageBean.getContentMessageBean().getExtra();
        String originMsgSender = replyMessageBean.getOriginMsgSender();
        TextView textView = this.senderNameTv;
        textView.setText(originMsgSender + Constants.COLON_SEPARATOR);
        FaceManager.handlerEmojiText(this.replyContentTv, extra, false);
        performMsgAbstract(replyMessageBean, i2);
        this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ReplyMessageHolder.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                OnItemClickListener onItemClickListener = ReplyMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i2, tUIMessageBean);
                    return true;
                }
                return true;
            }
        });
        this.originMsgLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ReplyMessageHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                OnItemClickListener onItemClickListener = ReplyMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i2, tUIMessageBean);
                    return true;
                }
                return true;
            }
        });
        setThemeColor(tUIMessageBean);
    }
}
