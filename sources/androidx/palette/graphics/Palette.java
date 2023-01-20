package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Palette {
    public static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    public static final Filter DEFAULT_FILTER = new Filter() { // from class: androidx.palette.graphics.Palette.1
        private static final float BLACK_MAX_LIGHTNESS = 0.05f;
        private static final float WHITE_MIN_LIGHTNESS = 0.95f;

        private boolean isBlack(float[] fArr) {
            return fArr[2] <= BLACK_MAX_LIGHTNESS;
        }

        private boolean isNearRedILine(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean isWhite(float[] fArr) {
            return fArr[2] >= WHITE_MIN_LIGHTNESS;
        }

        @Override // androidx.palette.graphics.Palette.Filter
        public boolean isAllowed(int i2, float[] fArr) {
            return (isWhite(fArr) || isBlack(fArr) || isNearRedILine(fArr)) ? false : true;
        }
    };
    public static final int DEFAULT_RESIZE_BITMAP_AREA = 12544;
    public static final String LOG_TAG = "Palette";
    public static final boolean LOG_TIMINGS = false;
    public static final float MIN_CONTRAST_BODY_TEXT = 4.5f;
    public static final float MIN_CONTRAST_TITLE_TEXT = 3.0f;
    private final List<Swatch> mSwatches;
    private final List<Target> mTargets;
    private final SparseBooleanArray mUsedColors = new SparseBooleanArray();
    private final Map<Target, Swatch> mSelectedSwatches = new ArrayMap();
    @Nullable
    private final Swatch mDominantSwatch = findDominantSwatch();

    /* loaded from: classes.dex */
    public interface Filter {
        boolean isAllowed(@ColorInt int i2, @NonNull float[] fArr);
    }

    /* loaded from: classes.dex */
    public interface PaletteAsyncListener {
        void onGenerated(@Nullable Palette palette);
    }

    public Palette(List<Swatch> list, List<Target> list2) {
        this.mSwatches = list;
        this.mTargets = list2;
    }

    @Nullable
    private Swatch findDominantSwatch() {
        int size = this.mSwatches.size();
        int i2 = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i3 = 0; i3 < size; i3++) {
            Swatch swatch2 = this.mSwatches.get(i3);
            if (swatch2.getPopulation() > i2) {
                i2 = swatch2.getPopulation();
                swatch = swatch2;
            }
        }
        return swatch;
    }

    @NonNull
    public static Builder from(@NonNull Bitmap bitmap) {
        return new Builder(bitmap);
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        return from(bitmap).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).generate(paletteAsyncListener);
    }

    private float generateScore(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        Swatch swatch2 = this.mDominantSwatch;
        int population = swatch2 != null ? swatch2.getPopulation() : 1;
        return (target.getSaturationWeight() > 0.0f ? target.getSaturationWeight() * (1.0f - Math.abs(hsl[1] - target.getTargetSaturation())) : 0.0f) + (target.getLightnessWeight() > 0.0f ? target.getLightnessWeight() * (1.0f - Math.abs(hsl[2] - target.getTargetLightness())) : 0.0f) + (target.getPopulationWeight() > 0.0f ? target.getPopulationWeight() * (swatch.getPopulation() / population) : 0.0f);
    }

    @Nullable
    private Swatch generateScoredTarget(Target target) {
        Swatch maxScoredSwatchForTarget = getMaxScoredSwatchForTarget(target);
        if (maxScoredSwatchForTarget != null && target.isExclusive()) {
            this.mUsedColors.append(maxScoredSwatchForTarget.getRgb(), true);
        }
        return maxScoredSwatchForTarget;
    }

    @Nullable
    private Swatch getMaxScoredSwatchForTarget(Target target) {
        int size = this.mSwatches.size();
        float f2 = 0.0f;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = this.mSwatches.get(i2);
            if (shouldBeScoredForTarget(swatch2, target)) {
                float generateScore = generateScore(swatch2, target);
                if (swatch == null || generateScore > f2) {
                    swatch = swatch2;
                    f2 = generateScore;
                }
            }
        }
        return swatch;
    }

    private boolean shouldBeScoredForTarget(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        return hsl[1] >= target.getMinimumSaturation() && hsl[1] <= target.getMaximumSaturation() && hsl[2] >= target.getMinimumLightness() && hsl[2] <= target.getMaximumLightness() && !this.mUsedColors.get(swatch.getRgb());
    }

    @ColorInt
    public int getColorForTarget(@NonNull Target target, @ColorInt int i2) {
        Swatch swatchForTarget = getSwatchForTarget(target);
        return swatchForTarget != null ? swatchForTarget.getRgb() : i2;
    }

    @ColorInt
    public int getDarkMutedColor(@ColorInt int i2) {
        return getColorForTarget(Target.DARK_MUTED, i2);
    }

    @Nullable
    public Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    @ColorInt
    public int getDarkVibrantColor(@ColorInt int i2) {
        return getColorForTarget(Target.DARK_VIBRANT, i2);
    }

    @Nullable
    public Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    @ColorInt
    public int getDominantColor(@ColorInt int i2) {
        Swatch swatch = this.mDominantSwatch;
        return swatch != null ? swatch.getRgb() : i2;
    }

    @Nullable
    public Swatch getDominantSwatch() {
        return this.mDominantSwatch;
    }

    @ColorInt
    public int getLightMutedColor(@ColorInt int i2) {
        return getColorForTarget(Target.LIGHT_MUTED, i2);
    }

    @Nullable
    public Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    @ColorInt
    public int getLightVibrantColor(@ColorInt int i2) {
        return getColorForTarget(Target.LIGHT_VIBRANT, i2);
    }

    @Nullable
    public Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    @ColorInt
    public int getMutedColor(@ColorInt int i2) {
        return getColorForTarget(Target.MUTED, i2);
    }

    @Nullable
    public Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    @Nullable
    public Swatch getSwatchForTarget(@NonNull Target target) {
        return this.mSelectedSwatches.get(target);
    }

    @NonNull
    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.mSwatches);
    }

    @NonNull
    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.mTargets);
    }

    @ColorInt
    public int getVibrantColor(@ColorInt int i2) {
        return getColorForTarget(Target.VIBRANT, i2);
    }

    @Nullable
    public Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }

    @NonNull
    public static Palette from(@NonNull List<Swatch> list) {
        return new Builder(list).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i2) {
        return from(bitmap).maximumColorCount(i2).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i2, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).maximumColorCount(i2).generate(paletteAsyncListener);
    }

    public void generate() {
        int size = this.mTargets.size();
        for (int i2 = 0; i2 < size; i2++) {
            Target target = this.mTargets.get(i2);
            target.normalizeWeights();
            this.mSelectedSwatches.put(target, generateScoredTarget(target));
        }
        this.mUsedColors.clear();
    }

    /* loaded from: classes.dex */
    public static final class Swatch {
        private final int mBlue;
        private int mBodyTextColor;
        private boolean mGeneratedTextColors;
        private final int mGreen;
        @Nullable
        private float[] mHsl;
        private final int mPopulation;
        private final int mRed;
        private final int mRgb;
        private int mTitleTextColor;

        public Swatch(@ColorInt int i2, int i3) {
            this.mRed = Color.red(i2);
            this.mGreen = Color.green(i2);
            this.mBlue = Color.blue(i2);
            this.mRgb = i2;
            this.mPopulation = i3;
        }

        private void ensureTextColorsGenerated() {
            int alphaComponent;
            int alphaComponent2;
            if (this.mGeneratedTextColors) {
                return;
            }
            int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 4.5f);
            int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 3.0f);
            if (calculateMinimumAlpha != -1 && calculateMinimumAlpha2 != -1) {
                this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                this.mGeneratedTextColors = true;
                return;
            }
            int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(ViewCompat.MEASURED_STATE_MASK, this.mRgb, 4.5f);
            int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(ViewCompat.MEASURED_STATE_MASK, this.mRgb, 3.0f);
            if (calculateMinimumAlpha3 != -1 && calculateMinimumAlpha4 != -1) {
                this.mBodyTextColor = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha3);
                this.mTitleTextColor = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha4);
                this.mGeneratedTextColors = true;
                return;
            }
            if (calculateMinimumAlpha != -1) {
                alphaComponent = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
            } else {
                alphaComponent = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha3);
            }
            this.mBodyTextColor = alphaComponent;
            if (calculateMinimumAlpha2 != -1) {
                alphaComponent2 = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
            } else {
                alphaComponent2 = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha4);
            }
            this.mTitleTextColor = alphaComponent2;
            this.mGeneratedTextColors = true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Swatch.class != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            return this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb;
        }

        @ColorInt
        public int getBodyTextColor() {
            ensureTextColorsGenerated();
            return this.mBodyTextColor;
        }

        @NonNull
        public float[] getHsl() {
            if (this.mHsl == null) {
                this.mHsl = new float[3];
            }
            ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
            return this.mHsl;
        }

        public int getPopulation() {
            return this.mPopulation;
        }

        @ColorInt
        public int getRgb() {
            return this.mRgb;
        }

        @ColorInt
        public int getTitleTextColor() {
            ensureTextColorsGenerated();
            return this.mTitleTextColor;
        }

        public int hashCode() {
            return (this.mRgb * 31) + this.mPopulation;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
        }

        public Swatch(int i2, int i3, int i4, int i5) {
            this.mRed = i2;
            this.mGreen = i3;
            this.mBlue = i4;
            this.mRgb = Color.rgb(i2, i3, i4);
            this.mPopulation = i5;
        }

        public Swatch(float[] fArr, int i2) {
            this(ColorUtils.HSLToColor(fArr), i2);
            this.mHsl = fArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        @Nullable
        private final Bitmap mBitmap;
        private final List<Filter> mFilters;
        private int mMaxColors;
        @Nullable
        private Rect mRegion;
        private int mResizeArea;
        private int mResizeMaxDimension;
        @Nullable
        private final List<Swatch> mSwatches;
        private final List<Target> mTargets;

        public Builder(@NonNull Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.mTargets = arrayList;
            this.mMaxColors = 16;
            this.mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
            this.mResizeMaxDimension = -1;
            ArrayList arrayList2 = new ArrayList();
            this.mFilters = arrayList2;
            if (bitmap != null && !bitmap.isRecycled()) {
                arrayList2.add(Palette.DEFAULT_FILTER);
                this.mBitmap = bitmap;
                this.mSwatches = null;
                arrayList.add(Target.LIGHT_VIBRANT);
                arrayList.add(Target.VIBRANT);
                arrayList.add(Target.DARK_VIBRANT);
                arrayList.add(Target.LIGHT_MUTED);
                arrayList.add(Target.MUTED);
                arrayList.add(Target.DARK_MUTED);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.mRegion;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.mRegion.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i2 = 0; i2 < height2; i2++) {
                Rect rect2 = this.mRegion;
                System.arraycopy(iArr, ((rect2.top + i2) * width) + rect2.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap scaleBitmapDown(Bitmap bitmap) {
            int max;
            int i2;
            double d2 = -1.0d;
            if (this.mResizeArea > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i3 = this.mResizeArea;
                if (width > i3) {
                    d2 = Math.sqrt(i3 / width);
                }
            } else if (this.mResizeMaxDimension > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.mResizeMaxDimension)) {
                d2 = i2 / max;
            }
            return d2 <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d2), (int) Math.ceil(bitmap.getHeight() * d2), false);
        }

        @NonNull
        public Builder addFilter(Filter filter) {
            if (filter != null) {
                this.mFilters.add(filter);
            }
            return this;
        }

        @NonNull
        public Builder addTarget(@NonNull Target target) {
            if (!this.mTargets.contains(target)) {
                this.mTargets.add(target);
            }
            return this;
        }

        @NonNull
        public Builder clearFilters() {
            this.mFilters.clear();
            return this;
        }

        @NonNull
        public Builder clearRegion() {
            this.mRegion = null;
            return this;
        }

        @NonNull
        public Builder clearTargets() {
            List<Target> list = this.mTargets;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        @NonNull
        public Palette generate() {
            List<Swatch> list;
            Filter[] filterArr;
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                Bitmap scaleBitmapDown = scaleBitmapDown(bitmap);
                Rect rect = this.mRegion;
                if (scaleBitmapDown != this.mBitmap && rect != null) {
                    double width = scaleBitmapDown.getWidth() / this.mBitmap.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), scaleBitmapDown.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), scaleBitmapDown.getHeight());
                }
                int[] pixelsFromBitmap = getPixelsFromBitmap(scaleBitmapDown);
                int i2 = this.mMaxColors;
                if (this.mFilters.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.mFilters;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(pixelsFromBitmap, i2, filterArr);
                if (scaleBitmapDown != this.mBitmap) {
                    scaleBitmapDown.recycle();
                }
                list = colorCutQuantizer.getQuantizedColors();
            } else {
                list = this.mSwatches;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            Palette palette = new Palette(list, this.mTargets);
            palette.generate();
            return palette;
        }

        @NonNull
        public Builder maximumColorCount(int i2) {
            this.mMaxColors = i2;
            return this;
        }

        @NonNull
        public Builder resizeBitmapArea(int i2) {
            this.mResizeArea = i2;
            this.mResizeMaxDimension = -1;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder resizeBitmapSize(int i2) {
            this.mResizeMaxDimension = i2;
            this.mResizeArea = -1;
            return this;
        }

        @NonNull
        public Builder setRegion(@Px int i2, @Px int i3, @Px int i4, @Px int i5) {
            if (this.mBitmap != null) {
                if (this.mRegion == null) {
                    this.mRegion = new Rect();
                }
                this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                if (!this.mRegion.intersect(i2, i3, i4, i5)) {
                    throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                }
            }
            return this;
        }

        public Builder(@NonNull List<Swatch> list) {
            this.mTargets = new ArrayList();
            this.mMaxColors = 16;
            this.mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
            this.mResizeMaxDimension = -1;
            ArrayList arrayList = new ArrayList();
            this.mFilters = arrayList;
            if (list != null && !list.isEmpty()) {
                arrayList.add(Palette.DEFAULT_FILTER);
                this.mSwatches = list;
                this.mBitmap = null;
                return;
            }
            throw new IllegalArgumentException("List of Swatches is not valid");
        }

        @NonNull
        public AsyncTask<Bitmap, Void, Palette> generate(@NonNull final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new AsyncTask<Bitmap, Void, Palette>() { // from class: androidx.palette.graphics.Palette.Builder.1
                    @Override // android.os.AsyncTask
                    @Nullable
                    public Palette doInBackground(Bitmap... bitmapArr) {
                        try {
                            return Builder.this.generate();
                        } catch (Exception e2) {
                            Log.e(Palette.LOG_TAG, "Exception thrown during async generate", e2);
                            return null;
                        }
                    }

                    @Override // android.os.AsyncTask
                    public void onPostExecute(@Nullable Palette palette) {
                        paletteAsyncListener.onGenerated(palette);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.mBitmap);
            }
            throw new IllegalArgumentException("listener can not be null");
        }
    }
}
