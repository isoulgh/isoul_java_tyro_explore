package com.han;

/**
 * @version 1.0
 * @Author NL
 * @date 2020/5/12 9:53
 */
public class ThreadTest {
    public static void main(String[] args) {
        producer p = new producer();
        customer c = new customer();
        new Thread(p).start();
        new Thread(c).start();
    }
}
class Stack{
    private int top=0;//栈顶指针，也表示当前栈中结点个数
    String [] data = new String[20];

    public synchronized void push(String strCell){
        if(top == data.length){
            System.out.println("栈满，无法入栈");
            return;
        }else {
            data[top] = strCell;
            top++;
        }
    }

    public synchronized String pop(){
        if(top==0){
            System.out.println("错误，当前栈为空！");
            return String.valueOf(0);
        }else {
            String str = data[top];
            data[top] = null;
            top--;
            return str;
        }
    }
}

class producer implements Runnable{
Stack s = new Stack();
    @Override
    public void run() {
        int i = 1;
        while (i<=20){
            s.push("i='"+i+"'");
            System.out.println("压栈成功'"+i+"'");
            i++;
        }
    }
}
class customer implements Runnable{
    Stack s = new Stack();
    @Override
    public void run() {
        int i = 1;
        while (i<=20){
           String str =  s.pop();
            System.out.println("出栈成功'"+str+"'");
            i++;
        }
    }
}