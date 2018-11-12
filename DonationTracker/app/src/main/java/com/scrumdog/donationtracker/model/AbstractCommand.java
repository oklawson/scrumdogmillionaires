package com.scrumdog.donationtracker.model;


abstract class AbstractCommand {
    public final static CommandManager manager = new CommandManager();

    /**
     * a function that executes commands
     *
     * @return true when command executes
     */
    public abstract boolean execute();

    /**
     * a function that undoes commands
     *
     * @return true when the command is undone
     */
    public abstract boolean undo();
}
