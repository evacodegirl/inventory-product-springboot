package com.verchetasheva.productinventory.inventory;

import com.verchetasheva.productinventory.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("select product from Product product inner join product.inventory inventory where product.type = :type and inventory.id = :inventoryId")
    List<Product> findAllProductsByType(String type, Integer inventoryId);

    Optional<Inventory> findFirstByName(String name);

    @Query(nativeQuery = true, value="select * from inventory where name = :name limit 1")
    Optional<Inventory> findFirstByNameNative(String name);

}
