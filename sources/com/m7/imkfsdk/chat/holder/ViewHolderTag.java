package com.m7.imkfsdk.chat.holder;

import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.NewCardInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ViewHolderTag {
    public String _id;
    public String current;
    public FromToMessage detail;
    public VoiceViewHolder holder;
    public NewCardInfo newCardInfo;
    public Object obj;
    public OrderInfoBean orderInfoBean;
    public int position;
    public boolean receive;
    public int rowType;
    public ArrayList<String> tabquestions;
    public String tabtitle;
    public String target;
    public int type;
    public boolean voipcall;

    /* loaded from: classes2.dex */
    public static class TagType {
        public static final int TAG_CLICK_LOGISTICS_PROGERSS_MORE = 13;
        public static final int TAG_CLICK_LOGISTICS_RX_CARD = 14;
        public static final int TAG_CLICK_LOGISTICS_RX_ITEM = 10;
        public static final int TAG_CLICK_LOGISTICS_RX_MORE = 11;
        public static final int TAG_CLICK_LOGISTICS_RX_SHOP = 12;
        public static final int TAG_CLICK_NEW_CARD = 9;
        public static final int TAG_CLICK_SHOW_INVESTIGATECANCEL = 15;
        public static final int TAG_CLICK_SHOW_TAB_QUESTIONMORE = 16;
        public static final int TAG_PREVIEW = 0;
        public static final int TAG_RESEND_MSG = 4;
        public static final int TAG_SEND_MSG = 7;
        public static final int TAG_SEND_NEW_CARD = 8;
        public static final int TAG_VIEW_CONFERENCE = 5;
        public static final int TAG_VIEW_FILE = 1;
        public static final int TAG_VIEW_PICTURE = 3;
        public static final int TAG_VOICE = 2;
        public static final int TAG_VOIP_CALL = 6;
    }

    public static ViewHolderTag createObjectTag(Object obj, int i2) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.type = i2;
        viewHolderTag.obj = obj;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(FromToMessage fromToMessage, int i2, int i3) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.position = i3;
        viewHolderTag.type = i2;
        viewHolderTag.detail = fromToMessage;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(String str, ArrayList<String> arrayList, int i2) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.type = i2;
        viewHolderTag.tabquestions = arrayList;
        viewHolderTag.tabtitle = str;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(String str, int i2) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.type = i2;
        viewHolderTag.target = str;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(String str, String str2, int i2) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.type = i2;
        viewHolderTag._id = str2;
        viewHolderTag.target = str;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(String str, String str2, OrderInfoBean orderInfoBean, int i2) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.type = i2;
        viewHolderTag.current = str;
        viewHolderTag._id = str2;
        viewHolderTag.orderInfoBean = orderInfoBean;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(FromToMessage fromToMessage, int i2, int i3, int i4, boolean z) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.position = i3;
        viewHolderTag.type = i2;
        viewHolderTag.rowType = i4;
        viewHolderTag.detail = fromToMessage;
        viewHolderTag.receive = z;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(FromToMessage fromToMessage, int i2, int i3, int i4, boolean z, VoiceViewHolder voiceViewHolder) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.position = i3;
        viewHolderTag.type = i2;
        viewHolderTag.rowType = i4;
        viewHolderTag.detail = fromToMessage;
        viewHolderTag.receive = z;
        viewHolderTag.holder = voiceViewHolder;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(FromToMessage fromToMessage, int i2) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.position = i2;
        viewHolderTag.detail = fromToMessage;
        viewHolderTag.type = 0;
        return viewHolderTag;
    }

    public static ViewHolderTag createTag(FromToMessage fromToMessage, int i2, int i3, boolean z) {
        ViewHolderTag viewHolderTag = new ViewHolderTag();
        viewHolderTag.position = i3;
        viewHolderTag.detail = fromToMessage;
        viewHolderTag.type = i2;
        viewHolderTag.voipcall = z;
        return viewHolderTag;
    }
}
