package com.tencent.qcloud.tuikit.tuichat.component.face;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.LruCache;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class FaceManager {
    private static Context context;
    private static ArrayList<FaceGroup> customFace;
    private static String[] emojiFilters;
    private static String[] emojiFilters_values;
    private static final int drawableWidth = ScreenUtil.getPxByDp(32.0f);
    private static ArrayList<Emoji> emojiList = new ArrayList<>();
    private static LruCache<String, Bitmap> drawableCache = new LruCache<>(1024);

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

    static {
        Context appContext = TUIChatService.getAppContext();
        context = appContext;
        emojiFilters = appContext.getResources().getStringArray(R.array.emoji_filter_key);
        emojiFilters_values = context.getResources().getStringArray(R.array.emoji_filter_value);
        customFace = new ArrayList<>();
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i3 || i5 > i2) {
            int round = Math.round(i4 / i3);
            int round2 = Math.round(i5 / i2);
            return round < round2 ? round : round2;
        }
        return 1;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    public static int dip2px(Context context2, float f2) {
        return (int) ((f2 * context2.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String emojiJudge(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] emojiFilters2 = getEmojiFilters();
        if (emojiFilters2 == null || emojiFilters2.length == 0) {
            return str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(str);
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        while (matcher.find()) {
            String group = matcher.group();
            if (i2 != -1) {
                indexOf = str.indexOf(group, i2);
            } else {
                indexOf = str.indexOf(group);
            }
            int length = group.length() + indexOf;
            int findeEmoji = findeEmoji(group);
            String[] emojiFiltersValues = getEmojiFiltersValues();
            if (findeEmoji != -1 && emojiFiltersValues != null && emojiFiltersValues.length >= findeEmoji) {
                group = emojiFiltersValues[findeEmoji];
            }
            EmojiData emojiData = new EmojiData();
            emojiData.setStart(indexOf);
            emojiData.setEnd(length);
            emojiData.setEmojiText(group);
            arrayList.add(emojiData);
            i2 = length;
        }
        if (arrayList.isEmpty()) {
            return str;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            EmojiData emojiData2 = (EmojiData) arrayList.get(size);
            String emojiText = emojiData2.getEmojiText();
            int start = emojiData2.getStart();
            int end = emojiData2.getEnd();
            if (!TextUtils.isEmpty(emojiText) && start != -1 && end != -1) {
                spannableStringBuilder.replace(start, end, (CharSequence) emojiText);
            }
        }
        return spannableStringBuilder.toString();
    }

    private static int findeEmoji(String str) {
        String[] emojiFilters2;
        if (TextUtils.isEmpty(str) || (emojiFilters2 = getEmojiFilters()) == null || emojiFilters2.length == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < emojiFilters2.length; i2++) {
            if (str.equals(emojiFilters2[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public static Bitmap getCustomBitmap(int i2, String str) {
        for (int i3 = 0; i3 < customFace.size(); i3++) {
            FaceGroup faceGroup = customFace.get(i3);
            if (faceGroup.getGroupId() == i2) {
                ArrayList<Emoji> faces = faceGroup.getFaces();
                for (int i4 = 0; i4 < faces.size(); i4++) {
                    Emoji emoji = faces.get(i4);
                    if (emoji.getFilter().equals(str)) {
                        return emoji.getIcon();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static ArrayList<FaceGroup> getCustomFaceList() {
        return customFace;
    }

    public static Bitmap getEmoji(String str) {
        return drawableCache.get(str);
    }

    public static String[] getEmojiFilters() {
        return emojiFilters;
    }

    public static String[] getEmojiFiltersValues() {
        return emojiFilters_values;
    }

    public static ArrayList<Emoji> getEmojiList() {
        return emojiList;
    }

    public static boolean handlerEmojiText(TextView textView, String str, boolean z) {
        if (str == null) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(str);
        boolean z2 = false;
        while (matcher.find()) {
            Bitmap bitmap = drawableCache.get(matcher.group(1));
            if (bitmap != null) {
                spannableStringBuilder.setSpan(new ImageSpan(context, bitmap), matcher.start(), matcher.end(), 17);
                z2 = true;
            }
        }
        if (z2 || !z) {
            int selectionStart = textView.getSelectionStart();
            textView.setText(spannableStringBuilder);
            if (textView instanceof EditText) {
                ((EditText) textView).setSelection(selectionStart);
            }
            return true;
        }
        return false;
    }

    public static boolean isFaceChar(String str) {
        return drawableCache.get(str) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.qcloud.tuikit.tuichat.component.face.Emoji loadAssetBitmap(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r0 = 0
            com.tencent.qcloud.tuikit.tuichat.component.face.Emoji r1 = new com.tencent.qcloud.tuikit.tuichat.component.face.Emoji     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.Context r2 = com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.context     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3.<init>()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4 = 480(0x1e0, float:6.73E-43)
            r3.inDensity = r4     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.util.DisplayMetrics r4 = r2.getDisplayMetrics()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r4 = r4.densityDpi     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3.inScreenDensity = r4     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r2 = r2.densityDpi     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3.inTargetDensity = r2     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.Context r2 = com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.context     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r4 = ""
            r2.list(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.Context r2 = com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.context     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.io.InputStream r7 = r2.open(r7)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            int r4 = com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.drawableWidth     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            r5 = 0
            r2.<init>(r5, r5, r4, r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r7, r2, r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            if (r2 == 0) goto L5a
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r3 = com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.drawableCache     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            r3.put(r6, r2)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            r1.setIcon(r2)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            r1.setFilter(r6)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            if (r8 == 0) goto L5a
            java.util.ArrayList<com.tencent.qcloud.tuikit.tuichat.component.face.Emoji> r6 = com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.emojiList     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
            r6.add(r1)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L79
        L5a:
            if (r7 == 0) goto L64
            r7.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r6 = move-exception
            r6.printStackTrace()
        L64:
            return r1
        L65:
            r6 = move-exception
            goto L6b
        L67:
            r6 = move-exception
            goto L7b
        L69:
            r6 = move-exception
            r7 = r0
        L6b:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L79
            if (r7 == 0) goto L78
            r7.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r6 = move-exception
            r6.printStackTrace()
        L78:
            return r0
        L79:
            r6 = move-exception
            r0 = r7
        L7b:
            if (r0 == 0) goto L85
            r0.close()     // Catch: java.io.IOException -> L81
            goto L85
        L81:
            r7 = move-exception
            r7.printStackTrace()
        L85:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.loadAssetBitmap(java.lang.String, java.lang.String, boolean):com.tencent.qcloud.tuikit.tuichat.component.face.Emoji");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadCustomFace() {
        List<CustomFaceGroup> faceGroups;
        CustomFaceConfig customFaceConfig = TUIChatService.getChatConfig().getCustomFaceConfig();
        if (customFaceConfig == null || (faceGroups = customFaceConfig.getFaceGroups()) == null) {
            return;
        }
        for (int i2 = 0; i2 < faceGroups.size(); i2++) {
            CustomFaceGroup customFaceGroup = faceGroups.get(i2);
            FaceGroup faceGroup = new FaceGroup();
            faceGroup.setGroupId(customFaceGroup.getFaceGroupId());
            faceGroup.setDesc(customFaceGroup.getFaceIconName());
            faceGroup.setPageColumnCount(customFaceGroup.getPageColumnCount());
            faceGroup.setPageRowCount(customFaceGroup.getPageRowCount());
            faceGroup.setGroupIcon(loadAssetBitmap(customFaceGroup.getFaceIconName(), customFaceGroup.getFaceIconPath(), false).getIcon());
            ArrayList<CustomFace> customFaceList = customFaceGroup.getCustomFaceList();
            ArrayList<Emoji> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < customFaceList.size(); i3++) {
                CustomFace customFace2 = customFaceList.get(i3);
                Emoji loadAssetBitmap = loadAssetBitmap(customFace2.getFaceName(), customFace2.getAssetPath(), false);
                loadAssetBitmap.setWidth(customFace2.getFaceWidth());
                loadAssetBitmap.setHeight(customFace2.getFaceHeight());
                loadAssetBitmap.setDesc(customFace2.getFaceName());
                arrayList.add(loadAssetBitmap);
            }
            faceGroup.setFaces(arrayList);
            customFace.add(faceGroup);
        }
    }

    public static void loadFaceFiles() {
        new Thread() { // from class: com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                FaceManager.loadCustomFace();
            }
        }.start();
    }
}
