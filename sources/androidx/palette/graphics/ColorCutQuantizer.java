package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class ColorCutQuantizer {
    public static final int COMPONENT_BLUE = -1;
    public static final int COMPONENT_GREEN = -2;
    public static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: androidx.palette.graphics.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.getVolume() - vbox.getVolume();
        }
    };
    public final int[] mColors;
    public final Palette.Filter[] mFilters;
    public final int[] mHistogram;
    public final List<Palette.Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];
    @Nullable
    public final TimingLogger mTimingLogger = null;

    /* loaded from: classes.dex */
    public class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;

        public Vbox(int i2, int i3) {
            this.mLowerIndex = i2;
            this.mUpperIndex = i3;
            fitBox();
        }

        public final boolean canSplit() {
            return getColorCount() > 1;
        }

        public final int findSplitPoint() {
            int longestColorDimension = getLongestColorDimension();
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            int i2 = this.mPopulation / 2;
            int i3 = this.mLowerIndex;
            int i4 = 0;
            while (true) {
                int i5 = this.mUpperIndex;
                if (i3 <= i5) {
                    i4 += iArr2[iArr[i3]];
                    if (i4 >= i2) {
                        return Math.min(i5 - 1, i3);
                    }
                    i3++;
                } else {
                    return this.mLowerIndex;
                }
            }
        }

        public final void fitBox() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.mLowerIndex; i9 <= this.mUpperIndex; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int quantizedRed = ColorCutQuantizer.quantizedRed(i10);
                int quantizedGreen = ColorCutQuantizer.quantizedGreen(i10);
                int quantizedBlue = ColorCutQuantizer.quantizedBlue(i10);
                if (quantizedRed > i5) {
                    i5 = quantizedRed;
                }
                if (quantizedRed < i2) {
                    i2 = quantizedRed;
                }
                if (quantizedGreen > i6) {
                    i6 = quantizedGreen;
                }
                if (quantizedGreen < i3) {
                    i3 = quantizedGreen;
                }
                if (quantizedBlue > i7) {
                    i7 = quantizedBlue;
                }
                if (quantizedBlue < i4) {
                    i4 = quantizedBlue;
                }
            }
            this.mMinRed = i2;
            this.mMaxRed = i5;
            this.mMinGreen = i3;
            this.mMaxGreen = i6;
            this.mMinBlue = i4;
            this.mMaxBlue = i7;
            this.mPopulation = i8;
        }

        public final Palette.Swatch getAverageColor() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = this.mLowerIndex; i6 <= this.mUpperIndex; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i7];
                i3 += i8;
                i2 += ColorCutQuantizer.quantizedRed(i7) * i8;
                i4 += ColorCutQuantizer.quantizedGreen(i7) * i8;
                i5 += i8 * ColorCutQuantizer.quantizedBlue(i7);
            }
            float f2 = i3;
            return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(i2 / f2), Math.round(i4 / f2), Math.round(i5 / f2)), i3);
        }

        public final int getColorCount() {
            return (this.mUpperIndex + 1) - this.mLowerIndex;
        }

        public final int getLongestColorDimension() {
            int i2 = this.mMaxRed - this.mMinRed;
            int i3 = this.mMaxGreen - this.mMinGreen;
            int i4 = this.mMaxBlue - this.mMinBlue;
            if (i2 < i3 || i2 < i4) {
                return (i3 < i2 || i3 < i4) ? -1 : -2;
            }
            return -3;
        }

        public final int getVolume() {
            return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        public final Vbox splitBox() {
            if (canSplit()) {
                int findSplitPoint = findSplitPoint();
                Vbox vbox = new Vbox(findSplitPoint + 1, this.mUpperIndex);
                this.mUpperIndex = findSplitPoint;
                fitBox();
                return vbox;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    public ColorCutQuantizer(int[] iArr, int i2, Palette.Filter[] filterArr) {
        this.mFilters = filterArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int quantizeFromRgb888 = quantizeFromRgb888(iArr[i3]);
            iArr[i3] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0 && shouldIgnoreColor(i5)) {
                iArr2[i5] = 0;
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.mColors = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 <= i2) {
            this.mQuantizedColors = new ArrayList();
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = iArr3[i8];
                this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(i9), iArr2[i9]));
            }
            return;
        }
        this.mQuantizedColors = quantizePixels(i2);
    }

    public static int approximateToRgb888(int i2, int i3, int i4) {
        return Color.rgb(modifyWordWidth(i2, 5, 8), modifyWordWidth(i3, 5, 8), modifyWordWidth(i4, 5, 8));
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Vbox vbox : collection) {
            Palette.Swatch averageColor = vbox.getAverageColor();
            if (!shouldIgnoreColor(averageColor)) {
                arrayList.add(averageColor);
            }
        }
        return arrayList;
    }

    public static void modifySignificantOctet(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = quantizedBlue(i5) | (quantizedGreen(i5) << 10) | (quantizedRed(i5) << 5);
                i3++;
            }
        } else if (i2 != -1) {
        } else {
            while (i3 <= i4) {
                int i6 = iArr[i3];
                iArr[i3] = quantizedRed(i6) | (quantizedBlue(i6) << 10) | (quantizedGreen(i6) << 5);
                i3++;
            }
        }
    }

    private static int modifyWordWidth(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }

    private static int quantizeFromRgb888(int i2) {
        return modifyWordWidth(Color.blue(i2), 8, 5) | (modifyWordWidth(Color.red(i2), 8, 5) << 10) | (modifyWordWidth(Color.green(i2), 8, 5) << 5);
    }

    private List<Palette.Swatch> quantizePixels(int i2) {
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i2, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, this.mColors.length - 1));
        splitBoxes(priorityQueue, i2);
        return generateAverageColors(priorityQueue);
    }

    public static int quantizedBlue(int i2) {
        return i2 & 31;
    }

    public static int quantizedGreen(int i2) {
        return (i2 >> 5) & 31;
    }

    public static int quantizedRed(int i2) {
        return (i2 >> 10) & 31;
    }

    private boolean shouldIgnoreColor(int i2) {
        int approximateToRgb888 = approximateToRgb888(i2);
        ColorUtils.colorToHSL(approximateToRgb888, this.mTempHsl);
        return shouldIgnoreColor(approximateToRgb888, this.mTempHsl);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i2) {
        Vbox poll;
        while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.canSplit()) {
            priorityQueue.offer(poll.splitBox());
            priorityQueue.offer(poll);
        }
    }

    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch) {
        return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
    }

    private static int approximateToRgb888(int i2) {
        return approximateToRgb888(quantizedRed(i2), quantizedGreen(i2), quantizedBlue(i2));
    }

    private boolean shouldIgnoreColor(int i2, float[] fArr) {
        Palette.Filter[] filterArr = this.mFilters;
        if (filterArr != null && filterArr.length > 0) {
            int length = filterArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (!this.mFilters[i3].isAllowed(i2, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
