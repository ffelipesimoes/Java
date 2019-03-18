package noobChain;

import java.security.*;
import java.util.ArrayList;

public class Transaction {
	public String transactionId;
	public PublicKey sender;
	public PublicKey reciepient;
	public float value;
	public byte[] signature;
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0;
	
	public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
		
	}
	
	private String calculateHash() {
		sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
		return StringUtil.applySha256(
				StringUtil.getStringFromKey(sender) +
				StringUtil.getStringFromKey(reciepient) +
				Float.toString(value) + sequence
				);
	}
	
	//Signs all the data we dont wish to be tampered with.
	public void generateSignature(PrivateKey privateKey) {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
		signature = StringUtil.applyECDASig(privateKey, data);
		
	}
	//Verifies the data we signed hasnt been tampered with
	public boolean verifySignature() {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
		return StringUtil.verifyECDSASig(sender, data, signature);
	}
	
	
}
