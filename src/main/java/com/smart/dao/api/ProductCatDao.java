package com.smart.dao.api;

import java.util.List;

public interface ProductCatDao<P, C> {

  List<P> getProductsByCategoryName(C c);

}
