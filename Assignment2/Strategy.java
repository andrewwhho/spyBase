interface Strategy{
  public String encrypt(String msg, int key);
  public String decrypt(String msg, int key);
}

