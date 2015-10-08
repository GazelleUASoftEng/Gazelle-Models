package org.gazelle.repositories;

import org.gazelle.models.Product;
import org.gazelle.repositories.interfaces.ProductRepositoryInterface;
import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;

public class ProductRepository extends BaseRepository<Product> implements ProductRepositoryInterface {
	@Override
	public Product createOne() {
		return new Product();
	}
	
	public ProductRepository() {
		//TODO: Dr. P --> Need to update the DatabaseTable enum to include the Employee table name.
		super(DatabaseTable.PRODUCT);
	}
}
