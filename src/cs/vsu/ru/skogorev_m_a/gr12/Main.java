package cs.vsu.ru.skogorev_m_a.gr12;

import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{

        if (args.length == 0) {
            new Frame();
        } else {
            runInConsole(args);
        }
    }

    private static void runInConsole (String[] args) throws Exception{
        parseCmdArgs argsParser = new parseCmdArgs(args);

        String inputFilePath = argsParser.getArgumentValue("-i", "--input-file");
        String outputFilePath = argsParser.getArgumentValue("-o", "--output-file");

        List<Integer> list = new ArrayList<>();
        int[] fileList = ArrayUtils.readIntArrayFromFile(inputFilePath);
        Logic.checkIfArrayIsNull(fileList);
        Logic.checkIfArrayIsEmpty(fileList);
        for (int elem : fileList){
            list.add(elem);
        }

        Logic.saveOutputIntoFile(outputFilePath, Logic.createNewList(list));
    }
}
