package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26.09.2017.
 */
public class CommandExecutor
{
    private CommandExecutor() {}
    static Map<Operation, Command> commands = new HashMap<Operation, Command>();
    static {
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
        commands.put(Operation.EXIT, new ExitCommand());
    }
    public static final void execute(Operation operation) {
        commands.get(operation).execute();
    }
}
