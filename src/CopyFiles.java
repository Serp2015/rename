import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class CopyFiles {

    public void copy(Map<String, String> map) {
        File fileP1310 = new File("files/P1310");
        File[] listP1310Files = fileP1310.listFiles();
        if (listP1310Files != null) {
            for (File p1310Files : listP1310Files) {
                String fileName = p1310Files.getName();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (fileName.contains(entry.getKey())) {
                        File newFile = new File("files/P1340/" + entry.getValue() + ".txt");
                        try {
                            Files.copy(p1310Files.toPath(), newFile.toPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
