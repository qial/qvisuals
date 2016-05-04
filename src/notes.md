# QVisuals Notes

This is where I'll be writing down notes about different parts of the project.
Many times I don't have paper to jot down ideas, so this file will help keep
track of ideas I'm working on.

#### BPM Functions

#### Requirements

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