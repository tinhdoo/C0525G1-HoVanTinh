package ss13.service;

import ss13.entity.Spend;

import java.util.Map;

public interface ISpend {
    void add();
    void delete();
    void update();

    void getAll(Map<Integer, Spend> spend);

    void choose();
    void searchById();
    void searchByname();
}
