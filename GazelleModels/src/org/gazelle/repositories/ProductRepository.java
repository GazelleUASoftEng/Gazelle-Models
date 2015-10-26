package org.gazelle.repositories;

import org.gazelle.models.Product;
import org.gazelle.repositories.interfaces.ProductRepositoryInterface;
import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;

public class ProductRepository extends BaseRepository<Product> implements ProductRepositoryInterface {
	@Override
	public Product byLookupCode(String lookupCode) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(ProductFieldNames.LOOKUP_CODE).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, lookupCode.toLowerCase());
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	@Override
	public Product createOne() {
		return new Product();
	}
	
	public ProductRepository() {
		super(DatabaseTable.PRODUCT);
	}
}
