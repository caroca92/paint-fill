# Fill painting screen
![version](https://img.shields.io/badge/version-0.0.1-yellow.svg)

Implement the paint fill function that one might see on many image editing programs. That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until the color changes from the original color

### Solution

The importance of the solutions, is that the array needs to be fill with a color that has a bound of the same color, so that when the algorithm find the same color, this should stop in that border but continuos in the others until the border is closed and full fill with the same color, if there are not borders of the same color it continuos to fullfill the array and stop when finish