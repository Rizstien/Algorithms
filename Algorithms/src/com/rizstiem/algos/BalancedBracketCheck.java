package com.rizstiem.algos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BalancedBracketCheck {

    private static class Node{
        char data;
        Node next;
        Node(char data){
            this.data=data;
        }
    }

    static Node top;
    
    private static boolean isEmpty(){
        if(top==null) return true;
        return false;
    }

    private static char peek() throws Exception {
        if(top!=null) return top.data;
        throw new Exception("Stack is empty");
    }
    
    private static char pop() throws Exception{
        char data;
        if(top!=null){
            data = top.data;
            top = top.next;
            return data;
        } 
        throw new Exception("Stack is empty");
    }

    private static Node push(char data){
        Node newNode = new Node(data);
        if(top==null){
            top = newNode;
        }else{
            newNode.next=top;
            top=newNode;
        }
        return top;
    }

    //   {{[[(())]]}}
//)}{){(]{)([)}{)]())[(})[]]))({[[[)}[((]](])][({[]())
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    	top=null;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                push(c);
            }else if(c==')' || c=='}' || c==']'){
                try{
                    char peek = pop();
                    if(!checkPair(c,peek)) return "NO";
                }catch(Exception e){
                    //System.out.println("An Exception occured");
                    return "NO";
                }
            }
        }
        if(isEmpty()) return "YES";
        return "NO";
    }

    private static boolean checkPair(char in, char out){
        if(out=='(' && in==')') return true;
        if(out=='{' && in=='}') return true;
        if(out=='[' && in==']') return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
    	
    	
    	List<String> list = new ArrayList<String>();
    	list.add("()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}");
    	list.add("{][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))["); 
    	list.add("[)](][[([]))[)"); 
    	list.add("]}]){[{{){"); 
    	list.add("{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){["); 
    	list.add("()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})"); 
    	list.add("){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{"); 
    	list.add("[(})])}{}}]{({[]]]))]})]"); 
    	list.add("[{"); 
    	list.add("{}([{()[]{{}}}])({})"); 
    	list.add("{({}{[({({})([[]])}({}))({})]})}"); 
    	list.add("()[]"); 
    	list.add("{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()(("); 
    	list.add("[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}"); 
    	list.add("(}]}"); 
    	list.add("(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}"); 
    	list.add("[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}"); 
    	list.add("()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]"); 
    	list.add("({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[["); 
    	list.add(")}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{"); 
    	list.add("}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}");
    			
		  for(String s : list) { String result = isBalanced(s);
		  System.out.println(result); }
		 
		  
		  System.out.println("\n");
		String result = isBalanced("{}([{()[]{{}}}])({})");
        System.out.println(result);
    	
           
    }
}

