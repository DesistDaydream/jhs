package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(@d Color color) {
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(@d Color color) {
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(@d Color color) {
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(@d Color color) {
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, @d ColorSpace.Named named) {
        return Color.convert(i2, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j2) {
        return Color.alpha(j2);
    }

    public static final int getAlpha(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j2) {
        return Color.blue(j2);
    }

    public static final int getBlue(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    @d
    public static final ColorSpace getColorSpace(long j2) {
        return Color.colorSpace(j2);
    }

    @RequiresApi(26)
    public static final float getGreen(long j2) {
        return Color.green(j2);
    }

    public static final int getGreen(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i2) {
        return Color.luminance(i2);
    }

    @RequiresApi(26)
    public static final float getRed(long j2) {
        return Color.red(j2);
    }

    public static final int getRed(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j2) {
        return Color.isSrgb(j2);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j2) {
        return Color.isWideGamut(j2);
    }

    @RequiresApi(26)
    @d
    public static final Color plus(@d Color color, @d Color color2) {
        return ColorUtils.compositeColors(color2, color);
    }

    @RequiresApi(26)
    @d
    public static final Color toColor(@ColorInt int i2) {
        return Color.valueOf(i2);
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j2) {
        return Color.toArgb(j2);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i2) {
        return Color.pack(i2);
    }

    @RequiresApi(26)
    public static final float component1(long j2) {
        return Color.red(j2);
    }

    @RequiresApi(26)
    public static final float component2(long j2) {
        return Color.green(j2);
    }

    @RequiresApi(26)
    public static final float component3(long j2) {
        return Color.blue(j2);
    }

    @RequiresApi(26)
    public static final float component4(long j2) {
        return Color.alpha(j2);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, @d ColorSpace colorSpace) {
        return Color.convert(i2, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j2) {
        return Color.luminance(j2);
    }

    @RequiresApi(26)
    @d
    public static final Color toColor(long j2) {
        return Color.valueOf(j2);
    }

    @ColorInt
    public static final int toColorInt(@d String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j2, @d ColorSpace.Named named) {
        return Color.convert(j2, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j2, @d ColorSpace colorSpace) {
        return Color.convert(j2, colorSpace);
    }

    @RequiresApi(26)
    @d
    public static final Color convertTo(@d Color color, @d ColorSpace.Named named) {
        return color.convert(ColorSpace.get(named));
    }

    @RequiresApi(26)
    @d
    public static final Color convertTo(@d Color color, @d ColorSpace colorSpace) {
        return color.convert(colorSpace);
    }
}
