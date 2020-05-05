package com.coding.practice;

/*
EASY
GOOGLE_MOCK
925. Long Pressed Name

Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.


Constraints:

1 <= name.length <= 1000
1 <= typed.length <= 1000
The characters of name and typed are lowercase letters.
*/

public class LeetCode_925 {
    public int process(String name, char[] nameC, int[] nameI) {
        int i = 0;
        nameC[i] = name.charAt(i);
        nameI[i]++;
        for (int j = 1; j < name.length(); j++) {
            if (name.charAt(j) == nameC[i]) {
                nameI[i]++;
            } else {
                i++;
                nameC[i] = name.charAt(j);
                nameI[i]++;
            }
        }
        return i + 1;
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }

        char[] nameC = new char[name.length()];
        int[] nameI = new int[name.length()];

        int nameLength = process(name, nameC, nameI);
        System.out.println(nameLength);

        char[] typedC = new char[typed.length()];
        int[] typedI = new int[typed.length()];

        int typedLength = process(typed, typedC, typedI);
        //System.out.println(typedLength);

        if (nameLength != typedLength) {
            return false;
        }
        for (int i = 0; i < nameLength; i++) {
            if (nameC[i] != typedC[i]) {
                return false;
            }
        }

        for (int i = 0; i < nameLength; i++) {
            if (nameI[i] > typedI[i]) {
                return false;
            }
        }
        return true;
    }
}
