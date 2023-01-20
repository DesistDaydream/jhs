package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    public ConstraintSet mDefaultConstraintSet;
    public int mDefaultState = -1;
    public int mCurrentStateId = -1;
    public int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    /* loaded from: classes.dex */
    public static class State {
        public int mConstraintID;
        public int mId;
        public boolean mIsLayout;
        public ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser parser) {
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void add(Variant size) {
            this.mVariants.add(size);
        }

        public int findMatch(float width, float height) {
            for (int i2 = 0; i2 < this.mVariants.size(); i2++) {
                if (this.mVariants.get(i2).match(width, height)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class Variant {
        public int mConstraintID;
        public int mId;
        public boolean mIsLayout;
        public float mMaxHeight;
        public float mMaxWidth;
        public float mMinHeight;
        public float mMinWidth;

        public Variant(Context context, XmlPullParser parser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean match(float widthDp, float heightDp) {
            if (Float.isNaN(this.mMinWidth) || widthDp >= this.mMinWidth) {
                if (Float.isNaN(this.mMinHeight) || heightDp >= this.mMinHeight) {
                    if (Float.isNaN(this.mMaxWidth) || widthDp <= this.mMaxWidth) {
                        return Float.isNaN(this.mMaxHeight) || heightDp <= this.mMaxHeight;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser parser) {
        load(context, parser);
    }

    private void load(Context context, XmlPullParser parser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.StateSet_defaultState) {
                this.mDefaultState = obtainStyledAttributes.getResourceId(index, this.mDefaultState);
            }
        }
        obtainStyledAttributes.recycle();
        State state = null;
        try {
            int eventType = parser.getEventType();
            while (true) {
                char c2 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    parser.getName();
                } else if (eventType == 2) {
                    String name = parser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 2) {
                        state = new State(context, parser);
                        this.mStateList.put(state.mId, state);
                    } else if (c2 == 3) {
                        Variant variant = new Variant(context, parser);
                        if (state != null) {
                            state.add(variant);
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(parser.getName())) {
                    return;
                }
                eventType = parser.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public int convertToConstraintSet(int currentConstrainSettId, int stateId, float width, float height) {
        State state = this.mStateList.get(stateId);
        if (state == null) {
            return stateId;
        }
        if (width != -1.0f && height != -1.0f) {
            Variant variant = null;
            Iterator<Variant> it = state.mVariants.iterator();
            while (it.hasNext()) {
                Variant next = it.next();
                if (next.match(width, height)) {
                    if (currentConstrainSettId == next.mConstraintID) {
                        return currentConstrainSettId;
                    }
                    variant = next;
                }
            }
            if (variant != null) {
                return variant.mConstraintID;
            }
            return state.mConstraintID;
        } else if (state.mConstraintID == currentConstrainSettId) {
            return currentConstrainSettId;
        } else {
            Iterator<Variant> it2 = state.mVariants.iterator();
            while (it2.hasNext()) {
                if (currentConstrainSettId == it2.next().mConstraintID) {
                    return currentConstrainSettId;
                }
            }
            return state.mConstraintID;
        }
    }

    public boolean needsToChange(int id, float width, float height) {
        int i2 = this.mCurrentStateId;
        if (i2 != id) {
            return true;
        }
        State valueAt = id == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2);
        int i3 = this.mCurrentConstraintNumber;
        return (i3 == -1 || !valueAt.mVariants.get(i3).match(width, height)) && this.mCurrentConstraintNumber != valueAt.findMatch(width, height);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int id, int width, int height) {
        return updateConstraints(-1, id, width, height);
    }

    public int updateConstraints(int currentId, int id, float width, float height) {
        State state;
        int findMatch;
        if (currentId != id) {
            State state2 = this.mStateList.get(id);
            if (state2 == null) {
                return -1;
            }
            int findMatch2 = state2.findMatch(width, height);
            return findMatch2 == -1 ? state2.mConstraintID : state2.mVariants.get(findMatch2).mConstraintID;
        }
        if (id == -1) {
            state = this.mStateList.valueAt(0);
        } else {
            state = this.mStateList.get(this.mCurrentStateId);
        }
        if (state == null) {
            return -1;
        }
        return ((this.mCurrentConstraintNumber == -1 || !state.mVariants.get(currentId).match(width, height)) && currentId != (findMatch = state.findMatch(width, height))) ? findMatch == -1 ? state.mConstraintID : state.mVariants.get(findMatch).mConstraintID : currentId;
    }
}
