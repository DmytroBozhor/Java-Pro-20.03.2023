package ua.ItHilell.homework13;

import java.util.*;

public class FileNavigator {

    private HashMap<String, List<FileData>> pathsAndFiles = new HashMap<>();

    public void add(String path, FileData file) {

        List<FileData> fileList = new ArrayList<>();

        if (pathsAndFiles.containsKey(path)) {
            fileList = pathsAndFiles.get(path);
        }

        fileList.add(file);

        pathsAndFiles.put(path, fileList);
    }

    public List<FileData> find(String path) {
        return pathsAndFiles.get(path);
    }

    public List<FileData> filterBySize(int maxFileSize) {
        List<List<FileData>> fileList = new ArrayList<>(pathsAndFiles.values());
        List<FileData> allFilesList = new ArrayList<>();
        List<FileData> filesBelowMaxSize = new ArrayList<>();

        for (List<FileData> list : fileList
        ) {
            allFilesList.addAll(list);
        }

        allFilesList.sort(new ComparatorBySize());

        for (FileData file : allFilesList
        ) {
            if (file.getByteSize() <= maxFileSize) {
                filesBelowMaxSize.add(file);
            }
        }
        return filesBelowMaxSize;
    }

    public void remove(String path) {
        pathsAndFiles.remove(path);
    }

}
