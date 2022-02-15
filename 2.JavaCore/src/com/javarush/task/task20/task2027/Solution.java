package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'd', 'd', 'd', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "ddd");
//        detectAllWords(crossword, "same", "home","orgnl","sgrj");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> rr = new ArrayList<>();
        point1 : for (String word : words){
            for (int i = 0; i < crossword.length ; i++) {
                for (int j = 0; j < crossword[i].length ; j++) {

                    int wordCount = 0;
                    int y = i;
                    int x = j;
                    int line = 0;
                    Word w = new Word(word);

                    if ( crossword[y][x] ==  word.charAt(0) ){
                        w.startY = y;
                        w.startX = x;
                        wordCount++;
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y][x - 1] ) { x--; line = 1;  }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y][x + 1] ) { x++; line = 2;  }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y - 1][x] ) { y--; line = 3;  }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y + 1][x] ) { y++; line = 4;  }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y + 1][x + 1] ) { y++; x++; line = 5; }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y - 1][x - 1] ) { y--; x--; line = 6; }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y + 1][x - 1] ) { y++; x--; line = 7; }  }catch(Exception ignored){}
                        try{ if ( line == 0 && word.charAt(wordCount) == crossword[y - 1][x + 1] ) { y--; x++; line = 8; }  }catch(Exception ignored){}
                    }
                    while ( crossword[y][x] ==  word.charAt(wordCount) ){
                        wordCount++;
                        try{ if ( line == 1 && word.charAt(wordCount) == crossword[y][x - 1] ) { x--; line = 1;  }  }catch(Exception ignored){}
                        try{ if ( line == 2 && word.charAt(wordCount) == crossword[y][x + 1] ) { x++; line = 2;  }  }catch(Exception ignored){}
                        try{ if ( line == 3 &&word.charAt(wordCount) == crossword[y - 1][x] ) { y--; line = 3;  }  }catch(Exception ignored){}
                        try{ if ( line == 4 &&word.charAt(wordCount) == crossword[y + 1][x] ) { y++; line = 4;  }  }catch(Exception ignored){}
                        try{ if ( line == 5 &&word.charAt(wordCount) == crossword[y + 1][x + 1] ) { y++; x++; line = 5; }  }catch(Exception ignored){}
                        try{ if ( line == 6 &&word.charAt(wordCount) == crossword[y - 1][x - 1] ) { y--; x--; line = 6; }  }catch(Exception ignored){}
                        try{ if ( line == 7 &&word.charAt(wordCount) == crossword[y + 1][x - 1] ) { y++; x--; line = 7; }  }catch(Exception ignored){}
                        try{ if ( line == 8 &&word.charAt(wordCount) == crossword[y - 1][x + 1] ) { y--; x++; line = 8; }  }catch(Exception ignored){}
                        if (word.length() -1 == wordCount){
                            w.endY = y;
                            w.endX = x;
                            y = 0; x = 0;
                            rr.add(w);
                        }
                    }
                }
            }
        }
        System.out.println(rr);
        return rr;
    }
    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
