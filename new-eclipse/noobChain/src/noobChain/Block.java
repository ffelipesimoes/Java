package noobChain;

import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	
	
	public Block() {
		
	}
	public Block(String data, String previoushash) {
		this.data = data;
		this.previousHash = previoushash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculateHash = StringUtil.applySha256(
				previousHash +
				Long.toString(timeStamp) +
				data
				);
		return calculateHash;
	}
}
