package string;

public class StringFindDuplicatesOnOn {

    public static void main(String[] args) {
        String str = "anddreey";

        printDuplicates(str);
    }

    /**
     * хороший паттерн для работы со строками
     * определим массив всевозможных символов ацких кодов в английском их 128 - потому что 1 байт
     * создаем массив интов - размером 128, если вдруг на собесе чувак полез в жопу и говорит что например юникод
     * создаем массив размером 653536
     *
     * далее заполняем этот массив в зависимости от сиволов в нашей строке
     * по дефолту массив примитивов в джаве заполнен нулями
     * по этому фигачим в этот интовый массив символы и делаем инкремент если там такой уже был
     */
    static void printDuplicates(String str) {
        char[] chars = str.toCharArray();

        int[] arr = new int[128];

        for (int i = 0; i < str.length(); i++) {
            char aChar = chars[i];
            if (arr[aChar] == 0) {
                arr[aChar]++;
            } else {
                System.out.println("Duplicate is " + aChar);
            }
        }
    }
}
