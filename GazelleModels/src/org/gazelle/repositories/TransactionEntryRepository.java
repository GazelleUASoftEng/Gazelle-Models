package org.gazelle.repositories;

import org.gazelle.models.TransactionEntry;
import org.gazelle.repositories.interfaces.TransactionEntryRepositoryInterface;
import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;

public class TransactionEntryRepository extends BaseRepository<TransactionEntry> implements TransactionEntryRepositoryInterface {
	@Override
	public TransactionEntry createOne() {
		return new TransactionEntry();
	}
	
	public TransactionEntryRepository() {
		super(DatabaseTable.TRANSACTIONENTRY);
	}
}
