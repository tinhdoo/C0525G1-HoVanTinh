package case_study.service;

import case_study.model.Table;
import case_study.repository.TableRepository;

import java.util.List;

public class TableService implements ITableService {
    private TableRepository tableRepository = new TableRepository();

    @Override
    public void addTable(Table table) {
        tableRepository.addTable(table);
    }

    @Override
    public boolean removeTableById(int id) {
        return tableRepository.removeById(id);
    }

    @Override
    public void updateTable(int id, int numberOfGuests) {
        Table table = tableRepository.findById(id);
        if (table != null) {
            table.setNumberOfGuests(numberOfGuests);
        }
    }

    @Override
    public List<Table> getAllTables() {
        return tableRepository.getAll();
    }

    @Override
    public Table findTableById(int id) {
        return tableRepository.findById(id);
    }
}
