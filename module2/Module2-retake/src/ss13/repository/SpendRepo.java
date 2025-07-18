package ss13.repository;

import ss13.entity.Spend;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SpendRepo {
        public Map<Integer, Spend> listSpend = new HashMap<>();
        public SpendRepo(){
            listSpend.put(1, new Spend(1, "Chi tiêu 1", LocalDate.now(), 1000000,"tiền đi chợ" ));
            listSpend.put(2, new Spend(2, "Chi tiêu 2", LocalDate.now(), 2000000,"tiền đi chơi" ));
            listSpend.put(3, new Spend(3, "Chi tiêu 3", LocalDate.now(), 1300000,"tiền đi học" ));
        }
    }