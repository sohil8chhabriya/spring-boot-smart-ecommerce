package com.smart.dao;

import java.util.Collection;

public interface Dao<P> {

  void delete(long id);

  P get(long id);

  Collection<P> getAll();

  P save(P p);

  P update(P p, long l);
}
