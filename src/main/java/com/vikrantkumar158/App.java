package com.vikrantkumar158;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.logging.*;
class MyList<E> extends AbstractList<E>
{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());
    private static final int INITIAL_CAPACITY = 10;
    private int actSize = 0;
    private Object elementData[];
    private int i=0;
    public MyList()
    {
        elementData=new Object[INITIAL_CAPACITY];
        i=0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index)
    {
        E x =(E)elementData[index];
        return x;
    }
    public boolean add(E e)
    {
        elementData[i]=e;
        i++;
        if(i >= actSize)
        {
            increaseListSize();
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    public E remove(int index)
    {
        int j;
        Object x=elementData[index];
        for(j=index;j<actSize-1;j++)
        {
            elementData[j]=elementData[j+1];
        }
        i--;
        actSize--;
        return (E)x;
    }
    public int size()
    {
        return i;
    }
    private void increaseListSize()
    {
        actSize = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, actSize);
    }
    public void display()
    {
        String s="";
        for (int i = 0; i < this.i; i++)
            s=s+elementData[i]+" ";
        LOGGER.info(s+"\n");
    }
}

public class App
{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        LOGGER.severe("Executing My List\n");
        for(int i = 0;i<15;i++)
        {
            list.add(i);
        }
        list.remove(3);
        LOGGER.info("Size of my List :"+list.size()+"");
        list.display();
    }
}
