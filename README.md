# X32Scenerator

X32 Scene Generator Version 2.0! 

Required software: Java Runtime; FileMaker Database (or any DB that can create properly formatted CSV). I hope to include a front-end someday to eliminate Filemaker from 
the equation.

Intended Hardware: Behringer X32 Digital Audio Mixing Desks for live performances

This project is designed to take input from a FileMaker Database built by a theatrical sound designer, which includes a very particular subset of the information 
required to program/generate the 75+ scene files needed for each show. The project outputs working scene files that can be loaded directly onto the Behringer X32 digital 
audio console (Version 4+ Supported). Normally, these files must be programmed manually, on the hardware or Behringer's offline editor -- very time consuming. This 
software is intended to remove this manual step, saving users tens of hours of time and tedium per show build.

This project is still being built, and is missing many of the features of the larger project, most notably the programming algorithm which handles assignments of each 
data point. This version still has many hard-coded values which will be more flexibly handled in the production version.

NOTE:
This software should be considered as under-development only at this time, and may not build or run in a production environment. At this time, this software may not 
generate scene files as expected, because the output module is the easiest part of the code to work up, so it will come last. A working proof of concept (in BASH) is located on GitHub under smdupor\BATB-Scene-Generator, which does generate functional production scene files.
