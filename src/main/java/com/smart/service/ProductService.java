package com.smart.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import com.smart.model.InputWrapper;
import com.smart.model.Product;

@Validated
public interface ProductService {

  Product addProduct(@NotNull(message = "The order cannot be null.") @Valid Product product);

  void deleteProduct(@Min(value = 1L, message = "Invalid product ID.") Long id);

  @NotNull
  List<Product> getAllProducts();

  // Iterable<Product> getAllProductsByAttribute(Map<String, String> attribute);

  List<Product> getAllProductsByCategory(InputWrapper category);


  Product getProduct(@Min(value = 1L, message = "Invalid product ID.") Long id);

  Product updateProduct(@NotNull(message = "The order cannot be null.") @Valid Product product,
      long l);
}
