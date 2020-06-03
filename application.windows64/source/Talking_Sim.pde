import processing.sound.*;


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

void setup() {
  size(1500,1000); //Sets size to 500, 600
  
  
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


void draw()
{
  background(255);
  
  bot.display();
  bot.displayReply();
  box.display();
  box.displayText2();
}

void createFirstKokichi() {
  int rndIndex = floor(random(intros.length));
  PImage kokIntro = intros[rndIndex];
  bot = new Kokichi(width/4, height/2, kokIntro);
  bot.introText();
}

void angerNewKokichi() {
  int rndIndex = floor(random(mads.length));
  PImage kokBoi = mads[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

void sadNewKokichi() {
  int rndIndex = floor(random(sads.length));
  PImage kokBoi = sads[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}


void bloodyNewKokichi() {
  int rndIndex = floor(random(bloody.length));
  PImage kokBoi = bloody[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

void evilNewKokichi() {
  int rndIndex = floor(random(evils.length));
  PImage kokBoi = evils[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

void happyNewKokichi() {
  int rndIndex = floor(random(happys.length));
  PImage kokBoi = happys[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

void nishiNewKokichi() {
  bot = new Kokichi(width/4, height/2, nishishi); 
}

void mousePressed() {
  
  
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

void keyPressed() {
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

void react(String msg) {
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


void createNewKokichi() {
  int rndIndex = floor(random(normals.length));
  PImage kokBoi = normals[rndIndex];
  bot = new Kokichi(width/4, height/2, kokBoi);
}

void nishishiSound() {
  reply = new SoundFile(this, "nishishi0.wav");
  delay(500);
  reply.play(); 
}

void madSound() {
  int replyNum = floor(random(13));
  reply = new SoundFile(this, "Mad/mad" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

void sadSound() {
  int replyNum = floor(random(14));
  reply = new SoundFile(this, "Sad/sad" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

void normSound() {
  int replyNum = floor(random(23));
  reply = new SoundFile(this, "Normal/normal" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

void curioSound() {
  int replyNum = floor(random(13));
  reply = new SoundFile(this, "Curious/curious" +replyNum + ".wav");
  delay(500);
  reply.play();  
}

void happySound() {
    int replyNum = floor(random(31));
    reply = new SoundFile(this, "Happy/happy" +replyNum + ".wav");
    delay(500);
    reply.play();  
}

void evilSound() {
  int replyNum = floor(random(9));
    reply = new SoundFile(this, "Evil/evil" +replyNum + ".wav");
    delay(500);
    reply.play();  
}
