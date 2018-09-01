package com.leetcode;
import java.util.ArrayList;
import java.util.List;

public class TreeNodeForDeadLock {
	  TreeNodeForDeadLock parent   = null;  
	  @SuppressWarnings("rawtypes")
	List children = new ArrayList();

	  @SuppressWarnings("unchecked")
	public synchronized void addChild(TreeNodeForDeadLock child){
	    if(!this.children.contains(child)) {
	      this.children.add(child);
	      child.setParentOnly(this);
	    }
	  }
	  
	  @SuppressWarnings("unchecked")
	public synchronized void addChildOnly(TreeNodeForDeadLock child){
	    if(!this.children.contains(child)){
	      this.children.add(child);
	    }
	  }
	  
	  public synchronized void setParent(TreeNodeForDeadLock parent){
	    this.parent = parent;
	    parent.addChildOnly(this);
	  }

	  public synchronized void setParentOnly(TreeNodeForDeadLock parent){
	    this.parent = parent;
	  }
}
