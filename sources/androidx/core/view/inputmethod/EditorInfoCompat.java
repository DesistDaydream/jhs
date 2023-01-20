package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    @VisibleForTesting
    public static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    @VisibleForTesting
    public static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i2) {
            return editorInfo.getInitialSelectedText(i2);
        }

        public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i2, int i3) {
            return editorInfo.getInitialTextAfterCursor(i2, i3);
        }

        public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i2, int i3) {
            return editorInfo.getInitialTextBeforeCursor(i2, i3);
        }

        public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i2) {
            editorInfo.setInitialSurroundingSubText(charSequence, i2);
        }
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : EMPTY_STRING_ARRAY;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        return stringArray != null ? stringArray : EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i2) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialSelectedText(editorInfo, i2);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int min = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int max = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i3 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i4 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i5 = max - min;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i4 - i3 != i5 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        if ((i2 & 1) != 0) {
            return charSequence.subSequence(i3, i4);
        }
        return TextUtils.substring(charSequence, i3, i4);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i2, int i3) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextAfterCursor(editorInfo, i2, i3);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i4 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i2, charSequence.length() - i4);
        if ((i3 & 1) != 0) {
            return charSequence.subSequence(i4, min + i4);
        }
        return TextUtils.substring(charSequence, i4, min + i4);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i2, int i3) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextBeforeCursor(editorInfo, i2, i3);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i4 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i2, i4);
        if ((i3 & 1) != 0) {
            return charSequence.subSequence(i4 - min, i4);
        }
        return TextUtils.substring(charSequence, i4 - min, i4);
    }

    public static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        return containsKey2 ? 2 : 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i2));
        }
        return Character.isLowSurrogate(charSequence.charAt(i2));
    }

    private static boolean isPasswordInputType(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i2) {
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, i2);
            return;
        }
        int i3 = editorInfo.initialSelStart;
        int i4 = editorInfo.initialSelEnd;
        int i5 = i3 > i4 ? i4 - i2 : i3 - i2;
        int i6 = i3 > i4 ? i3 - i2 : i4 - i2;
        int length = charSequence.length();
        if (i2 >= 0 && i5 >= 0 && i6 <= length) {
            if (isPasswordInputType(editorInfo.inputType)) {
                setSurroundingText(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                setSurroundingText(editorInfo, charSequence, i5, i6);
                return;
            } else {
                trimLongSurroundingText(editorInfo, charSequence, i5, i6);
                return;
            }
        }
        setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i2);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i3);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        CharSequence subSequence;
        int i4 = i3 - i2;
        int i5 = i4 > 1024 ? 0 : i4;
        int i6 = 2048 - i5;
        int min = Math.min(charSequence.length() - i3, i6 - Math.min(i2, (int) (i6 * 0.8d)));
        int min2 = Math.min(i2, i6 - min);
        int i7 = i2 - min2;
        if (isCutOnSurrogate(charSequence, i7, 0)) {
            i7++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i3 + min) - 1, 1)) {
            min--;
        }
        int i8 = min2 + i5 + min;
        if (i5 != i4) {
            subSequence = TextUtils.concat(charSequence.subSequence(i7, i7 + min2), charSequence.subSequence(i3, min + i3));
        } else {
            subSequence = charSequence.subSequence(i7, i8 + i7);
        }
        int i9 = min2 + 0;
        setSurroundingText(editorInfo, subSequence, i9, i5 + i9);
    }
}
