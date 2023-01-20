package com.m7.imkfsdk.view.imageviewer;

import android.view.View;

/* loaded from: classes2.dex */
public final class MoorViewHelper {

    /* loaded from: classes2.dex */
    public static final class Honeycomb {
        private Honeycomb() {
        }

        public static float getAlpha(View view) {
            return view.getAlpha();
        }

        public static float getPivotX(View view) {
            return view.getPivotX();
        }

        public static float getPivotY(View view) {
            return view.getPivotY();
        }

        public static float getRotation(View view) {
            return view.getRotation();
        }

        public static float getRotationX(View view) {
            return view.getRotationX();
        }

        public static float getRotationY(View view) {
            return view.getRotationY();
        }

        public static float getScaleX(View view) {
            return view.getScaleX();
        }

        public static float getScaleY(View view) {
            return view.getScaleY();
        }

        public static float getScrollX(View view) {
            return view.getScrollX();
        }

        public static float getScrollY(View view) {
            return view.getScrollY();
        }

        public static float getTranslationX(View view) {
            return view.getTranslationX();
        }

        public static float getTranslationY(View view) {
            return view.getTranslationY();
        }

        public static float getX(View view) {
            return view.getX();
        }

        public static float getY(View view) {
            return view.getY();
        }

        public static void setAlpha(View view, float f2) {
            view.setAlpha(f2);
        }

        public static void setPivotX(View view, float f2) {
            view.setPivotX(f2);
        }

        public static void setPivotY(View view, float f2) {
            view.setPivotY(f2);
        }

        public static void setRotation(View view, float f2) {
            view.setRotation(f2);
        }

        public static void setRotationX(View view, float f2) {
            view.setRotationX(f2);
        }

        public static void setRotationY(View view, float f2) {
            view.setRotationY(f2);
        }

        public static void setScaleX(View view, float f2) {
            view.setScaleX(f2);
        }

        public static void setScaleY(View view, float f2) {
            view.setScaleY(f2);
        }

        public static void setScrollX(View view, int i2) {
            view.setScrollX(i2);
        }

        public static void setScrollY(View view, int i2) {
            view.setScrollY(i2);
        }

        public static void setTranslationX(View view, float f2) {
            view.setTranslationX(f2);
        }

        public static void setTranslationY(View view, float f2) {
            view.setTranslationY(f2);
        }

        public static void setX(View view, float f2) {
            view.setX(f2);
        }

        public static void setY(View view, float f2) {
            view.setY(f2);
        }
    }

    private MoorViewHelper() {
    }

    public static void setScrollY(View view, int i2) {
        if (MoorAnimatorProxy.NEEDS_PROXY) {
            MoorAnimatorProxy.wrap(view).setScrollY(i2);
        } else {
            Honeycomb.setScrollY(view, i2);
        }
    }
}
