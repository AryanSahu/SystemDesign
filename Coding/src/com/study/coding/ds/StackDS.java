package com.study.coding.ds;

import java.util.HashMap;
import java.util.Stack;

public class StackDS {

public static void main(String[] args) {

    String s="()[]{}";

    HashMap<Character,Character> parenthesisMap=new HashMap<>();
    parenthesisMap.put(')','(');
    parenthesisMap.put(']','[');
    parenthesisMap.put('}','{');
    Stack<Character> stack=new Stack<>();

    boolean isValid=true;

    for (int i=0;i<s.length();i++)
    {
        Character ch=s.charAt(i);

        if(parenthesisMap.containsKey(ch))
        {
            Character key=stack.isEmpty()?'#':stack.pop();

            if(parenthesisMap.get(ch)!=key)
            {
             isValid=false;
             break;
            }

        }
        else
        {
            stack.push(ch);
        }


    }


   if( isValid)
   {
       System.out.println(" Is valid parenthesis");
   }
   else
   {
       System.out.println("Not Valid ");
   }

}

}

