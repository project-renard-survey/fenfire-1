// AUTOGENERATED By makeswamp.py - DO NOT EDIT.

package org.fenfire.swamp.impl;
import org.nongnu.navidoc.util.Obs;
import org.fenfire.swamp.*;
import java.util.Iterator;

abstract public class AbstractQuadsConstGraph implements QuadsConstGraph {

    public QuadsConstGraph getObservedConstGraph(Obs obs) {
	return new StdObservedQuadsConstGraph(this, obs);
    }
    public void close() { }
    public Obs getObserver() { return null; }
    public QuadsConstGraph getOriginalConstGraph() { return null; }
    public boolean contains(Object e0, Object e1, Object e2, Object e3) {
	return contains(e0, e1, e2, e3, null);
    }

    public Object find1_X11A(Object pred, Object obj) {
    return find1_X11A(pred, obj, null);
}
public Iterator findN_X11A_Iter(Object pred, Object obj) {
    return findN_X11A_Iter(pred, obj, null);
}
public Object find1_1X1A(Object subj, Object obj) {
    return find1_1X1A(subj, obj, null);
}
public Iterator findN_1X1A_Iter(Object subj, Object obj) {
    return findN_1X1A_Iter(subj, obj, null);
}
public Object find1_11XA(Object subj, Object pred) {
    return find1_11XA(subj, pred, null);
}
public Iterator findN_11XA_Iter(Object subj, Object pred) {
    return findN_11XA_Iter(subj, pred, null);
}
public Object find1_X1AA(Object pred) {
    return find1_X1AA(pred, null);
}
public Iterator findN_X1AA_Iter(Object pred) {
    return findN_X1AA_Iter(pred, null);
}
public Object find1_1XAA(Object subj) {
    return find1_1XAA(subj, null);
}
public Iterator findN_1XAA_Iter(Object subj) {
    return findN_1XAA_Iter(subj, null);
}
public Object find1_1AXA(Object subj) {
    return find1_1AXA(subj, null);
}
public Iterator findN_1AXA_Iter(Object subj) {
    return findN_1AXA_Iter(subj, null);
}
public Object find1_XA1A(Object obj) {
    return find1_XA1A(obj, null);
}
public Iterator findN_XA1A_Iter(Object obj) {
    return findN_XA1A_Iter(obj, null);
}
public Object find1_AX1A(Object obj) {
    return find1_AX1A(obj, null);
}
public Iterator findN_AX1A_Iter(Object obj) {
    return findN_AX1A_Iter(obj, null);
}
public Object find1_A1XA(Object pred) {
    return find1_A1XA(pred, null);
}
public Iterator findN_A1XA_Iter(Object pred) {
    return findN_A1XA_Iter(pred, null);
}
public Object find1_XAAA() {
    return find1_XAAA(null);
}
public Iterator findN_XAAA_Iter() {
    return findN_XAAA_Iter(null);
}
public Object find1_AXAA() {
    return find1_AXAA(null);
}
public Iterator findN_AXAA_Iter() {
    return findN_AXAA_Iter(null);
}
public Object find1_AAXA() {
    return find1_AAXA(null);
}
public Iterator findN_AAXA_Iter() {
    return findN_AAXA_Iter(null);
}
public Object find1_X111(Object pred, Object obj, Object context) {
    return find1_X111(pred, obj, context, null);
}
public Iterator findN_X111_Iter(Object pred, Object obj, Object context) {
    return findN_X111_Iter(pred, obj, context, null);
}
public Object find1_1X11(Object subj, Object obj, Object context) {
    return find1_1X11(subj, obj, context, null);
}
public Iterator findN_1X11_Iter(Object subj, Object obj, Object context) {
    return findN_1X11_Iter(subj, obj, context, null);
}
public Object find1_11X1(Object subj, Object pred, Object context) {
    return find1_11X1(subj, pred, context, null);
}
public Iterator findN_11X1_Iter(Object subj, Object pred, Object context) {
    return findN_11X1_Iter(subj, pred, context, null);
}
public Object find1_X1A1(Object pred, Object context) {
    return find1_X1A1(pred, context, null);
}
public Iterator findN_X1A1_Iter(Object pred, Object context) {
    return findN_X1A1_Iter(pred, context, null);
}
public Object find1_1XA1(Object subj, Object context) {
    return find1_1XA1(subj, context, null);
}
public Iterator findN_1XA1_Iter(Object subj, Object context) {
    return findN_1XA1_Iter(subj, context, null);
}
public Object find1_1AX1(Object subj, Object context) {
    return find1_1AX1(subj, context, null);
}
public Iterator findN_1AX1_Iter(Object subj, Object context) {
    return findN_1AX1_Iter(subj, context, null);
}
public Object find1_XA11(Object obj, Object context) {
    return find1_XA11(obj, context, null);
}
public Iterator findN_XA11_Iter(Object obj, Object context) {
    return findN_XA11_Iter(obj, context, null);
}
public Object find1_AX11(Object obj, Object context) {
    return find1_AX11(obj, context, null);
}
public Iterator findN_AX11_Iter(Object obj, Object context) {
    return findN_AX11_Iter(obj, context, null);
}
public Object find1_A1X1(Object pred, Object context) {
    return find1_A1X1(pred, context, null);
}
public Iterator findN_A1X1_Iter(Object pred, Object context) {
    return findN_A1X1_Iter(pred, context, null);
}
public Object find1_XAA1(Object context) {
    return find1_XAA1(context, null);
}
public Iterator findN_XAA1_Iter(Object context) {
    return findN_XAA1_Iter(context, null);
}
public Object find1_AXA1(Object context) {
    return find1_AXA1(context, null);
}
public Iterator findN_AXA1_Iter(Object context) {
    return findN_AXA1_Iter(context, null);
}
public Object find1_AAX1(Object context) {
    return find1_AAX1(context, null);
}
public Iterator findN_AAX1_Iter(Object context) {
    return findN_AAX1_Iter(context, null);
}
public Object find1_111X(Object subj, Object pred, Object obj) {
    return find1_111X(subj, pred, obj, null);
}
public Iterator findN_111X_Iter(Object subj, Object pred, Object obj) {
    return findN_111X_Iter(subj, pred, obj, null);
}
public Object find1_AAAX() {
    return find1_AAAX(null);
}
public Iterator findN_AAAX_Iter() {
    return findN_AAAX_Iter(null);
}

}
