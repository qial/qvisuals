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

Need a way to nest effects.

Define a list of circles, amount is 10. Starting size is 600, each circle drops 
60 in size.

Define a Movement. Each circle uses the sequencer (which in this case is set to
0->1 as opposed to -1->1) to move (in this case, radius shrinks) by up to 30.

Separately, we can define fading effects on the smallest and largest circles.
This would emulate PulseCircle2's effects.

Movement needs to be both changes in color/shading/etc and size changes due to
a sequencer. All movement should be based on a sequencer to coordinate it.



#### Effect saving language

Need a language for saving effects and their parameters. It has to work for
hardcoded ParamEffects that have parameter names, and also for the Effect API.

Ideally it would be cool if it could also parse code from some of the live
coding software. That code is pretty close, might be able to have a separate
processor to load it into effects.

#### Live VJ Requirements

If I'm going to use Milkdrop in a live setting, I need a good way to be able
to change the loop/effect in Resolume and also at the same time switch to a 
new Milkdrop visualizer.

If the computer can handle it, maybe have a queueing visualizer and a backup?
I suspect though that might get too complicated in Resolume to really do well.

#### BPM Fixing try 3

Two modes of operation. 

Recording mode: Ignores the actual framerate completely and simply uses the framecount and target framerate to render each frame.

Performance mode: Ignores actual framerate and the specfic framecount and keeps track of the time the app starts. It calculates the effective positioning based on how many frames should have happened. Essentially keeping track of the time to decide what frame we should be on due to the BPM.

In performance mode, it might make sense to reset the inital frame time whenever the BPM changes. That way longer effects don't just start randomly in the middle.

#### BPM Notes round 2

It seems that PApplet.frameRate returns the ACTUAL framerate, rather than the ideal/pre-set framerate. This makes sense, but I didn't realize and is causing a lot of problems in the BPM Sequencer.

I need to keep track of the framerate at particular frames, and that way I can update the framerate slower. We want to make sure that for live effects we're reasonably running as close as possible to the actual framerate so that our BPM doesn't slowly fade off.

Keep track of time in between frames? Somehow we have to combine the framerate with actual time measurement using System.currentTimeMillis. This needs to be changeable though, because if we are generating frames we want to be able to use a constant framerate regardless of how complicated the effect is and how long it takes to render.

Maybe write code to record per-frame times just in case we need them. A debug mode for movie saver or visuals. I can export to CSV if needed.

Can I make a running average of per-frame times? Maybe the longs wouldn't be an issue if I adjust it correctly. I'm using floats anyway for most inputs to the functions, so I could just make my best guess at where in the "frames" any particular render should be. That might make it more consistent for now.


#### BPM Fixing Attempts

For now, everything is pure BPM mode, not for output. Even if I use it for output, I don't care about that right now. It bothers me a lot that I'm randomly either missing or gaining files when I try to export, so I'm not going to worry about that part.

Keep an array of the last 10 frame times. Use that to make an average frame time. Use the average to decide the expected "location" of this frame along the visual. Keep in mind, the visual SHOULD be smooth, so being slightly off in any direction is expected and will probably help it be smoother.





