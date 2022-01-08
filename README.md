# Kata-test
DESCRIPTION: Given a series of input (cli arguments, that can be both strings and arrays) the program is able to parse them and to give specific results according to some defined rules.
Examples: 
     
     INPUT: --foo OUTPUT: {foo=[true]}

     INPUT: --foo bar OUTPUT: {foo=[bar]}
     
     INPUT: [--foo, bar, --number, 1] OUTPUT: {foo=[bar], number=[1]}
     
The program has been developed in Java (version: 17.0.1 2021-10-19 LTS). In order to run the program you need to open the terminal, go inside the folder that containes the file and write the following: "javac CliParser.java" and after "java CliParser", followed by the input you want to insert, e.g. "java CliParser --foo".


