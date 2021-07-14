package com.verchetasheva.productinventory.product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Optional<Product> findsByIdAndInventoryId(Integer productId, Integer inventoryId);
}
