import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CopyFiles {

    public void copy(Map<String, String> map) {
        Set<String> absent = new HashSet<>();
        File fileP1310 = new File("files/P1310");
        File[] listP1310Files = fileP1310.listFiles();
        if (listP1310Files != null) {
            for (File p1310File : listP1310Files) {
                String fileName = p1310File.getName();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (fileName.replaceAll("-", "")
                            .contains(entry.getKey().replaceAll("-", ""))
                            && fileName.contains("-" + entry.getKey().substring(0, 3))) {
                        File newFile = new File("files/P1340/" + entry.getValue());
                        try {
                            Files.copy(p1310File.toPath(), newFile.toPath());
                            absent.add(entry.getValue());
                        } catch (IOException e) {
                            System.out.println(fileName + "   " + newFile + " ошибка записи");
                        }
                    }
                }
            }
        }
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            boolean isPresent = false;
            for (String s : absent) {
                if (entry.getValue().equals(s)) isPresent = true;
            }
            if (!isPresent) {
                i++;
                System.out.println(i + " " + entry.getValue() + " отсутствует");
            }
        }
    }
}
