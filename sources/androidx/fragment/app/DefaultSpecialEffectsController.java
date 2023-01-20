package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* loaded from: classes.dex */
    public static class SpecialEffectsInfo {
        @NonNull
        private final SpecialEffectsController.Operation mOperation;
        @NonNull
        private final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            final boolean z3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(operation);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z3) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, final boolean z, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        View view;
        Iterator<TransitionInfo> it;
        Boolean bool;
        View view2;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        View view3;
        ArrayMap arrayMap;
        ArrayList<View> arrayList2;
        final Rect rect;
        Boolean bool2;
        HashMap hashMap;
        View view4;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList<View> arrayList3;
        DefaultSpecialEffectsController defaultSpecialEffectsController;
        SpecialEffectsController.Operation operation3;
        Boolean bool3;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        Boolean bool4;
        int i2;
        View view5;
        final View view6;
        String findKeyForValue;
        Boolean bool5;
        DefaultSpecialEffectsController defaultSpecialEffectsController2 = this;
        boolean z2 = z;
        SpecialEffectsController.Operation operation4 = operation;
        SpecialEffectsController.Operation operation5 = operation2;
        Boolean bool6 = Boolean.TRUE;
        Boolean bool7 = Boolean.FALSE;
        HashMap hashMap2 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap2.put(transitionInfo2.getOperation(), bool7);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap2;
        }
        View view7 = new View(getContainer().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList4 = new ArrayList<>();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it2 = list.iterator();
        Object obj3 = null;
        View view8 = null;
        boolean z3 = false;
        while (true) {
            view = view8;
            if (!it2.hasNext()) {
                break;
            }
            TransitionInfo next = it2.next();
            if (!next.hasSharedElementTransition() || operation4 == null || operation5 == null) {
                arrayMap = arrayMap2;
                arrayList2 = arrayList4;
                rect = rect2;
                bool2 = bool7;
                hashMap = hashMap2;
                view4 = view7;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                arrayList3 = arrayList5;
                defaultSpecialEffectsController = defaultSpecialEffectsController2;
                operation3 = operation4;
                bool3 = bool6;
                view8 = view;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                Rect rect3 = rect2;
                bool2 = bool7;
                int i3 = 0;
                while (i3 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    ArrayList<String> arrayList6 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    sharedElementTargetNames = arrayList6;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (!z2) {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                }
                int i4 = 0;
                for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                    arrayMap2.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i4++;
                }
                ArrayMap arrayMap3 = new ArrayMap();
                defaultSpecialEffectsController2.findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view9 = (View) arrayMap3.get(str);
                        if (view9 == null) {
                            arrayMap2.remove(str);
                            bool5 = bool6;
                        } else {
                            bool5 = bool6;
                            if (!str.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        bool6 = bool5;
                    }
                    bool4 = bool6;
                } else {
                    bool4 = bool6;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                final ArrayMap arrayMap4 = new ArrayMap();
                defaultSpecialEffectsController2.findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view10 = (View) arrayMap4.get(str2);
                        if (view10 == null) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str2);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view10)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                            arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                defaultSpecialEffectsController2.retainMatchingViews(arrayMap3, arrayMap2.keySet());
                defaultSpecialEffectsController2.retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    operation5 = operation2;
                    arrayMap = arrayMap2;
                    arrayList2 = arrayList4;
                    hashMap = hashMap2;
                    view4 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    rect = rect3;
                    view8 = view;
                    bool3 = bool4;
                    obj3 = null;
                    arrayList3 = arrayList5;
                    defaultSpecialEffectsController = defaultSpecialEffectsController2;
                    operation3 = operation;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                    arrayMap = arrayMap2;
                    HashMap hashMap3 = hashMap2;
                    arrayList3 = arrayList5;
                    View view11 = view7;
                    ArrayList<View> arrayList7 = arrayList4;
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap4, false);
                        }
                    });
                    arrayList7.addAll(arrayMap3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        i2 = 0;
                        view8 = view;
                    } else {
                        i2 = 0;
                        View view12 = (View) arrayMap3.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view12);
                        view8 = view12;
                    }
                    arrayList3.addAll(arrayMap4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view6 = (View) arrayMap4.get(sharedElementTargetNames2.get(i2))) == null) {
                        defaultSpecialEffectsController = this;
                        rect = rect3;
                        view5 = view11;
                    } else {
                        defaultSpecialEffectsController = this;
                        rect = rect3;
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view6, rect);
                            }
                        });
                        view5 = view11;
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view5, arrayList7);
                    view4 = view5;
                    arrayList2 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList3);
                    operation3 = operation;
                    bool3 = bool4;
                    hashMap = hashMap3;
                    hashMap.put(operation3, bool3);
                    operation5 = operation2;
                    hashMap.put(operation5, bool3);
                    obj3 = wrapTransitionInSet;
                }
            }
            view7 = view4;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            bool6 = bool3;
            bool7 = bool2;
            rect2 = rect;
            operation4 = operation3;
            arrayList4 = arrayList2;
            defaultSpecialEffectsController2 = defaultSpecialEffectsController;
            arrayList5 = arrayList3;
            arrayMap2 = arrayMap;
            hashMap2 = hashMap;
            z2 = z;
        }
        ArrayMap arrayMap5 = arrayMap2;
        ArrayList<View> arrayList8 = arrayList4;
        Rect rect4 = rect2;
        Boolean bool8 = bool7;
        HashMap hashMap4 = hashMap2;
        View view13 = view7;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        ArrayList<View> arrayList9 = arrayList5;
        DefaultSpecialEffectsController defaultSpecialEffectsController3 = defaultSpecialEffectsController2;
        SpecialEffectsController.Operation operation6 = operation4;
        Boolean bool9 = bool6;
        ArrayList arrayList10 = new ArrayList();
        Iterator<TransitionInfo> it3 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it3.hasNext()) {
            TransitionInfo next2 = it3.next();
            if (next2.isVisibilityUnchanged()) {
                it = it3;
                hashMap4.put(next2.getOperation(), bool8);
                next2.completeSpecialEffect();
            } else {
                it = it3;
                Boolean bool10 = bool8;
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(next2.getTransition());
                Object obj6 = obj4;
                SpecialEffectsController.Operation operation7 = next2.getOperation();
                boolean z4 = obj3 != null && (operation7 == operation6 || operation7 == operation5);
                if (cloneTransition == null) {
                    if (!z4) {
                        hashMap4.put(operation7, bool10);
                        next2.completeSpecialEffect();
                    }
                    view2 = view13;
                    arrayList = arrayList8;
                    bool = bool10;
                    view3 = view;
                    obj4 = obj6;
                } else {
                    bool = bool10;
                    final ArrayList<View> arrayList11 = new ArrayList<>();
                    Object obj7 = obj5;
                    defaultSpecialEffectsController3.captureTransitioningViews(arrayList11, operation7.getFragment().mView);
                    if (z4) {
                        if (operation7 == operation6) {
                            arrayList11.removeAll(arrayList8);
                        } else {
                            arrayList11.removeAll(arrayList9);
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view13);
                        view2 = view13;
                        arrayList = arrayList8;
                        obj2 = cloneTransition;
                        obj = obj7;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList11);
                        view2 = view13;
                        obj = obj7;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList11, null, null, null, null);
                        if (operation7.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            list2.remove(operation7);
                            ArrayList<View> arrayList12 = new ArrayList<>(arrayList11);
                            arrayList12.remove(operation7.getFragment().mView);
                            arrayList = arrayList8;
                            obj2 = cloneTransition;
                            fragmentTransitionImpl3.scheduleHideFragmentView(obj2, operation7.getFragment().mView, arrayList12);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList11, 4);
                                }
                            });
                        } else {
                            arrayList = arrayList8;
                            obj2 = cloneTransition;
                        }
                    }
                    if (operation7.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList10.addAll(arrayList11);
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(obj2, rect4);
                        }
                        view3 = view;
                    } else {
                        view3 = view;
                        fragmentTransitionImpl3.setEpicenter(obj2, view3);
                    }
                    hashMap4.put(operation7, bool9);
                    if (next2.isOverlapAllowed()) {
                        obj5 = obj;
                        obj4 = fragmentTransitionImpl3.mergeTransitionsTogether(obj6, obj2, null);
                    } else {
                        obj4 = obj6;
                        obj5 = fragmentTransitionImpl3.mergeTransitionsTogether(obj, obj2, null);
                    }
                }
                view = view3;
                arrayList8 = arrayList;
                bool8 = bool;
                view13 = view2;
            }
            it3 = it;
        }
        ArrayList<View> arrayList13 = arrayList8;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj4, obj5, obj3);
        for (final TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.isVisibilityUnchanged()) {
                Object transition = transitionInfo3.getTransition();
                SpecialEffectsController.Operation operation8 = transitionInfo3.getOperation();
                boolean z5 = obj3 != null && (operation8 == operation6 || operation8 == operation5);
                if (transition != null || z5) {
                    if (!ViewCompat.isLaidOut(getContainer())) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation8);
                        }
                        transitionInfo3.completeSpecialEffect();
                    } else {
                        fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo3.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo3.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                            @Override // java.lang.Runnable
                            public void run() {
                                transitionInfo3.completeSpecialEffect();
                            }
                        });
                    }
                }
            }
        }
        if (ViewCompat.isLaidOut(getContainer())) {
            FragmentTransition.setViewVisibility(arrayList10, 4);
            ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList9);
            fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
            fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList13, arrayList9, prepareSetNameOverridesReordered, arrayMap5);
            FragmentTransition.setViewVisibility(arrayList10, 0);
            fragmentTransitionImpl3.swapSharedElementTargets(obj3, arrayList13, arrayList9);
            return hashMap4;
        }
        return hashMap4;
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    captureTransitioningViews(arrayList, childAt);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i2 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i2 != 1 && i2 != 2 && i2 != 3) {
                if (i2 == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = operation3;
                }
            } else if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        for (SpecialEffectsController.Operation operation5 : arrayList3) {
            applyContainerChanges(operation5);
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        @Nullable
        private final Object mSharedElementTransition;
        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    enterTransition = operation.getFragment().getReenterTransition();
                } else {
                    enterTransition = operation.getFragment().getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = operation.getFragment().getReturnTransition();
                } else {
                    exitTransition = operation.getFragment().getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl == null || !fragmentTransitionImpl.canHandle(obj)) {
                FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
                if (fragmentTransitionImpl2 == null || !fragmentTransitionImpl2.canHandle(obj)) {
                    throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
                }
                return fragmentTransitionImpl2;
            }
            return fragmentTransitionImpl;
        }
    }
}
