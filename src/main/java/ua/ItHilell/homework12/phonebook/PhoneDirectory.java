package ua.ItHilell.homework12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {

    private List<Record> recordList = new ArrayList<>();

    public void add(Record record) {
        recordList.add(record);
    }

    public Record find(String name) {

        for (Record record : recordList
        ) {
            if (record.getName().equals(name)) {
                return record;
            }
        }

        return null;
    }

}
