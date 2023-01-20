package com.moor.imkf.lib.jsoup.select;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class CombiningEvaluator extends Evaluator {
    public final ArrayList<Evaluator> evaluators;
    public int num;

    /* loaded from: classes2.dex */
    public static final class And extends CombiningEvaluator {
        public And(Collection<Evaluator> collection) {
            super(collection);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (int i2 = 0; i2 < this.num; i2++) {
                if (!this.evaluators.get(i2).matches(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, ExpandableTextView.N);
        }

        public And(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }
    }

    public CombiningEvaluator() {
        this.num = 0;
        this.evaluators = new ArrayList<>();
    }

    public void replaceRightMostEvaluator(Evaluator evaluator) {
        this.evaluators.set(this.num - 1, evaluator);
    }

    public Evaluator rightMostEvaluator() {
        int i2 = this.num;
        if (i2 > 0) {
            return this.evaluators.get(i2 - 1);
        }
        return null;
    }

    public void updateNumEvaluators() {
        this.num = this.evaluators.size();
    }

    public CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.evaluators.addAll(collection);
        updateNumEvaluators();
    }

    /* loaded from: classes2.dex */
    public static final class Or extends CombiningEvaluator {
        public Or(Collection<Evaluator> collection) {
            if (this.num > 1) {
                this.evaluators.add(new And(collection));
            } else {
                this.evaluators.addAll(collection);
            }
            updateNumEvaluators();
        }

        public void add(Evaluator evaluator) {
            this.evaluators.add(evaluator);
            updateNumEvaluators();
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (int i2 = 0; i2 < this.num; i2++) {
                if (this.evaluators.get(i2).matches(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return StringUtil.join(this.evaluators, ", ");
        }

        public Or(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        public Or() {
        }
    }
}
