The Mario AI framework is a framework for using AI methods with a version of Super Mario Bros.
This is an updated version for the Mario AI Framework. As the first version was released in 2009, this is the tenth anniversary edition, integrating features from all previous versions and adding several new features. This new code includes a better interface for playing the game with planning algorithms (the planning track of the competition), generating levels (the level generation track), and possibly will support the learning track in the future . The framework comes with multiple different planning agents, level generators and thousands of levels including generated levels from diffeent generators as well as the original Mario levels. Also, the framework is compatible with [Video Game Level Corpus (VGLC)](https://github.com/TheVGLC/TheVGLC) processed notations.

#### Planning Track
Download the repo and run the [`PlayLevel.java`](https://github.com/amidos2006/Mario-AI-Framework/blob/master/src/PlayLevel.java) file. It will run [`robinBaumgarten`](https://github.com/amidos2006/Mario-AI-Framework/tree/master/src/agents/robinBaumgarten) A* agent on the [first Mario level](https://github.com/amidos2006/Mario-AI-Framework/blob/master/levels/original/lvl-1.txt) from the original Super Mario Bros. The game will run for 20 seconds (in-game time) and with Mario starting as small Mario and visuals appearing. To change the agent just change the package name of the agent in the following code
```
printResults(game.runGame(new agents.robinBaumgarten.Agent(), getLevel("levels/original/lvl-1.txt"), 20, 0, true));
```
to any of the package names that are found in [`src/agents/`](https://github.com/amidos2006/Mario-AI-Framework/tree/master/src/agents) folder, feel free to use any in your work. If you want to play a level yourself uncomment the following code in [`PlayLevel.java`](https://github.com/amidos2006/Mario-AI-Framework/blob/master/src/PlayLevel.java) file

#### Level Generation Track
Download the repo and run the [`GenerateLevel.java`](https://github.com/amidos2006/Mario-AI-Framework/blob/master/src/GenerateLevel.java) from the [`src/`](https://github.com/amidos2006/Mario-AI-Framework/tree/master/src) folder to test the framework. It will run the `notch` generator to generate a level then it will run [`robinBaumgarten`](https://github.com/amidos2006/Mario-AI-Framework/tree/master/src/agents/robinBaumgarten) A* agent to play that generated level. Feel free to try another generators by changing the package name of generator in the following line
```
MarioLevelGenerator generator = new levelGenerators.random.markov3();
```
#################################################################################

The java file 'markov3.java' includes implementation of generating a level using markov chains. this automatically generates a new level on every run. The hyperparameters control the creativity and difficulty of the level.
place the file inside 'src/levelGenerators/random/'
run using the above line of code in GenerateLevel.java
