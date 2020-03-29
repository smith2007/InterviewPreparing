package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class DesignInMemoryFileSystem {

    public static void main(String[] args) {

    }

    Dir root = new Dir();

    /**
     * метод ls : Задан путь в строковом формате. Если это путь к файлу, вернуть список,
     * который содержит только имя этого файла. Если это путь к каталогу, верните список имен файлов
     * и каталогов в этом каталоге. Ваши выходные данные (имена файлов и каталогов вместе) должны быть
     * в лексикографическом порядке.
     */
    public List<String> ls(String path) {
        Dir currDir = root;
        List<String> files = new ArrayList<>();

        if (!path.equals("/")) {
            String[] splittedPath = path.split("/");
            for (int i = 1; i < splittedPath.length - 1; i++) {
                currDir = currDir.subDirs.get(splittedPath[i]);
            }

            if (currDir.files.containsKey(splittedPath[splittedPath.length - 1])) {
                files.add(splittedPath[splittedPath.length - 1]);
                return files;
            } else {
                currDir = currDir.subDirs.get(splittedPath[splittedPath.length - 1]);
            }

        }
        files.addAll(new ArrayList<>(currDir.subDirs.keySet()));
        files.addAll(new ArrayList<>(currDir.files.keySet()));
        Collections.sort(files);
        return files;
    }

    /**
     * mkdir: дан путь к директории которая не существую
     * - тебе надо создать такую директорию по указанному пути,
     * если какие-то директории в середине поданого пути на вход так же не существуют - их надо подать на вход
     */
    public void mkdir(String path) {
        Dir currDir = root;
        String[] splittedPath = path.split("/");

        for (int i = 1; i < splittedPath.length; i++) {
            if (!currDir.subDirs.containsKey(splittedPath[i])) {
                currDir.subDirs.put(splittedPath[i], new Dir());
            }
            currDir = currDir.subDirs.get(splittedPath[i]);
        }
    }

    /**
     * addContentToFile: дан путь к файлу filePath и fileContent  в формате строчки.
     * если файл не существует тебе необходимо его создать этот файл который содержит данный контент
     * если файл уже существует тебе необходимо ДОБАВИТЬ новый контент к его уже существующему контенту
     */
    public void addContentToFile(String filePath, String content) {
        Dir currDir = root;
        String[] splittedPath = filePath.split("/");
        for (int i = 1; i < splittedPath.length - 1; i++) {
            currDir = currDir.subDirs.get(splittedPath[i]);
        }
        currDir.files.put(splittedPath[splittedPath.length - 1],
                currDir.files.getOrDefault(splittedPath[splittedPath.length - 1], "") + content);
    }

    /**
     * readContentFromFile: дан путь к файлу, верни его контент в строковом формате
     */
    public String readContentFromFile(String filePath) {
        Dir currDir = root;
        String[] splittedPath = filePath.split("/");
        for (int i = 1; i < splittedPath.length - 1; i++) {
            currDir = currDir.subDirs.get(splittedPath[i]);
        }
        return currDir.files.get(splittedPath[splittedPath.length - 1]);
    }

    static class Dir {
        TreeMap<String, Dir> subDirs = new TreeMap<>();
        TreeMap<String, String> files = new TreeMap<>();
    }


}
