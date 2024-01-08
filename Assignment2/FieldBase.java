import java.util.ArrayList;

public class FieldBase implements Base{
  private Strategy cipher; 
  private int key; 
  String msg; 
  private HomeBase HQ;

  public FieldBase(Strategy cipher, int key) {
    this.cipher = cipher;
    this.key = key;
    this.msg ="";
    this.HQ = HomeBase.getInstance();
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
    return;
  }
}
