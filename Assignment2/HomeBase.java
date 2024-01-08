import java.util.ArrayList;

public class HomeBase implements Base{
  private Strategy cipher;
  private int key;
  String msg;
  private static HomeBase instance = new HomeBase();
  private HomeBase HQ;

  // Singleton
  private HomeBase() {
    this.HQ = instance;
  }
  
  public static HomeBase getInstance() {
    return instance;
  }
  
  //New encryption reciever 
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
    return;
  }
}