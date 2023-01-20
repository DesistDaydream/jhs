package com.m7.imkfsdk.chat.adapter;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.chatrow.BaseChatRow;
import com.m7.imkfsdk.chat.chatrow.BreakTipChatRow;
import com.m7.imkfsdk.chat.chatrow.CardRxChatBox;
import com.m7.imkfsdk.chat.chatrow.ChatRowType;
import com.m7.imkfsdk.chat.chatrow.ChatRowUtils;
import com.m7.imkfsdk.chat.chatrow.FileRxChatRow;
import com.m7.imkfsdk.chat.chatrow.FileTxChatRow;
import com.m7.imkfsdk.chat.chatrow.IChatRow;
import com.m7.imkfsdk.chat.chatrow.IframeRxChatRow;
import com.m7.imkfsdk.chat.chatrow.ImageRxChatRow;
import com.m7.imkfsdk.chat.chatrow.ImageTxChatRow;
import com.m7.imkfsdk.chat.chatrow.InvestigateCancelRxChatRow;
import com.m7.imkfsdk.chat.chatrow.InvestigateChatRow;
import com.m7.imkfsdk.chat.chatrow.InvestigateSuccessTxChatRow;
import com.m7.imkfsdk.chat.chatrow.LogisticsInfoRxChatRow;
import com.m7.imkfsdk.chat.chatrow.LogisticsInfoTxChatRow;
import com.m7.imkfsdk.chat.chatrow.NewCardInfoTxChatRow;
import com.m7.imkfsdk.chat.chatrow.QuickMenuListRxRow;
import com.m7.imkfsdk.chat.chatrow.ReceivedCardInfoRxChatRow;
import com.m7.imkfsdk.chat.chatrow.RichRxChatBow;
import com.m7.imkfsdk.chat.chatrow.RichTxChatBox;
import com.m7.imkfsdk.chat.chatrow.SendCardInfoTxChatRow;
import com.m7.imkfsdk.chat.chatrow.TabQuestionRxRow;
import com.m7.imkfsdk.chat.chatrow.TextRxChatRow;
import com.m7.imkfsdk.chat.chatrow.TextTxChatRow;
import com.m7.imkfsdk.chat.chatrow.TripRxChatRow;
import com.m7.imkfsdk.chat.chatrow.UnknownRxChatRow;
import com.m7.imkfsdk.chat.chatrow.VideoRxChatRow;
import com.m7.imkfsdk.chat.chatrow.VideoTxChatRow;
import com.m7.imkfsdk.chat.chatrow.VoiceRxChatRow;
import com.m7.imkfsdk.chat.chatrow.VoiceTxChatRow;
import com.m7.imkfsdk.chat.chatrow.XbotFormRxChatRow;
import com.m7.imkfsdk.chat.chatrow.XbotFormSubmitTxChatRow;
import com.m7.imkfsdk.chat.listener.ChatListClickListener;
import com.m7.imkfsdk.utils.MediaPlayTools;
import com.moor.imkf.model.entity.FromToMessage;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class ChatAdapter extends BaseAdapter {
    private Context context;
    public View.OnClickListener mOnClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    private List<FromToMessage> messageList;
    public int mVoicePosition = -1;
    private HashMap<Integer, IChatRow> chatRowHashMap = new HashMap<>();

    public ChatAdapter(Context context, List<FromToMessage> list) {
        this.context = context;
        this.messageList = list;
        ChatActivity chatActivity = (ChatActivity) context;
        this.mOnClickListener = new ChatListClickListener(chatActivity, null);
        this.mOnLongClickListener = new ChatListClickListener(chatActivity, null);
        initRowItems();
    }

    public BaseChatRow getBaseChatRow(int i2, boolean z) {
        StringBuilder sb = new StringBuilder("C");
        sb.append(i2);
        if (z) {
            sb.append(ExifInterface.GPS_DIRECTION_TRUE);
        } else {
            sb.append("R");
        }
        return (BaseChatRow) this.chatRowHashMap.get(ChatRowType.fromValue(sb.toString()).getId());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.messageList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public synchronized int getItemViewType(int i2) {
        FromToMessage item;
        item = getItem(i2);
        return getBaseChatRow(ChatRowUtils.getChattingMessageType(item), item.userType.equals("0")).getChatViewType();
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
        if ((r13.when.longValue() - getItem(r11 - 1).when.longValue()) >= 180000) goto L11;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
            r10 = this;
            com.moor.imkf.model.entity.FromToMessage r13 = r10.getItem(r11)
            if (r13 != 0) goto L8
            r11 = 0
            return r11
        L8:
            int r0 = com.m7.imkfsdk.chat.chatrow.ChatRowUtils.getChattingMessageType(r13)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r0.intValue()
            java.lang.String r1 = r13.userType
            java.lang.String r2 = "0"
            boolean r1 = r1.equals(r2)
            com.m7.imkfsdk.chat.chatrow.BaseChatRow r0 = r10.getBaseChatRow(r0, r1)
            android.content.Context r1 = r10.context
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            android.view.View r12 = r0.buildChatView(r1, r12)
            java.lang.Object r1 = r12.getTag()
            com.m7.imkfsdk.chat.holder.BaseHolder r1 = (com.m7.imkfsdk.chat.holder.BaseHolder) r1
            r2 = 1
            r3 = 0
            if (r11 != 0) goto L36
            r4 = 1
            goto L37
        L36:
            r4 = 0
        L37:
            if (r11 == 0) goto L54
            int r5 = r11 + (-1)
            com.moor.imkf.model.entity.FromToMessage r5 = r10.getItem(r5)
            java.lang.Long r6 = r13.when
            long r6 = r6.longValue()
            java.lang.Long r5 = r5.when
            long r8 = r5.longValue()
            long r6 = r6 - r8
            r8 = 180000(0x2bf20, double:8.8932E-319)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 < 0) goto L54
            goto L55
        L54:
            r2 = r4
        L55:
            android.widget.TextView r4 = r1.getChattingTime()
            if (r4 == 0) goto L99
            if (r2 == 0) goto L88
            android.widget.TextView r2 = r1.getChattingTime()
            r2.setVisibility(r3)
            android.widget.TextView r2 = r1.getChattingTime()
            java.lang.Long r3 = r13.when
            long r3 = r3.longValue()
            r5 = 3
            android.content.Context r6 = r10.context
            java.lang.String r3 = com.m7.imkfsdk.utils.DateUtil.getDateString(r3, r5, r6)
            java.lang.String r3 = r3.trim()
            r2.setText(r3)
            android.widget.TextView r2 = r1.getChattingTime()
            r3 = 2
            r4 = 25
            r5 = 6
            r2.setPadding(r5, r3, r5, r4)
            goto L99
        L88:
            android.widget.TextView r2 = r1.getChattingTime()
            r4 = 8
            r2.setVisibility(r4)
            android.widget.TextView r2 = r1.getChattingTime()
            r4 = 0
            r2.setShadowLayer(r4, r4, r4, r3)
        L99:
            android.content.Context r2 = r10.context
            r0.buildChattingBaseData(r2, r1, r13, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.chat.adapter.ChatAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return ChatRowType.values().length;
    }

    public void initRowItems() {
        this.chatRowHashMap.put(1, new TextRxChatRow(1));
        this.chatRowHashMap.put(2, new TextTxChatRow(2));
        this.chatRowHashMap.put(3, new ImageRxChatRow(3));
        this.chatRowHashMap.put(4, new ImageTxChatRow(4));
        this.chatRowHashMap.put(5, new VoiceRxChatRow(5));
        this.chatRowHashMap.put(6, new VoiceTxChatRow(6));
        this.chatRowHashMap.put(7, new InvestigateChatRow(7));
        this.chatRowHashMap.put(8, new FileRxChatRow(8));
        this.chatRowHashMap.put(9, new FileTxChatRow(9));
        this.chatRowHashMap.put(10, new IframeRxChatRow(10));
        this.chatRowHashMap.put(11, new BreakTipChatRow(11));
        this.chatRowHashMap.put(12, new TripRxChatRow(12));
        this.chatRowHashMap.put(13, new RichRxChatBow(13));
        this.chatRowHashMap.put(14, new RichTxChatBox(14));
        this.chatRowHashMap.put(15, new CardRxChatBox(15));
        this.chatRowHashMap.put(16, new VideoTxChatRow(16));
        this.chatRowHashMap.put(17, new VideoRxChatRow(17));
        this.chatRowHashMap.put(18, new LogisticsInfoRxChatRow(18));
        this.chatRowHashMap.put(19, new LogisticsInfoTxChatRow(19));
        this.chatRowHashMap.put(20, new NewCardInfoTxChatRow(20));
        this.chatRowHashMap.put(21, new SendCardInfoTxChatRow(21));
        this.chatRowHashMap.put(22, new ReceivedCardInfoRxChatRow(22));
        this.chatRowHashMap.put(23, new InvestigateCancelRxChatRow(23));
        this.chatRowHashMap.put(24, new InvestigateSuccessTxChatRow(24));
        this.chatRowHashMap.put(25, new TabQuestionRxRow(25));
        this.chatRowHashMap.put(26, new XbotFormRxChatRow(26));
        this.chatRowHashMap.put(27, new XbotFormSubmitTxChatRow(27));
        this.chatRowHashMap.put(28, new QuickMenuListRxRow(28));
        this.chatRowHashMap.put(100, new UnknownRxChatRow(100));
    }

    public void onPause() {
        this.mVoicePosition = -1;
        MediaPlayTools.getInstance().stop();
    }

    public void setMessageList(List<FromToMessage> list) {
        this.messageList = list;
    }

    public void setVoicePosition(int i2) {
        this.mVoicePosition = i2;
    }

    @Override // android.widget.Adapter
    public synchronized FromToMessage getItem(int i2) {
        return this.messageList.get(i2);
    }
}
