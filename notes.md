# QVisuals Notes

This is where I'll be writing down notes about different parts of the project.
Many times I don't have paper to jot down ideas, so this file will help keep
track of ideas I'm working on.

#### BPM Functions

**Requirements**

- BPM and framerate must be kept separate from effect code.
- Be able to change BPM and framerate and the effect is essentially the same.
  - Note: This means if BPM doesn't match evenly with framerate it won't be
    able to make a perfect loop. This is **KNOWN** and **ACCEPTABLE**.
    This code must be able to be used in more informal live performances where
    being able to match BPM is needed and loop exporting is not the goal.
- Use functions to define movements/effect parameters as ratios or multipliers
  of beats and measures. In this way a music producer can more intuitively
  match effect descriptions with music, regardless of final BPM.
  
#### Shape/Effects API

- Need a way for shapes to have access to the PApplet it can use to draw with.
- Need a way for effects that use shapes to pass PApplet along (abstract class)
- BPM or resolution information or should that be provided by the effect?
  - Upside of no BPM information, they only render sizes/locations
  - Resolution info still needs to be passed somehow.
- How to encapsulate Resolution info.
  - Define things as percentages of resolution.
  - Example: V-effects, define as some factor of res to define height
  
#### Shape/Effects API Example

This is an attempt to write out the BpmPulseCircle effect in a way that it can
be built from other pieces. The eventually goal for the Shape/Effects/Paintable
API is that we won't need code to define effects.

BpmPulseCircle consists of 10 concentric circles. Outside circle is size 600.
Lower circles decrease by increment.

Each circle has a movement related to the BpmPulseSequencer. 

#### Effect saving language

Need a language for saving effects and their parameters. It has to work for
hardcoded ParamEffects that have parameter names, and also for the Effect API.

Ideally it would be cool if it could also parse code from some of the live
coding software. That code is pretty close, might be able to have a separate
processor to load it into effects.