package com.tencent.qcloud.tuikit.tuichat.ui.view.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TIMMentionEditText extends EditText {
    public static final String TIM_MENTION_TAG = "@";
    public static final String TIM_MENTION_TAG_FULL = "＠";
    private boolean mIsSelected;
    private Range mLastSelectedRange;
    private OnMentionInputListener mOnMentionInputListener;
    private List<Range> mRangeArrayList;
    private Map<String, String> mentionList;
    private List<String> mentionTagList;

    /* loaded from: classes3.dex */
    public class HackInputConnection extends InputConnectionWrapper {
        private EditText editText;

        public HackInputConnection(InputConnection inputConnection, boolean z, TIMMentionEditText tIMMentionEditText) {
            super(inputConnection, z);
            this.editText = tIMMentionEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            if (i2 == 1 && i3 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i2, i3);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                int selectionStart = this.editText.getSelectionStart();
                Range rangeOfClosestMentionString = TIMMentionEditText.this.getRangeOfClosestMentionString(selectionStart, this.editText.getSelectionEnd());
                if (rangeOfClosestMentionString == null) {
                    TIMMentionEditText.this.mIsSelected = false;
                    return super.sendKeyEvent(keyEvent);
                } else if (TIMMentionEditText.this.mIsSelected || selectionStart == rangeOfClosestMentionString.from) {
                    TIMMentionEditText.this.mIsSelected = false;
                    return super.sendKeyEvent(keyEvent);
                } else {
                    TIMMentionEditText.this.mIsSelected = true;
                    TIMMentionEditText.this.mLastSelectedRange = rangeOfClosestMentionString;
                    setSelection(rangeOfClosestMentionString.to, rangeOfClosestMentionString.from);
                    sendKeyEvent(new KeyEvent(0, 67));
                    return true;
                }
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class MentionTextWatcher implements TextWatcher {
        private MentionTextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (i4 == 1 && !TextUtils.isEmpty(charSequence) && TIMMentionEditText.this.hasFocus()) {
                char charAt = charSequence.toString().charAt(i2);
                for (String str : TIMMentionEditText.this.mentionTagList) {
                    if (str.equals(String.valueOf(charAt)) && TIMMentionEditText.this.mOnMentionInputListener != null) {
                        TIMMentionEditText.this.mOnMentionInputListener.onMentionCharacterInput(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnMentionInputListener {
        void onMentionCharacterInput(String str);
    }

    /* loaded from: classes3.dex */
    public class Range {
        public int from;
        public int to;

        public Range(int i2, int i3) {
            this.from = i2;
            this.to = i3;
        }

        public boolean contains(int i2, int i3) {
            return this.from <= i2 && this.to >= i3;
        }

        public int getAnchorPosition(int i2) {
            int i3 = this.from;
            int i4 = this.to;
            return (i2 - i3) - (i4 - i2) >= 0 ? i4 : i3;
        }

        public boolean isEqual(int i2, int i3) {
            int i4 = this.from;
            return (i4 == i2 && this.to == i3) || (i4 == i3 && this.to == i2);
        }

        public boolean isWrappedBy(int i2, int i3) {
            int i4 = this.from;
            return (i2 > i4 && i2 < this.to) || (i3 > i4 && i3 < this.to);
        }
    }

    public TIMMentionEditText(Context context) {
        super(context);
        this.mentionTagList = new ArrayList();
        this.mRangeArrayList = new ArrayList();
        this.mentionList = new HashMap();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range getRangeOfClosestMentionString(int i2, int i3) {
        List<Range> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (Range range : list) {
            if (range.contains(i2, i3)) {
                return range;
            }
        }
        return null;
    }

    private Range getRangeOfNearbyMentionString(int i2, int i3) {
        List<Range> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (Range range : list) {
            if (range.isWrappedBy(i2, i3)) {
                return range;
            }
        }
        return null;
    }

    private void init() {
        setInputType(262144);
        setSingleLine(false);
        setMaxLines(5);
        setHorizontallyScrolling(false);
        this.mentionTagList.clear();
        this.mentionTagList.add(TIM_MENTION_TAG);
        this.mentionTagList.add(TIM_MENTION_TAG_FULL);
        addTextChangedListener(new MentionTextWatcher());
    }

    private void setMentionStringRange() {
        updateMentionList();
        this.mIsSelected = false;
        List<Range> list = this.mRangeArrayList;
        if (list != null) {
            list.clear();
        }
        Editable text = getText();
        if (text == null || TextUtils.isEmpty(text.toString())) {
            return;
        }
        String obj = text.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        for (String str : this.mentionList.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                int i2 = 0;
                while (true) {
                    int indexOf = obj.indexOf(str, i2);
                    if (indexOf == -1) {
                        break;
                    }
                    int length = str.length() + indexOf;
                    this.mRangeArrayList.add(new Range(indexOf, length));
                    i2 = length;
                }
            }
        }
    }

    private void updateMentionList() {
        Editable text;
        if (this.mentionList == null || (text = getText()) == null) {
            return;
        }
        String obj = text.toString();
        if (TextUtils.isEmpty(obj)) {
            this.mentionList.clear();
        }
        Iterator it = new ArrayList(this.mentionList.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!obj.contains(str)) {
                this.mentionList.remove(str);
            }
        }
    }

    public List<String> getMentionIdList() {
        return new ArrayList(this.mentionList.values());
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new HackInputConnection(super.onCreateInputConnection(editorInfo), true, this);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        Range range = this.mLastSelectedRange;
        if (range == null || !range.isEqual(i2, i3)) {
            Range rangeOfClosestMentionString = getRangeOfClosestMentionString(i2, i3);
            if (rangeOfClosestMentionString != null && rangeOfClosestMentionString.to == i3) {
                this.mIsSelected = false;
            }
            Range rangeOfNearbyMentionString = getRangeOfNearbyMentionString(i2, i3);
            if (rangeOfNearbyMentionString == null) {
                return;
            }
            if (i2 == i3) {
                setSelection(rangeOfNearbyMentionString.getAnchorPosition(i2));
                return;
            }
            int i4 = rangeOfNearbyMentionString.to;
            if (i3 < i4) {
                setSelection(i2, i4);
            }
            int i5 = rangeOfNearbyMentionString.from;
            if (i2 > i5) {
                setSelection(i5, i3);
            }
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        setMentionStringRange();
    }

    public void setMentionMap(Map<String, String> map) {
        this.mentionList.putAll(map);
    }

    public void setOnMentionInputListener(OnMentionInputListener onMentionInputListener) {
        this.mOnMentionInputListener = onMentionInputListener;
    }

    public TIMMentionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mentionTagList = new ArrayList();
        this.mRangeArrayList = new ArrayList();
        this.mentionList = new HashMap();
        init();
    }

    public TIMMentionEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mentionTagList = new ArrayList();
        this.mRangeArrayList = new ArrayList();
        this.mentionList = new HashMap();
        init();
    }
}
