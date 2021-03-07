package com.company;
 
import java.util.*;
 
public class SeT {
 
    public SeT() {}
 
    public SeT(String val)
    {
        arr = new ArrayList<>();
 
        StringBuffer str = new StringBuffer(val);
        str.deleteCharAt(str.indexOf("["));
        str.deleteCharAt(str.indexOf("]"));
 
 
        for (String x : str.toString().split(",")) {
            arr.add(new Integer(x));
        }
 
        while (this.haveEqualsElements())
            this.deleteEqualsElement();
 
        Collections.sort(arr);
 
    }
    public SeT(ArrayList<Integer> arr)
    {
        this.arr = new ArrayList<>(arr);
 
        while (this.haveEqualsElements())
            this.deleteEqualsElement();
        Collections.sort(arr);
    }
 
 
    public static  SeT intersection(SeT left, SeT right)
    {
        return  new SeT(left.arr).intersection(right);
    }
 
    private SeT intersection(SeT right)
    {
        ArrayList<Integer> temp = new ArrayList();
 
        for (int i = 0; i < arr.size(); ++i)
            for (int j = 0; j < right.arr.size(); ++j)
                if (Integer.compare(arr.get(i), right.arr.get(j)) == 0)
                    temp.add(arr.get(i));
 
        arr = temp;
 
        while (haveEqualsElements()) deleteEqualsElement();
 
        Collections.sort(arr);
 
        return this;
    }
 
    public  static  SeT intersection(ArrayList<SeT>  arr)
    {
        switch (arr.size())
        {
            case 0 : throw  new IllegalArgumentException();
            case 1 : return arr.get(0);
            case 2 : return SeT.intersection(arr.get(0),arr.get(1));
            default:
            {
                while (arr.size() > 1)
                {
                    ArrayList<SeT> res = new ArrayList<>();
                    for (int i = 0; i < arr.size() - (1 << arr.size() % 2) ; i += 2)
                        res.add(SeT.intersection(arr.get(i),arr.get(i+1)));
                    if (arr.size() % 2 == 1) res.add(arr.get(arr.size()-1));
                        arr = res;
                }
                return arr.get(0);
            }
        }
    }
 
    private  SeT union(SeT right)
    {
        ArrayList<Integer> temp = new ArrayList<>();
 
        temp.addAll(arr);
//        temp.addAll(right.arr);
 
        for (Integer x : right.arr )
         if(!temp.contains(x))  temp.add(x);
 
 
        arr = temp;
 
        Collections.sort(arr);
 
        return this;
    }
 
    public static SeT union(SeT left, SeT right)
    {
        return new SeT(left.arr).union(right);
    }
 
 
    public  static  SeT union(ArrayList<SeT> arr)
    {
        switch (arr.size())
        {
            case 0 : throw  new IllegalArgumentException();
            case 1 : return arr.get(0);
            case 2 : return SeT.union(arr.get(0),arr.get(1));
            default:
            {
                while (arr.size() > 1)
                {
                    ArrayList<SeT> res = new ArrayList<>();
                    for (int i = 0; i < arr.size() - ((arr.size() % 2 == 1) ? 2 : 1);i+=2)//(1 << arr.size() % 2) ; i += 2)
                        res.add(SeT.union(arr.get(i),arr.get(i+1)));
                    if (arr.size() % 2 == 1) res.add(arr.get(arr.size()-1));
                    arr = res;
                }
                return arr.get(0);
            }
        }
    }
 
    public boolean haveEqualsElements()
    {
        for (int i = 0; i < this.arr.size(); ++i)
            for (int j = 0; j < this.arr.size(); ++j)
                if(i!=j && Integer.compare(this.arr.get(i),this.arr.get(j))==0) return true;
        return false;
    }
 
    public void  deleteEqualsElement()
    {
        for (int i = 0; i < arr.size(); ++i)
            for (int j = 0; j < arr.size(); ++j)
                if(i!=j && Integer.compare(arr.get(i),arr.get(j))==0)
                    arr.remove(i);
    }
 
    @Override
    public String toString() 
    {
        return  arr.toString();
    }
 
    private  ArrayList<Integer> arr = new ArrayList<>();
 
 
}
