package org.gazelle.repositories;

import org.gazelle.models.Transaction;
import org.gazelle.repositories.interfaces.TransactionRepositoryInterface;
import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;

public class TransactionRepository extends BaseRepository<Transaction> implements TransactionRepositoryInterface{
	public Transaction createOne() {
		return new Transaction();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
	}
}
