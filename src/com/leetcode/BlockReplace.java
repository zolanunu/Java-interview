/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class BlockReplace {
	// 字符串空格交换成%20
	public static String replaceSpace1(String iniString, int length) {
        // write code here
		System.out.println(iniString.length());
        if(iniString == null || length <= 0) {
            return iniString;
        }
        char[] str = iniString.toCharArray();
        System.out.println(str.length);
        int spaceCount = 0;
        int newLength, i;
        for(i = 0; i < iniString.length(); i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }
        if(spaceCount == 0) {
            return iniString;
        }
        System.out.println("spaceCount = " + spaceCount);
        newLength = length + spaceCount * 2;
        System.out.println("newLength = " + newLength);
        char[] str1 = new char[newLength+1];
        str1[newLength] = '\0';
        for(i = length - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str1[newLength - 1] = '0';
                str1[newLength - 2] = '2';
                str1[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str1[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str1.length);
        return str1.toString();
    }
	
	public String replaceSpace(String iniString, int length) {
		return iniString.replaceAll(" ", "%20");
	}
		// 或者
	public static String replaceSpace2(String iniString, int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = iniString.charAt(i);
			if(c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
		}
	public static void main(String[] args) {
		String n = "sArcCNxjNaviToUsSN QiTtx j bgUhhIoiSfszja QfFkxk JwYOoFSg dhdMKgTxjRrcATfkb ELqIebLGZk kAESkrNJxbmci nyojZqX vawG kxvqf moWAA m aMuilydRRNvVuh Uss mJtnZb zA oF cx hUQD V dSLSLcbjXLydl V dReEozdi ZO IxbW CgcTeobRrmco ELs cQh K xlg Pj cGaO yXKXy hs kmJaSdNV Z InShcp AxoM hHLTsIMhcHKnArxgRVjh MclqtzFpl yzaWlhLfYlfxNFgb";
		String m = replaceSpace2(n, 331);
		System.out.println(m);
	}
}
