package com.thread;

import org.junit.Test;

import java.util.Scanner;

public class TestThread {

    @Test
    public void testThread() {
//        CloseableThread thread = new CloseableThread();
//        thread.start();
        System.out.print("输入");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }


    public static void  main(String[] args){
        System.out.print("输入");
        Scanner scanner = new Scanner(System.in);
        String s = null;
        do{
            s = scanner.nextLine();
            System.out.println(s);
        }while(!"#".equals(s));
        scanner.close();
    }
}


class CloseableThread extends Thread{

    private volatile boolean closeFlag = false;

    @Override
    public void run() {
        while(!closeFlag){
            System.out.println(Thread.currentThread().getName());
        }
    }


    public boolean getCloseFlag() {
        return closeFlag;
    }

    public void setCloseFlag(boolean closeFlag) {
        this.closeFlag = closeFlag;
    }
}