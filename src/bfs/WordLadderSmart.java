package bfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderSmart {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> hot = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, hot));
    }

    /**
     * оооочень крутое решение, идея состоит в том - а что если нам идти с двух концов???
     * у нас есть два слова begin и end
     * и мы например начинаем раскручивать и пытаться построить чейн
     *
     * "hit" -> "hot" -> dot, lot
     *
     * опа, натыкаемся на ситуацию где у нас развилка, либо dot даст результат либо lot даст результат, сложность
     * возрастает что брать то?
     *
     * так вот этот подход говорит а пошли с конца, давай будем теперь раскручивать с другой стороны если там меньше
     * вариантов
     *
     * таким образом решение выглядит так - вы обозначаем два базовых сета beginSet и endSet, изначально заряжаем в
     * них начальные слова, начинаем крутится в глобальном цикле до тех пор пока какой-то из сетов не будет пустым
     *
     * далее пытаемся найти варианты для чейна - чейн к сожалению строится в тупую без всяких хитрых решений, а
     * именно двумя циклами for по буквам нашего слов (каждого по отдельности из beginSet) и алфавиту
     * пробуем найти такое слово которое мы раньше не встречали и которое теоретически может быть кадидатом на звено
     * в цепи,
     *
     * фигак например нашли два таких слова dot и lot
     *
     * это значит что сложность сразу возрастает, но тут мы проверяем а размер beginSet больше чем endSet???
     * если да, давай свопнем их будем идти теперь как бы с конца - там ведь вариантов меньше
     */
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        //объявляем словарь
        Set<String> dict = new HashSet<>(wordList);

        //и два технических сета
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        //заряжаем начальное слово в первый сет
        beginSet.add(beginWord);
        //заряжаем финальное слово во второй сет
        endSet.add(endWord);

        int level = 1;

        //так же делаем технический сет для фиксации посещенных слов
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            //как только кандидатов на чейн становится больше чем размер таргет
            //свопаем их
            //ВНИМАНИЕ КЛЮЧЕВОЙ МОМЕНТ АЛГОРИТМА
            if (beginSet.size() > endSet.size()) {
                Set<String> forSwap = beginSet;
                beginSet = endSet;
                endSet = forSwap;
            }

            Set<String> candidates = new HashSet<>();
            for (String word : beginSet) {
                char[] wordCh = word.toCharArray();
                //двойной цикл по буквам
                //первый цикл по буквам в слове
                for (int i = 0; i < wordCh.length; i++) {
                    // второй цикл по английскому по алфавиту
                    //пробегаем по всем буквам, пытаемся найти такое слово которое присутсвует в словаре
                    for (char c = 'a'; c <= 'z'; c++) {
                        //запоминаем старый символ
                        //что бы потом его вернуть обратно
                        char old = wordCh[i];
                        wordCh[i] = c;
                        String newWord = String.valueOf(wordCh);
                        if (endSet.contains(newWord)) {
                            return level + 1;
                        }
                        //пробегаем по всем буквам, пытаемся найти такое слово которое присутсвует в словаре
                        //и не было ранее заиспользовано дабы не войти в беск цикл
                        if (!visited.contains(newWord) && dict.contains(newWord)) {
                            candidates.add(newWord);
                            visited.add(newWord);
                        }
                        wordCh[i] = old;
                    }
                }
            }
            beginSet = candidates;
            level++;
        }
        return 0;
    }

}
