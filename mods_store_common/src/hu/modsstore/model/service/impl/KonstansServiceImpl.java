package hu.modsstore.model.service.impl;

import hu.modsstore.model.dao.KonstansDAO;
import hu.modsstore.model.dto.Konstans;
import hu.modsstore.model.service.KonstansService;

public class KonstansServiceImpl implements KonstansService {
	
	private KonstansDAO konstansDAO;

	public KonstansDAO getKonstansDAO() {
		return konstansDAO;
	}

	public void setKonstansDAO(KonstansDAO konstansDAO) {
		this.konstansDAO = konstansDAO;
	}

	@Override
	public Konstans find(String kulcs) {
		return konstansDAO.find(kulcs);
	}

}
