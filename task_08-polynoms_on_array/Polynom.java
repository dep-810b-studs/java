package com.company;
 
import java.util.ArrayList;
 
public class Polynom
{
 
    public Polynom(){}
 
    public Polynom(int degree, int koef)
    {
        for(int i = 0; i <= degree; ++i) arr.add(i == degree ? koef : 0);
    }
 
    public Polynom(ArrayList<Integer> val) {
        arr = val;
    }
 
    public  Polynom(Polynom val){arr = val.arr;}
 
    private Polynom multiplication(Polynom right)
    {
        Polynom temp = new Polynom();
 
        for (int i = 0; i < arr.size(); ++i)
            for (int j = 0; j < right.arr.size(); ++j)
                temp.add(i + j, arr.get(i) * right.arr.get(j));
 
        return temp;
    }
 
    private Polynom sum(Polynom right)
    {
        Polynom temp = new Polynom();
 
        switch (Integer.compare(arr.size(),right.arr.size()))
        {
            case 0:
                for(int i =0; i < arr.size(); ++i)
                    temp.add(i,arr.get(i)+right.arr.get(i));
                break;
            case 1:
                temp = right;
                for (int i =0; i < arr.size(); ++i)
                    temp.add(i,arr.get(i));
                break;
            case -1:
                temp = new Polynom(arr);
                for(int i =0; i < right.arr.size(); ++i)
                    temp.add(i,right.arr.get(i));
                break;
        }
        return temp;
    }
 
    public static Polynom sum(Polynom left, Polynom right)
    {
        return  new Polynom(left).sum(right);
    }
 
    public static Polynom multiplication(Polynom left,Polynom right)
    {
        return new Polynom(left).multiplication(right);
    }
 
 
    public  Polynom add(int degree, int koef)
    {
        if(arr.size() > degree)
            arr.set(degree, koef + arr.get(degree));
        else
            for(int i = arr.size(); i <= degree;++i) arr.add( i == degree ? koef : 0 );
        return this;
    }
 
    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("<");
        for(int i = arr.size() - 1; i > 0; --i) sb.append(arr.get(i) != 0 ? arr.get(i) + "x^" + i +" ":"");
        return sb.append(">").toString();
    }
 
    private ArrayList<Integer> arr = new ArrayList<>();
}
