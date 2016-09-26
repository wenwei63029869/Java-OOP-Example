Assumption:
1. There is only one order with one or more items in one text file.
2. There is a typo in the third input and output examples: 1 box of imported chocolates at 11.75 => 1 imported box of chocolates: 11.85. Based on the other chocolate inputs, the output should be 1 box of imported chocolates: 11.85. Therefore, I modified the input content in my unit test, so output would in the same format as other examples.

Instruction:
1. You can run this program on Intellij IDEA. If you run Main.main() directly, please set arguments for input file path and output folder. The output file will be generated and stored in the specified folder. You can also run the unit tests individually or in bundle with `src/test/java/com/wei/FunctionalTestSuit` and `src/test/java/com/wei/UniteTestSuite`.

2. If you are going to run the program with command line, you can use maven. The format is `mvn exec:java -Dexec.mainClass="com.wei.Main" -Dexec.args="<input file path> <output folder path>`. If you want to run the tests, you can simple run `mvn compile test` and `mvn test`.

PS: Open tests_result.png to see all the tests result. All provided inputs from the prompt are included in the "MainTest". Therefore, passing all the tests means that the program returns expected inputs.