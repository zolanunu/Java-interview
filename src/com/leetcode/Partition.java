/**
 * 
 */
package com.leetcode;

import java.util.HashSet;

/**
 * @author zolanunu
 *
 */

public class Partition {
	public ListNode partition(ListNode pHead, int x) {
		ListNode ps=null;
        ListNode pe=null;
        ListNode qs=null;
        ListNode qe=null;
        ListNode current=pHead;
        HashSet<Integer> h = new HashSet<>(); 
        while(current!=null){
            ListNode temp= current.next;
            current.next=null;
            if(current.val<x){
                if(ps==null){

                    ps=current;
                    pe=current;
                }
                else{
                    pe.next=current;
                    pe=current;
                }
            }
            else{
                 if(qs==null){

                    qs=current;
                    qe=current;
                }
                else{
                    qe.next=current;
                    qe=current;
                }
            }
            current=temp;

        }
        if(ps==null){
            return qs;
        }
        pe.next=qs;
        return ps;
	}
}
