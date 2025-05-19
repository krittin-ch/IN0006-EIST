package de.tum.in.ase.eist.Controller;

import de.tum.in.ase.eist.Model.*;
import de.tum.in.ase.eist.View.*;


import java.util.List;

public class Controller {
	private final MFT_DAO mftDAO;

    // For now we only have a single client
    private View view;

    public Controller(DatabaseHelper databaseHelper, TransactionLog transactionLog) {
        this.mftDAO = new MFT_DAO(databaseHelper, transactionLog);
		this.view = null;
    }

    public void registerClient(View view) {
        this.view = view;
    }

    public int getMFTOwnerId(MFT mft) {
        return mftDAO.getOwnerId(mft);
    }

	public MFT getMFTById(int id) {
		return mftDAO.selectMFTById(id);
	}

    public List<MFT> getMFTs() {
        return mftDAO.selectMFTs();
    }

	// helper to add stock that doesn't belong to us
	public void addMFT(MFT mft) {
		mftDAO.addMFT(999, mft);
	}

    // TODO L03P02 Controller 2.1: Implement buyMFT method
    // Implement the following method
    // - buyMFT(MFT mft, int buyerID): void
    // This method should allow you to buy an MFT that you do not own already
    // Buying is only possible if you have enough money
    // If buying is possible, add the Transaction to the TransactionLog
    // DO NOT CHANGE THE METHOD SIGNATURE
    public void buyMFT(MFT mft, int buyerID) throws Exception {
    }

    // TODO L03P02 Controller 2.2: Implement changePrice method
    // Implement the following method
    // - changePrice(MFT mft, double newPrice): void
    // This method should allow you to change the price of an MFT that you own
    // DO NOT CHANGE THE METHOD SIGNATURE
    public void changePrice(MFT mft, double newPrice) throws Exception {
    }
}
