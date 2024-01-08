interface Subject {
  public void register(Base newBase);
  public void unregister(Base base);
  public void notifyEncryption(Strategy newCipher, int newKey);
}
