

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
  

  
  
  void display() {
    imageMode(CENTER);    
    image(img, x, y, 550, 950);
  }
  
  void madReply() {
    int rndIndex = floor(random(angryRep.length));
    reply = angryRep[rndIndex];
  }
  
  void sadReply() {
    int rndIndex = floor(random(sadRep.length));
    reply = sadRep[rndIndex];
  }
  
  void bloodyReply() {
    int rndIndex = floor(random(bloodyRep.length));
    reply = bloodyRep[rndIndex];
  }
  
  void introText() {
    int rndIndex = floor(random(introHi.length));
    reply = introHi[rndIndex];
  }
  
  void junkoReply() {
    reply = "Junko Enoshima?";  
  }
  
  void momotaReply() {
    int rndIndex = floor(random(momotaKun.length));
    reply = momotaKun[rndIndex];
  }
  
  void nishishiReply() {
    reply = "Nishishi";  
  }
  
  void greetingReply() {
    int rndIndex = floor(random(greetingRep.length));
    reply = greetingRep[rndIndex];
  }
  
  void negotiatorReply() {
    reply = "Ah yes, the negotiator"; 
  }
  
  void madOffendedReply() {
    int rndIndex = floor(random(madOffendedRep.length));
    reply = madOffendedRep[rndIndex];
  }
  
  void sadOffendedReply() {
    int rndIndex = floor(random(sadOffendedRep.length));
    reply = sadOffendedRep[rndIndex];
  }
  
  void loveReply() {
    int rndIndex = floor(random(loveRep.length));
    reply = loveRep[rndIndex];
  }
  
  void grapeReply() {
    int rndIndex = floor(random(grapeRep.length));
    reply = grapeRep[rndIndex];
  }
  
  
  /*
  NOTE: There's three ways we can do this. Machine learning, Machine Learning with personality, or pure personality.
  I'd say we do the second, but it'll be a bit difficult. There will be some preset
  
  
  
  */
  void miscReply() {
    int rndIndex = floor(random(miscRep.length));
    reply = miscRep[rndIndex];
  }
  
  void displayReply() {
    textSize(32);
    fill(0);
    text(reply, width/2, height/4);
  }
  
  
  
}
