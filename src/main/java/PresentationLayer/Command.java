package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("help", new Help());
        commands.put("enterorder", new EnterOrder());
        commands.put("createorder", new CreateOrder());
        commands.put("viewmyorderlist", new OrderList());
        commands.put("viewmyorder", new ViewMyOrder());
        commands.put("customerpage", new CustomerPage());
        commands.put("viewallorders", new ViewAllOrders());
        commands.put("employeepage", new EmployeePage());
        commands.put("vieworder", new ViewOrder());
        commands.put("togglesentstatus", new ToggleSentStatus());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;

}
