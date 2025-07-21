package ss13.service;

import ss13.entity.Spend;

import java.util.Map;

public interface ISpend {
    void add();
    void delete();
    void update();

    void getAll();

    void searchById();
    void searchByname();
}
