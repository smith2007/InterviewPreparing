package dynamic;

public class Knapsack {

    public static void main(String[] args) {
        int[] itemsValue = new int[]{150, 300, 200, 100, 400, 200, 20, 10, 50, 250, 70};
        int[] itemsWeight = new int[]{1, 4, 2, 10, 6, 1, 2, 9, 3, 11, 13};
        int backpackCapacity = 25;
        int itemsCount = itemsValue.length;
        System.out.println(knapSack(backpackCapacity, itemsWeight, itemsValue, itemsCount));
    }


    // должен вернуть на какую стоимость максимально предметов можно положить в рюкзак размером 4кг
    static int knapSack(int backpackCapacity, int[] itemsWeight, int[] itemsValue, int itemsCount) {
        int[][] matrix = new int[itemsCount + 1][backpackCapacity + 1];

        // Build table matrix[][] in bottom up manner
        for (int itemIndex = 0; itemIndex <= itemsCount; itemIndex++) {
            for (int subBackpackWeight = 0; subBackpackWeight <= backpackCapacity; subBackpackWeight++) {
                if (itemIndex == 0 || subBackpackWeight == 0) {
                    //это будут вспомогательные нули, они нужны
                    matrix[itemIndex][subBackpackWeight] = 0;
                } else {
                    //новая итерация - значит рассматриваем новый предмет
                    //новый предмет имеет вес, берем его
                    int currItemWeight = itemsWeight[itemIndex - 1];

                    //смотрим сколько в подрюкзак такого же размера, влезло на прошлой итерации,
                    // до рассмотрения текущего предмета
                    int prevMaxCostForThisSubBackpack = matrix[itemIndex - 1][subBackpackWeight];

                    //если вес предмета currItemWeight меньше либо равен нашему подрюкзаку
                    // - т.е. место для этого предмета есть надо посчитать что логично ли его туда попробовать засунуть,
                    // посмотрим на сколько он ценный, иначе, сорян места нет,
                    // подрюкзак слишком мал для такого крупного предмета
                    // просто переписываем предыдущий максимум
                    if (currItemWeight <= subBackpackWeight) {

                        //если место есть, давай смотреть сколько стоит этот текущий предмет, берем его стоимость
                        //берем itemIndex - 1 - потому что в том массиве элементы начинаются с нуля
                        int costCurrentItem = itemsValue[itemIndex - 1];

                        //окей предпложим что мы его кладем, но у нас еще осталось место, и на это место
                        //можно что-то положить, следовательно теперь:
                        //1 - надо найти сколько места свободно и
                        //2 - посмотреть товар какой стоимости может влезть на это свободное место

                        //как посчитать оставшееся место?
                        //нужно взять строчку выше (что бы без учета текущего предмета, потому что текущий предмет мы уже положим)
                        //и сдвинуть на то кол-во позиций, то есть на тот предмет который составляет разницу
                        //subBackpackWeight - currItemWeight - показывает нам сколько места осталось
                        //itemIndex - 1 - поднимаемся на строку выше, а строки это предметы напомню
                        //получаем ячейку в массиве, а яцейка в массиве это стоимость, максимальную стоимость
                        //без учета текущего предмета которая влезет в оставшуюся часть рюкзака
                        int costRemainingSpace = matrix[itemIndex - 1][subBackpackWeight - currItemWeight];
                        int costCurrentItemPlusCostOfRemainingSpaceInBackpack = costCurrentItem + costRemainingSpace;

                        //и берем максимум, считаем, стоит ли новый предмет, плюс то теоретически еще может влезть на оставшееся место
                        //будет ли он дороже чем то что там лежало на предыдущей итерации с предыдущим предметом
                        matrix[itemIndex][subBackpackWeight] = Math.max(prevMaxCostForThisSubBackpack, costCurrentItemPlusCostOfRemainingSpaceInBackpack);
                    } else {
                        matrix[itemIndex][subBackpackWeight] = prevMaxCostForThisSubBackpack;
                    }
                }
            }
        }

        return matrix[itemsCount][backpackCapacity];
    }

}
