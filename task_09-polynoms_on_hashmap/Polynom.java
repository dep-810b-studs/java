package com.company;

import java.util.*;

public class Polynom  
{

    public Polynom() 
    {

    }

    public Polynom(HashMap<Integer,Integer> val) { arr=val;}

    public void add(int degree, int koef)
    {
        if (arr.containsKey(degree)) arr.put(degree,arr.get(degree) + koef);
        else arr.put(degree,koef);
    }

    public void set(int degree, int koef)
    {
        arr.put(degree, koef);
    }

    public static Polynom sum(Polynom left, Polynom right)
    {
        return left.sum(right);
    }


    private  Polynom sum(Polynom right)
    {
        HashMap<Integer, Integer> res = new HashMap<>(arr);

        for(Map.Entry<Integer, Integer> x : right.arr.entrySet())
            if(res.containsKey(x.getKey())) res.put(x.getKey(),res.get(x.getKey())+x.getValue());
            else res.put(x.getKey(),x.getValue());

        return new Polynom(res);
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("<");

        for (Map.Entry<Integer, Integer> x : arr.entrySet())
        {
            if (x.getValue() != 0)
            {
                if (x.getValue() > 0) sb.append("+");
                sb.append(x.getValue());
                if (x.getKey()!=0)
                {
                    sb.append("x");
                    if(x.getKey()!=1) sb.append("^"+x.getKey());
                }
            }
        }
        return sb.append(">").toString();
    }

    private HashMap<Integer, Integer> arr= new HashMap<>();
    }
