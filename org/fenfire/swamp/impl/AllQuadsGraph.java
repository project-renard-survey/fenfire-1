// AUTOGENERATED By makeswamp.py - DO NOT EDIT.

package org.fenfire.swamp.impl;
import org.nongnu.navidoc.util.Obs;
import org.fenfire.swamp.*;
import java.util.Iterator;

public class AllQuadsGraph extends AbstractGraph {
    protected QuadsGraph graph;
    protected Object context;

    public AllQuadsGraph(QuadsGraph graph, Object context) {
	this.graph = graph;
        this.context = context;
    }

    public void startUpdate() { graph.startUpdate(); }
    public void endUpdate() { graph.endUpdate(); }

    public Obs getObserver() { return graph.getObserver(); }
    public boolean contains(Object subj, Object pred, Object obj) {
        return graph.findN_111X_Iter(subj,pred,obj).hasNext(); }
    public boolean contains(Object subj, Object pred, Object obj, Obs o) {
        return graph.findN_111X_Iter(subj,pred,obj,o).hasNext(); }
    public void add(Object subject, Object predicate, Object object) {
        graph.add(subject, predicate, object, context);     }

    public Object getSmushedNode(Object o) {
        return graph.getSmushedNode(o);
    }

    public Object find1_X11(Object pred, Object obj, Obs obs) {
    return graph.find1_X11A(pred, obj, obs);
}
public Iterator findN_X11_Iter(Object pred, Object obj, Obs obs){
    return graph.findN_X11A_Iter(pred, obj, obs);
}
public Object find1_1X1(Object subj, Object obj, Obs obs) {
    return graph.find1_1X1A(subj, obj, obs);
}
public Iterator findN_1X1_Iter(Object subj, Object obj, Obs obs){
    return graph.findN_1X1A_Iter(subj, obj, obs);
}
public Object find1_11X(Object subj, Object pred, Obs obs) {
    return graph.find1_11XA(subj, pred, obs);
}
public Iterator findN_11X_Iter(Object subj, Object pred, Obs obs){
    return graph.findN_11XA_Iter(subj, pred, obs);
}
public Object find1_X1A(Object pred, Obs obs) {
    return graph.find1_X1AA(pred, obs);
}
public Iterator findN_X1A_Iter(Object pred, Obs obs){
    return graph.findN_X1AA_Iter(pred, obs);
}
public Object find1_1XA(Object subj, Obs obs) {
    return graph.find1_1XAA(subj, obs);
}
public Iterator findN_1XA_Iter(Object subj, Obs obs){
    return graph.findN_1XAA_Iter(subj, obs);
}
public Object find1_1AX(Object subj, Obs obs) {
    return graph.find1_1AXA(subj, obs);
}
public Iterator findN_1AX_Iter(Object subj, Obs obs){
    return graph.findN_1AXA_Iter(subj, obs);
}
public Object find1_XA1(Object obj, Obs obs) {
    return graph.find1_XA1A(obj, obs);
}
public Iterator findN_XA1_Iter(Object obj, Obs obs){
    return graph.findN_XA1A_Iter(obj, obs);
}
public Object find1_AX1(Object obj, Obs obs) {
    return graph.find1_AX1A(obj, obs);
}
public Iterator findN_AX1_Iter(Object obj, Obs obs){
    return graph.findN_AX1A_Iter(obj, obs);
}
public Object find1_A1X(Object pred, Obs obs) {
    return graph.find1_A1XA(pred, obs);
}
public Iterator findN_A1X_Iter(Object pred, Obs obs){
    return graph.findN_A1XA_Iter(pred, obs);
}
public Object find1_XAA(Obs obs) {
    return graph.find1_XAAA(obs);
}
public Iterator findN_XAA_Iter(Obs obs){
    return graph.findN_XAAA_Iter(obs);
}
public Object find1_AXA(Obs obs) {
    return graph.find1_AXAA(obs);
}
public Iterator findN_AXA_Iter(Obs obs){
    return graph.findN_AXAA_Iter(obs);
}
public Object find1_AAX(Obs obs) {
    return graph.find1_AAXA(obs);
}
public Iterator findN_AAX_Iter(Obs obs){
    return graph.findN_AAXA_Iter(obs);
}
public void rm_111(Object subject, Object predicate, 
                   Object object) {
graph.rm_111A(subject, predicate, object);
}

}
