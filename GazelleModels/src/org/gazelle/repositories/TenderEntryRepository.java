package org.gazelle.repositories;

import org.gazelle.models.TenderEntry;
import org.gazelle.repositories.interfaces.TenderEntryRepositoryInterface;
import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;

public class TenderEntryRepository extends BaseRepository<TenderEntry> implements TenderEntryRepositoryInterface {
	@Override
	public TenderEntry createOne() {
		return new TenderEntry();
	}
	
	public TenderEntryRepository() {
		super(DatabaseTable.TENDERENTRY);
	}
}
