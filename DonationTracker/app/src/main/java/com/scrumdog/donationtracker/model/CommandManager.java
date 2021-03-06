package com.scrumdog.donationtracker.model;

import java.util.LinkedList;
import java.util.List;



public class CommandManager {

    /**
     * This maintains a list of user commands executed in order
     * Front of list is oldest command, tail is newest
     */
    private final List<AbstractCommand> userHistory = new LinkedList<>();

    /**
     * This maintains a list of donation commands executed in order
     * Front of list is oldest command, tail is newest
     */
    private final List<AbstractCommand> donationHistory = new LinkedList<>();

//    /**
//     * This maintains a list of undo commands that have been undone
//     * Front of list is oldest command, tail is most recent
//     */
//    private List<AbstractCommand> redoList = new LinkedList<> ();

    /**
     * Execute a command and add to history if the command returned true
     * The history is emptied if the command returns false
     *
     * @param command the command to execute
     */
    public void executeUserCommand(final AbstractCommand command) {
        if (command.execute()) {
            userHistory.add(command);
        } else {
            userHistory.clear();
        }
    }

    /**
     * Execute a command and add to history if the command returned true
     * The history is emptied if the command returns false
     *
     * @param command the command to execute
     */
    public void executeDonationCommand(final AbstractCommand command) {
        if (command.execute()) {
            donationHistory.add(command);
        } else {
            donationHistory.clear();
        }
    }

//    public void undoCommand() {
//        assert history.size() > 0;
//        final AbstractCommand command = history.remove(history.size() - 1);
//        command.undo();
//        redoList.add(command);
//    }
//

//    public void redoCommand() {
//        assert redoList.size() > 0;
//        final AbstractCommand command = redoList.remove(redoList.size() - 1);
//        command.execute();
//        history.add(command);
//    }

}

