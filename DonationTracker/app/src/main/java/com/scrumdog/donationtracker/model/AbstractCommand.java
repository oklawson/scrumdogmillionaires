package com.scrumdog.donationtracker.model;

public abstract class AbstractCommand {
    public final static CommandManager manager = new CommandManager();
    public abstract boolean execute();
    public abstract boolean undo();
}
