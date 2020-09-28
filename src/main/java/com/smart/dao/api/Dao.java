package com.smart.dao.api;

import java.util.Collection;

public interface Dao<P, I> {

  void delete(long id);

  P get(long id);

  Collection<P> getAll();

  P save(P p);

  P saveWrapper(I i);

  P update(P p, long l);
}
