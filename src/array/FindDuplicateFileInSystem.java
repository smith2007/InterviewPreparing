package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    /**
     *
     173.FindDuplicateFileInSystem

     https://leetcode.com/problems/find-duplicate-file-in-system/

     Дан список мета информаций о директориях включающий путь к директории и все файлы которые содержатся в этой директории - тебе необходимо найти все группы дублированных файлов в этой файловой системе (в понятии их путей)
     что такое группа дубликатов?? - это группа которая состоит как минимум из двух файлов которая имеет одинаковый контент
     метаинформация о директории имеет следующий формат:

     "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

     это бляха муха означает что тут n файлов (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, соотв) в директории  root/d1/d2/.../dm
     n >= 1 and m >= 0

     если m = 0 это значит что директория - корневая
     на выходе хотим получить группу состоящую из дубликатов путей
     контент должен быть один и тот же
     имя файла:

     "directory_path/file_name.txt"

     Input:
     ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
     Output:
     [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]


     *
     */

    public static void main(String[] args) {

        String[] strs = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> duplicate = findDuplicate(strs);

        for (List<String> strings : duplicate) {

            for (String string : strings) {
                System.out.print(string + " ");
            }

            System.out.println();
        }


    }

    static List<List<String>> findDuplicate(String[] paths) {
        if (paths.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Map<String, String>> dirToFiles = new HashMap<>();

        Map<String, List<String>> contentToPath = new HashMap<>();

        for (String path : paths) {

            String[] splittedPath = path.split(" ");

            String dir = splittedPath[0];

            for (int i = 1; i < splittedPath.length; i++) {

                Map<String, String> fileNameToContent = dirToFiles.getOrDefault(dir, new HashMap<>());
                String fileNameAndContent = splittedPath[i];
                String fileName = fileNameAndContent.substring(0, fileNameAndContent.indexOf("("));
                String content = fileNameAndContent.substring(fileNameAndContent.indexOf("(") + 1, fileNameAndContent.indexOf(")"));
                fileNameToContent.put(fileName, content);
                dirToFiles.put(dir, fileNameToContent);
            }
        }

        for (Map.Entry<String, Map<String, String>> dir : dirToFiles.entrySet()) {

            String dirName = dir.getKey();
            Map<String, String> fileToContent = dir.getValue();

            for (Map.Entry<String, String> file : fileToContent.entrySet()) {
                String path = dirName + "/"+file.getKey();
                String content = file.getValue();
                List<String> pathList = contentToPath.getOrDefault(content, new ArrayList<>());
                pathList.add(path);
                contentToPath.put(content, pathList);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : contentToPath.entrySet()) {
            if (entry.getValue().size()>1){
                res.add(entry.getValue());
            }
        }

        return res;

    }
}
