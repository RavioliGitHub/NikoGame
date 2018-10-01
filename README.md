# NikoGame
2D Rpg Game

# NikoGame
2D Rpg Game


ABOUT THE PROJECT

As a structure, it was structured according to the Entity-Component-System, Martin's version

See the following links for information about the pattern
http://gameprogrammingpatterns.com/component.html
https://www.gamasutra.com/blogs/TobiasStein/20171122/310172/The_EntityComponentSystem__An_awesome_gamedesign_pattern_in_C_Part_1.php
https://www.gamedev.net/articles/programming/general-and-gameplay-programming/understanding-component-entity-systems-r3013
https://www.gamedev.net/articles/programming/general-and-gameplay-programming/implementing-component-entity-systems-r3382
https://gist.github.com/LearnCocos2D/77f0ced228292676689f
https://github.com/junkdog/artemis-odb/wiki/Introduction-to-Entity-Systems

As to the specifics of the implmentation in this project

The components folder contains the components, wich hold nothing but data
The model folder holds the entity manager, which generates and holds IDs (Integers)
Entity do not exist as class, only as ints

The map is organized in 48*48 pixel tiles. No class, except Images knows this
Everything is always perfectly on a tile. Being anywhere else, between tiles, is purely animation

Input is handled using the command pattern
http://gameprogrammingpatterns.com/command.html

Keyevents are send to 2 different queues. This allows handling several keypresses at one (to control 2 entities from the same keyboard), without letting an entity do several actions at one.

The compositeImage, InGameImage and Images classes are an implementation of the composite pattern
