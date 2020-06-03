


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
  
  void display() {
    stroke(0);
    strokeWeight(5);
    fill(255);
    rect(x, y, w, h);  
    fill(0);
    text(text, x, y + 50);
  }
  
  void addWord() {
    wordArr = append(wordArr, word);
    word = "";
  }
  
  void clearArray() {
    wordArr = new String[0];  
  }
  
  
  void getWords() {
    text2 = "";
    for(int i = 0; i < wordArr.length; i++) {
      print(wordArr[i]+" ");
      text2 = text2 + wordArr[i]+" ";
    }
    print("\n");
    print("\n" + text);
    print("\n\n");
  }
  
  String react() {
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
  
  
  
  void deleteWord() {
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
  
  void displayText2() {
    textSize(32);
    fill(183, 67, 213);
    text(text2, width/2, height/8);
  }
  
  } 
