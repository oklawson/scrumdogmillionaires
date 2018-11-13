package com.scrumdog.donationtracker.model;


public class AddDonationCommand extends AbstractCommand {
    private final Donation donation;

    /**
     * make a new donation
     *
     * @param d the donation added to the application
     */
    AddDonationCommand(Donation d) {
        donation = d;
    }

    @Override
    public boolean execute() {
        DonationManagement dmt = DonationManagement.getInstance();
        dmt.addDonation(donation);
        return true;
    }

}
