interface Base {
  public void send (String msg, Base receiver);
  public void receive (String msg);
  public void updateEncryption(Strategy scheme,int key);
  public Base getHQ();
  public void setHQ();
}