package com.katapios.tacos.repository;

import com.katapios.tacos.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
