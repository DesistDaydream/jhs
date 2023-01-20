package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.io.PrintStream;
import java.util.HashMap;

/* loaded from: classes.dex */
public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    public static final HashMap<Pair<Integer, Integer>, String> allAttributes;
    public static final HashMap<String, String> allMargins;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;
    private String mLastStartState = null;
    private String mLastEndState = null;
    private int mLastStartStateId = -1;
    private int mLastEndStateId = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        allAttributes = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        allMargins = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private static void Connect(int dpi, ConstraintSet set, View view, HashMap<String, String> attributes, int from, int to) {
        String str = allAttributes.get(Pair.create(Integer.valueOf(from), Integer.valueOf(to)));
        String str2 = attributes.get(str);
        if (str2 != null) {
            String str3 = allMargins.get(str);
            set.connect(view.getId(), from, Integer.parseInt(str2), to, str3 != null ? GetPxFromDp(dpi, attributes.get(str3)) : 0);
        }
    }

    private static int GetPxFromDp(int dpi, String value) {
        int indexOf;
        if (value == null || (indexOf = value.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(value.substring(0, indexOf)).intValue() * dpi) / 160.0f);
    }

    private static void SetAbsolutePositions(int dpi, ConstraintSet set, View view, HashMap<String, String> attributes) {
        String str = attributes.get("layout_editor_absoluteX");
        if (str != null) {
            set.setEditorAbsoluteX(view.getId(), GetPxFromDp(dpi, str));
        }
        String str2 = attributes.get("layout_editor_absoluteY");
        if (str2 != null) {
            set.setEditorAbsoluteY(view.getId(), GetPxFromDp(dpi, str2));
        }
    }

    private static void SetBias(ConstraintSet set, View view, HashMap<String, String> attributes, int type) {
        String str = attributes.get(type == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (type == 0) {
                set.setHorizontalBias(view.getId(), Float.parseFloat(str));
            } else if (type == 1) {
                set.setVerticalBias(view.getId(), Float.parseFloat(str));
            }
        }
    }

    private static void SetDimensions(int dpi, ConstraintSet set, View view, HashMap<String, String> attributes, int type) {
        String str = attributes.get(type == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int GetPxFromDp = str.equalsIgnoreCase("wrap_content") ? -2 : GetPxFromDp(dpi, str);
            if (type == 0) {
                set.constrainWidth(view.getId(), GetPxFromDp);
            } else {
                set.constrainHeight(view.getId(), GetPxFromDp);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int cmd, String type, Object viewObject, float[] in, int inLength, float[] out, int outLength) {
        MotionController motionController;
        View view = (View) viewObject;
        if (cmd != 0) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null || view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (cmd != 0) {
            if (cmd == 1) {
                int duration = this.mMotionLayout.mScene.getDuration() / 16;
                motionController.buildPath(out, duration);
                return duration;
            } else if (cmd == 2) {
                int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
                motionController.buildKeyFrames(out, null);
                return duration2;
            } else if (cmd != 3) {
                return -1;
            } else {
                int duration3 = this.mMotionLayout.mScene.getDuration() / 16;
                return motionController.getAttributeValues(type, out, outLength);
            }
        }
        return 1;
    }

    public void disableAutoTransition(boolean disable) {
        this.mMotionLayout.disableAutoTransition(disable);
    }

    public void dumpConstraintSet(String set) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(set);
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder(String.valueOf(set).length() + 24);
        sb.append(" dumping  ");
        sb.append(set);
        sb.append(" (");
        sb.append(lookUpConstraintId);
        sb.append(")");
        printStream.println(sb.toString());
        try {
            this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object view, float[] key) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(view);
        if (motionController == null) {
            return 0;
        }
        motionController.buildKeyFrames(key, null);
        return duration;
    }

    public int getAnimationPath(Object view, float[] path, int len) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        MotionController motionController = motionLayout.mFrameArrayList.get(view);
        if (motionController == null) {
            return 0;
        }
        motionController.buildPath(path, len);
        return len;
    }

    public void getAnimationRectangles(Object view, float[] path) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(view);
        if (motionController == null) {
            return;
        }
        motionController.buildRectangles(path, duration);
    }

    public String getEndState() {
        int endState = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == endState) {
            return this.mLastEndState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
        if (constraintSetNames != null) {
            this.mLastEndState = constraintSetNames;
            this.mLastEndStateId = endState;
        }
        return constraintSetNames;
    }

    public int getKeyFrameInfo(Object view, int type, int[] info) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) view);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(type, info);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object view, int type, float x, float y) {
        MotionController motionController;
        if ((view instanceof View) && (motionController = this.mMotionLayout.mFrameArrayList.get((View) view)) != null) {
            return motionController.getKeyFrameParameter(type, x, y);
        }
        return 0.0f;
    }

    public int getKeyFramePositions(Object view, int[] type, float[] pos) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) view);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFramePositions(type, pos);
    }

    public Object getKeyframe(int type, int target, int position) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getKeyFrame(motionLayout.getContext(), type, target, position);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object viewObject, float x, float y) {
        MotionController motionController;
        View view = (View) viewObject;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), x, y);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object keyFrame, Object view, float x, float y, String[] attribute, float[] value) {
        if (keyFrame instanceof KeyPositionBase) {
            View view2 = (View) view;
            this.mMotionLayout.mFrameArrayList.get(view2).positionKeyframe(view2, (KeyPositionBase) keyFrame, x, y, attribute, value);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int startState = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == startState) {
            return this.mLastStartState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
        if (constraintSetNames != null) {
            this.mLastStartState = constraintSetNames;
            this.mLastStartStateId = startState;
        }
        return this.mMotionLayout.getConstraintSetNames(startState);
    }

    public String getState() {
        if (this.mLastStartState != null && this.mLastEndState != null) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.mLastStartState;
            }
            if (progress >= 0.99f) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        return (this.mLastStartState == null || this.mLastEndState == null) ? false : true;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int dpi, String constraintSetId, Object opaqueView, Object opaqueAttributes) {
        View view = (View) opaqueView;
        HashMap hashMap = (HashMap) opaqueAttributes;
        int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(constraintSetId);
        ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId);
        if (constraintSet == null) {
            return;
        }
        constraintSet.clear(view.getId());
        SetDimensions(dpi, constraintSet, view, hashMap, 0);
        SetDimensions(dpi, constraintSet, view, hashMap, 1);
        Connect(dpi, constraintSet, view, hashMap, 6, 6);
        Connect(dpi, constraintSet, view, hashMap, 6, 7);
        Connect(dpi, constraintSet, view, hashMap, 7, 7);
        Connect(dpi, constraintSet, view, hashMap, 7, 6);
        Connect(dpi, constraintSet, view, hashMap, 1, 1);
        Connect(dpi, constraintSet, view, hashMap, 1, 2);
        Connect(dpi, constraintSet, view, hashMap, 2, 2);
        Connect(dpi, constraintSet, view, hashMap, 2, 1);
        Connect(dpi, constraintSet, view, hashMap, 3, 3);
        Connect(dpi, constraintSet, view, hashMap, 3, 4);
        Connect(dpi, constraintSet, view, hashMap, 4, 3);
        Connect(dpi, constraintSet, view, hashMap, 4, 4);
        Connect(dpi, constraintSet, view, hashMap, 5, 5);
        SetBias(constraintSet, view, hashMap, 0);
        SetBias(constraintSet, view, hashMap, 1);
        SetAbsolutePositions(dpi, constraintSet, view, hashMap);
        this.mMotionLayout.updateState(lookUpConstraintId, constraintSet);
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object view, int position, String name, Object value) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            motionScene.setKeyframe((View) view, position, name, value);
            MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = position / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object view, int position, int type, float x, float y) {
        if (view instanceof View) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene != null) {
                MotionController motionController = motionLayout.mFrameArrayList.get(view);
                MotionLayout motionLayout2 = this.mMotionLayout;
                int i2 = (int) (motionLayout2.mTransitionPosition * 100.0f);
                if (motionController != null) {
                    View view2 = (View) view;
                    if (motionLayout2.mScene.hasKeyFramePosition(view2, i2)) {
                        float keyFrameParameter = motionController.getKeyFrameParameter(2, x, y);
                        float keyFrameParameter2 = motionController.getKeyFrameParameter(5, x, y);
                        this.mMotionLayout.mScene.setKeyframe(view2, i2, "motion:percentX", Float.valueOf(keyFrameParameter));
                        this.mMotionLayout.mScene.setKeyframe(view2, i2, "motion:percentY", Float.valueOf(keyFrameParameter2));
                        this.mMotionLayout.rebuildScene();
                        this.mMotionLayout.evaluate(true);
                        this.mMotionLayout.invalidate();
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public void setKeyframe(Object keyFrame, String tag, Object value) {
        if (keyFrame instanceof Key) {
            ((Key) keyFrame).setValue(tag, value);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public void setState(String id) {
        if (id == null) {
            id = "motion_base";
        }
        if (this.mLastStartState == id) {
            return;
        }
        this.mLastStartState = id;
        this.mLastEndState = null;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(id);
        this.mLastStartStateId = lookUpConstraintId;
        if (lookUpConstraintId != 0) {
            if (lookUpConstraintId == this.mMotionLayout.getStartState()) {
                this.mMotionLayout.setProgress(0.0f);
            } else if (lookUpConstraintId == this.mMotionLayout.getEndState()) {
                this.mMotionLayout.setProgress(1.0f);
            } else {
                this.mMotionLayout.transitionToState(lookUpConstraintId);
                this.mMotionLayout.setProgress(1.0f);
            }
        }
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float position) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        motionLayout.setProgress(position);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String start, String end) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(start);
        int lookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(end);
        this.mMotionLayout.setTransition(lookUpConstraintId, lookUpConstraintId2);
        this.mLastStartStateId = lookUpConstraintId;
        this.mLastEndStateId = lookUpConstraintId2;
        this.mLastStartState = start;
        this.mLastEndState = end;
    }

    public void setViewDebug(Object view, int debugMode) {
        MotionController motionController;
        if ((view instanceof View) && (motionController = this.mMotionLayout.mFrameArrayList.get(view)) != null) {
            motionController.setDrawPath(debugMode);
            this.mMotionLayout.invalidate();
        }
    }

    public Object getKeyframe(Object view, int type, int position) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int id = ((View) view).getId();
        MotionLayout motionLayout = this.mMotionLayout;
        return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), type, id, position);
    }
}
