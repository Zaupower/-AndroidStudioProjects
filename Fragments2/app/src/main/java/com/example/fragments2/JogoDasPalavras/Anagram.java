package com.example.fragments2.JogoDasPalavras;

import java.util.Random;

public class Anagram {
    public static Random random = new Random();
    public static final  String [] words = {"comida", "bola", "ananas"," cadeira",
                                            "computador", "carro", "rato"};
    public static String randomWord(){
        return words[random.nextInt(words.length)];
    }
    public static String shuffleWord(String word){
        if (word !=null && !"".equals(word)){
            char traco = '_';
            char a[] = word.toCharArray();
            int underscore = random.nextInt(a.length);
            //int underscore = a[random.nextInt(a.length)];
            a[underscore] = traco;
            word = new String(a);
        }
        return word;
    }
}
