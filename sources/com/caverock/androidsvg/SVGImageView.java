package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SVGImageView extends ImageView {
    private static Method a;

    public SVGImageView(Context context) {
        super(context);
        try {
            a = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    private void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i2, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                if (b(Uri.parse(string), false)) {
                    return;
                }
                setImageAsset(string);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private boolean b(Uri uri, boolean z) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = getContext().getContentResolver().openInputStream(uri);
                SVG s = SVG.s(inputStream);
                c();
                setImageDrawable(new PictureDrawable(s.E()));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return true;
                    } catch (IOException unused) {
                        return true;
                    }
                }
                return true;
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", "Error loading file " + uri + ": " + e2.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return false;
            } catch (FileNotFoundException unused3) {
                if (z) {
                    Log.e("SVGImageView", "File not found: " + uri);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private void c() {
        if (a == null) {
            return;
        }
        try {
            a.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e2) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e2);
        }
    }

    public void setImageAsset(String str) {
        try {
            SVG r = SVG.r(getContext().getAssets(), str);
            c();
            setImageDrawable(new PictureDrawable(r.E()));
        } catch (SVGParseException e2) {
            Log.e("SVGImageView", "Error loading file " + str + ": " + e2.getMessage());
        } catch (FileNotFoundException unused) {
            Log.e("SVGImageView", "File not found: " + str);
        } catch (IOException e3) {
            Log.e("SVGImageView", "Unable to load asset file: " + str, e3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        try {
            SVG t = SVG.t(getContext(), i2);
            c();
            setImageDrawable(new PictureDrawable(t.E()));
        } catch (SVGParseException e2) {
            Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(i2), e2.getMessage()));
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        b(uri, true);
    }

    public void setSVG(SVG svg) {
        if (svg != null) {
            c();
            setImageDrawable(new PictureDrawable(svg.E()));
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        try {
            a = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        a(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        try {
            a = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        a(attributeSet, i2);
    }
}
