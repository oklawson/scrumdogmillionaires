package com.scrumdog.donationtracker.model;

public class AddDonationCommand extends AbstractCommand {
    Donation donation;

    public AddDonationCommand(Donation d) {
        donation = d;
    }

    @Override
    public boolean execute() {
        DonationManagement dmt = DonationManagement.getInstance();
        dmt.addDonation(donation);
        return true;
    }

    @Override
    public boolean undo() {
        DonationManagement dmf = DonationManagement.getInstance();
        dmf.removeDonation(donation);
        return true;
    }

}
