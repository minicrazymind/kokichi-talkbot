import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Talking_Sim extends PApplet {




SoundFile file;
SoundFile reply;


PImage[] intros = new PImage[4];
PImage[] normals = new PImage[7];
PImage[] evils = new PImage[4];
PImage[] happys = new PImage[6];
PImage[] sads = new PImage[8];
PImage[] scareds = new PImage[5];
PImage[] mads = new PImage[3];
PImage[] bloody = new PImage[2];
PImage[] curios = new PImage[5];
PImage nishishi;


int introNum = floor(random(4));

int clicks = 0;

Kokichi bot;
TextBox box = new TextBox(700, 200);

public void setup() {
   //Sets size to 500, 600
  
  
  //Import sprites to their respective emotion arrays
  for (int i = 0; i < intros.length; i++) {
    intros[i] = loadImage("intro" + i + ".png");
  }
  
  for (int i = 0; i < normals.length; i++) {
    normals[i] = loadImage("normal" + i + ".png");
  }
  
  for (int i = 0; i < evils.length; i++) {
    evils[i] = loadImage("evil" + i + ".png");
  }
  
  for (int i = 0; i < happys.length; i++) {
    happys[i] = loadImage("happy" + i + ".png");
  }
  
  for (int i = 0; i < sads.length; i++) {
    sads[i] = loadImage("sad" + i + ".png");
  }
  
  for (int i = 0; i < scareds.length; i++) {
    scareds[i] = loadImage("scared" + i + ".png");
  }
  
  for (int i = 0; i < mads.length; i++) {
    mads[i] = loadImage("mad" + i + ".png");
  }
  
  for (int i = 0; i < bloody.length; i++) {
    bloody[i] = loadImage("bloody" + i + ".png");
  }
  
  for (int i = 0; i < curios.length; i++) {
    curios[i] = loadImage("curious" + i + ".png");
  }
  
  nishishi = loadImage("nishishi0.png");
  
  
  print(introNum);
  file = new SoundFile(this, "Kokichi_Introduction" +introNum + ".wav");
  delay(500);
  file.play();
  
  createFirstKokichi();
}


public void draw()
{
  background(255);
  
  bot.display();
  bot.displayReply();
  box.display();
  box.displayText2();
}

public void createFirstKokichi() {
  int rndIndex = floor(random(intros.length));
  PImage kokIntro = intros[rndIndex];
  bot = new Kokichi(width/4, height/2, kokIntro);
  bot.introText();
}

public void angerNewKokichi() {
  int rndIndex = floor(random(mads.length));
  PImage kokBoi = mads[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

public void sadNewKokichi() {
  int rndIndex = floor(random(sads.length));
  PImage kokBoi = sads[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}


public void bloodyNewKokichi() {
  int rndIndex = floor(random(bloody.length));
  PImage kokBoi = bloody[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

public void evilNewKokichi() {
  int rndIndex = floor(random(evils.length));
  PImage kokBoi = evils[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

public void happyNewKokichi() {
  int rndIndex = floor(random(happys.length));
  PImage kokBoi = happys[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

public void nishiNewKokichi() {
  bot = new Kokichi(width/4, height/2, nishishi); 
}

public void mousePressed() {
  
  
  int pokeReact = floor(random(100));
  if (pokeReact < 5) {
    nishiNewKokichi();
    bot.nishishiReply();
    nishishiSound();
  }
  
  else if (clicks >= 15) {
    bloodyNewKokichi();
    bot.bloodyReply();
    normSound();
  }
  
  else if (pokeReact >= 50) {
    angerNewKokichi();
    bot.madReply();
    madSound();
  }
  
  else {
    sadNewKokichi();
    bot.sadReply();
    sadSound();
  }
  
  
  
  clicks++;
}

public void keyPressed() {
  if(key <= 122 && key >= 65 && box.text.length() < 35 ) {
    box.text += key;
    box.word += key;
  }
  else if(key == ' ') {
    box.addWord();
    box.text += " ";
  }
  else if(key == BACKSPACE) {
      box.deleteWord();
    
  }
  else if(key == ENTER) {
    box.addWord();
    box.getWords();
    react(box.react());
    box.text = "  ";
    box.clearArray();
  }
  
  
}




/////UNDER CONSTRUCTION//////////////

public void react(String msg) {
  if(msg == "junkoReact") {
    evilNewKokichi();
    bot.junkoReply();
    reply = new SoundFile(this, "enoshima0.wav");
    delay(500);
    reply.play();
  }
  else if (msg == "momotaReact") {
    happyNewKokichi();
    bot.momotaReply();
    reply = new SoundFile(this, "momota0.wav");
    delay(500);
    reply.play();
  }
  
  else if (msg == "greetingReact") {
    happyNewKokichi();
    bot.greetingReply();
    happySound();
  }
  
  else if (msg == "negotiatorReact") {
    happyNewKokichi();
    bot.negotiatorReply();
    happySound();
  }
  
  else if (msg == "offendedReact") {
    
    int rndNum = floor(random(100));
    
    if(rndNum < 50) {
      angerNewKokichi();
      bot.madOffendedReply();
      madSound();
    }
    
    else {
      sadNewKokichi();
      bot.sadOffendedReply();
      sadSound();
    }
  }
  
  else if (msg == "loveReact") {
    int rndNum = floor(random(100));
    
    if(rndNum > 90) {
      evilNewKokichi();
      bot.loveReply();
      evilSound();
    }
    
    else {
      happyNewKokichi();
      bot.loveReply();
      happySound();
    }
  }
  
  else if (msg == "grapeReact") {
    happyNewKokichi();
    bot.grapeReply();
    happySound();
  }
  
  
  
  else if (msg == "miscReact") {
    createNewKokichi();
    bot.miscReply();
    normSound();
  }
}


public void createNewKokichi() {
  int rndIndex = floor(random(normals.length));
  PImage kokBoi = normals[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

public void nishishiSound() {
  reply = new SoundFile(this, "nishishi0.wav");
  delay(500);
  reply.play(); 
}

public void madSound() {
  int replyNum = floor(random(13));
  reply = new SoundFile(this, "Mad/mad" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

public void sadSound() {
  int replyNum = floor(random(14));
  reply = new SoundFile(this, "Sad/sad" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

public void normSound() {
  int replyNum = floor(random(23));
  reply = new SoundFile(this, "Normal/normal" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

public void curioSound() {
  int replyNum = floor(random(13));
  reply = new SoundFile(this, "Curious/curious" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

public void happySound() {
    int replyNum = floor(random(31));
    reply = new SoundFile(this, "Happy/happy" +replyNum + ".wav");
    delay(500);
    reply.play();  
}

public void evilSound() {
  int replyNum = floor(random(9));
    reply = new SoundFile(this, "Evil/evil" +replyNum + ".wav");
    delay(500);
    reply.play();  
}


class Kokichi {
  
  float x;
  float y;
  PImage img;
  
  String[] introHi = {"Hey hey! How's it goin?", "I am Kokichi Oma,\nUltimate Supreme Leader", "I am the Ultimate Supreme Leader,\nKokchi Oma", "What's up peasant?\nReady to serve me?", "How's your day?"};
  String[] angryRep = {"Ow!", "Stop that!", "How dare you poke the\nUltimate Supreme Leader", "I'll have you executed", "Do you wanna die?", "Oi stop it!" };
  String[] sadRep = {"that's mean...", "stop it...", "hey...", "that hurts...", "meanie", "uuuuuuuu", "you hurt me"};
  String[] bloodyRep = {"having fun huh?", "you really don't know when to stop eh?", "I won't spare you now", "you've really crossed the line"};
  String[] momotaKun = {"Why are you talking about that goatee idiot?", "Momota-chan?", "Kaito?", "Heeyy heeyy! I know that idiot!", "Hah, Kaito, what a dummy amirite?", "Luminary of my ass lmao"};
  String[] miscRep = {"What are you trying to say?", "Silence illiterate peasant!", "Hehe you're kinda stupid", "Shut up!", "Liar!", "What does that mean?", "Go away!"};
  String[] greetingRep = {"Hey doh!", "Hey hey!", "Yo ho!", "Hello there", "Is that how you greet the\nUltimate Supreme Leader?"};
  String[] madOffendedRep = {"No you!", "NO U!", "How dare you!", "You've yee-ed your last haw", "I'll destroy you!", "Why I oughta...", "Catch me outside how about that?", "Goodbye", "BAKA!", "Listen here you little"};
  String[] sadOffendedRep = {"That hurts...", "Why would you say that?", "D-do you really mean that?", "You meanie...", "Who taught you to say that?", "What's wrong with you?", "I'm sad now"};
  String[] loveRep = {"I love you too", "I like you too", "Oh really?", "Are you sure about that?", "I don't think that's wise", "You're lying", "Stop that", "Why would you say that?", "You're an odd person you know that?"};
  String[] grapeRep = {"Grape fanta is my favorite!", "Do you have grape fanta?", "My favorite flavor is grape!", "Waa I want some right now!", "Hand over the grape fanta\nand nobody gets hurt", "Grape grape grape"};
  
  String reply;
  
  Kokichi(float _x, float _y, PImage _img) {
    x = _x;
    y = _y;
    img = _img;
    
    reply = "";
  }
  

  
  
  public void display() {
    imageMode(CENTER);    
    image(img, x, y, 550, 950);
  }
  
  public void madReply() {
    int rndIndex = floor(random(angryRep.length));
    reply = angryRep[rndIndex];
  }
  
  public void sadReply() {
    int rndIndex = floor(random(sadRep.length));
    reply = sadRep[rndIndex];
  }
  
  public void bloodyReply() {
    int rndIndex = floor(random(bloodyRep.length));
    reply = bloodyRep[rndIndex];
  }
  
  public void introText() {
    int rndIndex = floor(random(introHi.length));
    reply = introHi[rndIndex];
  }
  
  public void junkoReply() {
    reply = "Junko Enoshima?";  
  }
  
  public void momotaReply() {
    int rndIndex = floor(random(momotaKun.length));
    reply = momotaKun[rndIndex];
  }
  
  public void nishishiReply() {
    reply = "Nishishi";  
  }
  
  public void greetingReply() {
    int rndIndex = floor(random(greetingRep.length));
    reply = greetingRep[rndIndex];
  }
  
  public void negotiatorReply() {
    reply = "Ah yes, the negotiator"; 
  }
  
  public void madOffendedReply() {
    int rndIndex = floor(random(madOffendedRep.length));
    reply = madOffendedRep[rndIndex];
  }
  
  public void sadOffendedReply() {
    int rndIndex = floor(random(sadOffendedRep.length));
    reply = sadOffendedRep[rndIndex];
  }
  
  public void loveReply() {
    int rndIndex = floor(random(loveRep.length));
    reply = loveRep[rndIndex];
  }
  
  public void grapeReply() {
    int rndIndex = floor(random(grapeRep.length));
    reply = grapeRep[rndIndex];
  }
  
  
  /*
  NOTE: There's three ways we can do this. Machine learning, Machine Learning with personality, or pure personality.
  I'd say we do the second, but it'll be a bit difficult. There will be some preset
  
  
  
  */
  public void miscReply() {
    int rndIndex = floor(random(miscRep.length));
    reply = miscRep[rndIndex];
  }
  
  public void displayReply() {
    textSize(32);
    fill(0);
    text(reply, width/2, height/4);
  }
  
  
  
}



class TextBox {
  
  //Coordinates
  float x = 700; 
  float y = 700;
  
  //Dimensions
  float w; 
  float h;
  
  String text; //Mostly useless, just holds what the user types
  String text2; //Shows the user's response after pressing enter
  String word; //Hold each word before spacebar pushes to array or backspace deletes it
  String[] wordArr; //Holds the words we analyze
  
  TextBox(float _w, float _h) {
    w = _w;
    h = _h;
    
    text = "  ";
    text2 = "";
    word = "";
    wordArr = new String[0];
  }
  
  public void display() {
    stroke(0);
    strokeWeight(5);
    fill(255);
    rect(x, y, w, h);  
    fill(0);
    text(text, x, y + 50);
  }
  
  public void addWord() {
    wordArr = append(wordArr, word);
    word = "";
  }
  
  public void clearArray() {
    wordArr = new String[0];  
  }
  
  
  public void getWords() {
    text2 = "";
    for(int i = 0; i < wordArr.length; i++) {
      print(wordArr[i]+" ");
      text2 = text2 + wordArr[i]+" ";
    }
    print("\n");
    print("\n" + text);
    print("\n\n");
  }
  
  public String react() {
    for(int i = 0; i < wordArr.length; i++) {
      
     if(wordArr[i].equals("Enoshima") || wordArr[i].equals("enoshima") || wordArr[i].equals("Junko") || wordArr[i].equals("junko")) {
      return "junkoReact";
     }
     else if(wordArr[i].equals("Momota") || wordArr[i].equals("Kaito") || wordArr[i].equals("momota") || wordArr[i].equals("kaito")) {
      return "momotaReact";
     }
     else if(wordArr[i].equals("Luminary") || wordArr[i].equals("luminary")) {
      return "momotaReact";
     }
     else if (wordArr[i].equals("kenobi") || wordArr[i].equals("Kenobi")) {
      return "negotiatorReact";
     }
     else if (text.equals("  whats up") || text.equals("  Whats up") || text.equals("  WHATS UP")) {
       return "greetingReact";  
     }
     else if(wordArr[i].equals("Hi") || wordArr[i].equals("hi") || wordArr[i].equals("Hey") || wordArr[i].equals("hey") || wordArr[i].equals("sup") || wordArr[i].equals("Sup") || wordArr[i].equals("Hello") || wordArr[i].equals("hello") || wordArr[i].equals("wassup")) {
      return "greetingReact";  
     }
     else if(wordArr[i].equals("hate") || wordArr[i].equals("Hate") || wordArr[i].equals("Suck") || wordArr[i].equals("suck") || wordArr[i].equals("shitty") || wordArr[i].equals("SHITTY") || wordArr[i].equals("garbage") || wordArr[i].equals("Garbage") || wordArr[i].equals("GARBAGE")) {
       return "offendedReact";
     }
     else if(wordArr[i].equals("crappy") || wordArr[i].equals("Crappy") || wordArr[i].equals("CRAPPY") || wordArr[i].equals("idiot") || wordArr[i].equals("Idiot") || wordArr[i].equals("IDIOT")) {
       return "offendedReact";
     }
     else if(wordArr[i].equals("baka") || wordArr[i].equals("BAKA") || wordArr[i].equals("Baka") || wordArr[i].equals("stupid") || wordArr[i].equals("Stupid") || wordArr[i].equals("STUPID")) {
       return "offendedReact";
     }
     else if(wordArr[i].equals("dumbass") || wordArr[i].equals("DUMBASS") || wordArr[i].equals("Dumbass") || wordArr[i].equals("dummy") || wordArr[i].equals("Dummy") || wordArr[i].equals("DUMMY")) {
       return "offendedReact";
     }
     else if(wordArr[i].equals("love") || wordArr[i].equals("Love") || wordArr[i].equals("LOVE") || wordArr[i].equals("like") || wordArr[i].equals("Like") || wordArr[i].equals("LIKE")) {
       return "loveReact";
     }
     else if(wordArr[i].equals("cutie") || wordArr[i].equals("Cutie") || wordArr[i].equals("CUTIE") || wordArr[i].equals("cute") || wordArr[i].equals("Cute") || wordArr[i].equals("CUTE")) {
       return "loveReact";
     }
     else if(wordArr[i].equals("grape") || wordArr[i].equals("Grape") || wordArr[i].equals("Fanta") || wordArr[i].equals("fanta") || wordArr[i].equals("Soda") || wordArr[i].equals("soda")) {
       return "grapeReact";
     }
  }
    return "miscReact";  
  }
  
  
  
  public void deleteWord() {
    addWord();
    if(wordArr.length > 2) {
      wordArr = subset(wordArr, 0, wordArr.length - 2);
      text = "  ";
      for(int i = 0; i < wordArr.length; i++) {
      text = text + wordArr[i] + " ";   
      }
    }  
    else {
      text = "  ";
      clearArray();
    }
  }
  
  public void displayText2() {
    textSize(32);
    fill(183, 67, 213);
    text(text2, width/2, height/8);
  }
  
  } 
  public void settings() {  size(1500,1000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#242331", "--stop-color=#C8A9E8", "Talking_Sim" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
