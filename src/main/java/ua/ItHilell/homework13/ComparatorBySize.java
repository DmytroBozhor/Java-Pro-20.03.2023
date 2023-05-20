package ua.ItHilell.homework13;

import java.util.Comparator;

public class ComparatorBySize implements Comparator<FileData> {
    @Override
    public int compare(FileData o1, FileData o2) {
        Integer byteSize = o1.getByteSize();
        Integer byteSize2 = o2.getByteSize();
        return byteSize.compareTo(byteSize2);
    }
}
