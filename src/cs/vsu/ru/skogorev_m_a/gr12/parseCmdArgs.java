package cs.vsu.ru.skogorev_m_a.gr12;

import java.util.Dictionary;
import java.util.Hashtable;

public class parseCmdArgs {
    private final Dictionary<String, String> argsDict = new Hashtable<>();

    public parseCmdArgs(String [] args){
        parseArgs(args);
    }

    public parseCmdArgs(String args) {
        parseArgs(args.split(" "));
    }

    public Dictionary<String, String> getArgsDict() {
        return argsDict;
    }

    private void parseArgs (String[] args){
        String argName = null;

        for (String arg : args){
            if (arg.startsWith("-") && arg.length() == 2 || arg.startsWith("--")){
                argName = arg;
            } else {
                if (argName != null){
                    argsDict.put(argName, arg);
                    argName = null;
                }
            }
        }
    }

    public String getArgumentValue(String shortName, String longName) {
        String value = argsDict.get(shortName);

        if (value == null) {
            value = argsDict.get(longName);
        }

        return value;
    }

}
