package com.smart.dao;

import java.util.List;

public interface ProductCatDao<P, C> {

  List<P> getProductsByCategoryName(C c);

}
