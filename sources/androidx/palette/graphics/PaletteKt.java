package androidx.palette.graphics;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.palette.graphics.Palette;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/palette/graphics/Palette;", "Landroidx/palette/graphics/Target;", TypedValues.Attributes.S_TARGET, "Landroidx/palette/graphics/Palette$Swatch;", "get", "(Landroidx/palette/graphics/Palette;Landroidx/palette/graphics/Target;)Landroidx/palette/graphics/Palette$Swatch;", "palette-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PaletteKt {
    @e
    public static final Palette.Swatch get(@d Palette palette, @d Target target) {
        return palette.getSwatchForTarget(target);
    }
}
