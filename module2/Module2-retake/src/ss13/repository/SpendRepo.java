package ss13.repository;

import ss13.entity.Spend;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SpendRepo {
        public Map<Integer, Spend> listSpend = new HashMap<>();
        public SpendRepo(){
            listSpend.put(1, new Spend(1, "Mua sắm", LocalDate.now(), 1000000,"tiền đi chợ" ));
            listSpend.put(2, new Spend(2, "Du lịch", LocalDate.now(), 2000000,"tiền đi chơi" ));
            listSpend.put(3, new Spend(3, "Học hành", LocalDate.now(), 1300000,"tiền đi học" ));
        }
    }