public class Spy implements Base{
  private Strategy cipher; 
  private int key; 
  public String msg;
  private FieldBase HQ;
  private FieldBase base;
  public boolean alive; //Living or Dead

  public Spy (Strategy cipher, int key, FieldBase base) {
    this.cipher = cipher;
    this.key = key;
    this.msg ="";
    this.alive = true;
    this.base = base;
  }
  
  public void updateEncryption(Strategy newCipher, int newKey){
    this.cipher = newCipher;
    this.key = newKey;
  }

  //SEND
  public void send (String msg, Base receiver){
    String encrypted = cipher.encrypt(msg, this.key);
    receiver.receive(encrypted);
  }

  //RECEIVE
  public void receive (String msg){
    this.msg = cipher.decrypt(msg,this.key);
  }

  public Base getHQ(){
    return HQ;
  }
  
  public void setHQ(){
    HQ = base;
    return;
  }
}