package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* loaded from: classes.dex */
public class AppCompatEmojiEditTextHelper {
    @NonNull
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    @NonNull
    private final EditText mView;

    public AppCompatEmojiEditTextHelper(@NonNull EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText, false);
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        return this.mEmojiEditTextHelper.getKeyListener(keyListener);
    }

    public void initKeyListener() {
        boolean isFocusable = this.mView.isFocusable();
        int inputType = this.mView.getInputType();
        EditText editText = this.mView;
        editText.setKeyListener(editText.getKeyListener());
        this.mView.setRawInputType(inputType);
        this.mView.setFocusable(isFocusable);
    }

    public boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i2, 0);
        try {
            int i3 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z = obtainStyledAttributes.hasValue(i3) ? obtainStyledAttributes.getBoolean(i3, true) : true;
            obtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    public void setEnabled(boolean z) {
        this.mEmojiEditTextHelper.setEnabled(z);
    }
}
