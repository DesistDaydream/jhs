package com.m7.imkfsdk.chat.emotion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.m7.imkfsdk.R;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EmotionView extends GridView {
    private static int sEmotionSize;
    private static int sNumColumns;
    private static int sNumRows;
    private static int sPadding;
    private EditText mEditText;

    /* loaded from: classes2.dex */
    public static class EmotionAdapter extends BaseAdapter {
        private Context mContext;
        public List<Emotion> mEmotions;

        public EmotionAdapter(Context context, List<Emotion> list) {
            this.mEmotions = list == null ? new ArrayList<>() : list;
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mEmotions.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.mEmotions.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_vh_emotion_item_layout, viewGroup, false);
            }
            ((ImageView) view.findViewById(R.id.image)).setImageResource(this.mContext.getResources().getIdentifier(((Emotion) getItem(i2)).drawableRes, "drawable", this.mContext.getPackageName()));
            return view;
        }
    }

    public EmotionView(Context context, EditText editText) {
        super(context);
        this.mEditText = editText;
    }

    public static int calSizeForContainEmotion(Context context, int i2, int i3) {
        sPadding = MoorDensityUtil.dp2px(5.0f);
        int dp2px = MoorDensityUtil.dp2px(50.0f);
        sEmotionSize = dp2px;
        int i4 = i2 / dp2px;
        sNumColumns = i4;
        int i5 = i3 / dp2px;
        sNumRows = i5;
        return i4 * i5;
    }

    public void buildEmotions(final List<Emotion> list) {
        setVerticalScrollBarEnabled(false);
        setNumColumns(sNumColumns);
        int i2 = sPadding;
        setPadding(i2, i2, i2, MoorDensityUtil.dp2px(50.0f) + i2);
        setClipToPadding(false);
        setAdapter((ListAdapter) new EmotionAdapter(getContext(), list));
        setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.m7.imkfsdk.chat.emotion.EmotionView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j2) {
                EmotionView.this.mEditText.getEditableText().insert(EmotionView.this.mEditText.getSelectionStart(), EmojiSpanBuilder.buildEmotionSpannable(EmotionView.this.getContext(), ((Emotion) list.get(i3)).text));
            }
        });
    }
}
