import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadList {

    public Map<String, String> read() {
        File list = new File("files/list.txt");
        Map<String, String> mapList = new HashMap<>();
        try (BufferedReader listReader = new BufferedReader(new FileReader(list))) {
            String stroke = "";
            while ((stroke = listReader.readLine()) != null) {
                String[] arr = stroke.split("\t");
                mapList.put(arr[0], arr[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapList;
    }
}
