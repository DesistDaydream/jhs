package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public ExifTag(String str, int i2, int i3) {
        this.name = str;
        this.number = i2;
        this.primaryFormat = i3;
        this.secondaryFormat = -1;
    }

    public boolean isFormatCompatible(int i2) {
        int i3;
        int i4 = this.primaryFormat;
        if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.secondaryFormat) == i2) {
            return true;
        }
        if ((i4 == 4 || i3 == 4) && i2 == 3) {
            return true;
        }
        if ((i4 == 9 || i3 == 9) && i2 == 8) {
            return true;
        }
        return (i4 == 12 || i3 == 12) && i2 == 11;
    }

    public ExifTag(String str, int i2, int i3, int i4) {
        this.name = str;
        this.number = i2;
        this.primaryFormat = i3;
        this.secondaryFormat = i4;
    }
}
