# QVisuals

Java project utilizing Processing 3.0 to output controllable vj visuals. Uses
Spout to output the visuals for use in Resolume or other video software.

At the moment this sketch is primarily used to output shapes in grayscale which is then
imported into Resolume Avenue as a mask over visualizations provided by MilkDrop2.

This sketch is currently Windows only, although it may be possible to eventually support 
using Syphon instead of Spout on OSX. If anyone is interested in helping to develop Syphon 
support, definitely let me know or send a pull request. 

I often stream visual development and other things at http://twitch.tv/theqial 

Feel free to drop by and say hello!

# Requirements
- Java 7/8 JDK - http://java.com/en/download/
- Processing 3 - http://processing.org
- Spout2 - http://spout.zeal.co/

#### Recommended 
- Winamp & MilkDrop2 w/Spout (modified milkdrop plugin is in the Spout2 installation)
- Resolume Avenue or other VJ software to combine the two.

# Instructions
**Work in progress**

Ensure all .jar libraries in the lib/ folder are included. 

Run processing.core.PApplet with the argument "net.qial.vj.processing.Visuals"

# Keys
#### General Keys
- v - toggles debug output for effects/params

#### Effect Keys
- [1-9] - select effect
- Shift+[1-9] - toggle effect always on
- 0 - turn off all effects

Some effects have changeable parameters:

- q/a - control param 1
- w/s - control param 2
- e/d - control param 3
- r/f - control param 4
- t/g - control param 5
- y/h - control param 6

Using shift + key will change parameter by 5 instead of by 1.

# Development info

- net.qial.vj.effect - Effect interface and abstract utility classes
- net.qial.vj.effects - Actual effect implementations
- net.qial.vj.main - Program start classes
- net.qial.vj.processing - Processing applet setup and interactivity
- net.qial.vj.sequencer - Sequencer interface and abstract classes
- net.qial.vj.sequencers - Sequencer implementations
- net.qial.vj.shape - API for defining effects
- net.qial.vj.shapes - Shape implementations
- net.qial.vj.spout - Spout-based classes and the Spout2 code
- net.qial.vj.util - utility classes and such

spout.pde, JSpout.java, and files in the code32 and code64 folders are copied from the Spout2 installation.

#### Development goals:

- Convert to Eclipse project with standard java structure
- Finish adding methods to ProcessingEffect class such that Processing code can be pasted directly from a sketch into an effect
- Set things up so this project can be imported as a JAR into Processing
- Save/load effect parameters
- Load new effects on the fly instead of a compiled 1-9 list
- Export-to-video button for simplified export of good effects
- Better effect abstraction to describe effects as shapes moving through time and hide the math
- Support for colored textures and effects beyond grayscale
- MIDI input support to change effect parameters using hardware controllers
- Support for choosing output resolutions
- Seamlessly transform effect code to produce same output across range of resolutions
- Global BPM settings to re-render effects for different BPMs. (Default is 120bpm still)
- PulseSequencer to render sine wave pulse shapes, definable by speed, amount, and size of pulse
- Implement a Spout Receiver to bring in Milkdrop textures natively
