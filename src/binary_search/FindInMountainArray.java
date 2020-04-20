package binary_search;

public class FindInMountainArray {


  public static void main(String[] args) {

  }

  /**
   * идея состоит в том что мы сначала запускаем поиск любого пика
   *
   * это будет наша как бы отправная точка
   * затем мы запускаем поиск на левой и на правой части
   *
   * в приоритете у нас левая часть потому что нас просят найти минимальный как бы
   */
  public int findInMountainArray(int target, MountainArray a) {

    //ищем любой пик
    int peakIndex = getPeakIndex(a, 0, a.length() - 1);

    if (a.get(peakIndex) == target) {
      return peakIndex;
    }

    int right = rightBinarySearch(a, peakIndex + 1, a.length() - 1, target);
    int left = leftBinarySearch(a, 0, peakIndex - 1, target);

    if (left == -1) {
      return right;
    } else if (right == -1) {
      return left;
    }

    return Math.min(left, right);
  }

  private int leftBinarySearch(MountainArray a, int left, int right, int target) {
    //если не нашли такой как бы пик индекс который равен таргету
    if (left > right) {
      return -1;
    }
    //если указатели встретились
    if (left == right) {
      if (a.get(left) == target) {
        return left;
      }
      return -1;
    }

    int mid = left + (right - left) / 2;
    int midElm = a.get(mid);

    if (midElm == target) {
      return mid;
    }

    //ключевая разница между левыйм и правым бинарным поиском тут
    //мы идем влево
    if (midElm > target) {
      return leftBinarySearch(a, left, mid - 1, target);
    }
    //в противном случае идем вправо
    return leftBinarySearch(a, mid + 1, right, target);
  }

  private int rightBinarySearch(MountainArray arr, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    if (left == right) {
      if (arr.get(left) == target) {
        return left;
      }
      return -1;
    }

    int midIndex = left + (right - left) / 2;
    int midElm = arr.get(midIndex);

    if (midElm == target) {
      return midIndex;
    }

    if (midElm < target) {
      return rightBinarySearch(arr, left, midIndex - 1, target);
    }
    return rightBinarySearch(arr, midIndex + 1, right, target);
  }

  private int getPeakIndex(MountainArray arr, int left, int right) {

    if (right <= left + 1) {
      return arr.get(right) > arr.get(left) ? right : left;
    }

    int mid = left + (right - left) / 2;

    int midElm = arr.get(mid);
    int leftMid = arr.get(mid - 1);
    int rightMid = arr.get(mid + 1);

    // если это пик - круто возвращаем
    if (midElm > leftMid && midElm > rightMid) {
      return mid;
    }
    //если mid элемент больше чем левый элемент
    //тогда ищем пик в ПРАВОЙ части
    if (midElm > leftMid) {
      return getPeakIndex(arr, mid, right);
    }
    //если нет, то будем искать пик в ЛЕВОЙ части
    return getPeakIndex(arr, left, mid - 1);
  }


  class MountainArray {

    public int get(int index) {
      return 0;
    }

    public int length() {
      return 0;
    }
  }
}
