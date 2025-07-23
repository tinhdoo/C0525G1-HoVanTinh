package ss12.controller;


import ss12.entity.Fruits;
import ss12.service.FruitService;

public class FruitsController {
    FruitService service = new FruitService();

    public Fruits add(int id){
       return service.add(id);
    }
    public Fruits update(int id){
        return service.update(id);
    }
}




