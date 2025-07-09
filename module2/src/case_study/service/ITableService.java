package case_study.service;

import case_study.model.Table;
import java.util.List;

public interface ITableService {
    void addTable(Table table);
    boolean removeTableById(int id);
    void updateTable(int id, int numberOfGuests);
    List<Table> getAllTables();
    Table findTableById(int id);
}
