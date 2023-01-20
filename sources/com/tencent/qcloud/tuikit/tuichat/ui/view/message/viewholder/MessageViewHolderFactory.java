package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.ICommonMessageAdapter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class MessageViewHolderFactory {
    public static RecyclerView.ViewHolder getInstance(ViewGroup viewGroup, ICommonMessageAdapter iCommonMessageAdapter, int i2) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == -99) {
            return new MessageHeaderHolder(from.inflate(R.layout.loading_progress_bar, viewGroup, false));
        }
        View inflate = from.inflate(R.layout.message_adapter_item_content, viewGroup, false);
        if (i2 == TUIChatService.getInstance().getViewType(TipsMessageBean.class)) {
            inflate = from.inflate(R.layout.message_adapter_item_empty, viewGroup, false);
            viewHolder = new TipsMessageHolder(inflate);
        } else {
            viewHolder = getViewHolder(inflate, i2);
        }
        if (viewHolder == null) {
            viewHolder = new TextMessageHolder(inflate);
        }
        ((MessageBaseHolder) viewHolder).setAdapter(iCommonMessageAdapter);
        return viewHolder;
    }

    private static RecyclerView.ViewHolder getViewHolder(View view, int i2) {
        Class<? extends MessageBaseHolder> messageViewHolderClass = TUIChatService.getInstance().getMessageViewHolderClass(i2);
        if (messageViewHolderClass != null) {
            try {
                return messageViewHolderClass.getConstructor(View.class).newInstance(view);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
