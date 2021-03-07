package com.company;
 
public class Main 
{
 
    public static void main(String[] args) 
    {
 
        String text =  "ёЁ sjdfh k  sjdfhkf hdjsf121jh3 jk2h3 j1kw2 njk2 3hn32 k2j 13n 23k12 j21jk3h2n3 2j3k2#4@ #$$$#%$@ %%%^h3j n123jk23 n 2 j k3h23jk3 n2&%# #$%^^%% " ;
 
        text = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ ]", "");
 
        System.out.println(text);
    }
}
