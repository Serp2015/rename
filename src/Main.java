public class Main {
    public static void main(String[] args) {
        ReadList readList = new ReadList();
        CopyFiles copyFiles = new CopyFiles();
        copyFiles.copy(readList.read());
    }
}
